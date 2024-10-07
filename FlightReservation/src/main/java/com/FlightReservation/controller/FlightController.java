package com.FlightReservation.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation.entity.Flight;
import com.FlightReservation.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap modelMap) {
		
		List<Flight> flights=flightRepository.findFlights(from, to, departureDate);
		
		modelMap.addAttribute("flights", flights);
		
		return "displayFlight";
	}
	
	@RequestMapping("/bookFlight")
	public String bookFlight(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		
			Optional<Flight> findFlight = flightRepository.findById(flightId);
			Flight flight = findFlight.get();
			modelMap.addAttribute("flight",flight);
			
		return "reservation";
	}
	

}
