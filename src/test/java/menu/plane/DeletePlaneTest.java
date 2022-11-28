package menu.plane;

import menu.Input;
import menu.itemOtherMenu.ChoosePlane;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static menu.Input.getInt0_Limit;
import static org.junit.jupiter.api.Assertions.*;

class DeletePlaneTest {

    @Mock
    List<PassengerPlane> planes = new ArrayList<>();
    @Mock
    DeletePlane deletePlane;

    @BeforeEach
    public void setUp(){
        planes = new ArrayList<>();
        deletePlane = new DeletePlane();

        planes.add(new CargoPlane("Траспортний", "AirNevil 225", 0,
                84,6.4, 18.1, 88.4, 300, 640,100000,
                845, 15400, 43, "ТР ДД Д-18Т", 6, 905, 35,
                34, 250, 100, 11600, 900, 250,7000, 12));
    }

    @Test
    void deletePlaneTestEmptyList() throws Exception {
        deletePlane = new DeletePlane();
        String text = tapSystemOut(() -> {
            deletePlane.deletePlane(planes);
        });

        assertEquals("Список пустий\nПерезапустіть програму, щоб відновити список або добавте літак самостійно...", text.trim());
    }


    @Test
    void deletePlane(){
        try (MockedStatic<Input> input = Mockito.mockStatic(Input.class)) {
            input.when(()->getInt0_Limit(planes.size()+1)).thenReturn(1);
            String text = tapSystemOut(() -> {
                deletePlane.deletePlane(planes);
            });

            assertEquals("Введіть номер літака, щоб його видалити --> Літак видалений!", text.trim());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}