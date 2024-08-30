package com.deepoove.cargo.application.command.impl;

import com.deepoove.cargo.application.command.CargoCmdService;
import com.deepoove.cargo.application.command.cmd.CargoBookCommand;
import com.deepoove.cargo.application.command.cmd.CargoDeleteCommand;
import com.deepoove.cargo.application.command.cmd.CargoDeliveryUpdateCommand;
import com.deepoove.cargo.application.command.cmd.CargoSenderUpdateCommand;
import com.deepoove.cargo.domain.aggregator.cargo.Cargo;
import com.deepoove.cargo.domain.aggregator.cargo.enums.EnterpriseSegment;
import com.deepoove.cargo.domain.aggregator.cargo.event.CargoBookDomainEvent;
import com.deepoove.cargo.domain.aggregator.cargo.repository.CargoRepository;
import com.deepoove.cargo.domain.aggregator.cargo.valueobject.DeliverySpecification;
import com.deepoove.cargo.domain.aggregator.handlingevent.event.HandlingEvent;
import com.deepoove.cargo.domain.aggregator.handlingevent.repository.HandlingEventRepository;
import com.deepoove.cargo.domain.service.CargoDomainService;
import com.deepoove.cargo.shared.SalersService;
import com.deepoove.cargo.shared.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CargoCmdServiceImpl implements CargoCmdService {

    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private HandlingEventRepository handlingEventRepository;
    @Autowired
    private CargoDomainService cargoDomainService;
    @Autowired
    private SalersService salersService;
    @Autowired
    DomainEventPublisher domainEventPublisher;

    @Override
    public void bookCargo(CargoBookCommand cargoBookCommand) {
        // create Cargo
        DeliverySpecification delivery = Cargo.getDeliverySpecificationBuilder()
                .withDestinationLocationCode(cargoBookCommand.getDestinationLocationCode())
                .withOriginLocationCode(cargoBookCommand.getOriginLocationCode())
                .build();

        Cargo cargo = Cargo.cargoFactory(CargoDomainService.nextCargoId(), cargoBookCommand.getSenderPhone(),
                cargoBookCommand.getDescription(), delivery);

        // 流程编排
        int size = cargoRepository.sizeByCustomer(cargoBookCommand.getSenderPhone());
        EnterpriseSegment enterpriseSegment = salersService.deriveEnterpriseSegment(cargo);
        int sizeCargo = cargoRepository.sizeByEnterpriseSegment(enterpriseSegment);
        
        if (!cargoDomainService.mayAccept(size, sizeCargo,
                cargo)) { throw new IllegalArgumentException(
                        cargoBookCommand.getSenderPhone() + " cannot book cargo, exceed the limit: "
                                + CargoDomainService.MAX_CARGO_LIMIT); }

        // saveCargo
        cargoRepository.save(cargo);
        
        // post domain event
        domainEventPublisher.publish(new CargoBookDomainEvent(cargo));
    }

    @Override
    public void updateCargoDelivery(CargoDeliveryUpdateCommand cmd) {
        // validate

        // find
        Cargo cargo = cargoRepository.find(cmd.getCargoId());

        // domain logic
        cargo.changeDelivery(cmd.getDestinationLocationCode());

        // save
        cargoRepository.save(cargo);
    }

    @Override
    public void updateCargoSender(CargoSenderUpdateCommand cmd) {

        // find
        Cargo cargo = cargoRepository.find(cmd.getCargoId());
        List<HandlingEvent> events = handlingEventRepository.findByCargo(cmd.getCargoId());

        // domain service
        cargoDomainService.updateCargoSender(cargo, cmd.getSenderPhone(), CollectionUtils.isEmpty(events) ? null : events.get(0));

        // save
        cargoRepository.save(cargo);
    }

    @Override
    public void deleteCargo(CargoDeleteCommand cmd) {
        cargoRepository.remove(cmd.getCargoId());
    }

}
