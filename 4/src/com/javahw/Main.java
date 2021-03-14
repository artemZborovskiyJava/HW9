package com.javahw;

public class Main {

    public static final int MAX_AREA = 100;
    public static final int MAX_SIDE = 200;

    public static void main(String[] args) {
	    /*
	        4*) Подсчитать количество треугольников,
	        у которых стороны заданы целыми числами,
	        и площадь которых не больше 100.
	    */

        int count = 0;
        for (int a = 1; a <= MAX_SIDE; a++) {
            for (int b = a; b <= MAX_SIDE; b++) {
                for (int c = b; c <= MAX_SIDE; c++) {
                    if (a + b > c) {
                        double square = findArea(a, b, c);
                        if (square <= MAX_AREA) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("count -> " + count);
    }

    private static double findArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}