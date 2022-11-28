package menu.itemOtherMenu;

import menu.plane.PassengerPlane;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static menu.Input.getDouble;

public class FindPlane implements FirstMenuItem{
    private static final Logger LOG = LogManager.getLogger();
    public void findPlane(List<PassengerPlane> planes){
        LOG.info("Знаходження літака за споживання пального");

        if(planes.size() == 0){
            System.out.println("Список пустий, ви не можете користуватися цією функцією...\n" +
                    "Для відновлення списку, перезапустіть програму або заповність список замостійно за допомогою функції <Добавити літак у список> ");
            return;
        }

        Scanner in = new Scanner(System.in);
        int j = 0;
        System.out.print("Введіть діапазон споживання пального: \n");
        System.out.print("Від --> "); double a = getDouble();
        System.out.print("До --> "); double b = getDouble();
        System.out.println("№\t\tНазва\n");

        for(PassengerPlane plane : planes){
            if (plane.getFuelConsumption() >= a && plane.getFuelConsumption() <= b){
                System.out.println(j+1 + "\t\t" + plane.getName());
                j++;
            }
        }

    }
    @Override
    public void execute(List<PassengerPlane> planes) {
        findPlane(planes);
    }
}
