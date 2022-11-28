package menu.itemOtherMenu;

import menu.plane.PassengerPlane;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static menu.Input.getInt;
import static menu.Input.getInt0_Limit;

public class ChoosePlane implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public void execute(List<PassengerPlane> planes) {
        viewInfoPlane(planes);
    }

    public void viewInfoPlane(List<PassengerPlane> planes){
        LOG.info("користувач вибирає літак для перегляду детальнішої інформації");
        if(planes.size() == 0){
            System.out.println("Список пустий...");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Виберіть літак для перегляду інформації про нього --> ");
            int a = getInt0_Limit(planes.size()+1) - 1;

                System.out.print("------------------------------------------------------------------------\n");
                System.out.print("\t\t["+planes.get(a).getName()+"]\n\n");
                System.out.print(planes.get(a)+"\n");

    }
}
