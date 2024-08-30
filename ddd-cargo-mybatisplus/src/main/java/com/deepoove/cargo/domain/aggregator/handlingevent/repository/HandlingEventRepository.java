package com.deepoove.cargo.domain.aggregator.handlingevent.repository;

import com.deepoove.cargo.domain.aggregator.handlingevent.event.HandlingEvent;

import java.util.List;

public interface HandlingEventRepository {

    List<HandlingEvent> findByCargo(String cargoId);

    List<HandlingEvent> findByScheduleId(String scheduleId);

    void save(HandlingEvent handlingEvent);

}
