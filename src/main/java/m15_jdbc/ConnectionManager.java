package m15_jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class ConnectionManager {

//    private static final String URL = "jdbc:mysql://localhost:3306/carsshop";
//    private static final String LOGIN = "root";
//    private static final String PASSWORD = "1994";

    // Загружаем драйвер в память. До версии 1.8 сам не грузился. С 8 версии можно не использовать.
    static {
        loadDriver();
    }

    // Доступы принято хранить в Properties файле
    public static java.sql.Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesManager.get("db.url"),
                    PropertiesManager.get("db.login"),
                    PropertiesManager.get("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {

    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
