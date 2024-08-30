package com.deepoove.cargo.infrastructure.db.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deepoove.cargo.domain.aggregate.cargo.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.repository.CargoRepository;
import com.deepoove.cargo.domain.aggregate.cargo.enums.EnterpriseSegment;
import com.deepoove.cargo.infrastructure.db.converter.CargoConverter;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;
import com.deepoove.cargo.infrastructure.db.mapper.CargoMapper;

@Component
public class CargoRepositoryImpl implements CargoRepository {

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public Cargo find(String id) {
        CargoDO cargoDO = cargoMapper.selectById(id);
        Cargo cargo = CargoConverter.deserialize(cargoDO);
        return cargo;
    }

    @Override
    public void save(Cargo cargo) {
        CargoDO cargoDO = CargoConverter.serialize(cargo);
        CargoDO data = cargoMapper.selectById(cargoDO.getId());
        if (null == data) {
            cargoMapper.insert(cargoDO);
        } else {
            cargoMapper.updateById(cargoDO);
        }
    }

    @Override
    public void remove(String id) {
        cargoMapper.deleteById(id);
    }

    @Override
    public int sizeByCustomer(String customerPhone) {
        // 创建 LambdaQueryWrapper
        LambdaQueryWrapper<CargoDO> wp = new LambdaQueryWrapper<>();
        // 添加查询条件
        wp.eq(CargoDO::getSenderPhone, customerPhone);
        // 统计符合条件的记录数
        return cargoMapper.selectCount(wp);
    }

    @Override
    public int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment) {
        // cargoMapper
        return 20;
    }

}
