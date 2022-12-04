package menu.database;

import menu.plane.RacePlane;
import menu.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static menu.database.Database.connection;

public class UserData implements DAO<User>{
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public User get(int user_id) {
        User user = new User();
        String query = "select * from Users where user_id = ?";
        connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user_id);
            ResultSet res = statement.executeQuery();

            while (res.next()) {
                user.setId(res.getInt("user_id"));
                user.setLogin(res.getString("login"));
                user.setPassword(res.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println("sql error "+ex.getMessage());
            LOG.error("Проблеми з базою даних {}", ex.getMessage());
        }
        return user;
    }

        @Override
    public ArrayList<User> getAll() {
            ArrayList<User> users = new ArrayList<>();
            String query ="select user_id from Users";
            Database.connection = Database.getConnection();
            try (
                    PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet res = statement.executeQuery())
            {
                while(res.next()){
                    int user_id = res.getInt(1);
                    User van = get(user_id);
                    users.add(van);
                }

            }catch(SQLException ex){
                System.out.println("sql error (get all): "+ex.getMessage());
                LOG.error("Проблеми з базою даних {}", ex.getMessage());
            }
            return users;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean addPlane(User user) {
        String query = "insert into Users(login, password) values(?,?)";


            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();
                System.out.println("КОРИСТУВАЧА ДОДАНО ДО БАЗИ ДАНИХ!");
                LOG.info("Користувача додано до бази даних))");
                return true;

            } catch (SQLException e) {
                System.out.println("sql error (addPlane): "+ e.getMessage());
                LOG.error("Проблеми з базою даних {}", e.getMessage());
            }
        return false;
    }

}
