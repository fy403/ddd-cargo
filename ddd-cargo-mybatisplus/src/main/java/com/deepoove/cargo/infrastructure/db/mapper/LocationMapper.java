package com.deepoove.cargo.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepoove.cargo.infrastructure.db.dataobject.LocationDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper extends BaseMapper<LocationDO> {

//    LocationDO select(@Param("code") String code);
//
//    List<LocationDO> selectAll();
//

}
