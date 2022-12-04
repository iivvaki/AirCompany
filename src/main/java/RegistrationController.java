import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import menu.database.UserData;
import menu.user.User;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField logForm;

    @FXML
    private TextField passForm;
    UserData userData = new UserData();

    @FXML
    void reg(ActionEvent event) throws IOException {
        User user = new User();
        user.setLogin(logForm.getText());
        user.setPassword(passForm.getText());
        userData.addPlane(user);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
        stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
