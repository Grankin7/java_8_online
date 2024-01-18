package ua.com.alevel;

import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.conroller.MainController;

import java.io.IOException;

public class FinancialManagementMain {
    public static void main(String[] args) throws IOException {
        new MainController().start();
//        HibernateConfig.getInstance();
    }
}