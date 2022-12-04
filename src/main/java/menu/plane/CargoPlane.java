package menu.plane;

import menu.plane.PassengerPlane;

public class CargoPlane extends PassengerPlane {

    private int rangeWithCargo;
    private int id;
    public CargoPlane(String category, String name, int countOfPassengers, double generalLength, double weight, double height,
                      double wingspan, double maxLandingWeight, double maxTakeoffWeight, double maxFuelVolume,
                      double cruiseSpeed, int range, double cargoVolume, String nameEngine, int countEngines,
                      double wingArea, double wingGeometryAngle, double cabinWidth, double maxZeroFuelMass,
                      double maxDownload, double workingCeiling, double maxSpeed, double carryingCapacity, int rangeWithCargo, double fuelConsumption) {
        super(category, name, countOfPassengers, generalLength, weight, height, wingspan,
                maxLandingWeight, maxTakeoffWeight, maxFuelVolume, cruiseSpeed, range, cargoVolume,
                nameEngine, countEngines, wingArea, wingGeometryAngle, cabinWidth, maxZeroFuelMass, maxDownload,
                workingCeiling, maxSpeed, carryingCapacity, fuelConsumption);
        this.rangeWithCargo = rangeWithCargo;
    }

    public CargoPlane() {

    }

    public int getRangeWithCargo() {
        return rangeWithCargo;
    }

    public void setRangeWithCargo(int rangeWithCargo) {
        this.rangeWithCargo = rangeWithCargo;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return  "Назва: " + getName()+
                "\nКатегорія: "+ getCategory()+
                "\nК-ть пасажирів: "+getCountOfPassengers()+
                "\nРозмах крил(m): "+getWingspan()+
                "\nПлоща крил(m^2): "+getWingArea()+
                "\nКут крила: "+getWingGeometryAngle()+
                "\nДовжина(m): "+getGeneralLength()+
                "\nШирина(m): "+getWeight()+
                "\nВисота(m): "+getHeight()+
                "\n\nМаксимальна посадкова маса(т): "+getMaxLandingWeight()+
                "\nМаксимальна злітна маса(т): "+getMaxTakeoffWeight()+
                "\nМаксимальна нуль-палива маса(т): " + getMaxZeroFuelMass()+
                "\nЗавантаженість(т): " + getCarryingCapacity() +
                "\n\nКрейсерська швидкість(км/год): "+getCruiseSpeed()+
                "\nМаксимальна швидкість(км/год): "+getMaxSpeed()+
                "\nДальність(км): "+getRange()+
                "\nДальність з багажем(км): " + getRangeWithCargo() +
                "\n\nМаксимальний об'єм палива(л): "+getMaxFuelVolume()+
                "\nСпоживання пального(тис. л/год): "+ getFuelConsumption()+
                "\nШирина кабіни(м): "+getCabinWidth()+
                "\nМаксимальний об'єм палива(л): "+getMaxFuelVolume()+
                "\nОб'єм вантажного відділення(м^3): " + getCargoVolume()+
                "\nРобоча стеля(м): "+getWorkingCeiling()+
                "\n\nНазва двигуна: "+getNameEngine()+
                "\nК-ть двигунів: "+getCountEngines();
    }
}


