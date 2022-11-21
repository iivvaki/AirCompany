package menu;

import menu.plane.passengerPlane.PassengerPlane;
import menu.plane.ListOfPlane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    ListOfPlane listOfPlane = new ListOfPlane();
    List<PassengerPlane> planes = listOfPlane.choosePassengerPlane();

    public void menu(){
        MainMenu mainMenu = new MainMenu(planes);
        Scanner in = new Scanner(System.in);
        while (true){

            mainMenu.printAvailableCommands(planes);
            int a = in.nextInt();
            mainMenu.execute(a, planes);
        }

    }


}
