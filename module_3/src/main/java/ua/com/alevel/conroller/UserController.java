package ua.com.alevel.conroller;

import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserCrudService;
import ua.com.alevel.service.impl.UserCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class UserController {

    MainController mainController = new MainController();

    private UserCrudService userCrudService = new UserCrudServiceImpl();

    public void startUsersMenu() throws IOException {
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
        System.out.println("User Menu:");
        System.out.println("1 - Create user");
        System.out.println("2 - Find user");
        System.out.println("3 - Find all users");
        System.out.println("4 - Delete user");
        System.out.println("5 - Update user");
        System.out.println("0 - Go back");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findOne(bufferedReader);
            case "3" -> findAll();
            case "4" -> delete(bufferedReader);
            case "5" -> update(bufferedReader);
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
        User user = new User();
        user.setFirstName(fn);
        user.setLastName(ln);
        user.setAge(age);
        userCrudService.create(user);
    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
        User user = userCrudService.findOne(Long.parseLong(id));
        System.out.println("Id: " + user.getId());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Age: " + user.getAge());
    }

    private void findAll() {
        Collection<User> users = userCrudService.findAll();
        users.forEach(user -> {
            System.out.println("   ");
            System.out.println("Id: " + user.getId());
            System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("Age: " + user.getAge());
        });
    }

    private void delete(BufferedReader reader) throws IOException{
        System.out.println("Enter id");
        String id = reader.readLine();
        userCrudService.delete(Long.parseLong(id));
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
        System.out.println("Enter first name");
        String fn = reader.readLine();
        System.out.println("Enter last name");
        String ln = reader.readLine();
        System.out.println("Enter age");
        int age = Integer.parseInt(reader.readLine());
        User user = new User();
        user.setId(Long.parseLong(id));
        user.setFirstName(fn);
        user.setLastName(ln);
        user.setAge(age);
        userCrudService.update(user);
    }


}
