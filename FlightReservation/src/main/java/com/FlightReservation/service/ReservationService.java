package com.FlightReservation.service;

import com.FlightReservation.dto.ReservationRequest;
import com.FlightReservation.entity.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
