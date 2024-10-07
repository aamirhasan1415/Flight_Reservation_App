package com.checkIn.Integration;

import org.springframework.web.bind.annotation.RequestBody;

import com.checkIn.dto.Reservation;
import com.checkIn.dto.ReservationUpdateRequest;

public interface ReservationRestfulClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request);
}
