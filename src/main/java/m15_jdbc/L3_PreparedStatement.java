package m15_jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Calendar;

public class L3_PreparedStatement {

    public static void main(String[] args) {


        String sql = "INSERT INTO cars(mark_id, model, price) "
                + " VALUES(?,?,?)";

        try(Connection connection = ConnectionManager.open();
            PreparedStatement statement = connection.prepareStatement(sql);)  {

            statement.setInt(1, 57);
            statement.setString(2, "lexus");
            statement.setInt(3, 124214);

            statement.execute();

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
