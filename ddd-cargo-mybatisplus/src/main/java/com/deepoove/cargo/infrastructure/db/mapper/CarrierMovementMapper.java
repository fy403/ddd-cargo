package com.deepoove.cargo.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepoove.cargo.infrastructure.db.dataobject.CarrierMovementDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarrierMovementMapper extends BaseMapper<CarrierMovementDO> {

//    CarrierMovementDO select(@Param("scheduleId") String scheduleId);
//
//    List<CarrierMovementDO> selectAll();


}
