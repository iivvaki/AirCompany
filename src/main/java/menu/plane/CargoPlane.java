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
        return  "�����: " + getName()+
                "\n��������: "+ getCategory()+
                "\n�-�� ��������: "+getCountOfPassengers()+
                "\n������ ����(m): "+getWingspan()+
                "\n����� ����(m^2): "+getWingArea()+
                "\n��� �����: "+getWingGeometryAngle()+
                "\n�������(m): "+getGeneralLength()+
                "\n������(m): "+getWeight()+
                "\n������(m): "+getHeight()+
                "\n\n����������� ��������� ����(�): "+getMaxLandingWeight()+
                "\n����������� ����� ����(�): "+getMaxTakeoffWeight()+
                "\n����������� ����-������ ����(�): " + getMaxZeroFuelMass()+
                "\n�������������(�): " + getCarryingCapacity() +
                "\n\n����������� ��������(��/���): "+getCruiseSpeed()+
                "\n����������� ��������(��/���): "+getMaxSpeed()+
                "\n��������(��): "+getRange()+
                "\n�������� � �������(��): " + getRangeWithCargo() +
                "\n\n������������ ��'�� ������(�): "+getMaxFuelVolume()+
                "\n���������� ��������(���. �/���): "+ getFuelConsumption()+
                "\n������ �����(�): "+getCabinWidth()+
                "\n������������ ��'�� ������(�): "+getMaxFuelVolume()+
                "\n��'�� ���������� ��������(�^3): " + getCargoVolume()+
                "\n������ �����(�): "+getWorkingCeiling()+
                "\n\n����� �������: "+getNameEngine()+
                "\n�-�� �������: "+getCountEngines();
    }
}


