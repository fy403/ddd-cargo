package com.deepoove.cargo.shared;

import com.deepoove.cargo.domain.aggregator.cargo.Cargo;
import com.deepoove.cargo.domain.aggregator.cargo.enums.EnterpriseSegment;

public interface SalersService {
    public String getUserName(String phone);
    public EnterpriseSegment deriveEnterpriseSegment(Cargo cargo);
    public boolean mayAccept(int cargoSize, Cargo cargo);
}
