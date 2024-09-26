package com.locationapp.locationapp.repository;

import com.locationapp.locationapp.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
