package menu.plane;


import menu.airlines.Airlines;
import menu.database.*;
import menu.user.User;

import java.util.List;

public class fillList extends Airlines {
//    public List<BasePlane> planeList = choosePassengerPlane();
    PassengerPlaneData planeData = new PassengerPlaneData();
    CargoPlaneData cargoPlaneData = new CargoPlaneData();
    RacePlaneData racePlaneData = new RacePlaneData();

    AirlineData airlineData = new AirlineData();

    UserData userData = new UserData();


    CargoPlane plane = new CargoPlane("Траспортний", "AirNevil 225", 0,
            84,6.4, 18.1, 88.4, 300, 640,100000,
            845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
            34, 250, 100, 11600, 900, 250,7000, 12);

    public List<PassengerPlane> choosePlane(){
        List<PassengerPlane> planes;

        planes = planeData.getAll();
        planes.addAll(cargoPlaneData.getAll());
        planes.addAll(racePlaneData.getAll());

        return planes;
    }
    public List<User> chooseUsers(){
        List<User> users;
        users=userData.getAll();
        return users;
    }

    public List<Airlines> chooseAirlines(){
        List<Airlines> airlines;
        airlines = airlineData.getAll();
        return airlines;
    }


}
