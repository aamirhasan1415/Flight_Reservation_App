package com.FlightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlightReservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
