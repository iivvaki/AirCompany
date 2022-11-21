package menu.plane.racePlane;

import menu.plane.passengerPlane.PassengerPlane;

public class RacePlane extends PassengerPlane {

    private int countOfCrew;
    private int emptyMass;
    private int enginePower;
    private int highSpeed;  //���������������

    public RacePlane(String category, String name, int countOfPassengers, double generalLength,
                     double weight, double height, double wingspan, double maxLandingWeight,
                     double maxTakeoffWeight, double maxFuelVolume, double cruiseSpeed, int range,
                     double cargoVolume, String nameEngine, int countEngines, double wingArea,
                     double wingGeometryAngle, double cabinWidth, double maxZeroFuelMass, double maxDownload,
                     double workingCeiling, double maxSpeed, int countOfCrew, int emptyMass, int highSpeed, int enginePower, double carryingCapacity,
                     double fuelConsumption) {
        super(category, name, countOfPassengers, generalLength, weight, height, wingspan,
                maxLandingWeight, maxTakeoffWeight, maxFuelVolume, cruiseSpeed, range,
                cargoVolume, nameEngine, countEngines, wingArea, wingGeometryAngle, cabinWidth,
                maxZeroFuelMass, maxDownload, workingCeiling, maxSpeed, carryingCapacity, fuelConsumption);
        this.countOfCrew = countOfCrew;
        this.emptyMass = emptyMass;
        this.highSpeed = highSpeed;
        this.enginePower = enginePower;
    }

    public int getCountOfCrew() {
        return countOfCrew;
    }

    public void setCountOfCrew(int countOfCrew) {
        this.countOfCrew = countOfCrew;
    }

    public int getEmptyMass() {
        return emptyMass;
    }

    public void setEmptyMass(int emptyMass) {
        this.emptyMass = emptyMass;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getHighSpeed() {
        return highSpeed;
    }

    public void setHighSpeed(int highSpeed) {
        this.highSpeed = highSpeed;
    }



    @Override
    public String toString(){
        return "Назва: " + getName() +
                "К-ть екіпажу: " + getCountOfCrew()+
                "Довжина: " + getGeneralLength() +
                "Висота: " + getHeight() +
                "Розмах крил: " + getWingspan() +
                "Порожня маса: "+ getEmptyMass() +
                "Назва двигуна: "+ getNameEngine()+
                "потужність двигуна: "+getEnginePower()+
                "Максимальна швидкість: " + getMaxSpeed() +
                "Дальність польоту: " + getRange() +
                "Швидкість підйому: " + getHighSpeed();
    }
}
