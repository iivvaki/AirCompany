package menu.itemOtherMenu;

import java.util.List;

import menu.plane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TotalCountOfPassenger implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public int totalPassenger(List<PassengerPlane> planes){
        LOG.warn("ϳ�������� �������� ������� ��������");
        int totalSum = 0;
        for (PassengerPlane plane : planes){
            totalSum += plane.getCountOfPassengers();
        } return totalSum;
    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.println("������� �-�� �������� ��� �����: " + totalPassenger(planes) + "\n-------------------------\n");
    }
}
