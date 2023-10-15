package ru.vsu.cs.oop.karmanova.task01;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LineSegmentTests {
	@Test
	public void testLineSegmentIntersectionPoint1(){
		Point a = new Point(0.0, 4.0);
		Point b = new Point(0.0, 0.0);
		LineSegment ab = new LineSegment(a, b);

		Point c = new Point(1.0, 0.0);
		Point d = new Point(1.0, 4.0);
		LineSegment cd = new LineSegment(c, d);

		Optional<Point> intersection = ab.getIntersectionPoint(cd);

		assertEquals(Optional.empty(), intersection);
	}

	@Test
	public void testLineSegmentIntersectionPoint2(){
		Point a = new Point(0.0, 4.0);
		Point b = new Point(4.0, 0.0);
		LineSegment ab = new LineSegment(a, b);

		Point c = new Point(0.0, 0.0);
		Point d = new Point(4.0, 4.0);
		LineSegment cd = new LineSegment(c, d);

		Optional<Point> intersection = ab.getIntersectionPoint(cd);

		if (intersection.isEmpty()){
			fail();
		}

		assertEquals(new Point(2.0, 2.0), intersection.get());
	}
}
