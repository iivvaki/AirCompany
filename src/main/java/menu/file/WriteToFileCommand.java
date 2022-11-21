package menu.file;

import menu.itemMainMenu.MenuItem;
import menu.plane.passengerPlane.PassengerPlane;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class WriteToFileCommand implements MenuItem {
    private static final Logger LOG = LogManager.getLogger();
    public void writeToFile(List<PassengerPlane> planes) throws IOException {
        LOG.info("Запис літаків у файл");
        ObjectMapper mapper = new ObjectMapper();

        Scanner in = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу --> "); String filename = in.nextLine();

        mapper.writeValue(new File(filename), planes);

    }


    @Override
    public void execute(List<PassengerPlane> planes) {
        try {
            writeToFile(planes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
