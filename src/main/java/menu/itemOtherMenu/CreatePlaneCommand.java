package menu.itemOtherMenu;

import java.util.List;
import java.util.Scanner;

import menu.plane.cargoPlane.CreateCargoPlane;
import menu.plane.passengerPlane.CreatePassengerPlane;
import menu.plane.passengerPlane.PassengerPlane;
import menu.plane.racePlane.CreateRacePlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CreatePlaneCommand implements FirstMenuItem {
    private CreatePassengerPlane passengerPlane = new CreatePassengerPlane();
    private CreateCargoPlane cargoPlane = new CreateCargoPlane();
    private CreateRacePlane racePlane = new CreateRacePlane();
    private static final Logger LOG = LogManager.getLogger();
    public void chooseTypePlane(List<PassengerPlane> planes){


        System.out.print("""
                1.Пасажирський
                2.Транспортний
                3.Спортивний
                
                Виберіть категорію -->\t""");
        Scanner in = new Scanner(System.in);
        while (true){
            int a = in.nextInt();
            if (a == 1){
                LOG.info("Створення пасажирського літака");
                planes.add(passengerPlane.createNewPlane());
                System.out.println("Літак добавлений у список");
                return;
            } else if (a == 2) {
                LOG.info("Створення транспортного літака");
                planes.add(cargoPlane.createNewPlane());
                System.out.println("Літак добавлений у список");
                return;
            } else if (a == 3) {
                LOG.info("Створення спортивного літака");
                planes.add(racePlane.createRacePlane());
                System.out.println("Літак добавлений у список");
                return;
            }else {
                System.out.print("Такої категорії не існує...\nПовторіть спробу --> ");
            }
        }
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        chooseTypePlane(planes);
    }
}
