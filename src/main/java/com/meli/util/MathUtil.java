package com.meli.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.meli.domain.Point;

/**
 * Utility class that provides trigonometric calculation helpers.
 * 
 * @author facundocaputo
 *
 */
public class MathUtil {

	/** Delta to compare two double, if the difference is less
	 * than delta then they are considered to be equal. */
	static final double DELTA_ERROR = 1e-6;
	
	/**
	 * Given a circumference radio and an angle calculates the value of the x
	 * coordinate of the position vector.
	 * 
	 * @param radio The circumference radio.
	 * @param angle The angle represented in degrees.
	 * @return The x coordinate of the position vector.
	 */
	public static double getPositionVectorXCoordinate(final int radio, final int angle) {
		return new BigDecimal(radio * Math.cos(Math.toRadians(angle)))
		  .setScale(16, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * Given a circumference radio and an angle calculates the value of the y
	 * coordinate of the position vector.
	 * 
	 * @param radio The circumference radio.
	 * @param angle The angle represented in degrees.
	 * @return The y coordinate of the position vector.
	 */
	public static double getPositionVectorYCoordinate(final int radio, final int angle) {
		return new BigDecimal(radio * Math.sin(Math.toRadians(angle)))
				  .setScale(16, RoundingMode.HALF_UP).doubleValue();
	}
	
	/**
	 * Indicates if all points in the given list can be joined by a single line.
	 * There
	 * 
	 * @param points The list of points, cannot be null nor empty.
	 * @return true if the points are aligned, false otherwise.
	 */
	public static boolean arePointsAligned(final List<Point> points) {
		//Validate.notEmpty(points, "The list of points cannot be null");
		if (points.size() <= 2) {
			//For sure we can join 2 points with a single line.
			return true;
		}
		boolean aligned = false;
		for (int i = 2; i < points.size(); i++) {
			double x1 = points.get(i - 2).getX();
			double y1 = points.get(i - 2).getY();
			double x2 = points.get(i - 1).getX();
			double y2 = points.get(i - 1).getY();
			double x3 = points.get(i).getX();
			double y3 = points.get(i).getY();
			double y2y1Diff = y2 - y1;
			double y3y1Diff = y3 - y1;
			if (equals(new BigDecimal(y2y1Diff), BigDecimal.ZERO)
					&& equals(new BigDecimal(y3y1Diff), BigDecimal.ZERO)) {
				aligned = true;
			} else if (!equals(new BigDecimal(y2y1Diff), BigDecimal.ZERO)
					&& !equals(new BigDecimal(y3y1Diff), BigDecimal.ZERO)) {
				aligned = equals(new BigDecimal((x2 - x1) / y2y1Diff), new BigDecimal((x3 - x1) / y3y1Diff));
			} else {
				aligned = false;
			}
			if (!aligned){
				break;
			}
		}
		return aligned;
	}
	
	/**
	 * Determine through barycentric coordinate system if a point is inside a triangle.
	 * 
	 * @param pointToCheck The point to be verified, cannot be null.
	 * @param triangleVertex1 The first triangle vertex, cannot be null.
	 * @param triangleVertex2 The second triangle vertex, cannot be null.
	 * @param triangleVertex3 The third triangle vertex, cannot be null
	 * @return true if the point to check is inside the triangle, false otherwise.
	 */
	public static boolean isPointInsideTriangle(final Point pointToCheck,
			final Point triangleVertex1, final Point triangleVertex2,
			final Point triangleVertex3) {
		double x = pointToCheck.getX();
		double y = pointToCheck.getY();
		double x1 = triangleVertex1.getX();
		double y1 = triangleVertex1.getY();
		double x2 = triangleVertex2.getX();
		double y2 = triangleVertex2.getY();
		double x3 = triangleVertex3.getX();
		double y3 = triangleVertex3.getY();
		double denominator = ((y2 - y3)*(x1 - x3) + (x3 - x2)*(y1 - y3));
		double a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / denominator;
		double b = ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / denominator;
		double c = 1 - a - b;
		return 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1;
	}
	
	/**
	 * Retrieves the perimeter length of the triangle with the given vertices.
	 * @param vertex1 A triangle vertex, cannot be null.
	 * @param vertex2 A triangle vertex, cannot be null.
	 * @param vertex3 A triangle vertex, cannot be null.
	 * @return The perimeter length of the triangle.
	 */
	public static double getTrianglePerimeterLength(final Point vertex1,
			final Point vertex2, final Point vertex3) {
		double d1 = calculateDistance(vertex1, vertex2);
		double d2 = calculateDistance(vertex2, vertex3);
		double d3 = calculateDistance(vertex1, vertex3);
		return d1 + d2 + d3;
	}
	
	/**
	 * Calculates the length of the line that joins two points.
	 * 
	 * @param point1 A point.
	 * @param point2 Another point
	 * @return The length of the line that joins two points.
	 */
	private static double calculateDistance(final Point point1, final Point point2) {
		double x1 = point1.getX();
		double y1 = point1.getY();
		double x2 = point2.getX();
		double y2 = point2.getY();
		return Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
	}
	
	/**
	 * Indicates if two numbers are equals.
	 * @param x the first number.
	 * @param y the second number
	 * @return true if are equals, false otherwise.
	 */
	public static boolean equals(final BigDecimal n1, final BigDecimal n2) {
		BigDecimal diff = n1.abs().subtract(n2.abs());
		return diff.abs().compareTo(new BigDecimal(DELTA_ERROR)) < 1;
	}
}
