package com.FlightReservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FlightReservation.entity.User;
import com.FlightReservation.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
	}
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {

		userRepository.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
		
		User user=userRepository.findByEmail(email);
		if(user!=null) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return "findFlight";
			}
			else {
				modelMap.addAttribute("error", "Invalid email/password");
				return "login/login";
			}
		}
		else {
			modelMap.addAttribute("error", "Invalid email/password");
			return "login/login";
		}
		
		
	}

}
