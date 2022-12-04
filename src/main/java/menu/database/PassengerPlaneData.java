package menu.database;

import menu.plane.PassengerPlane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static menu.database.Database.connection;

public class PassengerPlaneData implements DAO<PassengerPlane>{
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public PassengerPlane get(int id) {
        PassengerPlane plane = new PassengerPlane();
        String query = "select * from PassengerPlane where id = ?";
        connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                plane.setName(res.getString("name"));
                plane.setCategory(res.getString("category"));
                plane.setCountOfPassengers(res.getInt("countOfPassengers"));
                plane.setGeneralLength(res.getFloat("length"));
                plane.setWeight(res.getFloat("weight"));
                plane.setHeight(res.getFloat("height"));
                plane.setWingspan(res.getFloat("winspan"));
                plane.setMaxLandingWeight(res.getFloat("maxLandingWeight"));
                plane.setMaxTakeoffWeight(res.getFloat("maxTakeoffWeight"));
                plane.setMaxFuelVolume(res.getFloat("maxFuelVolume"));
                plane.setCruiseSpeed(res.getFloat("cruiseSpeed"));
                plane.setRange(res.getInt("range"));
                plane.setCargoVolume(res.getFloat("cargoVolume"));
                plane.setNameEngine(res.getString("nameEngine"));
                plane.setCountEngines(res.getInt("countEngines"));
                plane.setWingArea(res.getFloat("wingArea"));
                plane.setWingGeometryAngle(res.getFloat("wingGeometryAngle"));
                plane.setCabinWidth(res.getFloat("cabinWidth"));
                plane.setMaxZeroFuelMass(res.getFloat("maxZeroFuelMass"));
                plane.setMaxDownload(res.getFloat("maxDownload"));
                plane.setWorkingCeiling(res.getFloat("workingCeiling"));
                plane.setMaxSpeed(res.getFloat("maxSpeed"));
                plane.setCarryingCapacity(res.getFloat("carryingCapacity"));
                plane.setFuelConsumption(res.getFloat("fuelConsumption"));
                plane.setId(res.getInt("id"));


            }

        }catch(SQLException ex){

            System.out.println("sql error "+ex.getMessage());
            LOG.error("Проблеми з базою даних {}", ex.getMessage());
        }
        return plane;

    }

    @Override
    public ArrayList<PassengerPlane> getAll() {
        ArrayList<PassengerPlane> planes = new ArrayList<>();
        String query ="select id from PassengerPlane";
        Database.connection = Database.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet res = statement.executeQuery())
        {
            while(res.next()){
                int id = res.getInt(1);
                PassengerPlane van = get(id);
                planes.add(van);
            }

        }catch(SQLException ex){
            System.out.println("sql error (get all): "+ex.getMessage());
            LOG.error("Проблеми з базою даних {}", ex.getMessage());
        }
        return planes;
    }

    @Override
    public boolean delete(int id){
        String query = "delete from PassengerPlane where id = ?";
        Database.connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("ЛІТАК ВИДАЛЕНИЙ З БАЗИ ДАНИХ!");
            LOG.info("Літак {} видалено з бази даних((",id);
            return true;
        } catch (SQLException e) {
            System.out.println("sql error (delete): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addPlane(PassengerPlane plane) {

        String query = "insert into PassengerPlane(name, category, countOfPassengers,length,weight,height,winspan," +
                "maxLandingWeight,maxTakeoffWeight,maxFuelVolume,cruiseSpeed,range,cargoVolume,nameEngine,countEngines," +
                "wingArea,wingGeometryAngle,cabinWidth,maxZeroFuelMass,maxDownload,workingCeiling,maxSpeed,carryingCapacity," +
                "fuelConsumption) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,plane.getName());
            statement.setString(2,"Пасажирський");
            statement.setInt(3,plane.getCountOfPassengers());
            statement.setDouble(4,plane.getGeneralLength());
            statement.setDouble(5,plane.getWeight());
            statement.setDouble(6, plane.getHeight());
            statement.setDouble(7,plane.getWingspan());
            statement.setDouble(8,plane.getMaxLandingWeight());
            statement.setDouble(9,plane.getMaxTakeoffWeight());
            statement.setDouble(10,plane.getMaxFuelVolume());
            statement.setDouble(11,plane.getCruiseSpeed());
            statement.setInt(12,plane.getRange());
            statement.setDouble(13,plane.getCargoVolume());
            statement.setString(14, plane.getNameEngine());
            statement.setInt(15, plane.getCountEngines());
            statement.setDouble(16, plane.getWingArea());
            statement.setDouble(17, plane.getWingGeometryAngle());
            statement.setDouble(18, plane.getCabinWidth());
            statement.setDouble(19,plane.getMaxZeroFuelMass());
            statement.setDouble(20, plane.getMaxDownload());
            statement.setDouble(21, plane.getWorkingCeiling());
            statement.setDouble(22, plane.getMaxSpeed());
            statement.setDouble(23, plane.getCarryingCapacity());
            statement.setDouble(24,plane.getFuelConsumption());
            statement.executeUpdate();
            System.out.println("ЛІТАК ДОДАНО ДО БАЗИ ДАНИХ!");
            LOG.info("Літак {} додано до бази даних((");
            return true;
        } catch (SQLException e) {
            System.out.println("sql error (addPlane): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }


        return false;
    }





}
