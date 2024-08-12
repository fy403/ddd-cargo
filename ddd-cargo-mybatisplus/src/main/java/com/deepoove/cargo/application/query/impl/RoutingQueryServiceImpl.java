package com.deepoove.cargo.application.query.impl;

import com.deepoove.cargo.application.query.RoutingQueryService;
import com.deepoove.cargo.application.query.assembler.CarrierMovementDTOAssembler;
import com.deepoove.cargo.application.query.dto.CarrierMovementDTO;
import com.deepoove.cargo.infrastructure.db.dao.CarrierMovementDao;
import com.deepoove.cargo.infrastructure.db.dao.LocationDao;
import com.deepoove.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutingQueryServiceImpl implements RoutingQueryService {

    @Autowired
    private CarrierMovementDao carrierMovementDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private CarrierMovementDTOAssembler converter;

    @Override
    public List<CarrierMovementDTO> queryCarriers() {
        List<CarrierMovementDO> carrierMovementDOs = carrierMovementDao.selectAll();
        return carrierMovementDOs.stream().map(converter::apply).collect(Collectors.toList());
    }

    @Override
    public List<LocationDO> queryLocations() {
        return locationDao.selectAll();
    }

}
