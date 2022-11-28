package menu.plane;

import java.util.Scanner;

import static java.lang.System.out;

public class CreatePlane {
    public static PassengerPlane createPassengerPlane(){
        Scanner in = new Scanner(System.in);
        System.out.println("При створенні літака дотримуйтеся вказівок або підкозок!");
        System.out.print("Назва --> "); String name = in.nextLine();
        System.out.print("К-ть пасажирів --> "); int countOfPassengers = in.nextInt();
        System.out.print("Довжина --> "); double generalLength = in.nextDouble();
        System.out.print("Ширина --> ");double weight = in.nextDouble();
        System.out.print("Висота --> ");double height = in.nextDouble();
        System.out.print("Розмах крил --> ");double wingspan = in.nextDouble();
        System.out.print("Максимальна посадкова маса --> ");double maxLandingWeight = in.nextDouble();
        System.out.print("Максимальна злітна маса --> ");double maxTakeoffWeight = in.nextDouble();
        System.out.print("Максимальний об'єм палива --> ");double maxFuelVolume = in.nextDouble();
        System.out.print("Крейсерська швидкість --> ");double cruiseSpeed = in.nextDouble();
        System.out.print("Дальність --> ");int range = in.nextInt();
        System.out.print("Об'єм вантажного відсіку --> ");double cargoVolume = in.nextDouble();
        System.out.print("Назва двигуна --> ");String nameEngine = in.nextLine();
        System.out.print("К-ть двигунів --> ");int countEngines = in.nextInt();
        System.out.print("Площа крил --> ");double wingArea = in.nextDouble();
        System.out.print("Кут крила --> ");double wingGeometryAngle = in.nextDouble();
        System.out.print("Ширина кабіни --> ");double cabinWidth = in.nextDouble();
        System.out.print("Максимальна нуль-палива маса --> ");double maxZeroFuelMass = in.nextDouble();
        System.out.print("Максимальна завантаженіть --> ");double maxDownload = in.nextDouble();
        System.out.print("Робоча стеля --> ");double workingCeiling = in.nextDouble();
        System.out.print("Максимальна швидкість --> ");double maxSpeed = in.nextDouble();
        System.out.print("Вантажопійомність --> ");double carryingCapacity = in.nextDouble();
        System.out.print("Споживання пального --> ");double fuelConsumption = in.nextDouble();

        return new PassengerPlane("Пасажирський", name, countOfPassengers,
                generalLength,weight, height, wingspan, maxLandingWeight, maxTakeoffWeight,maxFuelVolume,
                cruiseSpeed, range, cargoVolume, nameEngine, countEngines, wingArea, wingGeometryAngle,
                cabinWidth, maxZeroFuelMass, maxDownload, workingCeiling, maxSpeed, carryingCapacity, fuelConsumption);
    }

    public static CargoPlane createCargoPlane(){
        Scanner in = new Scanner(System.in);
        System.out.println("При створенні літака дотримуйтеся вказівок або підкозок!");
        System.out.print("Назва --> "); String name = in.nextLine();
        int countOfPassengers = 10;
        System.out.print("Довжина --> "); double generalLength = in.nextDouble();
        System.out.print("Ширина --> ");double weight = in.nextDouble();
        System.out.print("Висота --> ");double height = in.nextDouble();
        System.out.print("Розмах крил --> ");double wingspan = in.nextDouble();
        System.out.print("Максимальна посадкова маса --> ");double maxLandingWeight = in.nextDouble();
        System.out.print("Максимальна злітна маса --> ");double maxTakeoffWeight = in.nextDouble();
        System.out.print("Максимальний об'єм палива --> ");double maxFuelVolume = in.nextDouble();
        System.out.print("Крейсерська швидкість --> ");double cruiseSpeed = in.nextDouble();
        System.out.print("Дальність --> ");int range = in.nextInt();
        System.out.print("Об'єм вантажного відділення --> ");double cargoVolume = in.nextDouble();
        System.out.println();
        System.out.print("Назва двигуна --> ");String nameEngine = in.nextLine();
        System.out.print("К-ть двигунів --> ");int countEngines = in.nextInt();
        System.out.print("Площа крил --> ");double wingArea = in.nextDouble();
        System.out.print("Кут крила --> ");double wingGeometryAngle = in.nextDouble();
        System.out.print("Ширина кабіни --> ");double cabinWidth = in.nextDouble();
        System.out.print("Макс. нуль-палива маса --> ");double maxZeroFuelMass = in.nextDouble();
        System.out.print("Макс. завантаження --> ");double maxDownload = in.nextDouble();
        System.out.print("Робоча стеля --> ");double workingCeiling = in.nextDouble();
        System.out.print("Максимальна швидкість --> ");double maxSpeed = in.nextDouble();
        System.out.print("Вантажопійомність --> ");double carryingCapacity = in.nextDouble();
        System.out.print("Дальність з багажем --> ");int rangeWithCargo = in.nextInt();
        System.out.print("Витрати пального --> ");double fuelConsumption = in.nextDouble();

        return new CargoPlane("Траспортний", name, countOfPassengers,
                generalLength,weight, height, wingspan, maxLandingWeight, maxTakeoffWeight,maxFuelVolume,
                cruiseSpeed, range, cargoVolume, nameEngine, countEngines, wingArea, wingGeometryAngle,
                cabinWidth, maxZeroFuelMass, maxDownload, workingCeiling, maxSpeed, carryingCapacity, rangeWithCargo,fuelConsumption);


    }

    public static RacePlane createRacePlane(){
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
