package com.locationapp.locationapp.repository;

import com.locationapp.locationapp.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
