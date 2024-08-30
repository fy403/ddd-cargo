package com.deepoove.cargo.infrastructure.db.converter;

import com.deepoove.cargo.domain.aggregator.cargo.Cargo;
import com.deepoove.cargo.domain.aggregator.cargo.valueobject.DeliverySpecification;
import com.deepoove.cargo.infrastructure.db.dataobject.CargoDO;

public class CargoConverter {

    public static CargoDO serialize(Cargo cargo) {
        CargoDO target = new CargoDO();
        target.setId(cargo.id());
        target.setSenderPhone(cargo.sender());
        target.setDescription(cargo.description());
        DeliverySpecification delivery = cargo.delivery();
        target.setDestinationLocationCode(delivery.getDestinationLocationCode());
        target.setOriginLocationCode(delivery.getOriginLocationCode());
        return target;
    }

    public static Cargo deserialize(CargoDO cargo) {
        DeliverySpecification delivery = Cargo.getDeliverySpecificationBuilder()
                .withOriginLocationCode(cargo.getOriginLocationCode())
                .withDestinationLocationCode(cargo.getDestinationLocationCode())
                .build();
        return Cargo.cargoFactory(
                cargo.getId(),
                cargo.getSenderPhone(),
                cargo.getDescription(),
                delivery
        );
    }

}
