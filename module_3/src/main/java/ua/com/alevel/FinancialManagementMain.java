package ua.com.alevel;

import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.conroller.MainController;
import ua.com.alevel.entity.User;

import java.io.IOException;

public class FinancialManagementMain {
    public static void main(String[] args) throws IOException {
        HibernateConfig.getInstance();
        new MainController().start();
    }
}