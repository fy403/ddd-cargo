package com.deepoove.cargo.infrastructure.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deepoove.cargo.domain.aggregate.cargo.root.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.repository.CargoRepository;
import com.deepoove.cargo.domain.aggregate.cargo.enums.EnterpriseSegment;
import com.deepoove.cargo.infrastructure.db.converter.CargoConverter;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.mapper.CargoMapper;

@Component
public class CargoRepositoryImpl implements CargoRepository {

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public Cargo find(String id) {
        CargoDO cargoDO = cargoMapper.select(id);
        Cargo cargo = CargoConverter.deserialize(cargoDO);
        return cargo;
    }

    @Override
    public void save(Cargo cargo) {
        CargoDO cargoDO = CargoConverter.serialize(cargo);
        CargoDO data = cargoMapper.select(cargoDO.getId());
        if (null == data) {
            cargoMapper.save(cargoDO);
        } else {
            cargoMapper.update(cargoDO);
        }
    }

    @Override
    public void remove(String id) {
        cargoMapper.remove(id);
    }

    @Override
    public int sizeByCustomer(String customerPhone) {
        return cargoMapper.countByCustomer(customerPhone);
    }

    @Override
    public int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment) {
        // cargoMapper
        return 20;
    }

}
