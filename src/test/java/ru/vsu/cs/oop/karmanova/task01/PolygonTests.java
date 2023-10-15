package ru.vsu.cs.oop.karmanova.task01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTests {
	@Test
	public void testArea(){
		Point uL = new Point(0.0, 6.0);
		Point uR = new Point(6.0, 6.0);
		Point lR = new Point(6.0, 0.0);
		Point lL = new Point(0.0, 0.0);

		Polygon polygon = new Polygon(uR, uL, lL, lR);

		assertEquals(36.0, polygon.getArea());
	}

	@Test
	public void testIntersectedByOtherPolygon(){
		Point uL1 = new Point(0.0, 6.0);
		Point uR1 = new Point(6.0, 6.0);
		Point lR1 = new Point(6.0, 0.0);
		Point lL1 = new Point(0.0, 0.0);

		Polygon polygon1 = new Polygon(uR1, uL1, lL1, lR1);

		Point uL2 = new Point(3.0, 6.0);
		Point uR2 = new Point(9.0, 6.0);
		Point lR2 = new Point(9.0, 0.0);
		Point lL2 = new Point(3.0, 0.0);

		Polygon polygon2 = new Polygon(uR2, uL2, lL2, lR2);

		assertEquals(18.0, polygon2.getAreaIntersectedBy(polygon1));
	}
}
