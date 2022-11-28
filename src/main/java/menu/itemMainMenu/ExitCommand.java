package menu.itemMainMenu;

import menu.plane.PassengerPlane;

import java.util.List;

public class ExitCommand implements MenuItem {
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.println("The end");
        System.exit(0);
    }

}
