package com.weather.Weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.Weather.model.weather;
import com.weather.Weather.services.weatherService;

@Controller
public class HomeController {
	
	@Autowired
	private weatherService service;

	@GetMapping("/")
	public String homePage(Model model) {

		return "home";
	}
	@GetMapping("/getWeather")
	public String getWeather(@RequestParam String city, Model model) {
	    weather weatherResponse = service.getWeather(city);
	    
	    if (weatherResponse == null || weatherResponse.getCurrent() == null) {
	        model.addAttribute("error", "Weather data could not be retrieved.");
	    } else {
	        model.addAttribute("weatherResponse", weatherResponse);
	    }
	    
	    return "home";
	}

}
