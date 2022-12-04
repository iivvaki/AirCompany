package menu.database;

import menu.airlines.Airlines;
import menu.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static menu.database.Database.connection;

public class AirlineData implements DAO<Airlines>{
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public Airlines get(int id) {
        Airlines airlines = new Airlines();
        String query = "select * from Airlines where airline_id = ?";
        connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                airlines.setId(res.getInt("airline_id"));
                airlines.setCoast(res.getFloat("ticketCoast"));
                airlines.setDate(res.getString("date"));
                airlines.setCountry2(res.getString("country2"));
                airlines.setCity2(res.getString("city2"));
                airlines.setCountry1(res.getString("country1"));
                airlines.setCity1(res.getString("city1"));
                airlines.setNamePlane(res.getString("namePlane"));
            }
        } catch (SQLException ex) {
            System.out.println("sql error "+ex.getMessage());
            LOG.error("Проблеми з базою даних {}", ex.getMessage());
        }
        return airlines;
    }

    @Override
    public ArrayList<Airlines> getAll() {
        ArrayList<Airlines> airlines = new ArrayList<>();
        String query ="select airline_id from Airlines";
        Database.connection = Database.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet res = statement.executeQuery())
        {
            while(res.next()){
                int airlines_id = res.getInt(1);
                Airlines van = get(airlines_id);
                airlines.add(van);
            }

        }catch(SQLException ex){
            System.out.println("sql error (get all): "+ex.getMessage());
            LOG.error("Проблеми з базою даних {}", ex.getMessage());
        }
        return airlines;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from Airlines where airline_id = ?";
        Database.connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("РЕЙС ВИДАЛЕНИЙ З БАЗИ ДАНИХ!");
            LOG.info("Літак {} видалено з списку((",id);
            return true;
        } catch (SQLException e) {
            System.out.println("sql error (delete): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addPlane(Airlines airlines) {
        String query = "insert into Airlines(namePlane, city1, country1, city2, country2, date, ticketCoast) " +
                "values(?,?,?,?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, airlines.getNamePlane());
            statement.setString(2, airlines.getCity1());
            statement.setString(3, airlines.getCountry1());
            statement.setString(4, airlines.getCity2());
            statement.setString(5, airlines.getCountry2());
            statement.setString(6, airlines.getDate());
            statement.setDouble(7, airlines.getCoast());
            statement.executeUpdate();
            System.out.println("РЕЙС ДОДАНО ДО БАЗИ ДАНИХ!");
            LOG.info("Рейс додано до бази даних))");
            return true;

        } catch (SQLException e) {
            System.out.println("sql error (addPlane): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }
        return false;
    }

}
