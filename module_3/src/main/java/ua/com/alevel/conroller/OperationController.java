package ua.com.alevel.conroller;

import ua.com.alevel.dao.impl.OperationDaoImpl;
import ua.com.alevel.entity.BankAccount;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.BankAccountCrudService;
import ua.com.alevel.service.OperationCrudService;
import ua.com.alevel.service.UserCrudService;
import ua.com.alevel.service.impl.BankAccountCrudServiceImpl;
import ua.com.alevel.service.impl.OperationCrudServiceImpl;
import ua.com.alevel.service.impl.UserCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class OperationController {

    MainController mainController = new MainController();

    private OperationCrudService operationCrudService = new OperationCrudServiceImpl();
    UserCrudService userCrudService = new UserCrudServiceImpl();
    private BankAccountCrudService bankAccountCrudService = new BankAccountCrudServiceImpl();

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
        System.out.println("1 - Create operation");
        System.out.println("2 - Find operation");
        System.out.println("3 - Find all operation");
        System.out.println("4 - Delete account");
        System.out.println("Go back enter 0");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findOne(bufferedReader);
            case "3" -> findAll();
            case "4" -> delete(bufferedReader);
//            case "5" -> update(bufferedReader);
            case "0" -> mainController.start();
        }
    }

    private void create(BufferedReader reader) throws IOException {
        Operation operation = new Operation();

        try {
            System.out.println(" ");
            System.out.println("Who transfer money write the bill ID:");
            String transfer = reader.readLine();
            System.out.println("Who receives money write the bill ID:");
            String receives = reader.readLine();
            System.out.println("Amount to transfer money:");

            User userTransfer = userCrudService.findOne(Long.parseLong(transfer));
            if (userTransfer == null) {
                System.out.println("User with id " + transfer + " not found.");
                return;
            }

            operation.setUserWhoTransfers(userTransfer);

            User userReceives = userCrudService.findOne(Long.parseLong(receives));
            if (userReceives == null) {
                System.out.println("User with id " + receives + " not found.");
                return;
            }

            operation.setUserWhoGets(userReceives);

            Long sum = Long.valueOf(reader.readLine());
            if(sum == null) {
                System.out.println("Not found.");
                return;
            }

            operation.setSum(sum);

            operationCrudService.create(operation);

            updateSum(Long.parseLong(transfer), Long.parseLong(receives), sum);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid number.");
        }

    }

    private void findAll() {
        Collection<Operation> operations = operationCrudService.findAll();
        operations.forEach(operation -> {
            System.out.println(" ");
            System.out.println("Id operation: " + operation.getId());
            System.out.println("Amount: " + operation.getSum());

            User userWhoTransfers = userCrudService.findOne(operation.getUserWhoTransfers().getId());
            System.out.println("Who Transfer: ");
            System.out.println("Id: " + userWhoTransfers.getId());
            System.out.println("Name: " + userWhoTransfers.getFirstName() + " " + userWhoTransfers.getLastName());

            User user = userCrudService.findOne(operation.getUserWhoGets().getId());
            System.out.println("Who Get: ");
            System.out.println("Id: " + user.getId());
            System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
            System.out.println("---------------------------------");
        });
    }

    private void updateSum(Long idUserWhoTransfers, Long idUserWhoGets, Long sumTransactions) throws IOException {
        BankAccount userWhoTransfers = bankAccountCrudService.findOne(idUserWhoTransfers);
        BankAccount userWhoGets = bankAccountCrudService.findOne(idUserWhoGets);

        Long SumUserWhoTransfers = userWhoTransfers.getSum();
        Long SumUserWhoGets = userWhoGets.getSum();

        Long updateSumUserWhoTransfers = SumUserWhoTransfers - sumTransactions;
        userWhoTransfers.setSum(updateSumUserWhoTransfers);

        Long updateSumUserWhoGets = SumUserWhoGets + sumTransactions;
        userWhoGets.setSum(updateSumUserWhoGets);

        bankAccountCrudService.update(userWhoTransfers);
        bankAccountCrudService.update(userWhoGets);
    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Enter id");
        String id = reader.readLine();
        Operation operation = operationCrudService.findOne(Long.parseLong(id));
        System.out.println("Id operation: " + operation.getId());
        System.out.println("Amount: " + operation.getSum());

        User userWhoTransfers = userCrudService.findOne(operation.getUserWhoTransfers().getId());
        System.out.println("Who Transfer: ");
        System.out.println("Id: " + userWhoTransfers.getId());
        System.out.println("Name: " + userWhoTransfers.getFirstName() + " " + userWhoTransfers.getLastName());

        User user = userCrudService.findOne(operation.getUserWhoGets().getId());
        System.out.println("Who Get: ");
        System.out.println("Id: " + user.getId());
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
    }

    private void delete(BufferedReader reader) throws IOException{
        System.out.println("Enter id");
        String id = reader.readLine();
        operationCrudService.delete(Long.parseLong(id));
    }

}
