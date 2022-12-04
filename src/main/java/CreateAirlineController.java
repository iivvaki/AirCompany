import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import menu.airlines.Airlines;
import menu.database.AirlineData;

import java.io.IOException;
import java.util.Objects;

public class CreateAirlineController {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private Button addnewairline;

    @FXML
    private TextField city1;

    @FXML
    private TextField city2;

    @FXML
    private TextField coastticket;

    @FXML
    private TextField country1;

    @FXML
    private TextField country2;

    @FXML
    private DatePicker dateairline;
    @FXML
    private TextField planename;

    private AirlineData airlineData = new AirlineData();

    public Airlines getInfo(){
        Airlines airlines = new Airlines();
        airlines.setCountry1(country1.getText());
        airlines.setCity1(city1.getText());
        airlines.setCity2(city2.getText());
        airlines.setDate(String.valueOf(dateairline.getValue()));
        airlines.setCountry2(country2.getText());
        airlines.setCoast(Double.parseDouble(coastticket.getText()));
        airlines.setNamePlane(planename.getText());
        return airlines;
    }

    public void inputData(){

            country1.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    city1.setDisable(country1.getText().length() == 0);

                }
            });

        city1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    city1.getText();
                    country2.setDisable(false);
                    city1.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    city1.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    country2.setDisable(true);
                }
            }
        });
        country2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    country2.getText();
                    city2.setDisable(false);
                    country2.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    country2.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    city2.setDisable(true);
                }
            }
        });
        city2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    city2.getText();
                    dateairline.setDisable(false);
                    city2.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    city2.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    dateairline.setDisable(true);
                }
            }
        });
        dateairline.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    String.valueOf(dateairline.getValue());
                    coastticket.setDisable(false);
                    dateairline.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    dateairline.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    coastticket.setDisable(true);
                }
            }
        });
        coastticket.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    Double.parseDouble(coastticket.getText());
                    planename.setDisable(false);
                    coastticket.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    coastticket.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    planename.setDisable(true);
                }
            }
        });
        planename.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    planename.getText();
                    addnewairline.setDisable(false);
                    planename.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
                } catch (NumberFormatException e) {
                    planename.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
                    addnewairline.setDisable(true);
                }
            }
        });
    }

    @FXML
    void buttonClickAddAirline(ActionEvent event) throws IOException {
        airlineData.addPlane(getInfo());

        String text = "Рейс доданий до списку";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void backTomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
