package nl.kolkos.java.nl.kolkos.telegrambot2.controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nl.kolkos.java.nl.kolkos.telegrambot2.objects.User;
import nl.kolkos.java.nl.kolkos.telegrambot2.services.UserService;

@Controller
public class MiscController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public String registration(Authentication loggedInUser, Model model){
		
		// check if a user is logged in
		//String username = userService.findLoggedInUsername();
		//System.out.println("/menu username => " + username);
		
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "menu";
	}
	
	
}
