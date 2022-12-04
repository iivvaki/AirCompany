package menu.plane;

import java.util.ArrayList;
import java.util.List;

public class PassengerPlane extends ManipulationPlane {
    private String category;
    private String name;
    private int countOfPassengers;       //�-�� ��������
    private double generalLength;        //�������� �������
    private double weight;              //������
    private double height;              //������
    private double wingspan;            //������ ����
    private double maxLandingWeight; //����������� ��������� ����
    private double maxTakeoffWeight; //����������� ����� ����
    private double maxFuelVolume;       //��������� ��'�� ������
    private double cruiseSpeed;         //����������� ��������
    private int range;               //��������
    private double cargoVolume;         //��'�� ��� �������
    private String nameEngine;          //����� �������
    private int countEngines;           //�-�� �������
    private double wingArea;            //����� ����
    private double wingGeometryAngle;      //��� �����
    private double cabinWidth;          //������ �����
    private double maxZeroFuelMass;  //��������� ����-������ ����
    private double maxDownload;         //����������� �������������
    private double workingCeiling;      //������ �����
    private double maxSpeed;            //����������� ��������
    private double carryingCapacity;
    private double fuelConsumption;

    private int id;

    public PassengerPlane() {
    }

    public PassengerPlane(String category, String name, int countOfPassengers, double generalLength,
                          double weight, double height, double wingspan, double maxLandingWeight,
                          double maxTakeoffWeight, double maxFuelVolume, double cruiseSpeed, int range,
                          double cargoVolume, String nameEngine, int countEngines, double wingArea, double wingGeometryAngle,
                          double cabinWidth, double maxZeroFuelMass,
                          double maxDownload, double workingCeiling, double maxSpeed, double carryingCapacity, double fuelConsumption) {
        this.category = category;
        this.name = name;
        this.countOfPassengers = countOfPassengers;
        this.generalLength = generalLength;
        this.weight = weight;
        this.height = height;
        this.wingspan = wingspan;
        this.maxLandingWeight = maxLandingWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.maxFuelVolume = maxFuelVolume;
        this.cruiseSpeed = cruiseSpeed;
        this.range = range;
        this.cargoVolume = cargoVolume;
        this.nameEngine = nameEngine;
        this.countEngines = countEngines;
        this.wingArea = wingArea;
        this.wingGeometryAngle = wingGeometryAngle;

        this.cabinWidth = cabinWidth;

        this.maxZeroFuelMass = maxZeroFuelMass;
        this.maxDownload = maxDownload;
        this.workingCeiling = workingCeiling;
        this.maxSpeed = maxSpeed;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {return category;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;};
    public double getWingspan() {return wingspan;}
    public int getRange() {return range;}

    public int getCountOfPassengers() {
        return countOfPassengers;
    }

    public void setCountOfPassengers(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    public double getGeneralLength() {
        return generalLength;
    }

    public void setGeneralLength(double generalLength) {
        this.generalLength = generalLength;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setWingGeometryAngle(double wingGeometryAngle) {
        this.wingGeometryAngle = wingGeometryAngle;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCargoVolume() {return cargoVolume;}
    public void setCargoVolume(double cargoVolume) {this.cargoVolume = cargoVolume;}

    public String getNameEngine() {return nameEngine;}
    public void setNameEngine(String nameEngine) {this.nameEngine = nameEngine;}

    public int getCountEngines() {return countEngines;}
    public void setCountEngines(int countEngines) {this.countEngines = countEngines;}

    public double getWingArea() {return wingArea;}
    public void setWingArea(double wingArea) {this.wingArea = wingArea;}

    public double getWingGeometryAngle() {return wingGeometryAngle;}
    public void setWingGeometryAngle(int wingGeometryAngle) {this.wingGeometryAngle = wingGeometryAngle;}


    public double getCabinWidth() {return cabinWidth;}
    public void setCabinWidth(double cabinWidth) {this.cabinWidth = cabinWidth;}

    public double getMaxTakeoffWeight() {return maxTakeoffWeight;}
    public void setMaxTakeoffWeight(double maxTakeoffWeight) {this.maxTakeoffWeight = maxTakeoffWeight;}

    public double getMaxLandingWeight() {return maxLandingWeight;}
    public void setMaxLandingWeight(double maxLandingWeight) {this.maxLandingWeight = maxLandingWeight;}

    public double getMaxZeroFuelMass() {return maxZeroFuelMass;}
    public void setMaxZeroFuelMass(double maxZeroFuelMass) {this.maxZeroFuelMass = maxZeroFuelMass;}

    public double getMaxDownload() {return maxDownload;}
    public void setMaxDownload(double maxDownload) {this.maxDownload = maxDownload;}

    public double getCruiseSpeed() {return cruiseSpeed;}
    public void setCruiseSpeed(double cruiseSpeed) {this.cruiseSpeed = cruiseSpeed;}

    public double getWorkingCeiling() {return workingCeiling;}
    public void setWorkingCeiling(double workingCeiling) {this.workingCeiling = workingCeiling;}

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }



    @Override
    public String toString(){
        return  "�����: " + name+
                "\n��������: "+ category+
                "\n�-�� ��������: "+countOfPassengers+
                "\n������ ����(�): "+wingspan+
                "\n����� ����(�^2): "+wingArea+
                "\n��� �����: "+wingGeometryAngle+
                "\n�������(�): "+generalLength+
                "\n������(�): "+weight+
                "\n������(�): "+height+
                "\n\n����������� ��������� ����(�): "+maxLandingWeight+
                "\n����������� ����� ����(�): "+maxTakeoffWeight+
                "\n����������� ����-������ ����(�): " + maxZeroFuelMass+
                "\n���������������(�): " + carryingCapacity +
                "\n\n����������� ��������(��/���): "+cruiseSpeed+
                "\n����������� ��������(��/���): "+maxSpeed+
                "\n��������(��): "+range+
                "\n\n������������ ��'�� ������(�): "+maxFuelVolume+
                "\n���������� ��������(��): " + fuelConsumption +
                "\n������ �����(�): "+cabinWidth+
                "\n����������� ������������(�): "+maxDownload+
                "\n��'�� ���������� �����(�^3): " + cargoVolume+
                "\n������ �����(�): "+workingCeiling+
                "\n\n����� �������: "+nameEngine+
                "\n�-�� �������: "+countEngines;
    }
}