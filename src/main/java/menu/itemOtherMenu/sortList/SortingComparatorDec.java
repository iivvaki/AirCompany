package menu.itemOtherMenu.sortList;

import menu.plane.passengerPlane.PassengerPlane;

import java.util.Comparator;

public class SortingComparatorDec implements Comparator<PassengerPlane> {
    @Override
    public int compare(PassengerPlane o1, PassengerPlane o2) {
        return o1.getRange()- o2.getRange();
    }
}
