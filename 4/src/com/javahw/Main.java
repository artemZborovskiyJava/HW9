package com.javahw;

public class Main {

    public static final int MAX_AREA = 100;

    public static void main(String[] args) {
	    /*
	        4*) Подсчитать количество треугольников,
	        у которых стороны заданы целыми числами,
	        и площадь которых не больше 100.
	    */

        int count = 0;
        int maxSideLength = getMaxSideLength(MAX_AREA);
        double area = 0;
        for(int a = 1; a <= maxSideLength && area <= MAX_AREA; a++) {
            for(int b = a; b <= maxSideLength && area <= MAX_AREA; b++) {
                for(int c = b; c <= maxSideLength && area <= MAX_AREA; c++) {
                    if(isThereTriangle(a, b, c) && area <= MAX_AREA) {
                        area = getArea(a, b, c);
                        if(area <= MAX_AREA) {
                            count++;
                        }
                    }
                }
                if (area > MAX_AREA) {
                    area = 0;
                }
            }
        }
        System.out.println("count -> " + count);
    }

    private static int getMaxSideLength(int maxArea) {
        int a;
        int b;
        int c;
        for (a = 1, b = 1, c = 1; a + b > c; b++, c++) {
            if (getArea(a, b, c) >= maxArea) {
                break;
            }
        }
        if (b > c) {
            return b - 1;
        } else {
            return c - 1;
        }
    }

    private static boolean isThereTriangle(int a, int b, int c) {
        if(a + b > c) {
            if(b + c > a) {
                if(a + c > b) {
                    return true;
                }
            }
        }
        return false;
    }

    private static double getArea(int a, int b, int c) {
        double p = (double) (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}