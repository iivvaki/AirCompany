package menu.itemOtherMenu;

import menu.plane.PassengerPlane;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalCountOfCarryingCapacityTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Mock
    TotalCountOfCarryingCapacity totalCountOfCarryingCapacity;
    @Mock
    List<PassengerPlane> plane;

    @Test
    void totalCarryingCapacity(){
        plane = new ArrayList<>();
        totalCountOfCarryingCapacity = new TotalCountOfCarryingCapacity();
        plane.add(new PassengerPlane("������������", "AirNevil A319neo", 300,
                33.84,3.7, 11.76, 35.80, 63.9, 75.5,26730,
                828, 6950, 27, "CFM International LEAP-1A", 2, 122.6, 37.5,
                3.7, 61, 16.6, 11900, 890, 100, 8.4));
        plane.add(new PassengerPlane("������������", "AirNevil 70", 157,
                30.91,3.30, 8.5, 28.08, 36.74, 41.73,10731,
                850, 3410, 12.78, "Rolls-Royce RB.183 Tay", 2, 93.5, 35,
                3, 22.7, 10, 10700, 900, 100, 2.7));

        assertEquals(200, totalCountOfCarryingCapacity.totalCarryingCapacity(plane));
    }
}