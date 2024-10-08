package com.deepoove.cargo.application.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepoove.cargo.application.command.IncidentLoggingCmdService;
import com.deepoove.cargo.application.command.cmd.HandlingEventAddCommand;
import com.deepoove.cargo.domain.aggregator.handlingevent.enums.EventTypeEnum;
import com.deepoove.cargo.domain.aggregator.handlingevent.event.HandlingEvent;
import com.deepoove.cargo.domain.aggregator.handlingevent.repository.HandlingEventRepository;

@Service
public class IncidentLoggingCmdServiceImpl implements IncidentLoggingCmdService {

    @Autowired
    private HandlingEventRepository handlingEventRepository;

    @Override
    public void addHandlingEvent(HandlingEventAddCommand cmd) {
        // validate

        // create
        HandlingEvent handlingEvent = HandlingEvent.newHandlingEvent(cmd.getCargoId(),
                cmd.getDatetime(), EventTypeEnum.of(cmd.getEventType()), cmd.getScheduleId());

        // save
        handlingEventRepository.save(handlingEvent);

    }

}
