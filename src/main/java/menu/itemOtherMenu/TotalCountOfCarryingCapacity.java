package menu.itemOtherMenu;

import java.util.List;

import menu.plane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TotalCountOfCarryingCapacity implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public double totalCarryingCapacity(List<PassengerPlane> planes){
        LOG.info("Підрахунок загальної вантажопійомності");
        double totalSum = 0;
        for (PassengerPlane plane : planes) {
            totalSum += plane.getCarryingCapacity();
        } return totalSum;
    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.println("Сумарна вантажопійомніть всіх літаків: " + totalCarryingCapacity(planes) + "\n-------------------------\n");
    }
}
