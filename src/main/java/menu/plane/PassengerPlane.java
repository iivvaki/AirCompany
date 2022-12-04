package menu.plane;

import java.util.ArrayList;
import java.util.List;

public class PassengerPlane extends ManipulationPlane {
    private String category;
    private String name;
    private int countOfPassengers;       //к-ть пасажирів
    private double generalLength;        //загальна довжина
    private double weight;              //ширина
    private double height;              //висота
    private double wingspan;            //розмах крил
    private double maxLandingWeight; //максимальна посадкова маса
    private double maxTakeoffWeight; //максимальна злітна маса
    private double maxFuelVolume;       //максильна об'єм палива
    private double cruiseSpeed;         //крейсерська швидкість
    private int range;               //дальність
    private double cargoVolume;         //об'єм для вантажу
    private String nameEngine;          //назва двигуна
    private int countEngines;           //к-ть двигунів
    private double wingArea;            //площа крил
    private double wingGeometryAngle;      //кут крила
    private double cabinWidth;          //ширина кабіни
    private double maxZeroFuelMass;  //максильна нуль-палива маса
    private double maxDownload;         //максимальна завантаженість
    private double workingCeiling;      //робоча стеля
    private double maxSpeed;            //максимальна швидкість
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
        return  "Назва: " + name+
                "\nКатегорія: "+ category+
                "\nК-ть пасажирів: "+countOfPassengers+
                "\nРозмах крил(м): "+wingspan+
                "\nПлоща крил(м^2): "+wingArea+
                "\nКут крила: "+wingGeometryAngle+
                "\nДовжина(м): "+generalLength+
                "\nШирина(м): "+weight+
                "\nВисота(м): "+height+
                "\n\nМаксимальна посадкова маса(т): "+maxLandingWeight+
                "\nМаксимальна злітна маса(т): "+maxTakeoffWeight+
                "\nМаксимальна нуль-палива маса(т): " + maxZeroFuelMass+
                "\nВантажопійомність(т): " + carryingCapacity +
                "\n\nКрейсерська швидкість(км/год): "+cruiseSpeed+
                "\nМаксимальна швидкість(км/год): "+maxSpeed+
                "\nДальність(км): "+range+
                "\n\nМаксимальний об'єм палива(л): "+maxFuelVolume+
                "\nСпоживання пального(кг): " + fuelConsumption +
                "\nШирина кабіни(м): "+cabinWidth+
                "\nМаксимальна завантаженіть(т): "+maxDownload+
                "\nОб'єм вантажного відсіку(м^3): " + cargoVolume+
                "\nРобоча стеля(м): "+workingCeiling+
                "\n\nНазва двигуна: "+nameEngine+
                "\nК-ть двигунів: "+countEngines;
    }
}