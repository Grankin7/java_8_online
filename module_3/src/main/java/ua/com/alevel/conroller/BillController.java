package ua.com.alevel.conroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class BillController {

    MainController mainController = new MainController();

    public void startBillsMenu() throws IOException {
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
        System.out.println("Bank account Menu:");
        System.out.println("1 - Create account");
        System.out.println("2 - Find account");
        System.out.println("3 - Find all accounts");
        System.out.println("4 - Delete account");
        System.out.println("5 - Update account");
        System.out.println("0 - Go back");
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
        System.out.println("Enter first name");
        String fn = reader.readLine();
        System.out.println("Enter last name");
        String ln = reader.readLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(reader.readLine());
//        User user = new User();
//        user.setFirstName(fn);
//        user.setLastName(ln);
//        user.setAge(age);
//        userCrudService.create(user);
    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
//        User user = userCrudService.findOne(Long.parseLong(id));
//        System.out.println("Id: " + user.getId());
//        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
//        System.out.println("Age: " + user.getAge());
    }

    private void findAll() {
//        Collection<User> users = userCrudService.findAll();
//        users.forEach(user -> {
//            System.out.println("   ");
//            System.out.println("Id: " + user.getId());
//            System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
//            System.out.println("Age: " + user.getAge());
//        });
    }

}
