package com.FlightReservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlightReservation.dto.ReservationRequest;
import com.FlightReservation.entity.Flight;
import com.FlightReservation.entity.Passenger;
import com.FlightReservation.entity.Reservation;
import com.FlightReservation.repository.FlightRepository;
import com.FlightReservation.repository.PassengerRepository;
import com.FlightReservation.repository.ReservationRepository;
import com.FlightReservation.utilities.EmailUtil;
import com.FlightReservation.utilities.PDFgenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	public FlightRepository flightRepository;
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	@Autowired
	public PassengerRepository passengerRepository;
	
	@Autowired
	public PDFgenerator pdfgenerator;
	
	@Autowired
	public EmailUtil emailUtil;
	
	

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepository.save(passenger);
		
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepository.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservationRepository.save(reservation);
		
		String filePath="D:\\practice folder\\eclipse_project\\Spring_project\\FlightReservation\\tickets"+reservation.getId()+".pdf";
		
		pdfgenerator.generateItinerary(reservation, filePath);
		
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		
		
		return reservation;
	}

}
