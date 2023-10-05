package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static ua.com.alevel.string.Strings.reverse;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    String str;

    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            stringsOperations(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println("Select an operation:");
        System.out.println("1: Write a string");
        System.out.println("2: Fill string automatically");
        System.out.println("3: Usual reverse");
        System.out.println("4: Print your string");
        System.out.println("5: Reverse by specified substring in a string");
        System.out.println("6: Reverse by index");
        System.out.println("0: Exit");
    }

    private void stringsOperations(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> write();
            case "2" -> writeAutomatically();
            case "3" -> usualReverse();
            case "4" -> print();
            case "5" -> substringReverse();
            case "6" -> reverseByIndex();
            case "0" -> finish();
            default -> System.out.println("Incorrect choice of operation. Try again.");
        }
    }

    public String write() {
        System.out.println("Write string");
        String string = scanner.nextLine();
        str = string;
        return str;
    }
    public String writeAutomatically() {
        str = "They went hiking last weekend.";
        return str;
    }

    public void usualReverse() {
        System.out.println(reverse(str));
    }

    public void substringReverse() {
        print();
        System.out.println("Write substring");
        String substring = scanner.nextLine();
        reverse(str, substring);
    }

    public void reverseByIndex() {
        print();
        System.out.println("Write first index");
        int firstIndex = scanner.nextInt();
        System.out.println("Write second index");
        int secondIndex = scanner.nextInt();
        reverse(str, firstIndex, secondIndex);
    }

    public void print() {
        System.out.println(str);
    }

    public void finish() {
        System.out.println("Thanks for using the app!");
        scanner.close();
        System.exit(0);
    }

}
