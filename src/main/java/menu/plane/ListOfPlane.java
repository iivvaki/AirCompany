package menu.plane;


import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlane {
    //public List<BasePlane> planeList = choosePassengerPlane();
    PassengerPlaneData planeData = new PassengerPlaneData();
    CargoPlaneData cargoPlaneData = new CargoPlaneData();
    RacePlaneData racePlaneData = new RacePlaneData();
//    public List<PassengerPlane> choosePlane(){
//        List<PassengerPlane> planeList = new ArrayList<>();
//
//        planeList.add(new PassengerPlane("Пасажирський", "AirNevil 747-8", 605,
//                76.3,6.13, 19.4, 68.5, 213, 448,239000,
//                917, 14300, 162, "GEnx-2B67", 4, 552, 37.5,
//                6.13, 295, 76.7, 13100, 1102.5, 100, 9.1));
//
//        planeList.add(new PassengerPlane("Пасажирський", "AirNevil A319neo", 300,
//                33.84,3.7, 11.76, 35.80, 63.9, 75.5,26730,
//                828, 6950, 27, "CFM International LEAP-1A", 2, 122.6, 37.5,
//                3.7, 61, 16.6, 11900, 890, 100, 8.4));
//
//        planeList.add(new PassengerPlane("Пасажирський", "AirNevil 70", 157,
//                30.91,3.30, 8.5, 28.08, 36.74, 41.73,10731,
//                850, 3410, 12.78, "Rolls-Royce RB.183 Tay", 2, 93.5, 35,
//                3, 22.7, 10, 10700, 900, 100, 2.7));
//
//        planeList.add(new CargoPlane("Траспортний", "AirNevil 225", 0,
//                84,6.4, 18.1, 88.4, 300, 640,100000,
//                845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
//                34, 250, 100, 11600, 900, 250,7000, 12));

//        List<PassengerPlane> planes1;
//
//        planes1 = planeData.getAll();
//
//        planeList.addAll(planes1);
//
//        return planeList;
//    }

    public List<PassengerPlane> choosePlane(){
        List<PassengerPlane> planes;

        planes = planeData.getAll();
        planes.addAll(cargoPlaneData.getAll());
        planes.addAll(racePlaneData.getAll());

        return planes;
    }


}
