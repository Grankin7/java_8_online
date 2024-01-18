package ua.com.alevel.conroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OperationController {

    MainController mainController = new MainController();

    public void startOperationsMenu() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("Operation Menu:");
        System.out.println("Go back enter 0");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
//            case "2" -> findOne(bufferedReader);
//            case "3" -> findAll();
//            case "4" -> delete(bufferedReader);
//            case "5" -> update(bufferedReader);
            case "0" -> mainController.start();
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter first name");
        String fn = reader.readLine();
        System.out.println("Please enter last name");
        String ln = reader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(reader.readLine());
    }

}
