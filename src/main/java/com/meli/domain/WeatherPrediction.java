package com.meli.domain;

/**
 * Expresses the weather conditions that a day will have.
 * 
 * @author facundocaputo
 */
public class WeatherPrediction {

	/** Day over which the weather condition will apply. */
	private final int day;
	/** The weather condition, never null. */
	private WeatherCondition weatherCondition;
	
	WeatherPrediction(final int theDay, final WeatherCondition theWeatherCondition) {
		day = theDay;
		weatherCondition = theWeatherCondition;
	}
	
	/**
	 * Updates the weather conditions.
	 * 
	 * @param theWeatherCondition The new weather conditions of the day, cannot be null.
	 */
	void update(final WeatherCondition theWeatherCondition) {
		weatherCondition = theWeatherCondition;
	}
	
	/**
	 * Retrieves the weather condition.
	 * 
	 * @return The weather condition, never null.
	 */
	public WeatherCondition getWeatherCondition() {
		return weatherCondition;
	}
}
