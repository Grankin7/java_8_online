package ua.com.alevel;

import ua.com.alevel.conroller.MainController;
import ua.com.alevel.config.HibernateConfig;

import java.io.IOException;

public class HibernateMain {
    public static void main(String[] args) throws IOException {
        new MainController().start();
//        HibernateConfig.getInstance();

    }
}