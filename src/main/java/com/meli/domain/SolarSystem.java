package com.meli.domain;

import java.util.ArrayList;
import java.util.List;

import com.meli.util.MathUtil;

/**
 * A system where the sun is the center and planets orbit around it.
 * The solar system can have only 3 planets and the weather condition
 * in each planet is based on their position in the solar system.
 * The weather conditions are as follows:
 * <br>
 * DRY: All planets aligned with the sun.
 * <br>
 * OPTIMAL: All planets aligned but not with the sun.
 * <br>
 * RAIN: Sun is inside a triangle created by the 3 planets.
 * <br>
 * MAX_RAIN: Sun is inside a triangle created by the 3 planets and the
 * perimeter of the triangle is max.
 * <br>
 * UNKNOWN: When none of the previous situations apply.
 * 
 * 
 * @author facundocaputo
 */
public class SolarSystem {

	/** The sun is the center of any solar system. */
	private static final Point SUN_POSITION = new Point(0.0, 0.0);
	
	/** The list of planets that conform the solar system. */
	private final List<Planet> planets;
	
	/**
	 * Constructs a solar system with the given planets.
	 * 
	 * @param thePlanets The planets that are included in the solar system, cannot be null.
	 */
	public SolarSystem(final List<Planet> thePlanets) {
		//Validate
		planets = thePlanets;
	}
	
	/**
	 * Calculates the weather conditions in the solar system for the next given
	 * number of days.
	 * 
	 * @param days The number of days for which the weather should be predicted.
	 */
	public List<WeatherPrediction> predictWeather(final int days) {
		//We calculate day 0 as well.
		int totalDays = days + 1;
		List<WeatherPrediction> weatherPredictions = new ArrayList<>(totalDays);
		double maxPerimeterLength = 0;
		WeatherPrediction maxPerimeterForecast = null;
		for (int i = 0; i < totalDays; i++) {
			List<Point> points = new ArrayList<>(planets.size());
			for (Planet planet : planets) {
				points.add(planet.getPosition(i));
			}
			boolean planetsAreAligned = MathUtil.arePointsAligned(points);
			if (planetsAreAligned) {
				points.add(SUN_POSITION);
				boolean sunIsAlignedWithPlanets = MathUtil.arePointsAligned(points);
				if (sunIsAlignedWithPlanets) {
					weatherPredictions.add(new WeatherPrediction(i, WeatherCondition.DRY));
				} else {
					weatherPredictions.add(new WeatherPrediction(i, WeatherCondition.OPTIMAL));
				}
			} else if (MathUtil.isPointInsideTriangle(SUN_POSITION, points.get(0), points.get(1), points.get(2))) {
				WeatherPrediction rainyForecast = new WeatherPrediction(i, WeatherCondition.RAIN);
				weatherPredictions.add(rainyForecast);
				double perimeterLength = MathUtil.getTrianglePerimeterLength(points.get(0), points.get(1), points.get(2));
				if (perimeterLength > maxPerimeterLength) {
					maxPerimeterLength = perimeterLength;
					maxPerimeterForecast = rainyForecast;
				}
			} else {
				weatherPredictions.add(new WeatherPrediction(i, WeatherCondition.UNKNOWN));
			}
		}
		if (maxPerimeterForecast != null) {
			maxPerimeterForecast.update(WeatherCondition.MAX_RAIN);
		}
		return weatherPredictions;
	}

}
