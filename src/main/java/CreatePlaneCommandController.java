import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;
import menu.plane.CargoPlane;
import menu.plane.PassengerPlane;
import menu.plane.RacePlane;

import java.io.IOException;
import java.util.Objects;

public class CreatePlaneCommandController {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private final PassengerPlaneData passengerPlaneData = new PassengerPlaneData();
    private final CargoPlaneData cargoPlaneData = new CargoPlaneData();
    private final RacePlaneData racePlaneData = new RacePlaneData();
    @FXML
    private ChoiceBox<String> typePlane;

    @FXML
    private TextField cabinWidth;

    @FXML
    private TextField cargoVolume;

    @FXML
    private TextField carryingCapacity;

    @FXML
    private TextField countEngine;

    @FXML
    private TextField countOfCrew;

    @FXML
    private TextField countPassenger;

    @FXML
    private TextField cruiseSpeed;

    @FXML
    private TextField emptyMass;

    @FXML
    private TextField enginePower;

    @FXML
    private TextField fuelConsumption;

    @FXML
    private TextField height;

    @FXML
    private TextField highSpeed;

    @FXML
    private TextField length;

    @FXML
    private TextField maxDownload;

    @FXML
    private TextField maxFuelVolume;

    @FXML
    private TextField maxLandingWeight;

    @FXML
    private TextField maxSpeed;

    @FXML
    private TextField maxTakeoffWeight;

    @FXML
    private TextField maxZeroFuelMass;

    @FXML
    private TextField name;

    @FXML
    private TextField nameEngine;

    @FXML
    private TextField range;

    @FXML
    private TextField rangeWithCargo;
@FXML
private Button create;

    @FXML
    private TextField weight;

    @FXML
    private TextField wingArea;

    @FXML
    private TextField wingGeometryAngle;

    @FXML
    private TextField wingspan;

    @FXML
    private TextField workingCeiling;

    @FXML
    private Label lbcapacity;

    @FXML
    private Label lbcargovol;

    @FXML
    private Label lbcountcrew;

    @FXML
    private Label lbcounteng;

    @FXML
    private Label lbcountpas;

    @FXML
    private Label lbcruisespeed;

    @FXML
    private Label lbemptymass;

    @FXML
    private Label lbfuelcons;

    @FXML
    private Label lbheight;

    @FXML
    private Label lbhighspeed;

    @FXML
    private Label lblength;

    @FXML
    private Label lbmaxdown;

    @FXML
    private Label lbmaxfuelvol;

    @FXML
    private Label lbmaxlandweight;

    @FXML
    private Label lbmaxspped;

    @FXML
    private Label lbmaxtakeoffweight;

    @FXML
    private Label lbname;

    @FXML
    private Label lbnameeng;

    @FXML
    private Label lbpowereng;

    @FXML
    private Label lbrange;

    @FXML
    private Label lbrangewithcar;

    @FXML
    private Label lbweight;

    @FXML
    private Label lbweightcabin;

    @FXML
    private Label lbwingarea;

    @FXML
    private Label lbwingkut;

    @FXML
    private Label lbwingspan;

    @FXML
    private Label lbworkcel;

    @FXML
    private Label lbzerofuelmass;

    @FXML
    private Label error;

    private String[] type = {"Пасажирський", "Транспортний", "Спортивний"};

