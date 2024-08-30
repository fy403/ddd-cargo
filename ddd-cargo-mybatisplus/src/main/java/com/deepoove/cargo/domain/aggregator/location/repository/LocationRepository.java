package com.deepoove.cargo.domain.aggregator.location.repository;

import com.deepoove.cargo.domain.aggregator.location.valueobject.Location;

public interface LocationRepository {
    Location find(String code);
}
