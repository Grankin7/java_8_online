package ua.com.alevel.controller;

import ua.com.alevel.entity.Builders;
import ua.com.alevel.service.BuildsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {
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
        System.out.println("Если вы хотите создать бригаду нажмите 3");
        System.out.println("Если вы хотите удалить бригаду нажмите 4");
        System.out.println("Если вы хотите добавить строителя в бригаду нажмите 5");
        System.out.println("Если вы хотите посмотреть на список строителей нажмите 6");
        System.out.println("Если вы хотите посмотреть на список бригад со строителями нажмите 7");
        System.out.println("Если вы хотите выйти нажмите 8");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch(position) {
//            case "1" -> create(bufferedReader);
            case "2" -> findAll();
//            case "3" -> creatTeam();
            case "4" -> deleteTeam();
            case "5" -> addToTeam();
            case "6" -> lockAllBuilders();
            case "7" -> lockAllBuildersInTeam();
            case "8" -> System.exit(0);

        }

    }

    private void lockAllBuildersInTeam() {
    }

    private void lockAllBuilders() {
    }

    private void deleteTeam() {
    }

    private void addToTeam() {

    }

    private void creatTeam(BufferedReader bufferedReader) throws IOException {
        System.out.println("Напишите название бригады");
        String name_team = bufferedReader.readLine();
        System.out.println("Выбирите id строителя, которого хотите добавить");
        BuildsService.createTeam(name_team);

    }

    private void findAll() {
        Builders[] builders = buildsService.findAll();
        for (int i = 0; i < builders.length; i++) {
            Builders builder = builders[i];
            if (builder != null) {
                System.out.println("first name = " + builders[i].getFirstname());
                System.out.println("last name = " + builders[i].getLastname());
                System.out.println("specialization = " + builders[i].getSpecialization());
                System.out.println("years of experience = " + builders[i].getYearsOfExperience());
            }
        }
    }

//    private void create(BufferedReader bufferedReader) throws IOException {
//        System.out.println("Please enter first name");
//        String first_name = bufferedReader.readLine();
//        System.out.println("Please enter last name");
//        String last_name = bufferedReader.readLine();
//        System.out.println("Please enter specialization");
//        String spec = bufferedReader.readLine();
//        System.out.println("Please enter years of experience");
//        int year_Experience = Integer.parseInt(bufferedReader.readLine());
//        BuildsService.create(first_name,last_name,spec,year_Experience);

//        builders.setFirstName(fn);
//        builders.setLastName(ln);
//        builders.setAge(age);
//        studentCrudService.create(student);
    }

