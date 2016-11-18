package com.meli.domain;

import com.meli.util.MathUtil;

/**
 * A planet in the solar system.
 * 
 * @author facundocaputo
 *
 */
public class Planet {

	/** The name of the planet, never null. */
	private final String name;
	/** The initial angle measure from the x axis. */
	private final int initialAngle;
	/** The angular velocity of the planet. */
	private final int angularVelocity;
	/** The distance to the sun, expressed in km. */
	private final int sunDistance;
	
	/**
	 * Constructs a planet with the given parameters.
	 * 
	 * @param theName The name of the planet, cannot be null nor empty.
	 * @param theAngularVelocity The angular velocity that explains the circular movement.
	 * If negative then the planet moves clockwise and if positive then it moves
	 * counterclockwise.
	 * @param theSunDistance The distance to the solar system sun, expressed in km.
	 */
	public Planet(final String theName, final int theInitialAngle,
			final int theAngularVelocity, final int theSunDistance) {
		name = theName;
		initialAngle = theInitialAngle;
		angularVelocity = theAngularVelocity;
		sunDistance = theSunDistance;
	}
	
	
	/**
	 * Retrieves the position of the planet the given day.
	 * 
	 * @param day The day for which the point wants to be retrieved.
	 */
	Point getPosition(final int day) {
		int dayAngle = initialAngle + (day * angularVelocity);
		double x = MathUtil.getPositionVectorXCoordinate(sunDistance, dayAngle);
		double y = MathUtil.getPositionVectorYCoordinate(sunDistance, dayAngle);
		return new Point(x, y);
	}
}
