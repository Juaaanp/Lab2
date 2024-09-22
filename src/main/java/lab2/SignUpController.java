package lab2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import lab2.Models.LocalUser;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignUpController implements Initializable {
    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField roleTF;
    @FXML
    private Button back;
    @FXML
    private Button signUp;

    private ArrayList<LocalUser> localUsers;

    private ResourceBundle bundle;

    @SuppressWarnings("unchecked")
    @FXML
    private void signUp(ActionEvent event) throws IOException, ClassNotFoundException {
        String name = nameTF.getText();
        String id = idTF.getText();
        String email = emailTF.getText();
        String role = emailTF.getText();

        LocalUser localUser = new LocalUser(id, name, email, role);

        try {
            localUsers = (ArrayList<LocalUser>) Utilities.getInstance().deserializeObjectXML("localUsers.xml");
        } catch (FileNotFoundException e) {
            localUsers = new ArrayList<>();
        }
        localUsers.add(localUser);

        Utilities.getInstance().serializeObject("localUsers.xml", localUsers);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("You have been registered successfully");
        alert.showAndWait();
    }

    @FXML
    private void loadStage(String url, Event event, ResourceBundle bundle) {
        try {
            Window window = ((javafx.scene.Node) (event.getSource())).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url), bundle);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = (Stage) window;
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backOnAction(@SuppressWarnings("exports") ActionEvent event) throws IOException {
        if (bundle == null) {
            bundle = App.getBundle();
        }
        loadStage("login.fxml", event, bundle);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        localUsers = new ArrayList<>();
    }
}
