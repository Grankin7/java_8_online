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
        System.out.println("9 -  сортує колекцію від найбільшого тільки ті елементи, які лежать між firstIndex та lastIndex");
        System.out.println("10 - сортує колекцію від найбільшого починаючи з value");
        System.out.println("11 -  сортує колекцію від найменшого");
        System.out.println("12 - сортує колекцію від найменшого тільки ті елементи, які лежать між firstIndex та lastIndex");
        System.out.println("13 - сортує колекцію від найменшого починаючи з value");
        System.out.println("14 - вивести значення по index");
        System.out.println("15 - вивести максимальне значення");
        System.out.println("16 - вивести мінімальне значення");
        System.out.println("17 - віддає середнє значення");
        System.out.println("18 - віддає медіану");

        System.out.println("19- вивести массив");
        System.out.println("20 - вивести массив по index");
        System.out.println("21 - вирізає з firstIndex по lastIndex");
        System.out.println("22 - удаляє всі елементи");
        System.out.println("23 - удаляє елемент по индексу");
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
            case "9" -> sortDescByIndex();
            case "10" -> sortDescByValue();
            case "11" -> sortAsc();
            case "12" -> sortAscByIndex();
            case "13" -> sortAscByValue();
            case "14" -> get();
            case "15" -> getMax();
            case "16" -> getMin();
            case "17" -> getAverage();
            case "18" -> getMedian();
            case "19" -> matList.print();
            case "20" ->  cut();
            case "21" ->  cut();
            case "22" -> clear();
            case "23" -> clearNumbers();
        }

    }

    public void clear(){
        matList.clear();
        matList.print();
    }

    public void clearNumbers(){
        matList.print();
        System.out.println("Напиши кількість елементів для видалення");
        int sizeArray = scanner.nextInt();

        Integer[] array = new Integer[sizeArray];
        System.out.println("Напиши елементи массиву через space які хочете видалити");
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Ваш новий массив: ");
        matList.clear(array);
    }


    public void  cut(){
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши перший індекс");
        int firstIndex = scanner.nextInt();
        System.out.println("Напиши другий індекс");
        int lastIndex = scanner.nextInt();
        System.out.println(matList.sortDesc(firstIndex, lastIndex));
    }

    public void getMedian(){
        matList.print();
        System.out.println(" ");
        System.out.println(matList.getMedian());
    }

    public void getAverage(){
        matList.print();
        System.out.println(" ");
        System.out.println("Середнє значення: ");
        System.out.println(matList.getAverage());
    }

    public void getMin(){
        matList.print();
        System.out.println(" ");
        System.out.println("Найменше значення: ");
        matList.getMin();
    }

    public void getMax(){
        matList.print();
        System.out.println(" ");
        System.out.println("Найбільше значення: ");
        matList.getMax();
    }

    public void get(){
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши index значення якого хочешь отримати");
        int index = scanner.nextInt();
        matList.get(index);
    }

    public void sortAscByValue(){
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши value");
        int value = scanner.nextInt();
        matList.sortAsc(value);
        matList.print();
    }

    public void sortAscByIndex(){
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши перший індекс");
        int firstIndex = scanner.nextInt();
        System.out.println("Напиши другий індекс");
        int lastIndex = scanner.nextInt();
        matList.sortDesc(firstIndex, lastIndex);
        matList.sortAsc();
//        matList.sortAscByIndex(firstIndex, lastIndex);
        matList.print();
    }

    public void sortAsc(){
        matList.sortAsc();
        matList.print();
    }

    public void sortDescByValue() {
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши value");
        int value = scanner.nextInt();
        matList.sortDesc(value);
        matList.print();
    }

    public void sortDescByIndex() {
        matList.print();
        System.out.println(" ");
        System.out.println("Напиши перший індекс");
        int firstIndex = scanner.nextInt();
        System.out.println("Напиши другий індекс");
        int lastIndex = scanner.nextInt();
        matList.sortDesc(firstIndex, lastIndex);
        matList.sortDesc();
        matList.print();
    }

    public  void sortDesc() {
        matList.sortDesc();
        matList.print();
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

        Integer[] array = new Integer[sizeArray];;
        for(int i = 0; i < sizeArray; i++) {
            array[i] = new Random().nextInt(20);
        }

        System.out.print("Ваш массив: ");
        secondMatList = new MatList<Integer>(array);
        secondMatList.print();
    }

    public void addElements() {
        System.out.println("Напиши кількість елементів");
        int sizeArray = scanner.nextInt();

        Integer[] array = new Integer[sizeArray];
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

        Integer[] array = new Integer[sizeArray];
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

        Integer[] array = new Integer[sizeArray];
        for(int i = 0; i < sizeArray; i++) {
            array[i] = new Random().nextInt(20);
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

