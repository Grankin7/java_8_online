package ua.com.alevel.conroller;



import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;
import ua.com.alevel.service.BuilderCrudService;
import ua.com.alevel.service.TeamCrudService;
import ua.com.alevel.service.impl.BuilderCrudServiceImpl;
import ua.com.alevel.service.impl.TeamCrudServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class MainController {

    private BuilderCrudService builderCrudService = new BuilderCrudServiceImpl();
    private TeamCrudService teamCrudService = new TeamCrudServiceImpl();

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
        System.out.println("If you want create builder please enter 1");
        System.out.println("If you want create team please enter 2");
        System.out.println("If you want find builder please enter 3");
        System.out.println("If you want find team please enter 4");
        System.out.println("If you want delete builder please enter 5");
        System.out.println("If you want delete team please enter 6");
        System.out.println("If you want update builder please enter 7");
        System.out.println("If you want update team please enter 8");
        System.out.println("If you want find all builders please enter 9");
        System.out.println("If you want find all teams please enter 10");
        System.out.println("If you want close app please enter 0");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> createTeam(bufferedReader);
            case "3" -> findOne(bufferedReader);
            case "5" -> delete(bufferedReader);
            case "7" -> update(bufferedReader);
            case "9" -> findAll();
            case "10" -> findAllTeam();
            case "6" -> System.exit(0);
        }
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id = reader.readLine();
        System.out.println("Please enter name");
        String name = reader.readLine();
        System.out.println("Please enter speciality");
        String speciality = reader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt(reader.readLine());
        Builder builder = new Builder();
        builder.setId(id);
        builder.setName(name);
        builder.setSpeciality(speciality);
        builder.setAge(age);
        builderCrudService.update(builder);

    }

    private void findOne(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id = reader.readLine();
        Builder builder = builderCrudService.findOne(id);
        System.out.println("id = " + builder.getId());
        System.out.println("first name = " + builder.getName());
        System.out.println("last name = " + builder.getSpeciality());
        System.out.println("age = " + builder.getAge());
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter id");
        String id= reader.readLine();
        builderCrudService.delete(id);
    }

    private void findAll() {
        Collection<Builder> builders = builderCrudService.findAll();
        builders.forEach(builder -> {
            System.out.println("id = " + builder.getId());
            System.out.println("Name = " + builder.getName());
            System.out.println("Speciality = " + builder.getSpeciality());
            System.out.println("age = " + builder.getAge());
            System.out.println(" ");
        });
    }

    private void findAllTeam() {
        Collection<Team> teams = teamCrudService.findAll();
        teams.forEach(team -> {
            System.out.println("Name = " + team.getNameTeam());
            System.out.println("Speciality = " + team.getSpecialization());
            System.out.println(" ");
        });


    }

    private void create(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter name");
        String name = bufferedReader.readLine();
        System.out.println("Please enter speciality");
        String speciality = bufferedReader.readLine();
        System.out.println("Please enter age");
        int age = Integer.parseInt((bufferedReader.readLine()));
        Builder builder = new Builder();
        builder.setName(name);
        builder.setSpeciality(speciality);
        builder.setAge(age);
        builderCrudService.create(builder);
    }

    private void createTeam(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter name team");
        System.out.println();
        String nameTeam = bufferedReader.readLine();
        System.out.println("Please enter specialization");
        String specialization = bufferedReader.readLine();
        System.out.println("Please enter id");
        String id = bufferedReader.readLine();
        Team team = new Team();
        team.setNameTeam(nameTeam);
        team.setSpecialization(specialization);
        team.setIdBuilders(id);
        teamCrudService.create(team);
    }
}
