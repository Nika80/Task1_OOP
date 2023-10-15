package ru.vsu.cs.oop.karmanova.task01;

import java.util.*;

public class Polygon implements PlaneElement, Iterable<Point> {
    private final List<Point> vertices;

    public Polygon() {
        this.vertices = new ArrayList<>();
    }

    public Polygon(Point... points) {
        this.vertices = new ArrayList<>(List.of(points));
    }

    public Polygon(Collection<Point> points) {
        this.vertices = new ArrayList<>(points);
    }

    public List<Point> getVertices() {
        List<Point> newList = new ArrayList<>();
        for (Point vertex : vertices) {
            newList.add(new Point(vertex));
        }
        return newList;
    }

    public int getNumberOfVertices(){
        return vertices.size();
    }

    public void add(Point vertex) {
        if (vertices.contains(vertex)) return;
        vertices.add(vertex);
    }

    public void add(List<Point> points) {

        vertices.addAll(points);
    }

    public void add(Point... points) {
        vertices.addAll(List.of(points));
    }

    public boolean remove(Point point) {
        return vertices.remove(point);
    }

    public void remove(Point... points) {
        for (Point point : points) {
            vertices.remove(point);
        }
    }

    private List<Point> getIntersectionPoints(Polygon other) {
        List<Point> intersectionPoints = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            int j = (i + 1) % vertices.size();
            Point firstPoint = vertices.get(i);
            Point secondPoint = vertices.get(j);
            LineSegment firstEdge = new LineSegment(firstPoint, secondPoint);

            for (int k = 0; k < other.getNumberOfVertices(); k++) {
                int l = (k + 1) % other.getNumberOfVertices();
                Point q1 = other.getVertices().get(k);
                Point q2 = other.getVertices().get(l);
                LineSegment secondEdge = new LineSegment(q1, q2);

                Optional<Point> intersectionPoint = firstEdge.getIntersectionPoint(secondEdge);

	            intersectionPoint.ifPresent(intersectionPoints::add);
            }
        }

        return intersectionPoints;
    }

    private boolean containsPoint(Point point) {
        int n = this.getNumberOfVertices();
        if (n < 3) return false;

        double x = point.getX();
        double y = point.getY();
        boolean inside = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            double iX = vertices.get(i).getX();
            double iY = vertices.get(i).getY();
            double jX = vertices.get(j).getX();
            double jY = vertices.get(j).getY();

            boolean intersect = ((iY > y) != (jY > y)) && (x < (jX - iX) * (y - iY) / (jY - iY) + iX);

            if (intersect) {
                inside = !inside;
            }
        }

        return inside;
    }

    private List<Point> getPointsInside(Polygon other) {
        List<Point> pointInside = new ArrayList<>();

        for (Point vertex : vertices) {
            if (other.containsPoint(vertex)) {
                pointInside.add(vertex);
            }
        }

        return pointInside;
    }

    public double getAreaIntersectedBy(Polygon other) {
        Polygon resultPolygon = new Polygon(new ArrayList<>());

        List<Point> intersectionPoints = this.getIntersectionPoints(other);
        for (Point pInside : this.getPointsInside(other)) {
            if(!intersectionPoints.contains(pInside)) intersectionPoints.add(pInside);
        }
        for (Point pInside : other.getPointsInside(this)) {
            if(!intersectionPoints.contains(pInside)) intersectionPoints.add(pInside);
        }

        resultPolygon.add(intersectionPoints);

        return resultPolygon.getArea();
    }

    public double getArea() {
        int numVertices = vertices.size();

        if (numVertices < 3) return 0.0;

        double area = 0.0;
        for (int i = 0; i < numVertices; i++) {
            int j = (i + 1) % numVertices;
            double iX = vertices.get(i).getX();
            double iY = vertices.get(i).getY();
            double jX = vertices.get(j).getX();
            double jY = vertices.get(j).getY();
            area += (iX * jY - jX * iY);
        }

        area = Math.abs(area) / 2.0;
        return area;
    }

    @Override
    public String toString() {
        return "Polygon(" + vertices + ')';
    }

    @Override
    public Iterator<Point> iterator() {
        return vertices.iterator();
    }
}
