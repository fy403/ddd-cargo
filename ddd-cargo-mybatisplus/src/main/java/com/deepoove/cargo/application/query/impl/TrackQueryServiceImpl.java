package com.deepoove.cargo.application.query.impl;

import com.deepoove.cargo.application.query.TrackQueryService;
import com.deepoove.cargo.application.query.assembler.CargoDTOAssembler;
import com.deepoove.cargo.application.query.assembler.HandlingEventDTOAssembler;
import com.deepoove.cargo.application.query.dto.CargoDTO;
import com.deepoove.cargo.application.query.dto.CargoHandlingEventDTO;
import com.deepoove.cargo.application.query.dto.HandlingEventDTO;
import com.deepoove.cargo.application.query.qry.EventFindbyCargoQry;
import com.deepoove.cargo.infrastructure.db.dao.CargoDao;
import com.deepoove.cargo.infrastructure.db.dao.HandlingEventDao;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackQueryServiceImpl implements TrackQueryService {

    @Autowired
    private HandlingEventDao handlingEventDao;

    @Autowired
    private CargoDao cargoDao;

    @Autowired
    private CargoDTOAssembler converter;
    @Autowired
    private HandlingEventDTOAssembler handlingEventDTOAssembler;

    @Override
    public CargoHandlingEventDTO queryHistory(EventFindbyCargoQry qry) {

        CargoDO cargo = cargoDao.selectById(qry.getCargoId());
        List<HandlingEventDO> events = handlingEventDao.selectByCargo(qry.getCargoId());

        // convertor
        CargoDTO cargoDTO = converter.apply(cargo);
        List<HandlingEventDTO> dtoEvents = events.stream().map(handlingEventDTOAssembler::apply)
                .collect(Collectors.toList());

        CargoHandlingEventDTO cargoHandlingEventDTO = new CargoHandlingEventDTO();
        cargoHandlingEventDTO.setCargo(cargoDTO);
        cargoHandlingEventDTO.setEvents(dtoEvents);

        return cargoHandlingEventDTO;
    }

}
