package com.deepoove.cargo.application.query.impl;

import com.deepoove.cargo.application.query.CargoQueryService;
import com.deepoove.cargo.application.query.assembler.CargoDTOAssembler;
import com.deepoove.cargo.application.query.dto.CargoDTO;
import com.deepoove.cargo.application.query.qry.CargoFindbyCustomerQry;
import com.deepoove.cargo.infrastructure.db.dao.CargoDao;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoQueryServiceImpl implements CargoQueryService {

    @Autowired
    private CargoDao cargoDao;
    
    @Autowired
    private CargoDTOAssembler converter;

    @Override
    public List<CargoDTO> queryCargos() {
        List<CargoDO> cargos = cargoDao.queryCargos();
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public List<CargoDTO> queryCargos(CargoFindbyCustomerQry qry) {
        List<CargoDO> cargos = cargoDao.selectByCustomer(qry.getCustomerPhone());
        return cargos.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public CargoDTO getCargo(String cargoId) {
        CargoDO select = cargoDao.selectById(cargoId);
        return converter.apply(select);
    }

}
