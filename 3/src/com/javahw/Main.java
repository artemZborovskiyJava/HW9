package com.javahw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
	    /*
	        3*) Написать метод который ищет при помощи бинарного поиска
	        есть ли число в отсортированном массиве
	    */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число -> ");
        int x = scanner.nextInt();
        int[] array = arrayInit(10, 100);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        sortArray(array);
        System.out.println("Ваше число присутствует в массиве: " + findNumber(array, x));
    }

    private static int[] arrayInit(int size, int bound) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(bound);
        }
        return array;
    }

    private static void sortArray(int[] arr) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    isSorted = false;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    private static boolean findNumber(int[] array, int x) {
        int start = 0;
        int end = array.length - 1;
        if (array.length == 1 && array[0] == x) {
            return true;
        }
        while (start >= 0 && end <= array.length - 1) {
            int centerIndex = start + (end - start) / 2;
            int center = array[centerIndex];
            if (center == x || array[start] == x || array[end] == x) {
                return true;
            }
            if (end - start <= 1) {
                return false;
            }
            if (x < center && centerIndex > 0) {
                end = centerIndex - 1;
            } else if (x > center && centerIndex < array.length - 1) {
                start = centerIndex + 1;
            }
        }
        return false;
    }
}