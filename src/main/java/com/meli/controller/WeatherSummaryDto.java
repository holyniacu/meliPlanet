package com.meli.controller;

/**
 * Summary of the weather conditions of the solar system
 * 
 * @author facundocaputo
 */
public class WeatherSummaryDto {

	/** The dry days count.*/
	private int dryDays;
	/** The rainy days count.*/
	private int rainyDays;
	/** The optimal days count.*/
	private int optimalDays;
	/** The unknown days count.*/
	private int unknownDays;
	/** The day with max rain.*/
	private int maxRainDay;
	
	/**
	 * Constructor.
	 * 
	 * @param theDryDays The dry days count.
	 * @param theRainyDays The rainy days count.
	 * @param theOptimalDays The optimal days count.
	 * @param theUnknownDays The unknown days count.
	 * @param theMaxRainDay The day with max rain.
	 */
	public WeatherSummaryDto(final int theDryDays, final int theRainyDays,
			final int theOptimalDays, final int theUnknownDays, final int theMaxRainDay) {
		dryDays = theDryDays;
		rainyDays = theRainyDays;
		optimalDays = theOptimalDays;
		unknownDays = theUnknownDays;
		maxRainDay = theMaxRainDay;
	}
	
	/**
	 * Retrieves the number of dry days.
	 * 
	 * @return The number of dry days.
	 */
	public int getDryDays() {
		return dryDays;
	}
	
	/**
	 * Retrieves the number of rainy days.
	 * 
	 * @return The number of rainy days.
	 */
	public int getRainyDays() {
		return rainyDays;
	}
	
	/**
	 * Retrieves the number of optimal days.
	 * 
	 * @return The number of optimal days.
	 */
	public int getOptimalDays() {
		return optimalDays;
	}
	
	/**
	 * Retrieves the number of unknown days.
	 * 
	 * @return The number of unknown days.
	 */
	public int getUnknownDays() {
		return unknownDays;
	}
	
	/**
	 * Retrieves the day with max rain.
	 * 
	 * @return The day with max rain.
	 */
	public int getMaxRainDay() {
		return maxRainDay;
	}
	
}
