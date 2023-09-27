package ua.com.alevel.controller;

import ua.com.alevel.matList.MatList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    MatList matList;
    MatList secondMatList;
    Scanner scanner = new Scanner(System.in);
    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while((position = bufferedReader.readLine()) != null) {
            MathOperations(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1 - створити властний массив");
        System.out.println("2 - створити массив з рандомними значеннями");
        System.out.println("3 - додає елемент");
        System.out.println("4 - додає n елементів");
        System.out.println("5 - створити другий MatList");
        System.out.println("6 - об'єднує з іншими MatList");
        System.out.println("7 -  об'єднує з іншими MatList, залишаючи тільки ті елементи, які є в усіх колекціях");
        System.out.println("8 -  сортує колекцію від найбільшого");

//        System.out.println("7 -  сортує колекцію від найбільшого тільки ті елементи, які лежать між firstIndex та lastIndex");
//        System.out.println("8 - сортує колекцію від найбільшого починаючи з value");
//        System.out.println("9 -  сортує колекцію від найменшого");
//        System.out.println("10 - сортує колекцію від найменшого тільки ті елементи, які лежать між firstIndex та lastIndex");
//
//        System.out.println("10 - сортує колекцію від найменшого починаючи з value");
//        System.out.println("11 - ");
//        System.out.println("12 - ");
//        System.out.println("13 - ");
//        System.out.println("14 - віддає середнє значення");
//        System.out.println("15 - віддає медіану");
//        System.out.println("16 - ");
//        System.out.println("17 - ");
//        System.out.println("18 - вирізає з firstIndex по lastIndex");
//        System.out.println("19 - удаляє всі елементи");
//        System.out.println("20 - удаляє елемент по индексу ");
    }

    private void MathOperations(String position, BufferedReader bufferedReader) throws IOException {
        switch(position) {
            case "1" -> createArray();
            case "2" -> createRandomArray();
            case "3" -> addElement();
            case "4" -> addElements();
            case "5" -> createSecondMatList();
            case "6" -> joinMatList();
            case "7" -> intersection();
            case "8" -> sortDesc();
        }

    }

    public  void sortDesc() {

    }

    public void intersection() {
        matList.intersection(secondMatList);
        matList.print();
    }
    public void joinMatList() {
        matList.join(secondMatList);
        matList.print();
    }

    public void createSecondMatList(){
        System.out.println("Напиши розмір массиву");
        int sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];;
        for(int i = 0; i < sizeArray; i++) {
            array[i] = new Random().nextInt(10);
        }
        System.out.print("Ваш массив: ");
        secondMatList = new MatList(array);
        secondMatList.print();
    }

    public void addElements() {
        System.out.println("Напиши кількість елементів");
        int sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];
        System.out.println("Напиши елементи массиву через space");
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Ваш новий массив: ");
        matList.add(array);
        matList.print();
    }

    public void createArray() {
        System.out.println("Напиши розмір массиву");
        int sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];
        System.out.println("Напиши елементи массиву через space");
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Ваш массив: ");
        for (int i = 0; i < sizeArray; i++){
            System.out.print(" " + array[i]);
        }
        matList = new MatList(array);
    }

    public void createRandomArray() {
        System.out.println("Напиши розмір массиву");
        int sizeArray = scanner.nextInt();
        int[] array = new int[sizeArray];
        for(int i = 0; i < sizeArray; i++) {
            array[i] = new Random().nextInt(10);
        }
        System.out.println("Ваш массив: ");
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(" " + array[i]);
        }

        matList = new MatList(array);
    }

    public void addElement() {
        System.out.println("Напиши цисло, яке хочеш добавити в массив: ");
        int addedElement = scanner.nextInt();

        System.out.print("Ваш старий массив: ");
        matList.print();
        System.out.println(" ");
        System.out.print("Ваш новий массив: ");
        matList.add(addedElement);
        matList.print();
    }

}

