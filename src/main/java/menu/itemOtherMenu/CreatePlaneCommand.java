package menu.itemOtherMenu;

import java.util.List;
import java.util.Scanner;

import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;
import menu.plane.CargoPlane;
import menu.plane.CreatePlane;
import menu.plane.PassengerPlane;
import menu.plane.RacePlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static menu.Input.getInt;
import static menu.Input.getInt0_Limit;

public class CreatePlaneCommand implements FirstMenuItem {
    private final CreatePlane createPlane = new CreatePlane();
    private final PassengerPlaneData passengerPlaneData = new PassengerPlaneData();
    private final CargoPlaneData cargoPlaneData = new CargoPlaneData();
    private final RacePlaneData racePlaneData = new RacePlaneData();
    private static final Logger LOG = LogManager.getLogger();

    public void chooseTypePlane(List<PassengerPlane> planes){
        System.out.print("""
                1.������������
                2.������������
                3.����������
                
                ������� �������� -->\t""");
            int a = getInt0_Limit(4);

            switch (a){
                case 1 -> {
                    LOG.info("��������� ������������� �����");
                    PassengerPlane passengerPlane = CreatePlane.createPassengerPlane();

                    planes.add(passengerPlane);
                    passengerPlaneData.addPlane(passengerPlane);
                    System.out.println("˳��� ���������� � ������");
                    return;
                }
                case 2 -> {
                    LOG.info("��������� ������������� �����");
                    CargoPlane cargoPlane = CreatePlane.createCargoPlane();
                    cargoPlaneData.addPlane(cargoPlane);
                    planes.add(cargoPlane);
                    System.out.println("˳��� ���������� � ������");
                    return;
                }
                case 3 -> {
                    LOG.info("��������� ����������� �����");
                    RacePlane racePlane = CreatePlane.createRacePlane();
                    racePlaneData.addPlane(racePlane);
                    planes.add(racePlane);
                    System.out.println("˳��� ���������� � ������");
                    return;
                }
                default -> System.out.print("���� ������� �� ����...\n�������� ������ --> ");
            }


    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        chooseTypePlane(planes);
    }
}
