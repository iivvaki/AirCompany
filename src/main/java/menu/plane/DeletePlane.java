package menu.plane;

import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;
import menu.itemOtherMenu.FirstMenuItem;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static menu.Input.getInt;
import static menu.Input.getInt0_Limit;

public class DeletePlane implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    private PassengerPlaneData passengerPlaneData = new PassengerPlaneData();
    private RacePlaneData racePlaneData = new RacePlaneData();
    private CargoPlaneData cargoPlaneData = new CargoPlaneData();
    public void deletePlane(List<PassengerPlane> planes){
        LOG.info("���������� ������ ����, ��� �������� ����. � �������, ���� ������ ������");
        if(planes.size() == 0){
            System.out.println("������ ������\n������������ ��������, ��� �������� ������ ��� ������� ���� ���������...\n");
            return;
        }
        System.out.print("������ ����� �����, ��� ���� �������� --> ");
        int a = getInt0_Limit(planes.size()+1)-1;

        switch (planes.get(a).getCategory()) {
            case "������������" -> passengerPlaneData.delete(planes.get(a).getId());
            case "������������" -> cargoPlaneData.delete(planes.get(a).getId());
            case "����������" -> racePlaneData.delete(planes.get(a).getId());
            default -> System.out.println("������ ���� ����� �� ����");
        }

        planes.remove(a);
        System.out.println("˳��� ���������!\n\n");
        return;


}



    @Override
    public void execute(List<PassengerPlane> planes) {
        deletePlane(planes);
    }
}
