package menu.plane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ManipulationPlane {
    private static final Logger LOG = LogManager.getLogger();

    public double totalCarryingCapacity(List<PassengerPlane> planes){
        LOG.info("Підрахунок загальної вантажопійомності");
        double totalSum = 0;
        for (PassengerPlane plane : planes) {
            totalSum += plane.getCarryingCapacity();
        } return totalSum;
    }

    public int totalPassenger(List<PassengerPlane> planes){
        LOG.warn("Підрахунок загальної кількості пасажирів");
        int totalSum = 0;
        for (PassengerPlane plane : planes){
            totalSum += plane.getCountOfPassengers();
        } return totalSum;
    }

    public List<PassengerPlane> findPlane(List<PassengerPlane> planes, int a, int b){
        List<PassengerPlane> list = new ArrayList<>();

        for(PassengerPlane plane : planes){
            if (plane.getFuelConsumption() >= a && plane.getFuelConsumption() <= b){
                list.add(plane);
            }
        }

        return list;
    }
}
