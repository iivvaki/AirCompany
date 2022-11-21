package menu.itemOtherMenu;

import menu.backMenu.BackMainMenu;
import menu.plane.DeletePlane;
import menu.plane.passengerPlane.PassengerPlane;
import menu.itemOtherMenu.sortList.SortList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FirstMenu{
    private final Map<Integer, FirstMenuItem> firstMenuItem;
    public FirstMenu(List<PassengerPlane> planeList){
        firstMenuItem = new LinkedHashMap<>();
        firstMenuItem.put(1, new ChoosePlane());
        firstMenuItem.put(2, new DeletePlane());
        firstMenuItem.put(3, new CreatePlaneCommand());
        firstMenuItem.put(4, new TotalCountOfPassenger());
        firstMenuItem.put(5, new TotalCountOfCarryingCapacity());
        firstMenuItem.put(6, new FindPlane());
        firstMenuItem.put(7, new SortList());
        firstMenuItem.put(8, new BackMainMenu());

    }

    public void execute(Integer command, List<PassengerPlane> planes) {
        firstMenuItem.getOrDefault(command, (a) -> System.out.println("Incorrect command. Try again!!!")).execute(planes);
    }

    public void printAvailableCommands(List<PassengerPlane> planes){
        new PrintFirstMenu().execute(planes);
    }
}
