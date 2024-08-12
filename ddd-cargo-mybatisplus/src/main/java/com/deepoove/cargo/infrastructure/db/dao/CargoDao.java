package com.deepoove.cargo.infrastructure.db.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.mapper.CargoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoDao extends ServiceImpl<CargoMapper, CargoDO> {
    public List<CargoDO> queryCargos() {
        return lambdaQuery().list();
    }

    public List<CargoDO> selectByCustomer(String customerPhone) {
        return lambdaQuery().eq(CargoDO::getSenderPhone, customerPhone).list();
    }

    public CargoDO selectById(String cargoId) {
        return lambdaQuery().eq(CargoDO::getId, cargoId).one();
    }
}
