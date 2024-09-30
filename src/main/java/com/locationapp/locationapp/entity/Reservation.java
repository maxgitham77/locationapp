package com.locationapp.locationapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;
    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
