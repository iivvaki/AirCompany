import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.airlines.Airlines;
import menu.database.AirlineData;
import menu.plane.fillList;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FindAirlinesController {
    private Stage stage;
    private Scene scene;
    @FXML
    private MenuItem btnDetilInfo;

    @FXML
    private Label city1;

    @FXML
    private TextField city1rg;

    @FXML
    private Label city2;

    @FXML
    private TextField city2rg;

    @FXML
    private Label date;

    @FXML
    private TextField daterg;

@FXML
    private AnchorPane anchorPane = new AnchorPane();
    @FXML
    private TableColumn<Airlines, String> datacol;
    @FXML
    private TableColumn<Airlines, String> fromcity;
    @FXML
    private TableColumn<Airlines, String> tocity;
    @FXML
    private TableColumn<Airlines, String> plane;

    @FXML
    private TableView<Airlines> table;

    @FXML
    private ChoiceBox<String> typeFind;
    @FXML
    private Label lbR;


    private AirlineData airlineData = new AirlineData();
    private Airlines airlines = new Airlines();
    private List<Airlines> airlinesList = new fillList().chooseAirlines();

    private String[] type = {"Міста", "Дата"};


    public void initialize() {
        typeFind.getItems().addAll(type);
        typeFind.setOnAction(this::getType);


        plane.setCellValueFactory(new PropertyValueFactory<Airlines, String>("namePlane"));
        datacol.setCellValueFactory(new PropertyValueFactory<Airlines, String>("date"));
        fromcity.setCellValueFactory(new PropertyValueFactory<Airlines, String>("city1"));
        tocity.setCellValueFactory(new PropertyValueFactory<Airlines, String>("city2"));
    }

    public void getType(ActionEvent event) {
        String type = typeFind.getValue();
        switch (type) {
            case "Міста" -> {

                city1rg.setVisible(true);
                city2rg.setVisible(true);
                lbR.setVisible(false);

                daterg.setVisible(false);
            }
            case "Дата" -> {

                daterg.setVisible(true);
                lbR.setVisible(true);

                city1rg.setVisible(false);
                city2rg.setVisible(false);
            }
        }
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void back2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generalInfo.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void detailinfo(ActionEvent event) throws IOException {
        Airlines airlines1 = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(airlines1.toString());
        alert.showAndWait();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailIfnfoAirline2.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChooseAirlineController cont = loader.getController();
//        cont.initialize(airlines1);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();
    }

    @FXML
    void detailinfo2(ActionEvent event) throws IOException {
        Airlines airlines1 = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(airlines1.toString());
        alert.showAndWait();        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailIfnfoAirline22.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChooseAirlineController cont = loader.getController();
//        cont.initialize(airlines1);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();
    }

    private ObservableList<Airlines> list = FXCollections.observableArrayList();

    @FXML
    void findAirline(ActionEvent event) {
        String type = typeFind.getValue();
        table.getItems().clear();
        switch (type) {
            case "Міста" -> {

                list.addAll(airlines.findAirlineToCity(airlinesList,city1rg.getText(), city2rg.getText()));
                table.setItems(list);
            }
            case "Дата" -> {
                list.addAll(airlines.findAirlineDate(airlinesList,daterg.getText()));
                table.setItems(list);

            }
        }
    }
}
