package com.locationapp.locationapp.service;

import com.locationapp.locationapp.dto.ReservationRequest;
import com.locationapp.locationapp.entity.Reservation;

public interface ReservationService {
    Reservation bookFlight(ReservationRequest request);
}
