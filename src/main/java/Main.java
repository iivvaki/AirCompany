import menu.MainMenu;
import menu.plane.ListOfPlane;
import menu.plane.PassengerPlane;

import java.util.List;
import java.util.Scanner;

public class Main {
    static ListOfPlane listOfPlane = new ListOfPlane();
    static List<PassengerPlane> planes = listOfPlane.choosePlane();
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu(planes);
        Scanner in = new Scanner(System.in);
        while (true){

            mainMenu.printAvailableCommands(planes);
            int a = in.nextInt();
            mainMenu.execute(a, planes);
        }
    }
}
