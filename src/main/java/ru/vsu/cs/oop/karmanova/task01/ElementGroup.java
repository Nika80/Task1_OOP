package ru.vsu.cs.oop.karmanova.task01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ElementGroup implements PlaneElement, Iterable<PlaneElement> {
    private final List<PlaneElement> elements;

    public ElementGroup(){
        this.elements = new ArrayList<>();
    }
    public ElementGroup(PlaneElement... elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }
    public ElementGroup(Collection<PlaneElement> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public void add(PlaneElement object) {
        this.elements.add(object);
    }

    public boolean remove(PlaneElement object) {
        return this.elements.remove(object);
    }

    @Override
    public String toString() {
        return "Group(" + elements + ')';
    }

    public double getIntersectedArea() {
        if (elements.isEmpty()) return 0.0;

        List<Polygon> polygons = new ArrayList<>();
        for (PlaneElement object : elements) {
            if (object instanceof Polygon) {
                polygons.add((Polygon) object);
            }
        }

        if (polygons.size() == 1) return 0.0;

        double area = 0.0;

        for (Polygon polygon1 : polygons) {
            for (Polygon polygon2 : polygons) {
                if (polygon1 == polygon2) continue;
                area += polygon1.getAreaIntersectedBy(polygon2);
            }
        }

        return area / 2.0;
    }

    public double getUnionArea() {
        if (elements.isEmpty()) return 0.0;

        List<Polygon> polygons = new ArrayList<>();
        for (PlaneElement object : elements) {
            if (object instanceof Polygon) {
                polygons.add((Polygon) object);
            }
        }

        if (polygons.size() == 1) return polygons.get(0).getArea();

        double area = 0.0;

        for (Polygon polygon1 : polygons) {
            for (Polygon polygon2 : polygons) {
                if (polygon1 != polygon2) {
                    area += polygon1.getArea() + polygon2.getArea() - polygon1.getAreaIntersectedBy(polygon2);
                }
            }
        }

        return area / 2.0;
    }

    @Override
    public Iterator<PlaneElement> iterator() {
        return elements.iterator();
    }
}
