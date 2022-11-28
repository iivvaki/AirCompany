package menu.itemMainMenu;

import menu.plane.PassengerPlane;

import java.util.List;

public class PrintMainMenuCommand implements MenuItem {
    @Override
    public void execute(List<PassengerPlane> planes) {
        System.out.print("""
                
                \t\t[Головне меню]
                1.Подивитися список літаків
                2.Записати у файл
                3.Читати з файлу
                4.Вийти
                
                -->\t""");
    }
}
