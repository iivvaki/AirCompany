package menu.itemOtherMenu;

import menu.plane.passengerPlane.PassengerPlane;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ChoosePlane implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();
    @Override
    public void execute(List<PassengerPlane> planes) {
        viewInfoPlane(planes);
    }

    public void viewInfoPlane(List<PassengerPlane> planes){
        LOG.error("Користувач вибирає літак для перегляду детальнішої інформації");
        if(planes.size() == 0){
            System.out.println("Список пустий...");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Виберіть літак для перегляду інформації про нього --> ");
        while(true){
            int a = in.nextInt() - 1;
            if(a > planes.size() && a < 0){
                System.out.println("Ви ввели неправильну цифру...\nПовторіть спробу");
            }
            else{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\t["+planes.get(a).getName()+"]\n");
                System.out.println(planes.get(a));
                return;
            }
        }


    }
}
