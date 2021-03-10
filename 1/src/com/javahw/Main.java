package com.javahw;

import java.util.Random;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
	    /*
	        1) Заполнить массив случайными числами. Подсчитать:
            - количество элементов которые больше своего соседа слева
            - количество четных элементов
            - количество элементов которые меньше среднего арифметического
	    */

        int[] array = createArray(10, 100);
        for (int i : array) {
            System.out.print(i + " ");
        }

        int biggerAverageCount = 0;
        double average = 0;
        for(int j : array) {
            average += j;
        }
        average = average / array.length;

        int evenCount = 0;
        int biggerLeftCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != 0 && array[i] > array[i - 1]) {
                biggerLeftCount++;
            }
            if (array[i] % 2 == 0) {
                evenCount++;
            }
            if (array[i] > average) {
                biggerAverageCount++;
            }
        }

        System.out.println("\nКоличество елементов которые больше среднего значения -> " + biggerAverageCount);
        System.out.println("Количество четных елементов -> " + evenCount);
        System.out.println("Количество элементов которые больше своего соседа слева -> " + biggerLeftCount);
    }

    private static int[] createArray(int size, int bound) {
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = RANDOM.nextInt(bound);
        }
        return array;
    }
}