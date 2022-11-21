package menu.itemOtherMenu;

import java.util.List;
import java.util.Scanner;

import menu.plane.cargoPlane.CreateCargoPlane;
import menu.plane.passengerPlane.CreatePassengerPlane;
import menu.plane.passengerPlane.PassengerPlane;
import menu.plane.racePlane.CreateRacePlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CreatePlaneCommand implements FirstMenuItem {
    private CreatePassengerPlane passengerPlane = new CreatePassengerPlane();
    private CreateCargoPlane cargoPlane = new CreateCargoPlane();
    private CreateRacePlane racePlane = new CreateRacePlane();
    private static final Logger LOG = LogManager.getLogger();
    public void chooseTypePlane(List<PassengerPlane> planes){


        System.out.print("""
                1.������������
                2.������������
                3.����������
                
                ������� �������� -->\t""");
        Scanner in = new Scanner(System.in);
        while (true){
            int a = in.nextInt();
            if (a == 1){
                LOG.info("��������� ������������� �����");
                planes.add(passengerPlane.createNewPlane());
                System.out.println("˳��� ���������� � ������");
                return;
            } else if (a == 2) {
                LOG.info("��������� ������������� �����");
                planes.add(cargoPlane.createNewPlane());
                System.out.println("˳��� ���������� � ������");
                return;
            } else if (a == 3) {
                LOG.info("��������� ����������� �����");
                planes.add(racePlane.createRacePlane());
                System.out.println("˳��� ���������� � ������");
                return;
            }else {
                System.out.print("���� ������� �� ����...\n�������� ������ --> ");
            }
        }
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        chooseTypePlane(planes);
    }
}
