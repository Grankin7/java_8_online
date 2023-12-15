package ua.com.alevel;

import ua.com.alevel.controller.Controller;
import ua.com.alevel.factory.JdbcFactory;

public class CrudSqlMain {
    public static void main(String[] args) throws Exception {
        JdbcFactory.getInstance().initDB(CrudSqlMain.class);
        Controller mainController = new Controller();
        mainController.start();
    }
}