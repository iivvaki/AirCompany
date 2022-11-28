package menu.itemOtherMenu;

import menu.plane.PassengerPlane;

import java.util.List;

public class PrintFirstMenu implements FirstMenuItem{


    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.print("""
                \n1.Подивитися більше інформації про літак
                2.Видалити літак із списку
                3.Добавити літак в список
                4.Загальна к-ть пасажирів
                5.Загальна вантажопійомність
                6.Знайти літак за споживанням пального
                7.Відсортувати список літаків за дальністю польоту
                8.На головне меню
                
                -->\t""");
    }
}
