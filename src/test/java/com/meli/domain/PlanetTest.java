package com.meli.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.meli.domain.Planet;
import com.meli.domain.Point;
import com.meli.util.MathUtil;

public class PlanetTest {

	@Test public void testGetPosition() {
		Planet planet = new Planet("test", 90, -1, 500);
		Point position = planet.getPosition(0);
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getX()), BigDecimal.ZERO));
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getY()), new BigDecimal(500)));
		position = planet.getPosition(90);
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getX()), new BigDecimal(500)));
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getY()), BigDecimal.ZERO));
		position = planet.getPosition(180);
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getX()), BigDecimal.ZERO));
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getY()), new BigDecimal(-500)));
		position = planet.getPosition(270);
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getX()), new BigDecimal(-500)));
		Assert.assertTrue(MathUtil.equals(new BigDecimal(position.getY()), BigDecimal.ZERO));
	}
	
}
