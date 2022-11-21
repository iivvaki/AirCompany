package menu.itemOtherMenu;

import menu.itemOtherMenu.FirstMenuItem;

import java.util.List;

import menu.plane.passengerPlane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TotalCountOfPassenger implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public int totalPassenger(List<PassengerPlane> planes){
        LOG.warn("Підрахунок загальної кількості пасажирів");
        int totalSum = 0;
        for (int i = 0; i < planes.size(); i++){
            totalSum += planes.get(i).getCountOfPassengers();
        }
        return totalSum;
    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.println("Сумарна к-ть паражирів всіх літаків: " + totalPassenger(planes) + "\n-------------------------\n");
    }
}
