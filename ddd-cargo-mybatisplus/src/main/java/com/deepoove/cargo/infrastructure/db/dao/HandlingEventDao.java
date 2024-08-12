package com.deepoove.cargo.infrastructure.db.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepoove.cargo.infrastructure.db.dataobject.HandlingEventDO;
import com.deepoove.cargo.infrastructure.db.mapper.HandlingEventMapper;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class HandlingEventDao extends ServiceImpl<HandlingEventMapper, HandlingEventDO> {
    public List<HandlingEventDO> selectByCargo(String cargoId){
        return lambdaQuery().
                eq(HandlingEventDO::getCargoId, cargoId).
                orderByDesc(HandlingEventDO::getDatetime).
                list();
    }
    public List<HandlingEventDO> selectByScheduleId(String scheduleId){
        return lambdaQuery().
                eq(HandlingEventDO::getScheduleId, scheduleId).
                list();
    }
    public void saved(HandlingEventDO handlingEventDO){
        this.save(handlingEventDO);
    }
}
