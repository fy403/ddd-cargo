package com.deepoove.cargo.domain.aggregator.cargo;

import com.deepoove.cargo.domain.aggregator.cargo.valueobject.DeliverySpecification;

public class Cargo {

    private String id;
    private String senderPhone;
    private String description;
    private DeliverySpecification delivery;

    public Cargo(String id) {
        this.id = id;
    }

    public Cargo() {}

    /**
     * Factory method：预订新的货物
     * 
     * @param senderPhone
     * @param description
     * @param delivery
     * @return
     */
    public static Cargo cargoFactory(String id, String senderPhone, String description,
                                     DeliverySpecification delivery) {
        Cargo cargo = new Cargo(id);
        cargo.senderPhone = senderPhone;
        cargo.description = description;
        cargo.delivery = delivery;
        return cargo;
    }

    public static DeliverySpecificationBuilder getDeliverySpecificationBuilder() {
        return new DeliverySpecificationBuilder();
    }

    public static class DeliverySpecificationBuilder{
        private String originLocationCode;
        private String destinationLocationCode;
        public DeliverySpecificationBuilder withOriginLocationCode(String originLocationCode) {
            this.originLocationCode = originLocationCode;
            return this;
        }
        public DeliverySpecificationBuilder withDestinationLocationCode(String destinationLocationCode) {
            this.destinationLocationCode = destinationLocationCode;
            return this;
        }
        public DeliverySpecification build() {
            return new DeliverySpecification(originLocationCode, destinationLocationCode);
        }
    }

    public String id() {
        return id;
    }

    public String sender() {
        return senderPhone;
    }

    public String description() {
        return description;
    }

    public DeliverySpecification delivery() {
        return delivery;
    }

    public void setDelivery(DeliverySpecification delivery) {
        this.delivery = delivery;
    }

    public void changeDelivery(String destinationLocationCode) {
        if (this.delivery
                .getOriginLocationCode().equals(destinationLocationCode)) { throw new IllegalArgumentException(
                        "destination and origin location cannot be the same."); }
        this.delivery.setDestinationLocationCode(destinationLocationCode);
    }

    public void changeSender(String senderPhone) {
        this.senderPhone = senderPhone;
    }

}
