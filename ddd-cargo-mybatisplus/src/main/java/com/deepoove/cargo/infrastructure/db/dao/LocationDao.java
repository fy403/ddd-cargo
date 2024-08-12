package com.deepoove.cargo.infrastructure.db.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import com.deepoove.cargo.infrastructure.db.mapper.LocationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationDao extends ServiceImpl<LocationMapper, LocationDO> {
    public LocationDO selectByCode(String code){
        return lambdaQuery().
                eq(LocationDO::getCode, code).
                one();
    }
    public List<LocationDO> selectAll(){
        return lambdaQuery().list();
    }
}
