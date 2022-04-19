package m15_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class L4_FetchSize {

    public static void main(String[] args) {

        // fetch size - количество строк которые возвращает селект запрос
        // достает данные частями чтобы не занять всю память одним запросом, если данных очень много
        // обычно 50-100

        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();) {

            statement.setFetchSize(3); //////
            statement.setQueryTimeout(10);
            statement.setMaxRows(11); // обезопасит от out of memory

            ResultSet result = statement.executeQuery("SELECT * FROM cars");

            while (result.next()) {
                System.out.println(result.getString("model"));
                System.out.println(result.getInt("price"));
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
