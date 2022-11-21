package menu.itemOtherMenu.sortList;

import menu.itemOtherMenu.FirstMenuItem;
import menu.itemMainMenu.PrintListOfPlane;
import menu.plane.passengerPlane.PassengerPlane;

import java.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SortList implements FirstMenuItem {

    private static final Logger LOG = LogManager.getLogger();
    private static PlaneSorting chooseSortType(List<PassengerPlane> planes){
        if (planes.size() == 0){
            System.out.println("������ ������, �� �� ������ ������������� ���� ��������...\n" +
                    "��� ���������� ������, ������������ �������� ��� ��������� ������ ��������� �� ��������� ������� <�������� ���� � ������> ");
            return null;
        }
        Scanner in = new Scanner(System.in);
        System.out.print("""
                1.³���������� �� ����������
                2.³���������� �� ���������
                
                -->\t""");
        while (true){
            int a = in.nextInt();
            if(a == 1){
                return PlaneSorting.ASC;
            } else if (a == 2) {
                return PlaneSorting.DES;
            }else {
                System.out.print("�� ������� ����������� �������..." +
                    "�������� ������ --> ");
            }
        }
    }

    enum PlaneSorting {
        DES,
        ASC
    }

    public static List<PassengerPlane> sortPlane(List<PassengerPlane> planes){
        PlaneSorting a = chooseSortType(planes);

        List<PassengerPlane> sortedPlane = new ArrayList<>(planes);
        if(a == PlaneSorting.ASC){
            LOG.info("���������� �� ����������");
            sortedPlane.sort(new SortingComparatorAsc());
            return sortedPlane;
        } else if (a == PlaneSorting.DES){
            LOG.info("���������� �� ���������");
            sortedPlane.sort(new SortingComparatorDec());
            return sortedPlane;
        }
        else{
            return null;
        }
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        List<PassengerPlane> passengerPlane = sortPlane(planes);
        if(passengerPlane == null){
            return;
        }
        PrintListOfPlane plane = new PrintListOfPlane(passengerPlane);
        plane.execute(passengerPlane);

    }

}
