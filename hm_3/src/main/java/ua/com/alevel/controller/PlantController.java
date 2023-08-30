package ua.com.alevel.controller;

import ua.com.alevel.entity.Plant;
import ua.com.alevel.service.PlantService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlantController {

    private PlantService plantService = new PlantService();

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
        System.out.println(" ");
        System.out.println("If you want create plant please enter 1");
        System.out.println("If you want find plant please enter 2");
        System.out.println("If you want close app please enter 3");
    }

    private void crud(String position, BufferedReader bufferedReader) throws IOException {
        switch (position) {
            case "1" -> create(bufferedReader);
            case "2" -> findAll();
            case "3" -> System.exit(0);
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter Plant Variety ");
        String pv = reader.readLine();
        System.out.println("Please enter Name Plant ");
        String np = reader.readLine();
        System.out.println("Please enter age ");
        int age = Integer.parseInt(reader.readLine());
        plantService.create(pv, np, age);
    }

    private void findAll() {
        Plant[] plants = plantService.findAll();
        for (int i = 0; i < plants.length; i++) {
            Plant plant = plants[i];
            if (plant != null) {
                System.out.println("Plant Variety = " + plants[i].getPlantVariety());
                System.out.println("Name Plant = " + plants[i].getNamePlant());
                System.out.println("Plant age = " + plants[i].getAge());
            }
        }
    }
}
