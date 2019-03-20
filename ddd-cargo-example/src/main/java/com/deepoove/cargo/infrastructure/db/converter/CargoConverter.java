package com.deepoove.cargo.infrastructure.db.converter;

import org.springframework.beans.BeanUtils;

import com.deepoove.cargo.domain.aggregate.cargo.Cargo;
import com.deepoove.cargo.domain.aggregate.cargo.valueobject.DeliverySpecification;
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
        Cargo target = new Cargo();
        BeanUtils.copyProperties(cargo, target);
        target.setDelivery(new DeliverySpecification(cargo.getOriginLocationCode(),
                cargo.getDestinationLocationCode()));
        return target;
    }

}
