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
            System.out.println("Список пустий, ви не можете користуватися цією функцією...\n" +
                    "Для відновлення списку, перезапустіть програму або заповність список замостійно за допомогою функції <Добавити літак у список> ");
            return null;
        }
        Scanner in = new Scanner(System.in);
        System.out.print("""
                1.Відсортувати за зростанням
                2.Відсортувати за спаданням
                
                -->\t""");
        while (true){
            int a = in.nextInt();
            if(a == 1){
                return PlaneSorting.ASC;
            } else if (a == 2) {
                return PlaneSorting.DES;
            }else {
                System.out.print("Ви вибрали неправильну команду..." +
                    "Повторіть спробу --> ");
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
            LOG.info("Сортування за зростанням");
            sortedPlane.sort(new SortingComparatorAsc());
            return sortedPlane;
        } else if (a == PlaneSorting.DES){
            LOG.info("Сортування за спаданням");
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
