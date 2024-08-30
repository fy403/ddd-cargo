package com.deepoove.cargo.infrastructure.db.repository;

import com.deepoove.cargo.domain.aggregator.handlingevent.event.HandlingEvent;
import com.deepoove.cargo.domain.aggregator.handlingevent.repository.HandlingEventRepository;
import com.deepoove.cargo.infrastructure.db.converter.HandlingEventConverter;
import com.deepoove.cargo.infrastructure.db.dao.HandlingEventDao;
import com.deepoove.cargo.infrastructure.db.dataobject.HandlingEventDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HandlingEventRepositoryImpl implements HandlingEventRepository {

    @Autowired
    private HandlingEventDao handlingEventDao;

    @Override
    public List<HandlingEvent> findByCargo(String cargoId) {
        List<HandlingEventDO> handlingEventDOs = handlingEventDao.selectByCargo(cargoId);

        return handlingEventDOs.stream().map(HandlingEventConverter::deserialize)
                .collect(Collectors.toList());
    }

    @Override
    public List<HandlingEvent> findByScheduleId(String scheduleId) {
        List<HandlingEventDO> handlingEventDOs = handlingEventDao.selectByScheduleId(scheduleId);

        return handlingEventDOs.stream().map(HandlingEventConverter::deserialize)
                .collect(Collectors.toList());
    }

    @Override
    public void save(HandlingEvent handlingEvent) {
        HandlingEventDO handlingEventDO = HandlingEventConverter.serialize(handlingEvent);
        handlingEventDao.saved(handlingEventDO);
    }

}
