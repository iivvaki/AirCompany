package menu.file;

import com.fasterxml.jackson.databind.DatabindException;
import menu.itemMainMenu.MenuItem;
import menu.MainMenu;
import menu.plane.passengerPlane.PassengerPlane;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ReadFromFileCommand implements MenuItem {
    private List<PassengerPlane> readFromFile(String filename){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    new File(filename),
                    new TypeReference<>() {
                    });
        } catch (StreamReadException e) {
            System.out.println("������� � ���� ��� ������� ���������� �� � json ������");
        } catch (IOException e) {
            System.out.println("���� �� ��������");
        }


        return null;
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        Scanner in = new Scanner(System.in);
        System.out.print("������ ���� �� ����� --> "); String filename = in.nextLine();

        planes = readFromFile(filename);

        if(planes == null){
            return;
        }

        MainMenu mainMenu = new MainMenu(planes);

        while (true){

            mainMenu.printAvailableCommands(planes);
            int a = in.nextInt();
            mainMenu.execute(a, planes);
        }

    }
}
