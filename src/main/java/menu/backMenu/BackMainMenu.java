package menu.backMenu;

import menu.itemOtherMenu.FirstMenuItem;
import menu.MainMenu;
import menu.plane.PassengerPlane;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BackMainMenu implements FirstMenuItem {
    private static final Logger LOG = LogManager.getLogger();

    public void backToMainMenu(List<PassengerPlane> planes){
        LOG.info("���������� � ������� ����");
        MainMenu mainMenu = new MainMenu(planes);
        Scanner in = new Scanner(System.in);

        while (true){

            mainMenu.printAvailableCommands(planes);
            int a = in.nextInt();
            mainMenu.execute(a, planes);
        }
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        backToMainMenu(planes);
    }

}
