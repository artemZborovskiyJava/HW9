package com.javahw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    /*
	        2) Попросить пользователя ввести строку и имя файла.
	        Записать строку в файл.
	    */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку которую хотите записать: ");
        String string = scanner.nextLine();
        String fileName;
        do {
            System.out.print("Введите имя файла в который хотите записать даную строку -> ");
            fileName = scanner.nextLine();
        } while(fileName != null && fileName.trim().isEmpty());
        writeToFile(string, fileName);
    }

    private static void writeToFile(String str, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}