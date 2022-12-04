import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import menu.airlines.Airlines;
import menu.database.AirlineData;
import menu.database.CargoPlaneData;
import menu.database.PassengerPlaneData;
import menu.database.RacePlaneData;
import menu.plane.ManipulationPlane;
import menu.plane.fillList;
import menu.plane.PassengerPlane;
import menu.user.User;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private MenuItem detailairline;
    @FXML
    private MenuItem detailairline1;

    private final List<PassengerPlane> passengerPlaneList = new fillList().choosePlane();

    private List<User> users = new fillList().chooseUsers();
    private List<Airlines> airlines = new fillList().chooseAirlines();
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuItem detailInfo;
    @FXML
    private MenuItem detailInfo1;

    @FXML
    private Button createplane;

    @FXML
    private Button deleteplane;

    @FXML
    private Button findplane;

    @FXML
    private TableColumn<PassengerPlane, String> name = new TableColumn<>();

    @FXML
    private TableColumn<PassengerPlane, Integer> range= new TableColumn<>();

    @FXML
    private TableView<PassengerPlane> table = new TableView<>();

    @FXML
    private TableColumn<PassengerPlane, String> typePlane= new TableColumn<>();

    @FXML
    private TableColumn<PassengerPlane, Double> wingspan= new TableColumn<>();
    @FXML
    private Label LabelSetCountPas = new Label();
    @FXML
    private Label LabelSetCapacity = new Label();
//    private final TotalCountOfCarryingCapacity totalCountOfCarryingCapacity = new TotalCountOfCarryingCapacity();
//    private final TotalCountOfPassenger countOfPassenger = new TotalCountOfPassenger();
    private ManipulationPlane plane = new ManipulationPlane();
    private final PassengerPlaneData passengerPlaneData = new PassengerPlaneData();
    private final RacePlaneData racePlaneData = new RacePlaneData();
    private final CargoPlaneData cargoPlaneData = new CargoPlaneData();

    private final AirlineData airlineData = new AirlineData();
    @FXML
    private TextField emailField;

    @FXML
    private Label lbEmail;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button showInfo;
    @FXML
    private Button deleteAirline;

    @FXML
    private TableColumn<Airlines, String> datecol= new TableColumn<>();
    @FXML
    private TableColumn<Airlines, String> fromcity= new TableColumn<>();
    @FXML
    private TableColumn<Airlines, String> tocity= new TableColumn<>();

    @FXML
    private TableColumn<Airlines, String> planeName = new TableColumn<>();

    @FXML
    private TableView<Airlines> airlinelist = new TableView<>();


    @FXML
    void registration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException {
        User user = new User();
        String login = emailField.getText();
        String password = passwordField.getText();
        if(user.checkLogin(users, login, password)){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
            stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            String text = "Користувача не знайдено";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(text);
            alert.showAndWait();
        }



    }
@FXML
private AnchorPane anchorPane2;
    @FXML
    void showInfoButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generalInfo.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void findAirline(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("findAirline.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void findAirline2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("findAirline2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addNewAirline(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createAirline.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public ObservableList<PassengerPlane> fillArray(){
        ObservableList<PassengerPlane> list = FXCollections.observableArrayList();
        list.addAll(passengerPlaneList);
        return list;
    }

    public ObservableList<Airlines> fillArrayAirlines(){
        ObservableList<Airlines> list = FXCollections.observableArrayList();
        list.addAll(airlines);
        return list;
    }
    public void showmoreinfo(ActionEvent event) throws IOException {
        Airlines airlines1 = airlinelist.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(airlines1.toString());
        alert.showAndWait();


    }
    public void showmoreinfo1(ActionEvent event) throws IOException {
        Airlines airlines1 = airlinelist.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(airlines1.toString());
        alert.showAndWait();
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailIfnfoAirline21.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChooseAirlineController cont = loader.getController();
//        cont.initialize(airlines1);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<Airlines> airlinesList = fillArrayAirlines();
        ObservableList<PassengerPlane> list1 = fillArray();


        name.setCellValueFactory(new PropertyValueFactory<PassengerPlane, String>("name"));
        typePlane.setCellValueFactory(new PropertyValueFactory<PassengerPlane, String>("category"));
        wingspan.setCellValueFactory(new PropertyValueFactory<PassengerPlane, Double>("wingspan"));
        range.setCellValueFactory(new PropertyValueFactory<PassengerPlane, Integer>("range"));

        planeName.setCellValueFactory(new PropertyValueFactory<Airlines, String>("namePlane"));
        datecol.setCellValueFactory(new PropertyValueFactory<Airlines, String>("date"));
        fromcity.setCellValueFactory(new PropertyValueFactory<Airlines, String>("city1"));
        tocity.setCellValueFactory(new PropertyValueFactory<Airlines, String>("city2"));

        airlinelist.setItems(airlinesList);
        table.setItems(list1);



        List<PassengerPlane> planes = new ArrayList<>();
        planes.addAll(list1);

        LabelSetCountPas.setText(String.valueOf(plane.totalPassenger(planes)));
        LabelSetCapacity.setText(String.valueOf(plane.totalCarryingCapacity(planes)));
    }

    public void deleteAirline(){
        Airlines airlines1 = airlinelist.getSelectionModel().getSelectedItem();
        airlineData.delete(airlines1.getId());
        airlinelist.getItems().removeAll(airlinelist.getSelectionModel().getSelectedItem());
    }

    public void deletePlane(){
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
        if (plane.getCategory().equals("Пасажирський")){
            passengerPlaneData.delete(plane.getId());
        } else if (plane.getCategory().equals("Транспортний")) {
            cargoPlaneData.delete(plane.getId());
        } else if (plane.getCategory().equals("Спортивний")) {
            racePlaneData.delete(plane.getId());
        }

        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());


    };
    public  void detailAirlinesAble1(MouseEvent mouseEvent){
        Airlines airlines1 = airlinelist.getSelectionModel().getSelectedItem();
        detailairline1.setDisable(airlines1==null);

    }

    public  void detailAirlinesAble(MouseEvent mouseEvent){
        Airlines airlines1 = airlinelist.getSelectionModel().getSelectedItem();
        deleteAirline.setDisable(airlines1==null);
        detailairline.setDisable(airlines1==null);

    }
    public void detailInfoAble1(MouseEvent mouseEvent) {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
        detailInfo1.setDisable(plane == null);
    }
    public void detailInfoAble(MouseEvent mouseEvent) {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();

        detailInfo.setDisable(plane == null);
        deleteplane.setDisable(plane == null);

    }

    public void switchToDetailInfoPlane(ActionEvent event) throws IOException {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();



        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(plane.toString());
        alert.showAndWait();


//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailInfoPlane.fxml"));
//
//            Parent find = loader.load();
//            Scene findScene = new Scene(find);
//            ChoosePlaneController cont = loader.getController();
//            cont.initialize(plane);
//            Stage window =(Stage) anchorPane.getScene().getWindow();
//            window.setScene(findScene);
//            window.show();

    }
    public void switchToDetailInfoPlane1(ActionEvent event) throws IOException {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(plane.toString());
        alert.showAndWait();


//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailInfoPlane21.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChoosePlaneController cont = loader.getController();
//        cont.initialize(plane);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();

    }

    public void createPlane(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("createPlane.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void findPlane(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("findPlane.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void findPlane1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("findPlane2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
