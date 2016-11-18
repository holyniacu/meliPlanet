package com.meli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.domain.Planet;
import com.meli.domain.SolarSystem;
import com.meli.domain.WeatherPrediction;
import com.meli.domain.WeatherPredictionRepository;

@Component
public class InitTask {

	@Autowired
	private WeatherPredictionRepository repository;
	
	void init() {
		List<Planet> planets = new ArrayList<>(3);
		planets.add(new Planet("Ferengi", 0, -1, 500));
		planets.add(new Planet("Betasoide", 0, -3, 2000));
		planets.add(new Planet("Vulcano", 0, 5, 1000));
		SolarSystem solarSystem = new SolarSystem(planets);
		List<WeatherPrediction> weatherPredictions = solarSystem.predictWeather(10 * 365);
		repository.save(weatherPredictions);
	}
	
}
