package m15_jdbc;

import java.sql.*;
import java.util.Optional;

public class L8_DAO {

      public static void main(String[] args) {

            saveAndDeleteExample();

            CarDAO dao = CarDAO.getInstance();


            var car = dao.findById(1L);

            //car.next().setModel("kalina222");
      }

      public static void saveAndDeleteExample() {
            CarDAO dao = CarDAO.getInstance();

            Car car1 = new Car(null, 5, "cherry", 9950);
            Car savedCar = dao.save(car1);

            System.out.println(savedCar.getId());

            dao.delete(savedCar.getId());
      }

      public static void update() {

      }

}


// таблица. singleton
class CarDAO {

      private static final CarDAO instance = new CarDAO();

      private static final String DELETE_SQL = "DELETE FROM cars WHERE id = ?";

      private static final String SAVE_SQL = "INSERT INTO cars(mark_id, model, price) VALUES (?, ?, ?)";

      private static final String UPDATE_SQL = "UPDATE cars SET mark_id = ?, model = ?, price = ? WHERE id = ?";

      private static final String FIND_BY_ID_SQL = "SELECT * FROM cars WHERE id = ?";


      private CarDAO() {}

      public static CarDAO getInstance() {
            return  instance;
      }

      public Optional<Car> findById(Long id) {
            try (Connection connection = ConnectionManager.open();
                 PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL);) {

                  statement.setLong(1, id);
                  ResultSet result = statement.executeQuery();

                  Car car = null;
                  if(result.next()) {
                        car = new Car(
                                result.getLong("id"),
                                result.getInt("mark_id"),
                                result.getString("model"),
                                result.getInt("price")
                        );
                  }

                  return Optional.ofNullable(car);
            } catch(SQLException e) {
                  throw new DaoException(e);
            }
      }

      public Car save(Car car) {
            try (Connection connection = ConnectionManager.open();
                 PreparedStatement statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);) {

                  statement.setInt(1, car.getMarkId());
                  statement.setString(2, car.getModel());
                  statement.setInt(3, car.getPrice());

                  statement.executeUpdate();

                  ResultSet generatedKeys = statement.getGeneratedKeys();

                  if(generatedKeys.next()) {
                        car.setId(generatedKeys.getLong(1));
                  }

                  return car;

            } catch(SQLException e) {
                  throw new DaoException(e);
            }
      }

      public void update(Car car) {
            try (Connection connection = ConnectionManager.open();
                 PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);) {

                  statement.setInt(1, car.getMarkId());
                  statement.setString(2, car.getModel());
                  statement.setInt(3, car.getPrice());
                  statement.setLong(4, car.getId());

                  statement.executeUpdate();

            } catch(SQLException e) {
                  throw new DaoException(e);
            }
      }

      public boolean delete(Long id) {
            try (Connection connection = ConnectionManager.open();
                 PreparedStatement statement = connection.prepareStatement(DELETE_SQL);) {

                  statement.setLong(1, id);
                  return statement.executeUpdate() > 0;
            } catch(SQLException e) {
                  throw new DaoException(e);
            }
      }
}

// строка таблицы. Entity
class Car {
      private Long id;
      private int markId;
      private String model;
      private int price;

      public Car(Long id, int markId, String model, int price) {
            this.id = id;
            this.markId = markId;
            this.model = model;
            this.price = price;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public int getMarkId() {
            return markId;
      }

      public void setMarkId(int markId) {
            this.markId = markId;
      }

      public String getModel() {
            return model;
      }

      public void setModel(String model) {
            this.model = model;
      }

      public int getPrice() {
            return price;
      }

      public void setPrice(int price) {
            this.price = price;
      }

      @Override
      public String toString() {
            return "Car{" +
                    "id=" + id +
                    ", markId=" + markId +
                    ", model='" + model + '\'' +
                    ", price=" + price +
                    '}';
      }
}

class DaoException extends RuntimeException {
      public DaoException(Throwable throwable) {
            super(throwable);
      }
}