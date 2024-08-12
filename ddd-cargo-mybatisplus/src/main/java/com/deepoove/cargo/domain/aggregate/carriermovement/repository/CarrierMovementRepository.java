package com.deepoove.cargo.domain.aggregate.carriermovement.repository;

import com.deepoove.cargo.domain.aggregate.carriermovement.root.CarrierMovement;

public interface CarrierMovementRepository {

    CarrierMovement find(String id);

}
