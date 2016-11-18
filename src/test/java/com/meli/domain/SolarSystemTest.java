package com.meli.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.meli.domain.Planet;
import com.meli.domain.SolarSystem;
import com.meli.domain.WeatherCondition;
import com.meli.domain.WeatherPrediction;

public class SolarSystemTest {

	@Test public void predictWeather_allAligned() {
		List<Planet> planets = new ArrayList<>(3);
		planets.add(new Planet("Planet1", 0, -1, 500));
		planets.add(new Planet("Planet2", 0, -1, 1000));
		planets.add(new Planet("Planet3", 0, -1, 2000));
		SolarSystem solarSystem = new SolarSystem(planets);
		List<WeatherPrediction> weatherPredictions = solarSystem.predictWeather(360);
		for (WeatherPrediction weatherPrediction : weatherPredictions) {
			Assert.assertEquals(WeatherCondition.DRY, weatherPrediction.getWeatherCondition());
		}
	}
	
}
