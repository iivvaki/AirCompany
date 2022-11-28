package menu.itemOtherMenu;

import menu.Input;
import menu.plane.CargoPlane;
import menu.plane.CreatePlane;
import menu.plane.PassengerPlane;
import menu.plane.RacePlane;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static menu.Input.getInt0_Limit;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreatePlaneCommandTest {


    @Mock
    List<PassengerPlane> planes = new ArrayList<>();
    @InjectMocks
    CreatePlane createPlane = new CreatePlane();

    @Test
    void chooseTypePlane1() {
        CreatePlaneCommand createPlaneCommand = new CreatePlaneCommand();

        PassengerPlane plane = new PassengerPlane("Пасажирський", "AirNevil 747-8", 605,
                76.3,6.13, 19.4, 68.5, 213, 448,239000,
                917, 14300, 162, "GEnx-2B67", 4, 552, 37.5,
                6.13, 295, 76.7, 13100, 1102.5, 100, 9.1);

        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class);
                MockedStatic<CreatePlane> create = Mockito.mockStatic(CreatePlane.class)) {
            input.when(() -> getInt0_Limit(4)).thenReturn(1);
            create.when(CreatePlane::createPassengerPlane).thenReturn(plane);

            createPlaneCommand.chooseTypePlane(planes);

            assertEquals(plane, planes.get(0));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void chooseTypePlane2() {
        CreatePlaneCommand createPlaneCommand = new CreatePlaneCommand();

        CargoPlane plane = new CargoPlane("Траспортний", "AirNevil 225", 0,
                84,6.4, 18.1, 88.4, 300, 640,100000,
                845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
                34, 250, 100, 11600, 900, 250,7000, 12);

        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class);
             MockedStatic<CreatePlane> create = Mockito.mockStatic(CreatePlane.class)) {
            input.when(() -> getInt0_Limit(4)).thenReturn(2);
            create.when(CreatePlane::createCargoPlane).thenReturn(plane);

            createPlaneCommand.chooseTypePlane(planes);

            assertEquals(plane, planes.get(0));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void chooseTypePlane3() {
        CreatePlaneCommand createPlaneCommand = new CreatePlaneCommand();

        RacePlane plane = new RacePlane("Спортивний", "AirNevil 747-8", 605,
                76.3,6.13, 19.4, 68.5, 213, 448,239000,
                917, 14300, 162, "GEnx-2B67", 4, 552, 37.5,
                6.13, 295, 76.7, 13100, 1102.5, 100, 9,7,6,3,3);

        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class);
             MockedStatic<CreatePlane> create = Mockito.mockStatic(CreatePlane.class)) {
            input.when(() -> getInt0_Limit(4)).thenReturn(3);
            create.when(CreatePlane::createRacePlane).thenReturn(plane);

            createPlaneCommand.chooseTypePlane(planes);

            assertEquals(plane, planes.get(0));

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void chooseTypePlane4() {
        CreatePlaneCommand createPlaneCommand = new CreatePlaneCommand();


        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
            input.when(() -> getInt0_Limit(4)).thenReturn(1000);

            String text = tapSystemOut(() -> {
                createPlaneCommand.chooseTypePlane(planes);
            });
            assertEquals("1.Пасажирський\n" +
                    "2.Транспортний\n" +
                    "3.Спортивний\n" +
                    "\n" +
                    "Виберіть категорію -->\tТакої категорії не існує...\nПовторіть спробу -->", text.trim());

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}