    public void initialize(){
        typePlane.getItems().addAll(type);
        typePlane.setOnAction(this::getTypePlane);

    }
    private void getTypePlane(ActionEvent actionEvent) {
        String type = typePlane.getValue();
        name.setVisible(true);
        countPassenger.setVisible(true);
        length.setVisible(true);
        weight.setVisible(true);
        height.setVisible(true);
        wingspan.setVisible(true);
        nameEngine.setVisible(true);
        range.setVisible(true);
        maxDownload.setVisible(true);
        maxFuelVolume.setVisible(true);
        maxSpeed.setVisible(true);
        maxLandingWeight.setVisible(true);
        maxTakeoffWeight.setVisible(true);
        maxZeroFuelMass.setVisible(true);
        cabinWidth.setVisible(true);
        cargoVolume.setVisible(true);
        carryingCapacity.setVisible(true);
        wingGeometryAngle.setVisible(true);
        wingArea.setVisible(true);
        workingCeiling.setVisible(true);
        fuelConsumption.setVisible(true);
        cruiseSpeed.setVisible(true);
        countEngine.setVisible(true);


        switch (type) {
            case "Пасажирський" -> {
                emptyMass.setVisible(false);
                enginePower.setVisible(false);
                highSpeed.setVisible(false);
                countOfCrew.setVisible(false);

            }
            case "Транспортний" -> {
                emptyMass.setVisible(false);
                enginePower.setVisible(false);
                highSpeed.setVisible(false);
                countOfCrew.setVisible(false);


                rangeWithCargo.setVisible(true);

            }
            case "Спортивний" -> {
                maxDownload.setVisible(false);
                maxFuelVolume.setVisible(false);
                countPassenger.setVisible(false);
                maxLandingWeight.setVisible(false);
                maxTakeoffWeight.setVisible(false);
                maxZeroFuelMass.setVisible(false);
                cabinWidth.setVisible(false);
                cargoVolume.setVisible(false);
                carryingCapacity.setVisible(false);
                wingGeometryAngle.setVisible(false);
                wingArea.setVisible(false);
                workingCeiling.setVisible(false);

                cruiseSpeed.setVisible(false);
                rangeWithCargo.setVisible(false);



                emptyMass.setVisible(true);
                enginePower.setVisible(true);
                highSpeed.setVisible(true);
                countOfCrew.setVisible(true);


            }
        }
    }
// назва лейблу.setVisible(False)


    public PassengerPlane createPasPlane(){
        PassengerPlane pasPlane = new PassengerPlane();
        pasPlane.setName(name.getText());
        pasPlane.setCountOfPassengers(Integer.parseInt(countPassenger.getText()));
        pasPlane.setGeneralLength(Double.parseDouble(length.getText()));
        pasPlane.setWeight(Double.parseDouble(weight.getText()));
        pasPlane.setHeight(Double.parseDouble(height.getText()));
        pasPlane.setWingspan(Double.parseDouble(wingspan.getText()));
        pasPlane.setMaxLandingWeight(Double.parseDouble(maxLandingWeight.getText()));
        pasPlane.setMaxTakeoffWeight(Double.parseDouble(maxTakeoffWeight.getText()));
        pasPlane.setMaxFuelVolume(Double.parseDouble(maxFuelVolume.getText()));
        pasPlane.setCruiseSpeed(Double.parseDouble(cruiseSpeed.getText()));
        pasPlane.setRange(Integer.parseInt(range.getText()));
        pasPlane.setCargoVolume(Double.parseDouble(cargoVolume.getText()));
        pasPlane.setNameEngine(nameEngine.getText());
        pasPlane.setCountEngines(Integer.parseInt(countEngine.getText()));
        pasPlane.setWingArea(Double.parseDouble(wingArea.getText()));
        pasPlane.setWingGeometryAngle(Double.parseDouble(wingGeometryAngle.getText()));
        pasPlane.setCabinWidth(Double.parseDouble(cabinWidth.getText()));
        pasPlane.setMaxZeroFuelMass(Double.parseDouble(maxZeroFuelMass.getText()));
        pasPlane.setMaxDownload(Double.parseDouble(maxDownload.getText()));
        pasPlane.setWorkingCeiling(Double.parseDouble(workingCeiling.getText()));
        pasPlane.setMaxSpeed(Double.parseDouble(maxSpeed.getText()));
        pasPlane.setCarryingCapacity(Double.parseDouble(carryingCapacity.getText()));
        pasPlane.setFuelConsumption(Double.parseDouble(fuelConsumption.getText()));
        return pasPlane;
    }

