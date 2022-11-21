package menu.itemOtherMenu.sortList;

import menu.plane.passengerPlane.PassengerPlane;

import java.util.Comparator;

public class SortingComparatorAsc implements Comparator<PassengerPlane> {

    @Override
    public int compare(PassengerPlane o1, PassengerPlane o2) {
        return o2.getRange() - o1.getRange();
    }
}
