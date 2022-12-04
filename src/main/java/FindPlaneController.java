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
//import menu.itemOtherMenu.FindPlane;
import menu.plane.ManipulationPlane;
import menu.plane.fillList;
import menu.plane.PassengerPlane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FindPlaneController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private MenuItem detail1;
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
    private Button ButtonFind;

    @FXML
    private TextField RangeDo;

    @FXML
    private TextField RangeVid;

    @FXML
    private Button backtomainmenu;

    @FXML
    private MenuItem detail;
    private ManipulationPlane plane = new ManipulationPlane();
//    private FindPlane findPlane = new FindPlane();
    private ObservableList<PassengerPlane> list = FXCollections.observableArrayList();
    @FXML
    void FindPlane(ActionEvent event) {
        List<PassengerPlane> pasList = new fillList().choosePlane();
        table.getItems().clear();
        int a = 0, b = 0;
        try {
            a = Integer.parseInt(RangeVid.getText());
        }catch (NumberFormatException e){
            RangeVid.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
        }

        try {
            b = Integer.parseInt(RangeDo.getText());
        }catch (NumberFormatException e){
            RangeDo.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
        }

        if(b>a){
            list.addAll(plane.findPlane(pasList, a, b));

            table.setItems(list);
            RangeDo.setStyle("-fx-border-color: none; -fx-border-width: 1px;");
        }else {
            RangeDo.setStyle("-fx-border-color: red; -fx-border-width: 1px;");
        }
    }

    public void detailInfoAble(MouseEvent mouseEvent) {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();

        detail.setDisable(plane == null);
    }
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    @FXML
    void detailinfo(ActionEvent event) throws IOException {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(plane.toString());
        alert.showAndWait();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailInfoPlane2.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChoosePlaneController cont = loader.getController();
//        cont.initialize(plane);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();
    }
    @FXML
    void detailinfo3(ActionEvent event) throws IOException {
        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(plane.toString());
        alert.showAndWait();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailInfoPlane22.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChoosePlaneController cont = loader.getController();
//        cont.initialize(plane);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();
    }
//    @FXML
//    void detailinfo1(ActionEvent event) throws IOException {
//        PassengerPlane plane = table.getSelectionModel().getSelectedItem();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detailInfoPlane22.fxml"));
//
//        Parent find = loader.load();
//        Scene findScene = new Scene(find);
//        ChoosePlaneController cont = loader.getController();
//        cont.initialize(plane);
//        Stage window =(Stage) anchorPane.getScene().getWindow();
//        window.setScene(findScene);
//        window.show();
//    }
    @FXML
    public void backTomain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void backTomain1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generalInfo.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<PassengerPlane, String>("name"));
        typePlane.setCellValueFactory(new PropertyValueFactory<PassengerPlane, String>("category"));
        wingspan.setCellValueFactory(new PropertyValueFactory<PassengerPlane, Double>("wingspan"));
        range.setCellValueFactory(new PropertyValueFactory<PassengerPlane, Integer>("range"));
    }
}
