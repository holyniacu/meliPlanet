package com.meli.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Weather prediction repository.
 * 
 * @author facundocaputo
 */
public interface WeatherPredictionRepository extends CrudRepository<WeatherPrediction, Long> {
	
	/**
	 * Finds a prediction for the given day.
	 * 
	 * @param day The day for which the prediction must be found.
	 * @return The prediction for the given day, null if no prediction for the given
	 * day exists.
	 */
	WeatherPrediction findByDay(int day);
	
	/**
	 * Counts the number of days with the given weather condition.
	 * 
	 * @param weatherCondition The weather condition to filter, cannot be null.
	 * @return The count of days matching the weather condition.
	 */
	int countByWeatherCondition(WeatherCondition weatherCondition);
	
	/**
	 * Retrieves the days with the given weather condition.
	 * 
	 * @param weatherCondition The weather condition to filter, cannot be null.
	 * @return The days with the weather condition, never null.
	 */
	List<WeatherPrediction> findByWeatherCondition(WeatherCondition weatherCondition);

}
