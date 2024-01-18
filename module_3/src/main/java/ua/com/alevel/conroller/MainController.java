package ua.com.alevel.conroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainController {

    public void start() throws IOException {
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
        System.out.println("Mini Bank application");
        System.out.println("1 - Users Menu");
        System.out.println("2 - Bills Menu");
        System.out.println("3 - Operations Menu");
        System.out.println("0 - Exit");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> {
                new UserController().startUsersMenu();
            }
            case "2" -> {
                new BillController().startBillsMenu();
            }
            case "3" -> {
                new OperationController().startOperationsMenu();
            }
            case "0" -> System.exit(0);
        }
    }

}
