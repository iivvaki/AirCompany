package menu.plane.passengerPlane;

import java.util.Scanner;

public class CreatePassengerPlane {
    public PassengerPlane createNewPlane(){
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
        System.out.print("Дальність --> ");int range = in.nextInt();               //��������
        System.out.print("Об'єм вантажного відсіку --> ");double cargoVolume = in.nextDouble();
        System.out.println();
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
}
