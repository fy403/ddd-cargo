package com.deepoove.cargo.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepoove.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HandlingEventMapper extends BaseMapper<HandlingEventDO> {

//    List<HandlingEventDO> selectByCargo(@Param("cargoId") String cargoId);
//
//    List<HandlingEventDO> selectByScheduleId(@Param("scheduleId") String scheduleId);
//
//    void save(HandlingEventDO handlingEventDO);

}
