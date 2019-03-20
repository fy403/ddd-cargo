package com.deepoove.cargo.application.command;

import com.deepoove.cargo.application.command.cmd.CargoBookCommand;
import com.deepoove.cargo.application.command.cmd.CargoDeleteCommand;
import com.deepoove.cargo.application.command.cmd.CargoDeliveryUpdateCommand;

public interface CargoCmdService {
    
    void bookCargo(CargoBookCommand cargoBookCommand);

    void updateCargoDelivery(CargoDeliveryUpdateCommand cmd);

    void deleteCargo(CargoDeleteCommand cmd);

}
