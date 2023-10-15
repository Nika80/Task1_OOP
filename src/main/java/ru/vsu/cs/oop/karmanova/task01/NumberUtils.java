package ru.vsu.cs.oop.karmanova.task01;

public class NumberUtils {
	public static boolean equalsWithTolerance(double d1, double d2){
		return Math.abs(d1 - d2) <= 1E-6;
	}
}
