package m15_jdbc;

import java.sql.*;

public class L5_MetaData {

    public static void main(String[] args) {

        try(Connection connection = ConnectionManager.open();
            Statement statement = connection.createStatement();) {

            // Можно достать данные о базах, таблицах

            DatabaseMetaData meta = connection.getMetaData();

            ResultSet catalogs = meta.getCatalogs(); // список баз

            while(catalogs.next()) {
                System.out.println(catalogs.getString(1));
            }

            //meta.getColumns("cars", "");

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void checkMetadata() {

    }
}
