package menu.plane.racePlane;

import java.util.Scanner;

import static java.lang.System.out;

public class CreateRacePlane {
    public RacePlane createRacePlane(){
        Scanner in = new Scanner(System.in);
        out.println("При створенні літака дотримуйтеся вказівок або підкозок!");

        out.print("Назва --> "); String name = in.nextLine();
        out.print("К-ть екіпажу(не більше 2) --> "); int countOfCrew = in.nextInt();
        while (true){
            if(countOfCrew > 2 || countOfCrew < 1){
                out.print("Ви ввели невірну кількість членів екіпажу...\nПовторіть спробу --> ");
                countOfCrew = in.nextInt();
            }else {
                break;
            }
        }

        System.out.print("Довжина --> "); double length = in.nextDouble();
        out.print("Висота --> "); double height = in.nextDouble();
        out.print("Розмах крил --> "); double wingspan = in.nextDouble();
        out.print("Площа крил --> "); double wingArea = in.nextDouble();
        out.print("Маса порожнього(чим легший літак, тим краще він літає) --> "); int emptyMass = in.nextInt();
        out.print("Назва двигуна --> "); String nameEngine = in.nextLine();
        out.print("Потужність двигуна(к.н.) --> "); int enginePower = in.nextInt();
        out.print("Максимальна швидкість --> "); double speed = in.nextInt();
        out.print("Дальність польоту --> "); int range = in.nextInt();
        out.print("Швидкопідйомність --> "); int highSpeed = in.nextInt();

        return new RacePlane("Спортивні", name, 0, length, 0, height, wingspan,
                0, 0,0,0,range, 0,nameEngine,
                1, wingArea, 0,0,0,0,0,speed,
                countOfCrew, emptyMass, highSpeed, enginePower, 0, 0);
    }
}
