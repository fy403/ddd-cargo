package com.deepoove.cargo.domain.aggregator.carriermovement.repository;

import com.deepoove.cargo.domain.aggregator.carriermovement.valueobject.CarrierMovement;

public interface CarrierMovementRepository {

    CarrierMovement find(String id);

}
