package menu.file;

import menu.itemMainMenu.MenuItem;
import menu.plane.PassengerPlane;
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
        LOG.info("����� ����� � ����");
        ObjectMapper mapper = new ObjectMapper();

        Scanner in = new Scanner(System.in);
        System.out.print("������ ���� �� ����� --> "); String filename = in.nextLine();

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
