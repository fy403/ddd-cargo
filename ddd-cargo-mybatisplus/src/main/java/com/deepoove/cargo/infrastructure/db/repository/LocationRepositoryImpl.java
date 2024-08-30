package com.deepoove.cargo.infrastructure.db.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.deepoove.cargo.domain.aggregate.location.repository.LocationRepository;
import com.deepoove.cargo.domain.aggregate.location.Location;
import com.deepoove.cargo.infrastructure.db.converter.LocationConverter;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import com.deepoove.cargo.infrastructure.db.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationRepositoryImpl implements LocationRepository{
    
    @Autowired
    private LocationMapper mapper;

    @Override
    public Location find(String code) {
        LambdaQueryWrapper<LocationDO> wp = new LambdaQueryWrapper<>();
        wp.eq(LocationDO::getCode, code);
        LocationDO locationDO = mapper.selectOne(wp);
        return LocationConverter.deserialize(locationDO);
    }

}
