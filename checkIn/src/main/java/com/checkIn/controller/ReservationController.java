package com.checkIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkIn.Integration.ReservationRestfulClient;
import com.checkIn.dto.Reservation;
import com.checkIn.dto.ReservationUpdateRequest;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationRestfulClient restClient;
	
	@RequestMapping("/startCheckin")
	public String startCheckin() {
		return "startCheckin";
	}
	
	
	@RequestMapping("/proceedCheckIn")
	public String proceedCheckIn(@RequestParam("id") long id, ModelMap modelMap) {
		
		Reservation reservation=restClient.findReservation(id);
		modelMap.addAttribute("reservation", reservation);
		
		return "displayReservation";
	}
	
	@RequestMapping("/proceedToCheckIn")
	public String proceedToCheckIn(@RequestParam("id") long id, @RequestParam("numberOfBags") int numberOfBags ) {
		
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		
		request.setId(id);
		request.setNumberOfBags(numberOfBags);
		request.setCheckedIn(true);
		
		restClient.updateReservation(request);
		
		return "confirmReservation";
		
	}

}
