package menu.itemOtherMenu;

import menu.plane.passengerPlane.PassengerPlane;

import java.util.List;

public class PrintFirstMenu implements FirstMenuItem{


    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.print("""
                \n1.���������� ����� ���������� ��� ����
                2.�������� ���� �� ������
                3.�������� ���� � ������
                4.�������� �-�� ��������
                5.�������� ���������������
                6.������ ���� �� ����������� ��������
                7.³���������� ������ ����� �� �������� �������
                8.�� ������� ����
                
                -->\t""");
    }
}
