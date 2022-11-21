package menu.itemOtherMenu;

import menu.plane.passengerPlane.PassengerPlane;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FindPlane implements FirstMenuItem{
    private static final Logger LOG = LogManager.getLogger();
    public void findPlane(List<PassengerPlane> planes){
        LOG.info("����������� ����� �� ���������� ��������");

        if(planes.size() == 0){
            System.out.println("������ ������, �� �� ������ ������������� ���� ��������...\n" +
                    "��� ���������� ������, ������������ �������� ��� ��������� ������ ��������� �� ��������� ������� <�������� ���� � ������> ");
            return;
        }

        Scanner in = new Scanner(System.in);
        int j = 0;
        System.out.println("������ ������� ���������� ��������: ");
        System.out.print("³� --> ");
        double a = in.nextDouble();
        System.out.print("�� --> ");
        double b = in.nextDouble();
        System.out.println("�\t\t�����");
        for (int i =0;i < planes.size();i++){
            if (planes.get(i).getFuelConsumption() >= a && planes.get(i).getFuelConsumption() <= b){
                System.out.println(j+1 + "\t\t" + planes.get(i).getName());
                j++;
            }
        }


    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        findPlane(planes);
    }
}
