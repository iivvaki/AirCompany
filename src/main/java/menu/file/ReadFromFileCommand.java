package menu.file;

import menu.itemMainMenu.MenuItem;
import menu.MainMenu;
import menu.plane.PassengerPlane;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadFromFileCommand implements MenuItem {
    private List<PassengerPlane> readFromFile(String filename){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    new File(filename),
                    new TypeReference<>() {
                    });
        } catch (StreamReadException e) {
            System.out.println("Помилка у файлі або входяча інформація не у json форматі");
        } catch (IOException e) {
            System.out.println("Файл не знайдено");
        }


        return null;
    }

    @Override
    public void execute(List<PassengerPlane> planes) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу --> "); String filename = in.nextLine();

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
