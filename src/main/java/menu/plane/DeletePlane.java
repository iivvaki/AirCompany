package menu.plane;

import menu.itemOtherMenu.FirstMenuItem;

import java.util.List;
import java.util.Scanner;

import menu.plane.passengerPlane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DeletePlane implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public void deletePlane(List<PassengerPlane> planes){
        LOG.info("���������� ������ ����, ��� �������� ����. � �������, ���� ������ ������");
        if(planes.size() == 0){
            System.out.println("������ ������\n������������ ��������, ��� �������� ������ ��� ������� ���� ���������...\n");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("������ ����� �����, ��� ���� �������� --> ");
        while (true){
            int a = in.nextInt()-1;
            if(a > planes.size() && a < 0){
                System.out.print("�� ����� ����������� �����...\n�������� ������ --> ");
            }else {
                planes.remove(a);
                System.out.println("˳��� ���������!\n\n");
                return;
            }

        }

    }


    @Override
    public void execute(List<PassengerPlane> planes) {
        deletePlane(planes);
    }
}
