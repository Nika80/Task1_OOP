package ru.vsu.cs.oop.karmanova.task01;


import java.util.Optional;

public class Tests {
	public static void testPolygonGroup1(){
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
		if (0.5 != polygonsGroup.getIntersectedArea()) {
			System.err.println("testPolygonGroup1 FAILED");
			return;
		}
		if(5.5 != polygonsGroup.getUnionArea()) {
			System.err.println("testPolygonGroup1 FAILED");
			return;
		}
		System.out.println("testPolygonGroup1 PASSED");
	}

	public static void test2(){
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

		if(0.0 != objectsGroup.getIntersectedArea()) {
			System.err.println("test2 FAILED");
			return;
		}
		if(3.0 != objectsGroup.getUnionArea()) {
			System.err.println("test2 FAILED");
			return;
		}
		System.out.println("test2 PASSED");
	}

	public static void testLineSegmentIntersectionPoint1(){
		Point a = new Point(0.0, 4.0);
		Point b = new Point(0.0, 0.0);
		LineSegment ab = new LineSegment(a, b);

		Point c = new Point(1.0, 0.0);
		Point d = new Point(1.0, 4.0);
		LineSegment cd = new LineSegment(c, d);

		Optional<Point> intersection = ab.getIntersectionPoint(cd);

		if (!Optional.empty().equals(intersection)) {
			System.err.println("testLineSegmentIntersectionPoint1 FAILED");
			return;
		}
		System.out.println("testLineSegmentIntersectionPoint1 PASSED");
	}

	public static void testLineSegmentIntersectionPoint2(){
		Point a = new Point(0.0, 4.0);
		Point b = new Point(4.0, 0.0);
		LineSegment ab = new LineSegment(a, b);

		Point c = new Point(0.0, 0.0);
		Point d = new Point(4.0, 4.0);
		LineSegment cd = new LineSegment(c, d);

		Optional<Point> intersection = ab.getIntersectionPoint(cd);

		if (intersection.isEmpty()){
			System.err.println("testLineSegmentIntersectionPoint2 FAILED");
			return;
		}

		if(!new Point(2.0, 2.0).equals(intersection.get())) {
			System.err.println("testLineSegmentIntersectionPoint2 FAILED");
			return;
		}

		System.out.println("testLineSegmentIntersectionPoint2 PASSED");
	}

	public static void testArea(){
		Point uL = new Point(0.0, 6.0);
		Point uR = new Point(6.0, 6.0);
		Point lR = new Point(6.0, 0.0);
		Point lL = new Point(0.0, 0.0);

		Polygon polygon = new Polygon(uR, uL, lL, lR);

		if(36.0 != polygon.getArea()) {
			System.err.println("testArea FAILED");
			return;
		}
		System.out.println("testArea PASSED");
	}

	public static void testIntersectedByOtherPolygon(){
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

		if(18.0 != polygon2.getAreaIntersectedBy(polygon1)) {
			System.err.println("testIntersectedByOtherPolygon FAILED");
			return;
		}
		System.out.println("testIntersectedByOtherPolygon PASSED");
	}

	public static void runAll(){
		testPolygonGroup1();
		test2();
		testLineSegmentIntersectionPoint1();
		testLineSegmentIntersectionPoint2();
		testArea();
		testIntersectedByOtherPolygon();
	}
}
