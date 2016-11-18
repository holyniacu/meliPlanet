package com.meli.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.meli.domain.Point;
import com.meli.util.MathUtil;

/**
 * Math util test class.
 * 
 * @author facundocaputo
 */
public class MathUtilTest {

	@Test
	public void testGetPositionVectorXCoordinate() {
		int radio = 500;
		Assert.assertEquals(radio, MathUtil.getPositionVectorXCoordinate(radio, 0), 0.1);
		Assert.assertEquals(0, MathUtil.getPositionVectorXCoordinate(radio, 90), 0.1);
		Assert.assertEquals(-radio, MathUtil.getPositionVectorXCoordinate(radio, 180), 0.1);
		Assert.assertEquals(0, MathUtil.getPositionVectorXCoordinate(radio, 270), 0.1);
		Assert.assertEquals(radio, MathUtil.getPositionVectorXCoordinate(radio, 360), 0.1);
	}
	
	@Test
	public void testGetPositionVectorYCoordinate() {
		int radio = 500;
		Assert.assertEquals(0, MathUtil.getPositionVectorYCoordinate(radio, 0), 0.1);
		Assert.assertEquals(radio, MathUtil.getPositionVectorYCoordinate(radio, 90), 0.1);
		Assert.assertEquals(0, MathUtil.getPositionVectorYCoordinate(radio, 180), 0.1);
		Assert.assertEquals(-radio, MathUtil.getPositionVectorYCoordinate(radio, 270), 0.1);
		Assert.assertEquals(0, MathUtil.getPositionVectorYCoordinate(radio, 360), 0.1);
	}
	
	@Test
	public void testArePointsAligned() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(-1,2));
		points.add(new Point(1,1));
		points.add(new Point(3,0));
		Assert.assertTrue(MathUtil.arePointsAligned(points));
		points.add(new Point(5,-2));
		Assert.assertFalse(MathUtil.arePointsAligned(points));
	}
	
	@Test
	public void testArePointsAligned_deltaError() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(0,0));
		points.add(new Point(1,1));
		points.add(new Point(2,2.000001));
		Assert.assertTrue(MathUtil.arePointsAligned(points));
		points.add(new Point(3,3.00001));
		Assert.assertFalse(MathUtil.arePointsAligned(points));
	}
	
	@Test
	public void testIsPointInsideTriangle() {
		Assert.assertTrue(MathUtil.isPointInsideTriangle(new Point(0.0, 0.0),
				new Point(0.0, 1.0), new Point(-1.0, -1.0), new Point(1.0, -1.0)));
	}
	
	@Test
	public void testIsPointInsideTriangle_edge() {
		//Over the edge of one side
		Assert.assertTrue(MathUtil.isPointInsideTriangle(new Point(0.0, 0.0),
				new Point(0.0, 1.0), new Point(0.0, -1.0), new Point(1.0, 0.0)));
		//Slightly outside one of the edges
		Assert.assertFalse(MathUtil.isPointInsideTriangle(new Point(0.0, 0.0),
				new Point(0.0, 1.0), new Point(1e-6, -1.0), new Point(1.0, 0.0)));
	}
	
	@Test
	public void testGetTrianglePerimeterLength() {
		//Over the edge of one side
		Assert.assertEquals(3.414213, MathUtil.getTrianglePerimeterLength(
				new Point(0.0, 0.0), new Point(1.0, 0.0), new Point(1.0, 1.0)),
				MathUtil.DELTA_ERROR);
	}
	
	@Test
	public void testEquals() {
		Assert.assertFalse(MathUtil.equals(new BigDecimal(0.5),
				new BigDecimal(0.5 + MathUtil.DELTA_ERROR)));
		Assert.assertTrue(MathUtil.equals(new BigDecimal(0.5),
				new BigDecimal(0.5 + (MathUtil.DELTA_ERROR / 2))));
	}
}
