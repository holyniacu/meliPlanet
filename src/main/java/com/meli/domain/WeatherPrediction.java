package com.meli.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Expresses the weather conditions that a day will have.
 * 
 * @author facundocaputo
 */
@Entity
@Table(name = "weather_prediction")
public class WeatherPrediction {

	@Id
    @GeneratedValue
    private Long id;
	/** Day over which the weather condition will apply. */
	@Column(nullable = false)
	private int day;
	/** The weather condition, never null. */
	@Column(nullable = false, name="weather_condition")
	@Enumerated(EnumType.STRING)
	private WeatherCondition weatherCondition;
	
	/**
	 * Default constructor for hibernate.
	 */
	private WeatherPrediction() {
	}
	
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
