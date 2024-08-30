package com.deepoove.cargo.domain.aggregate.cargo.repository;

import com.deepoove.cargo.domain.aggregate.cargo.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.enums.EnterpriseSegment;

public interface CargoRepository {

    Cargo find(String id);
    
    int sizeByCustomer(String customerPhone);
    
    int sizeByEnterpriseSegment(EnterpriseSegment enterpriseSegment);

    void save(Cargo cargo);

    void remove(String id);

}
