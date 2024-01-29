package ua.com.alevel.dao.impl;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportToCSV {

    public ExportToCSV() {
        String url = "jdbc:mysql://localhost:3306/construction";
        String user = "root";
        String password = "Test123!";

        String query = "SELECT id, amount, user_id_who_gets, user_id_who_transfers FROM operation";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter writer = new FileWriter("file.csv")) {

            while (rs.next()) {
                String column1 = rs.getString("id");
                String column2 = rs.getString("amount");
                String column3 = rs.getString("user_id_who_gets");
                String column4 = rs.getString("user_id_who_transfers");

                writer.append(column1)
                        .append(",")
                        .append(column2)
                        .append(",")
                        .append(column3)
                        .append(",")
                        .append(column4)
                        .append("\n");
            }
            System.out.println("Данные успешно экспортированы в CSV файл.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
