package menu.database;

import menu.plane.RacePlane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static menu.database.Database.connection;

public class RacePlaneData implements DAO<RacePlane>{
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public RacePlane get(int id) {
        RacePlane plane = new RacePlane("qeq","qwe",123,123,123,213,3,223,2,3,23,
        33,43,"rer",123,12,3213,12,3,5,2,3,23,2,4,
        34,1,2);
        String query = "select * from RacePlane where id = ?";
        connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet res = statement.executeQuery();
            while (res.next()){
                plane.setName(res.getString("name"));
                plane.setCategory(res.getString("category"));
                plane.setCountEngines(res.getInt("countOfPassenger"));
                plane.setGeneralLength(res.getFloat("length"));
                plane.setWeight(res.getFloat("weight"));
                plane.setHeight(res.getFloat("height"));
                plane.setWingspan(res.getFloat("wingspan"));
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
                plane.setCountOfCrew(res.getInt("countOfCrew"));
                plane.setEmptyMass(res.getInt("emptyMass"));
                plane.setHighSpeed(res.getInt("highSpeed"));
                plane.setEnginePower(res.getInt("enginePower"));
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
    public ArrayList<RacePlane> getAll() {
        ArrayList<RacePlane> planes = new ArrayList<>();
        String query ="select id from RacePlane";
        Database.connection = Database.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet res = statement.executeQuery())
        {
            while(res.next()){
                int id = res.getInt(1);
                RacePlane van = get(id);
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
        String query = "delete from RacePlane where id = ?";
        Database.connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("ЛІТАК ВИДАЛЕНИЙ З БАЗИ ДАНИХ!");
            LOG.info("Фургон {} видалено з списку((",id);
            return true;
        } catch (SQLException e) {
            System.out.println("sql error (delete): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addPlane(RacePlane plane) {
        String query = "insert into RacePlane(name, category, countOfPassengers,length,weight,height,winspan," +
                "maxLandingWeight,maxTakeoffWeight,maxFuelVolume,cruiseSpeed,range,cargoVolume,nameEngine,countEngines," +
                "wingArea,wingGeometryAngle,cabinWidth,maxZeroFuelMass,maxDownload,workingCeiling,maxSpeed,countOfCrew" +
                "emptyMass, highSpeed, enginePower,carryingCapacity,fuelConsumption) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            statement.setInt(23, plane.getCountOfCrew());
            statement.setInt(24, plane.getEmptyMass());
            statement.setInt(25,plane.getHighSpeed());
            statement.setInt(26, plane.getEnginePower());
            statement.setDouble(27, plane.getCarryingCapacity());
            statement.setDouble(28,plane.getFuelConsumption());
            statement.executeUpdate();
            System.out.println("ЛІТАК ДОДАНО ДО БАЗИ ДАНИХ!");
            LOG.info("Літак {} додано до бази даних((");
            return true;
        } catch (SQLException e) {
            System.out.println("sql error (delete): "+ e.getMessage());
            LOG.error("Проблеми з базою даних {}", e.getMessage());
        }


        return false;
    }

    @Override
    public boolean insert(RacePlane racePlane) {
        return false;
    }

    @Override
    public int getID(RacePlane racePlane) {
        return 0;
    }

    @Override
    public boolean isExist(RacePlane racePlane) {
        return false;
    }
}
