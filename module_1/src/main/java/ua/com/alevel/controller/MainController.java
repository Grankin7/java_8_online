package ua.com.alevel.controller;

import ua.com.alevel.entity.Builders;
import ua.com.alevel.service.BuildsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    int id = 1;

    private BuildsService buildsService = new BuildsService();
    public void start() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while((position = bufferedReader.readLine()) != null) {
            crud(position, bufferedReader);
            menu();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("Если вы хотите создать строителя нажмите 1");
        System.out.println("Если вы хотите посмотреть строителля нажмите 2");
        System.out.println("Если вы хотите удалить строителля нажмите 3");
        System.out.println("Если вы хотите создать бригаду нажмите 4");
        System.out.println("Если вы хотите удалить бригаду нажмите 5");
        System.out.println("Если вы хотите добавить строителя в бригаду нажмите 6");
        System.out.println("Если вы хотите посмотреть на список бригад со строителями нажмите 7");
        System.out.println("Если вы хотите выйти нажмите 8");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch(position) {
            case "1" -> create(bufferedReader);
            case "2" -> findAll();
            case "3" -> delete(bufferedReader);
            case "4" -> creatTeam(bufferedReader);
            case "5" -> deleteTeam();
            case "6" -> addToTeam();
            case "7" -> lockAllBuildersInTeam();
            case "8" -> System.exit(0);

        }

    }


    private void lockAllBuildersInTeam() {
    }



    private void deleteTeam() {
    }

    private void addToTeam() {

    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Введите имя строителя");
        String firstName = reader.readLine();
        System.out.println("Введите фамилию строителя");
        String lastName = reader.readLine();
        System.out.println("Введите специализацию строителя");
        String specialization = reader.readLine();
        System.out.println("Введите года опыта " + firstName + " " + lastName);
        int ageSpecialization = Integer.parseInt(reader.readLine());
        int ID = id++;
        buildsService.create(firstName, lastName, specialization,  ageSpecialization, ID );
    }

    private void delete(BufferedReader reader) throws IOException {
        getIds();
        System.out.println("Напишите ID строителя ");
        int idBuild = Integer.parseInt(reader.readLine());
        if(true) {
            System.out.println("чет работает");
        }

    }

    private void creatTeam(BufferedReader reader) throws IOException {

        System.out.println("Напишите название бригады");
        String nameTeam = reader.readLine();
    }

    private void findAll() {
        Builders[] builders = buildsService.findAll();
        for (int i = 0; i < builders.length; i++) {
            Builders builder = builders[i];
            if (builder != null) {
                System.out.println( (i + 1) + ") Имя: " + builders[i].getFirstname());
                System.out.println("Фамилия: " + builders[i].getLastname());
                System.out.println("Специализация: " + builders[i].getSpecialization());
                System.out.println("Лет опыта: " + builders[i].getYearsOfExperience());
                System.out.println("ID: " + builders[i].getId());
                System.out.println("_____________________");
            }
        }
    }
    private void getIds() {
        Builders[] builders = buildsService.findAll();
        for (int i = 0; i < builders.length; i++) {
            Builders builder = builders[i];
            if (builder != null) {
                System.out.println(builders[i].getSpecialization() + " " + builders[i].getYearsOfExperience() + " лет опыта с ID: " + builders[i].getId());
                System.out.println("_____________________");
            }
    }


    }
}

