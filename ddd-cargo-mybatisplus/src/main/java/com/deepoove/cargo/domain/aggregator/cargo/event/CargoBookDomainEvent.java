package com.deepoove.cargo.domain.aggregator.cargo.event;

import com.deepoove.cargo.domain.aggregator.cargo.Cargo;

public class CargoBookDomainEvent {

    private Cargo cargo;

    public CargoBookDomainEvent(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