    public CargoPlane createCarPlane(){

        CargoPlane pasPlane = new CargoPlane();

        pasPlane.setName(name.getText());
        pasPlane.setCountOfPassengers(Integer.parseInt(countPassenger.getText()));
        pasPlane.setGeneralLength(Double.parseDouble(length.getText()));
        pasPlane.setWeight(Double.parseDouble(weight.getText()));
        pasPlane.setHeight(Double.parseDouble(height.getText()));
        pasPlane.setWingspan(Double.parseDouble(wingspan.getText()));
        pasPlane.setMaxLandingWeight(Double.parseDouble(maxLandingWeight.getText()));
        pasPlane.setMaxTakeoffWeight(Double.parseDouble(maxTakeoffWeight.getText()));
        pasPlane.setMaxFuelVolume(Double.parseDouble(maxFuelVolume.getText()));
        pasPlane.setCruiseSpeed(Double.parseDouble(cruiseSpeed.getText()));
        pasPlane.setRange(Integer.parseInt(range.getText()));
        pasPlane.setCargoVolume(Double.parseDouble(cargoVolume.getText()));
        pasPlane.setNameEngine(nameEngine.getText());
        pasPlane.setCountEngines(Integer.parseInt(countEngine.getText()));
        pasPlane.setWingArea(Double.parseDouble(wingArea.getText()));
        pasPlane.setWingGeometryAngle(Double.parseDouble(wingGeometryAngle.getText()));
        pasPlane.setCabinWidth(Double.parseDouble(cabinWidth.getText()));
        pasPlane.setMaxZeroFuelMass(Double.parseDouble(maxZeroFuelMass.getText()));
        pasPlane.setMaxDownload(Double.parseDouble(maxDownload.getText()));
        pasPlane.setWorkingCeiling(Double.parseDouble(workingCeiling.getText()));
        pasPlane.setMaxSpeed(Double.parseDouble(maxSpeed.getText()));
        pasPlane.setCarryingCapacity(Double.parseDouble(carryingCapacity.getText()));
        pasPlane.setFuelConsumption(Double.parseDouble(fuelConsumption.getText()));
        pasPlane.setRangeWithCargo(Integer.parseInt(rangeWithCargo.getText()));


        return pasPlane;
    }

    public  RacePlane createRacPlane(){
        RacePlane pasPlane = new RacePlane();

        pasPlane.setCategory("Спортивний");
        pasPlane.setCountOfPassengers(0);
        pasPlane.setWeight(0);
        pasPlane.setMaxLandingWeight(0);
        pasPlane.setMaxTakeoffWeight(0);
        pasPlane.setMaxFuelVolume(0);
        pasPlane.setCruiseSpeed(0);
        pasPlane.setCargoVolume(0);

        pasPlane.setCountEngines(0);
        pasPlane.setWingArea(0);
        pasPlane.setWingGeometryAngle(0);
        pasPlane.setCabinWidth(0);
        pasPlane.setMaxZeroFuelMass(0);
        pasPlane.setMaxDownload(0);
        pasPlane.setWorkingCeiling(0);
        pasPlane.setCarryingCapacity(0);

            pasPlane.setName(name.getText());

            pasPlane.setNameEngine(nameEngine.getText());

            pasPlane.setGeneralLength(Double.parseDouble(length.getText()));

            pasPlane.setHeight(Double.parseDouble(height.getText()));

            pasPlane.setWingspan(Double.parseDouble(wingspan.getText()));

            pasPlane.setRange(Integer.parseInt(range.getText()));

            pasPlane.setMaxSpeed(Double.parseDouble(maxSpeed.getText()));

            pasPlane.setFuelConsumption(Double.parseDouble(fuelConsumption.getText()));

            pasPlane.setEnginePower(Integer.parseInt(enginePower.getText()));

            pasPlane.setEmptyMass(Integer.parseInt(emptyMass.getText()));

            pasPlane.setCountOfCrew(Integer.parseInt(countOfCrew.getText()));

            pasPlane.setHighSpeed(Integer.parseInt(highSpeed.getText()));

            return pasPlane;


    }

