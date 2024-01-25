package ua.com.alevel.conroller;

import ua.com.alevel.entity.BankAccount;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.BankAccountCrudService;
import ua.com.alevel.service.UserCrudService;
import ua.com.alevel.service.impl.BankAccountCrudServiceImpl;
import ua.com.alevel.service.impl.UserCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class BillController {

    MainController mainController = new MainController();

    private UserCrudService userCrudService = new UserCrudServiceImpl();
    private BankAccountCrudService bankAccountCrudService = new BankAccountCrudServiceImpl();

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
            case "2" -> findOne(bufferedReader);
            case "3" -> findAll();
            case "4" -> delete(bufferedReader);
            case "5" -> update(bufferedReader);
            case "0" -> mainController.start();
        }
    }

    private void create(BufferedReader reader) throws IOException {
        UserCrudService userCrudService = new UserCrudServiceImpl();
        BufferedReader bufferedReader = new BufferedReader(reader);

        try {
            System.out.println("Enter id user");
            Long id = Long.valueOf(bufferedReader.readLine());

            User user = userCrudService.findOne(id);
            if (user == null) {
                System.out.println("User with id " + id + " not found.");
                return;
            }

            BankAccount bankAccount = new BankAccount();
            bankAccount.setUser(user);

            System.out.println("Enter the amount");
            Long sum = Long.valueOf(bufferedReader.readLine());
            bankAccount.setSum(sum);

            bankAccountCrudService.create(bankAccount);
            System.out.println("Bank account created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid number.");
        }

    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
        BankAccount bankAccount = bankAccountCrudService.findOne(Long.parseLong(id));
        System.out.println("Id: " + bankAccount.getId());
        System.out.println("Sum: " + bankAccount.getSum());

        User user = userCrudService.findOne(bankAccount.getUser().getId());
        System.out.println("Id: " + user.getId());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
    }

    private void findAll() {
        Collection<BankAccount> bankAccounts = bankAccountCrudService.findAll();
        bankAccounts.forEach(bankAccount -> {
            System.out.println(" ");
            System.out.println("Id: " + bankAccount.getId());
            System.out.println("Sum: " + bankAccount.getSum());
        });
    }

    private void delete(BufferedReader reader) throws IOException{
        System.out.println("Enter id");
        String id = reader.readLine();
        bankAccountCrudService.delete(Long.parseLong(id));
    }

    private void update(BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter id bank account");
        String idBankAccount = bufferedReader.readLine();
        System.out.println("Enter the amount");
        Long sum = Long.valueOf(bufferedReader.readLine());
        System.out.println("Enter id user");
        Long id = Long.valueOf(bufferedReader.readLine());

        BankAccount bankAccount = new BankAccount();
        User user = userCrudService.findOne(id);

        bankAccount.setSum(sum);
        bankAccount.setId(Long.parseLong(idBankAccount));
        bankAccount.setUser(user);
        bankAccountCrudService.update(bankAccount);
    }


}
