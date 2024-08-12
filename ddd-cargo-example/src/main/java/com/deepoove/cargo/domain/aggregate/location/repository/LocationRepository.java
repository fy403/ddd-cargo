package com.deepoove.cargo.domain.aggregate.location.repository;

import com.deepoove.cargo.domain.aggregate.location.root.Location;

public interface LocationRepository {
    Location find(String code);
}
