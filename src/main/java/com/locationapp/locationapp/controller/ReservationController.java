package com.locationapp.locationapp.controller;

import com.locationapp.locationapp.dto.ReservationRequest;
import com.locationapp.locationapp.entity.Flight;
import com.locationapp.locationapp.entity.Reservation;
import com.locationapp.locationapp.repository.FlightRepository;
import com.locationapp.locationapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap)
    {
        Flight flight =  flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @PostMapping("/completeRevervation")
    public String completeReservation(ReservationRequest request, ModelMap modelMap)
    {
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully and the reservation id is " + reservation.getId());
        return "reservationConfirmation";
    }

}
