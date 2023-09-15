package ua.com.alevel;

import ua.com.alevel.controller.MainController;
import ua.com.alevel.entity.Builders;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainController mainController = new MainController();
        mainController.start();
    }
}