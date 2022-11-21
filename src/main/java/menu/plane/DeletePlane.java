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
        LOG.info("Користувач вибирає літак, щоб видалити його. Є виняток, коли список пустий");
        if(planes.size() == 0){
            System.out.println("Список пустий\nПерезапустіть програму, щоб відновити список або добавте літак самостійно...\n");
            return;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Введіть номер літака, щоб його видалити --> ");
        while (true){
            int a = in.nextInt()-1;
            if(a > planes.size() && a < 0){
                System.out.print("Ви ввели неправильне число...\nПовторіть спробу --> ");
            }else {
                planes.remove(a);
                System.out.println("Літак видалений!\n\n");
                return;
            }

        }

    }


    @Override
    public void execute(List<PassengerPlane> planes) {
        deletePlane(planes);
    }
}
