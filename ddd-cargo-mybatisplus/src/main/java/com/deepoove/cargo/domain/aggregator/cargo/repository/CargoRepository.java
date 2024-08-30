package com.deepoove.cargo.domain.aggregator.cargo.repository;

import com.deepoove.cargo.domain.aggregator.cargo.Cargo;
import com.deepoove.cargo.domain.aggregator.cargo.enums.EnterpriseSegment;

public interface CargoRepository {

    Cargo find(String id);
    
    int sizeByCustomer(String customerPhone);
    
    int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment);

    void save(Cargo cargo);

    void remove(String id);

}
