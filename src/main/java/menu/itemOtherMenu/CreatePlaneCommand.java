package menu.itemOtherMenu;

import java.util.List;
import java.util.Scanner;

import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;
import menu.plane.CargoPlane;
import menu.plane.CreatePlane;
import menu.plane.PassengerPlane;
import menu.plane.RacePlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static menu.Input.getInt;
import static menu.Input.getInt0_Limit;

public class CreatePlaneCommand implements FirstMenuItem {
    private final CreatePlane createPlane = new CreatePlane();
    private final PassengerPlaneData passengerPlaneData = new PassengerPlaneData();
    private final CargoPlaneData cargoPlaneData = new CargoPlaneData();
    private final RacePlaneData racePlaneData = new RacePlaneData();
    private static final Logger LOG = LogManager.getLogger();

    public void chooseTypePlane(List<PassengerPlane> planes){
        System.out.print("""
                1.Пасажирський
                2.Транспортний
                3.Спортивний
                
                Виберіть категорію -->\t""");
            int a = getInt0_Limit(4);

            switch (a){
                case 1 -> {
                    LOG.info("Створення пасажирського літака");
                    PassengerPlane passengerPlane = CreatePlane.createPassengerPlane();

                    planes.add(passengerPlane);
                    passengerPlaneData.addPlane(passengerPlane);
                    System.out.println("Літак добавлений у список");
                    return;
                }
                case 2 -> {
                    LOG.info("Створення транспортного літака");
                    CargoPlane cargoPlane = CreatePlane.createCargoPlane();
                    cargoPlaneData.addPlane(cargoPlane);
                    planes.add(cargoPlane);
                    System.out.println("Літак добавлений у список");
                    return;
                }
                case 3 -> {
                    LOG.info("Створення спортивного літака");
                    RacePlane racePlane = CreatePlane.createRacePlane();
                    racePlaneData.addPlane(racePlane);
                    planes.add(racePlane);
                    System.out.println("Літак добавлений у список");
                    return;
                }
                default -> System.out.print("Такої категорії не існує...\nПовторіть спробу --> ");
            }


    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        chooseTypePlane(planes);
    }
}
