package ru.vsu.cs.oop.karmanova.task01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementsGroupTests {
	@Test
	public void testPolygonGroup1(){
		Point p1 = new Point(1, -3);
		Point p2 = new Point(3, -2);
		Point p3 = new Point(3, -5);
		Polygon polygon1 = new Polygon();
		polygon1.add(p1, p2, p3);

		Point q1 = new Point(2, -3);
		Point q2 = new Point(4, -2);
		Point q3 = new Point(5, -3);
		Point q4 = new Point(4, -4);
		Polygon polygon2 = new Polygon(q1, q2, q3, q4);

		ElementGroup polygonsGroup = new ElementGroup(polygon1, polygon2);
		assertEquals(0.5, polygonsGroup.getIntersectedArea());
		assertEquals(5.5, polygonsGroup.getUnionArea());
	}

	@Test
	public void test2(){
		Point a = new Point(-1, -2);

		Point c = new Point(3, -4);
		Point d = new Point(4, 4);
		LineSegment cd = new LineSegment(c, d);

		Point q1 = new Point(2, -3);
		Point q2 = new Point(4, -2);
		Point q3 = new Point(5, -3);
		Point q4 = new Point(4, -4);
		Polygon polygon2 = new Polygon(q1, q2, q3, q4);

		ElementGroup objectsGroup = new ElementGroup(a, cd, polygon2);

		assertEquals(0.0, objectsGroup.getIntersectedArea());
		assertEquals(3.0, objectsGroup.getUnionArea());
	}

}
