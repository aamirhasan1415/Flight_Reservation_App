package com.FlightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
