package com.deepoove.cargo.application.query.assembler;

import com.deepoove.cargo.application.query.dto.CargoDTO;
import com.deepoove.cargo.infrastructure.db.dao.LocationDao;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CargoDTOAssembler implements Function<CargoDO, CargoDTO> {

    @Autowired
    private LocationDao locationDao;

    public CargoDTO apply(CargoDO t) {
        CargoDTO target = new CargoDTO();
        BeanUtils.copyProperties(t, target);
        LocationDO select = locationDao.selectByCode(t.getOriginLocationCode());
        target.setOriginLocationName(select.getName());
        select = locationDao.selectByCode(t.getDestinationLocationCode());
        target.setDestinationLocationName(select.getName());
        return target;
    }

}
