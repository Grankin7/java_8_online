package ua.com.alevel.controller;

import ua.com.alevel.dictionary.Dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Controller {

    Dictionary<String, String> dictionary = new Dictionary<>();
    Dictionary<String, String> secondDictionary = new Dictionary<>();

    Scanner scanner = new Scanner(System.in);


    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            dictionaryOperations(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println("Виберіть операцію:");
        System.out.println("1. Додати запис");
        System.out.println("2. Додати записи для перевірки");
        System.out.println("3. Видалити запис за ключем");
        System.out.println("4. Отримати розмір словника");
        System.out.println("5. Отримати значення за ключем");
        System.out.println("6. Перевірити наявність ключа");
        System.out.println("7. Перевірити пустий чи не пустий словник");
        System.out.println("8. Перевірити наявність елемента");
        System.out.println("9. Вивести всі значення");
        System.out.println("10. Видалити все");
        System.out.println("11. Вивести массив ключей");
        System.out.println("12. Зїднати с другим словником");
        System.out.println("13. Вивести значення");
        System.out.println("14. Вийти");
    }

    private void dictionaryOperations(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> put();
            case "2" -> noteTest();
            case "3" -> remove();
            case "4" -> size();
            case "5" -> getV();
            case "6" -> containsKey();
            case "7" -> isEmpty();
            case "8" -> containsValue();
            case "9" -> printAll();
            case "10" -> clear();
            case "11" -> keySet();
            case "12" -> putAll();
            case "13" -> values();
            case "14" -> finish();
            default -> System.out.println("Невірний вибір операції. Спробуйте ще раз.");
        }
    }

    public void size() {
        System.out.println("Розмір словника: " + dictionary.size());
    }

    public void noteTest(){
        dictionary.noteTest();
    }

    public void isEmpty() {
        dictionary.isEmpty();
    }

    public void containsKey() {
        System.out.print("Введіть ключ: ");
        String key = scanner.nextLine();

        if (dictionary.containsKey(key)) {
            System.out.println("Ключ присутній.");
            String value = dictionary.get(key);

            if (value != null) {
                System.out.println("Значення: " + value);
                return;
            }
            System.out.println("Запис за ключем не знайдено.");
            return;
        }
        System.out.println("Ключ відсутній.");
    }

    public void containsValue() {
        System.out.print("Введіть значення: ");
        String value = scanner.nextLine();
        if (dictionary.containsValue(value)) {
            System.out.println("Значення присутнє.");
        } else {
            System.out.println("Ключ відсутній.");
        }
    }

    public void getV() {
        System.out.print("Введіть ключ: ");
        String key = scanner.nextLine();
        String retrievedValue = dictionary.get(key);
        if (retrievedValue != null) {
            System.out.println("Значення: " + retrievedValue);
        } else {
            System.out.println("Запис за ключем не знайдено.");
        }
    }

    public void put() {
        System.out.print("Введіть ключ: ");
        String key = scanner.nextLine();
        System.out.print("Введіть значення: ");
        String value = scanner.nextLine();
        if (dictionary.put(key, value)) {
            System.out.println("Запис успішно доданий.");
        } else {
            System.out.println("Ключ вже існує.");
        }
    }

    public void remove() {
        System.out.print("Введіть ключ: ");
        String key = scanner.nextLine();
        if (dictionary.remove(key)) {
            System.out.println("Запис успішно видалений.");
        } else {
            System.out.println("Запис за ключем не знайдено.");
        }
    }

    public void putAll() {
        secondDictionary.secondNoteTest();
        dictionary.putAll(secondDictionary);
    }

    public void clear() {
        dictionary.clear();
    }

    public void keySet() {
        System.out.println(dictionary.keySet());
    }

    public void values() {
        System.out.println(dictionary.values());
    }

    public void printAll() {
        dictionary.printAll();
    }

    public void finish() {
        System.out.println("Дякую за використання словника!");
        scanner.close();
        System.exit(0);
    }
}
