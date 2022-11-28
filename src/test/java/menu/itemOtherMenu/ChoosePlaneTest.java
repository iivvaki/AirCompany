package menu.itemOtherMenu;

import menu.Input;
import menu.plane.CargoPlane;
import menu.plane.PassengerPlane;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static menu.Input.getInt0_Limit;
import static org.junit.jupiter.api.Assertions.*;

class ChoosePlaneTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Mock
    ChoosePlane choosePlane;
    @Mock
    List<PassengerPlane> planes;
    @BeforeEach
    public void setUp(){
        planes = new ArrayList<>();
        choosePlane= new ChoosePlane();

        planes.add(new CargoPlane("Траспортний", "AirNevil 225", 0,
                84,6.4, 18.1, 88.4, 300, 640,100000,
                845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
                34, 250, 100, 11600, 900, 250,7000, 12));
    }

    @Test
    void viewInfoPlaneTestEmptyList() throws Exception {
        List<PassengerPlane> plane = new ArrayList<>();
        String text = tapSystemOut(() -> {
            choosePlane.viewInfoPlane(plane);
        });

        Assert.assertEquals("Список пустий...", text.trim());
    }

    @Test
    void viewInfoPlaneTestNotEmptyList(){

        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
            input.when(()->getInt0_Limit(planes.size()+1)).thenReturn(1);
            String text = tapSystemOut(() -> {
                choosePlane.viewInfoPlane(planes);
            });

            assertEquals("Виберіть літак для перегляду інформації про нього --> ------------------------------------------------------------------------\n\t\t["+planes.get(0).getName()+"]\n\n"+planes.get(0).toString(), text.trim());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
