package m15_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class L1_DDL_Insert_Update {

    public static void main(String[] args) {

        Connection connection = ConnectionManager.open();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            // DDL - create table
            statement.execute("CREATE TABLE IF NOT EXISTS cars (id SERIAL PRIMARY KEY, mark_id int, model varchar(255), price int)");

            // INSERT
            statement.execute("INSERT INTO cars(mark_id, model, price) VALUES (3, 'Kalina', 20000)");

            // UPDATE
            int res = statement.executeUpdate("UPDATE cars SET price = price + 111 WHERE model = 'Kalina'");
            System.out.println(res); // количество обновленных строк

            // EXECUTE batch - several operations
            // batch запросы выполняются за один раз, один запрос. Иначе каждый запрос отправляется в базу, потом база шлет ответ в приложение
            // и так для каждого запроса
            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (3, 'Priora', 4000)");
            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (2, 'cayman', 14000)");
            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (1, 'S7', 100000)");

            statement.executeBatch();

            boolean closed = statement.isClosed();
            System.out.println(closed);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
