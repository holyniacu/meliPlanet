package com.meli.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.domain.WeatherPrediction;
import com.meli.domain.WeatherPredictionRepository;

@RestController
public class HomeController {

	@Autowired
	private WeatherPredictionRepository repository;
	
	@RequestMapping("/clima")
    public WeatherPrediction weather(@RequestParam int day) {
        return repository.findByDay(day);
    }
	
	@RequestMapping("/summary")
    public String summary() {
		return repository.findByDay(90).getWeatherCondition().toString();
    }
}
