package menu;

import menu.file.ReadFromFileCommand;
import menu.file.WriteToFileCommand;
import menu.itemMainMenu.*;
import menu.plane.passengerPlane.PassengerPlane;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class MainMenu {
    private final Map<Integer, MenuItem> menuItems;

    public MainMenu(List<PassengerPlane> planes){
        menuItems = new LinkedHashMap<>();
        menuItems.put(1, new PrintListOfPlane(planes));
        menuItems.put(2, new WriteToFileCommand());
        menuItems.put(3, new ReadFromFileCommand());
        menuItems.put(4, new ExitCommand());
    }
    public void execute(Integer command, List<PassengerPlane> planes){
        menuItems.getOrDefault(command, (a) -> System.out.println("Incorrect command. Try again!!!")).execute(planes);
    }
    public void printAvailableCommands(List<PassengerPlane> planes){
        new PrintMainMenuCommand().execute(planes);
    }
}
