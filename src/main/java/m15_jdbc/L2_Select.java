package m15_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class L2_Select {

      public static void main(String[] args) {

            try(Connection connection = ConnectionManager.open();
                Statement statement = connection.createStatement();) {

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
