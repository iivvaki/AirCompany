package menu.itemOtherMenu;

import menu.Input;
import menu.plane.CargoPlane;
import menu.plane.PassengerPlane;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.*;

class FindPlaneTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Mock
    FindPlane findPlane;
    @Mock
    List<PassengerPlane> planes;

    @Test
    void viewInfoPlaneTestEmptyList() throws Exception {
        planes = new ArrayList<>();
        findPlane = new FindPlane();
        String text = tapSystemOut(() -> {
            findPlane.findPlane(planes, 0, 10);
        });

        assertEquals("Список пустий, ви не можете користуватися цією функцією...\nДля відновлення списку, перезапустіть програму або заповність список замостійно за допомогою функції <Добавити літак у список>", text.trim());
    }

    @Test
    void findPlane(){
        planes = new ArrayList<>();
        findPlane = new FindPlane();
        var plane1 = new CargoPlane("Траспортний", "AirNevil 225", 0,
                84,6.4, 18.1, 88.4, 300, 640,100000,
                845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
                34, 250, 100, 11600, 900, 250,7000, 12);

        var plane2 = new PassengerPlane("Пасажирський", "AirNevil 70", 157,
                30.91,3.30, 8.5, 28.08, 36.74, 41.73,10731,
                850, 3410, 12.78, "Rolls-Royce RB.183 Tay", 2, 93.5, 35,
                3, 22.7, 10, 10700, 900, 100, 2.7);

        var plane3 = new PassengerPlane("Пасажирський", "AirNevil A319neo", 300,
                33.84,3.7, 11.76, 35.80, 63.9, 75.5,26730,
                828, 6950, 27, "CFM International LEAP-1A", 2, 122.6, 37.5,
                3.7, 61, 16.6, 11900, 890, 100, 8.4);
        planes.add(plane1); planes.add(plane2); planes.add(plane3);

        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
             input.when(Input::getDouble).thenReturn(5);
             input.when(Input::getDouble).thenReturn(10);

            String text = tapSystemOut(() -> {
                findPlane.findPlane(planes, 0 ,10);
            });

            assertEquals("Введіть діапазон споживання пального: \nВід --> До --> №\t\tНазва", text.trim());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}