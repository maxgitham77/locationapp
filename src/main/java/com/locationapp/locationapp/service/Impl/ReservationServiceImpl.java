package com.locationapp.locationapp.service.Impl;

import com.locationapp.locationapp.dto.ReservationRequest;
import com.locationapp.locationapp.entity.Flight;
import com.locationapp.locationapp.entity.Passenger;
import com.locationapp.locationapp.entity.Reservation;
import com.locationapp.locationapp.repository.FlightRepository;
import com.locationapp.locationapp.repository.PassengerRepository;
import com.locationapp.locationapp.repository.ReservationRepository;
import com.locationapp.locationapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Flight flight = flightRepository.findById(request.getFlightId()).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        return reservation;
    }
}
