package com.deepoove.cargo.domain.aggregate.carriermovement.repository;

import com.deepoove.cargo.domain.aggregate.carriermovement.CarrierMovement;

public interface CarrierMovementRepository {

    CarrierMovement find(String id);

}
