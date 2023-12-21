package ua.com.alevel;

import com.sun.tools.javac.Main;
import ua.com.alevel.conroller.MainController;
import ua.com.alevel.factory.JdbcFactory;

import java.io.IOException;

public class SqlCrudMain {
    public static void main(String[] args) throws IOException {
        JdbcFactory.getInstance().initDB(SqlCrudMain.class);
        MainController mainController = new MainController();
        mainController.start();
    }
}