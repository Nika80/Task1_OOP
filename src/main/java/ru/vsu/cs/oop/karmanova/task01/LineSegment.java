package ru.vsu.cs.oop.karmanova.task01;

import java.util.Optional;

public class LineSegment implements PlaneElement {
	private final Point start;
	private final Point end;

	public LineSegment(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public LineSegment(double startX, double startY, double endX, double endY) {
		this.start = new Point(startX, startY);
		this.end = new Point(endX, endY);
	}

	public Point getStart() {
		return new Point(start);
	}

	public Point getEnd() {
		return new Point(end);
	}

	@Override
	public String toString() {
		return "LineSegment(start=" + start + ", end=" + end + ')';
	}

	private boolean isPointOnSegment(Point point) {
		return (point.getX() >= Math.min(this.start.getX(), this.end.getX()) &&
				point.getX() <= Math.max(this.start.getX(), this.end.getX()) &&
				point.getY() >= Math.min(this.start.getY(), this.end.getY()) &&
				point.getY() <= Math.max(this.start.getY(), this.end.getY()));
	}

	public Optional<Point> getIntersectionPoint(LineSegment other) {
		double x1 = this.start.getX();
		double y1 = this.start.getY();
		double x2 = this.end.getX();
		double y2 = this.end.getY();

		double x3 = other.start.getX();
		double y3 = other.start.getY();
		double x4 = other.end.getX();
		double y4 = other.end.getY();

		double A1 = y2 - y1;
		double B1 = x1 - x2;
		double C1 = x2 * y1 - x1 * y2;

		double A2 = y4 - y3;
		double B2 = x3 - x4;
		double C2 = x4 * y3 - x3 * y4;

		double determinant = A1 * B2 - A2 * B1;

		if (determinant == 0) {
			return Optional.empty();
		}

		double intersectionX = -(B2 * C1 - B1 * C2) / determinant;
		double intersectionY = -(A1 * C2 - A2 * C1) / determinant;
		Point intersectionPoint = new Point(intersectionX, intersectionY);

		if (this.isPointOnSegment(intersectionPoint) && other.isPointOnSegment(intersectionPoint)) {
			return Optional.of(intersectionPoint);
		}

		return Optional.empty();
	}
}
