package com.meli.domain;

/**
 * Represents a point in a two dimension Cartesian coordinate system.
 * 
 * @author facundocaputo
 */
public class Point {

	/** Coordinate in the X axis.*/
	private double x;
	/** Coordinate in the Y axis. */
	private double y;
	
	/**
	 * Constructor for a point with the given coordinates.
	 *
	 * @param theX The x coordinate.
	 * @param theY The Y coordinate.
	 */
	public Point (final double theX, final double theY) {
		x = theX;
		y = theY;
	}
	
	/**
	 * Retrieves the x coordinate.
	 * 
	 * @return The x coordinate.
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Retrieves the y coordinate.
	 * 
	 * @return The y coordinate.
	 */
	public double getY() {
		return y;
	}
	
}
