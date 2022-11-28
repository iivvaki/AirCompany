package menu.itemMainMenu;

import menu.plane.PassengerPlane;

import java.util.List;

public class PrintMainMenuCommand implements MenuItem {
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.print("""
                
                \t\t[������� ����]
                1.���������� ������ �����
                2.�������� � ����
                3.������ � �����
                4.�����
                
                -->\t""");
    }
}
