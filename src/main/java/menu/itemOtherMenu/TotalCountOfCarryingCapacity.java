package menu.itemOtherMenu;

import menu.itemOtherMenu.FirstMenuItem;

import java.util.List;

import menu.plane.passengerPlane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TotalCountOfCarryingCapacity implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public double totalPassenger(List<PassengerPlane> planes){
        LOG.info("Підрахунок загальної вантажопійомності");
        double totalSum = 0;
        for (int i = 0; i < planes.size(); i++){
            totalSum += planes.get(i).getCarryingCapacity();
        }


        return totalSum;
    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.println("Сумарна вантажопійомніть всіх літаків: " + totalPassenger(planes) + "\n-------------------------\n");
    }
}
