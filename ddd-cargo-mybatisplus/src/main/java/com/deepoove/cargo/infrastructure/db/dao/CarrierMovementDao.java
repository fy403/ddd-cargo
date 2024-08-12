package com.deepoove.cargo.infrastructure.db.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepoove.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import com.deepoove.cargo.infrastructure.db.mapper.CarrierMovementMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierMovementDao extends ServiceImpl<CarrierMovementMapper, CarrierMovementDO> {
    public CarrierMovementDO selectByScheduleId(String scheduleId) {
        return lambdaQuery().eq(CarrierMovementDO::getScheduleId, scheduleId).one();
    }
    public List<CarrierMovementDO> selectAll() {
        return lambdaQuery().list();
    }
}