    public void inputData(ActionEvent event){
        String type = typePlane.getValue();
        if (type.equals("Транспортний")) {
            name.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    countPassenger.setDisable(name.getText().length() == 0);

                }
            });
            countPassenger.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(countPassenger.getText());
                        length.setDisable(false);
                        countPassenger.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        countPassenger.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        length.setDisable(true);
                    }
                }
            });

            length.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(length.getText());
                        weight.setDisable(false);
                        length.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        length.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        weight.setDisable(true);
                    }
                }
            });

            weight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(weight.getText());
                        height.setDisable(false);
                        weight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        weight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        height.setDisable(true);
                    }
                }
            });

            height.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(height.getText());
                        wingspan.setDisable(false);
                        height.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        height.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingspan.setDisable(true);
                    }
                }
            });

            wingspan.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingspan.getText());
                        maxLandingWeight.setDisable(false);
                        wingspan.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingspan.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxLandingWeight.setDisable(true);
                    }
                }
            });

            maxLandingWeight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxLandingWeight.getText());
                        maxTakeoffWeight.setDisable(false);
                        maxLandingWeight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxLandingWeight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxTakeoffWeight.setDisable(true);
                    }
                }
            });

            maxTakeoffWeight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxTakeoffWeight.getText());
                        maxFuelVolume.setDisable(false);
                        maxTakeoffWeight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxTakeoffWeight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxFuelVolume.setDisable(true);
                    }
                }
            });

            maxFuelVolume.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxFuelVolume.getText());
                        cruiseSpeed.setDisable(false);
                        maxFuelVolume.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxFuelVolume.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cruiseSpeed.setDisable(true);
                    }
                }
            });

            cruiseSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(cruiseSpeed.getText());
                        range.setDisable(false);
                        cruiseSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cruiseSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        range.setDisable(true);
                    }
                }
            });

            range.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(range.getText());
                        cargoVolume.setDisable(false);
                        range.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        range.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cargoVolume.setDisable(true);
                    }
                }
            });

            cargoVolume.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(range.getText());
                        nameEngine.setDisable(false);
                        cargoVolume.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cargoVolume.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        nameEngine.setDisable(true);
                    }
                }
            });

            nameEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        nameEngine.getText();
                        countEngine.setDisable(false);
                        nameEngine.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        nameEngine.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        countEngine.setDisable(true);
                    }
                }
            });

            countEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(countEngine.getText());
                        maxSpeed.setDisable(false);
                        countEngine.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        countEngine.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxSpeed.setDisable(true);
                    }
                }
            });

            maxSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxSpeed.getText());
                        fuelConsumption.setDisable(false);
                        maxSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        fuelConsumption.setDisable(true);
                    }
                }
            });

            fuelConsumption.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(fuelConsumption.getText());
                        cabinWidth.setDisable(false);
                        fuelConsumption.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        fuelConsumption.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cabinWidth.setDisable(true);
                    }
                }
            });

            cabinWidth.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(cabinWidth.getText());
                        maxZeroFuelMass.setDisable(false);
                        cabinWidth.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cabinWidth.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxZeroFuelMass.setDisable(true);
                    }
                }
            });

            maxZeroFuelMass.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxZeroFuelMass.getText());
                        maxDownload.setDisable(false);
                        maxZeroFuelMass.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxZeroFuelMass.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxDownload.setDisable(true);
                    }
                }
            });

            maxDownload.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxDownload.getText());
                        workingCeiling.setDisable(false);
                        maxDownload.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxDownload.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        workingCeiling.setDisable(true);
                    }
                }
            });

            workingCeiling.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(workingCeiling.getText());
                        wingArea.setDisable(false);
                        workingCeiling.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        workingCeiling.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingArea.setDisable(true);
                    }
                }
            });


            wingArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingArea.getText());
                        carryingCapacity.setDisable(false);
                        wingArea.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingArea.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        carryingCapacity.setDisable(true);
                    }
                }
            });

            carryingCapacity.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(carryingCapacity.getText());
                        wingGeometryAngle.setDisable(false);
                        carryingCapacity.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        carryingCapacity.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingGeometryAngle.setDisable(true);
                    }
                }
            });

            wingGeometryAngle.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingGeometryAngle.getText());
                        rangeWithCargo.setDisable(false);
                        wingGeometryAngle.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingGeometryAngle.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        rangeWithCargo.setDisable(true);
                    }
                }
            });

            rangeWithCargo.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(rangeWithCargo.getText());
                        create.setDisable(false);

                        rangeWithCargo.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        rangeWithCargo.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        create.setDisable(true);
                    }
                }
            });
        } else if (type.equals("Пасажирський")) {
            name.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    countPassenger.setDisable(name.getText().length() == 0);

                }
            });
            countPassenger.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(countPassenger.getText());
                        length.setDisable(false);
                        countPassenger.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        countPassenger.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        length.setDisable(true);
                    }
                }
            });

            length.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(length.getText());
                        weight.setDisable(false);
                        length.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        length.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        weight.setDisable(true);
                    }
                }
            });

            weight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(weight.getText());
                        height.setDisable(false);
                        weight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        weight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        height.setDisable(true);
                    }
                }
            });

            height.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(height.getText());
                        wingspan.setDisable(false);
                        height.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        height.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingspan.setDisable(true);
                    }
                }
            });

            wingspan.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingspan.getText());
                        maxLandingWeight.setDisable(false);
                        wingspan.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingspan.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxLandingWeight.setDisable(true);
                    }
                }
            });

            maxLandingWeight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxLandingWeight.getText());
                        maxTakeoffWeight.setDisable(false);
                        maxLandingWeight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxLandingWeight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxTakeoffWeight.setDisable(true);
                    }
                }
            });

            maxTakeoffWeight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxTakeoffWeight.getText());
                        maxFuelVolume.setDisable(false);
                        maxTakeoffWeight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxTakeoffWeight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxFuelVolume.setDisable(true);
                    }
                }
            });

            maxFuelVolume.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxFuelVolume.getText());
                        cruiseSpeed.setDisable(false);
                        maxFuelVolume.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxFuelVolume.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cruiseSpeed.setDisable(true);
                    }
                }
            });

            cruiseSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(cruiseSpeed.getText());
                        range.setDisable(false);
                        cruiseSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cruiseSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        range.setDisable(true);
                    }
                }
            });

            range.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(range.getText());
                        cargoVolume.setDisable(false);
                        range.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        range.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cargoVolume.setDisable(true);
                    }
                }
            });

            cargoVolume.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(range.getText());
                        nameEngine.setDisable(false);
                        cargoVolume.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cargoVolume.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        nameEngine.setDisable(true);
                    }
                }
            });

            nameEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        nameEngine.getText();
                        countEngine.setDisable(false);
                        nameEngine.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        nameEngine.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        countEngine.setDisable(true);
                    }
                }
            });

            countEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Integer.parseInt(countEngine.getText());
                        maxSpeed.setDisable(false);
                        countEngine.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        countEngine.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxSpeed.setDisable(true);
                    }
                }
            });

            maxSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxSpeed.getText());
                        fuelConsumption.setDisable(false);
                        maxSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        fuelConsumption.setDisable(true);
                    }
                }
            });

            fuelConsumption.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(fuelConsumption.getText());
                        cabinWidth.setDisable(false);
                        fuelConsumption.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        fuelConsumption.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        cabinWidth.setDisable(true);
                    }
                }
            });

            cabinWidth.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(cabinWidth.getText());
                        maxZeroFuelMass.setDisable(false);
                        cabinWidth.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        cabinWidth.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxZeroFuelMass.setDisable(true);
                    }
                }
            });

            maxZeroFuelMass.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxZeroFuelMass.getText());
                        maxDownload.setDisable(false);
                        maxZeroFuelMass.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxZeroFuelMass.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxDownload.setDisable(true);
                    }
                }
            });

            maxDownload.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(maxDownload.getText());
                        workingCeiling.setDisable(false);
                        maxDownload.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        maxDownload.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        workingCeiling.setDisable(true);
                    }
                }
            });

            workingCeiling.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(workingCeiling.getText());
                        wingArea.setDisable(false);
                        workingCeiling.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        workingCeiling.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingArea.setDisable(true);
                    }
                }
            });


            wingArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingArea.getText());
                        carryingCapacity.setDisable(false);
                        wingArea.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingArea.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        carryingCapacity.setDisable(true);
                    }
                }
            });

            carryingCapacity.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(carryingCapacity.getText());
                        wingGeometryAngle.setDisable(false);
                        carryingCapacity.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        carryingCapacity.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingGeometryAngle.setDisable(true);
                    }
                }
            });

            wingGeometryAngle.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingGeometryAngle.getText());
                        create.setDisable(false);
                        wingGeometryAngle.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingGeometryAngle.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        create.setDisable(true);
                    }
                }
            });

        } else if (type.equals("Спортивний")) {
            name.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    length.setDisable(name.getText().length() == 0);

                }
            });

            length.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(length.getText());
                        weight.setDisable(false);
                        length.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        length.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        weight.setDisable(true);
                    }
                }
            });

            weight.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(weight.getText());
                        height.setDisable(false);
                        weight.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        weight.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        height.setDisable(true);
                    }
                }
            });

            height.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(height.getText());
                        wingspan.setDisable(false);
                        height.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        height.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        wingspan.setDisable(true);
                    }
                }
            });

            wingspan.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(wingspan.getText());
                        countOfCrew.setDisable(false);
                        wingspan.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        wingspan.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        countOfCrew.setDisable(true);
                    }
                }
            });

            countOfCrew.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(countOfCrew.getText());
                        emptyMass.setDisable(false);
                        countOfCrew.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        countOfCrew.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        emptyMass.setDisable(true);
                    }
                }
            });

            emptyMass.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(emptyMass.getText());
                        enginePower.setDisable(false);
                        emptyMass.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        emptyMass.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        enginePower.setDisable(true);
                    }
                }
            });

            enginePower.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(enginePower.getText());
                        highSpeed.setDisable(false);
                        enginePower.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        enginePower.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        highSpeed.setDisable(true);
                    }
                }
            });

            highSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        range.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        range.setDisable(true);
                    }
                }
            });

            range.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        nameEngine.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        nameEngine.setDisable(true);
                    }
                }
            });

            nameEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        countEngine.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        countEngine.setDisable(true);
                    }
                }
            });

            countEngine.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        maxSpeed.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        maxSpeed.setDisable(true);
                    }
                }
            });

            maxSpeed.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        fuelConsumption.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        fuelConsumption.setDisable(true);
                    }
                }
            });

            fuelConsumption.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    try {
                        Double.parseDouble(highSpeed.getText());
                        create.setDisable(false);
                        highSpeed.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                    } catch (NumberFormatException e) {
                        highSpeed.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                        create.setDisable(true);
                    }
                }
            });

        }


    }

    public void buttonClickCreatePlane(ActionEvent event) throws IOException {
        String type = typePlane.getValue();


        switch (type) {
            case "Пасажирський" -> {

                passengerPlaneData.addPlane(createPasPlane());
            }
            case "Транспортний" -> {
                cargoPlaneData.addPlane(createCarPlane());
            }
            case "Спортивний" -> {
                racePlaneData.addPlane(createRacPlane());
            }
        }

        String text = "Літак доданий до списку";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();

//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
//        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }


    public void backToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
