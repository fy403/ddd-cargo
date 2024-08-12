package com.deepoove.cargo.domain.aggregate.cargo.event;

import com.deepoove.cargo.domain.aggregate.cargo.root.Cargo;

public class CargoBookDomainEvent {

    private Cargo cargo;

    public CargoBookDomainEvent(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

}
