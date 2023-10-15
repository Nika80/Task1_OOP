package ru.vsu.cs.oop.karmanova.task01;

import java.util.Objects;

import static ru.vsu.cs.oop.karmanova.task01.NumberUtils.equalsWithTolerance;

public class Point implements PlaneElement {
    private final double x;
    private final double y;

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point other) {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        boolean isXSame = equalsWithTolerance(this.getX(), point.getX());
        boolean isYSame = equalsWithTolerance(this.getY(), point.getY());

        boolean isDiff1Same = equalsWithTolerance(this.getX(), point.getY());
        boolean isDiff2Same = equalsWithTolerance(this.getY(), point.getX());
        return (isXSame && isYSame) && isDiff1Same && isDiff2Same;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
