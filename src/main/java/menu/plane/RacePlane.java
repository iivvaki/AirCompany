package menu.plane;

public class RacePlane extends PassengerPlane {

    private int countOfCrew;
    private int emptyMass;
    private int enginePower;
    private int highSpeed;
    private int id;
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

    public RacePlane() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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
                "\nК-ть екіпажу: " + getCountOfCrew()+
                "\nДовжина: " + getGeneralLength() +
                "\nВисота: " + getHeight() +
                "\nРозмах крил: " + getWingspan() +
                "\nМаса пустого: "+ getEmptyMass() +
                "\n\nНазва двигуна: "+ getNameEngine()+
                "\nПотужність двигуна: "+getEnginePower()+
                "\n\nМаксимальна швидкість: " + getMaxSpeed() +
                "\nДальність: " + getRange() +
                "\nШвидкопідйомність: " + getHighSpeed();
    }
}
