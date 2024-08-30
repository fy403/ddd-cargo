package com.deepoove.cargo.domain.aggregate.location.repository;

import com.deepoove.cargo.domain.aggregate.location.Location;

public interface LocationRepository {
    Location find(String code);
}
