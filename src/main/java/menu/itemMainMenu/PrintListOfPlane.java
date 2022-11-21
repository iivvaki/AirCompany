package menu.itemMainMenu;

import menu.itemOtherMenu.FirstMenu;
import menu.plane.passengerPlane.PassengerPlane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Scanner;

public class PrintListOfPlane implements MenuItem {

    private static final Logger LOG = LogManager.getLogger();
    Scanner in = new Scanner(System.in);
    private FirstMenu firstMenu;
    public PrintListOfPlane(List<PassengerPlane> planes) {
        firstMenu = new FirstMenu(planes);
    }



    @Override
    public void execute(List<PassengerPlane> planes) {

        while (true) {
            print(planes);
            firstMenu.printAvailableCommands(planes);
            int a = in.nextInt();
            firstMenu.execute(a,planes);
        }
    }


    private void print(List<PassengerPlane> planes){
        LOG.info("Виведення списку літаків, є виняток коли список пустий");
        if(planes.size() == 0){
            System.out.println("СПИСОК ПУСТИЙ...\nПерезапустіть програму, щоб відновити список, або добавте літаки вручну");

        }

        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("№ |        Літак         |   Тип літака  | Розмах крил(м) | Дальність польоту(км)| Крейсерська швидкість(км/год) |");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < planes.size(); i++){

           System.out.printf("%d | %20s | %9s  | %8.2f%6s | %12d%8s | %16.1f%13s |\n", i + 1, planes.get(i).getName(), planes.get(i).getCategory(),
                    planes.get(i).getWingspan(), ' ', planes.get(i).getRange(), ' ', planes.get(i).getCruiseSpeed(), ' ');

            System.out.println("..................................................................................................................");
        }
    }



}
