package m15_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class L6_Transactions {

      public static void main(String[] args) {

            Connection connection = null;
            Statement statement;

            try {
                  connection = ConnectionManager.open();
                  statement = connection.createStatement();

                  connection.setAutoCommit(false);

                  try {
                        // some sql operations

                        connection.commit();

                  } catch (Exception e) {
                        if(connection != null) {
                              connection.rollback();
                        }
                  }

            } catch(SQLException e) {
                  System.out.println(e.getMessage());
            }

      }


}
