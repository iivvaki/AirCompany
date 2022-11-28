package menu.itemMainMenu;

import menu.plane.PassengerPlane;

import java.util.List;

public interface MenuItem {
    void execute(List<PassengerPlane> planes);

}
