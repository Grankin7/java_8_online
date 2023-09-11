package ua.com.alevel;

import ua.com.alevel.controller.PlantController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PlantController plantController = new PlantController();
        plantController.start();

    }
}