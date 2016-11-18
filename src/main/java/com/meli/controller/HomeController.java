package com.meli.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.domain.Planet;
import com.meli.domain.SolarSystem;
import com.meli.domain.WeatherPrediction;

@RestController
public class HomeController {

	@RequestMapping("/clima")
    public WeatherPrediction weather(@RequestParam int day) {
		List<Planet> planets = new ArrayList<>(3);
		planets.add(new Planet("Ferengi", 0, -1, 500));
		planets.add(new Planet("Betasoide", 0, -3, 2000));
		planets.add(new Planet("Vulcano", 0, 5, 1000));
		SolarSystem solarSystem = new SolarSystem(planets);
		List<WeatherPrediction> weatherPredictions = solarSystem.predictWeather(10 * 365);
        return weatherPredictions.get(day);
    }
	
	@RequestMapping("/summary")
    public String summary() {
		return "Summary";
    }
}
