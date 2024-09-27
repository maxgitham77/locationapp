package com.locationapp.locationapp.repository;

import com.locationapp.locationapp.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "select type,count(type) from locations group by type", nativeQuery = true)
    public List<Object[]> findTypeAndTypeCount();

}
