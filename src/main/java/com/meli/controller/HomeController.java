package com.meli.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.domain.WeatherCondition;
import com.meli.domain.WeatherPrediction;
import com.meli.domain.WeatherPredictionRepository;

/**
 * Home controller of the app.
 * 
 * @author facundocaputo
 */
@RestController
public class HomeController {

	/** Weather condition repository, never null. */
	@Autowired
	private WeatherPredictionRepository repository;
	
	/**
	 * Indicates the expected weather on the given day.
	 * 
	 * @param day The day for which the weather wants to be known.
	 * @return The weather prediction, never null.
	 */
	@RequestMapping("/clima")
    public WeatherPrediction weather(@RequestParam int day) {
		WeatherPrediction weatherPrediction = repository.findByDay(day);
		if (weatherPrediction != null) {
			return weatherPrediction;
		} else {
			//Errors will not be handled nicely
			throw new RuntimeException("The prediction for this day is unknown");
		}
    }
	
	/**
	 * Retrieves a summary of the solar system weather condition.
	 * 
	 * @return A summary of the solar system weather condition, never null.
	 */
	@RequestMapping("/summary")
    public WeatherSummaryDto summary() {
		int dryDays = repository.countByWeatherCondition(WeatherCondition.DRY);
		int rainyDays = repository.countByWeatherCondition(WeatherCondition.RAIN);
		int optimalDays = repository.countByWeatherCondition(WeatherCondition.OPTIMAL);
		int unknownDays = repository.countByWeatherCondition(WeatherCondition.UNKNOWN);
		List<WeatherPrediction> maxRainWeathers = repository
				.findByWeatherCondition(WeatherCondition.MAX_RAIN);
		int maxRainDay = maxRainWeathers.get(0).getDay();
		return new WeatherSummaryDto(dryDays, rainyDays, optimalDays, unknownDays, maxRainDay);
    }
}
