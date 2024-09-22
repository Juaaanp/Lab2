package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.util.logging.Level;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import lab2.Models.LocalUser;

public class LoginController {
    @FXML
    private Button logIn;
    @FXML
    private TextField idTF;
    @FXML
    private Hyperlink signUp;

    private ResourceBundle bundle;


    @FXML
    public void eventOnAction(@SuppressWarnings("exports") Event event) throws IOException, ClassNotFoundException {
        Utilities.getInstance().writeLog("Checking for the User credentials",Level.INFO);

        Object evt = event.getSource();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        @SuppressWarnings("unchecked")
        ArrayList<LocalUser> localUsers = (ArrayList<LocalUser>) Utilities.getInstance()
                .deserializeObjectXML("localUsers.xml");

        if (evt.equals(logIn)) {
            if (!idTF.getText().isEmpty()) {
                boolean userFound = false;
                for (LocalUser localUser : localUsers) {
                    if (localUser.getId().equals(idTF.getText())) {
                        // if (bundle == null) {
                        //     bundle = App.getBundle();
                        // }
                        loadStage("user.fxml", event, bundle);
                        userFound = true;
                        break;
                    }
                }
                if (!userFound) {
                    if (idTF.getText().equals("12345")) {
                        if (bundle == null) {
                            bundle = App.getBundle();
                        }
                        loadStage("admin.fxml", event, bundle);
                    } else {
                        alert.setContentText(bundle.getString("idNotFound"));
                        alert.show();
                    }
                }
            } else {
                alert.setContentText(bundle.getString("idFieldEmpty"));
                alert.show();
            }
        }
    }

    @FXML
    private void loadStage(String url, Event event, ResourceBundle bundle) {
        try {
            Utilities.getInstance().writeLog("Scene " + url + " loaded.", Level.INFO);
            Window window = ((javafx.scene.Node) (event.getSource())).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url), bundle);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = (Stage) window;
            newStage.setScene(scene);
            newStage.show();
        } catch (Exception e) {
            Utilities.getInstance().writeLog("Failed to load the " + url + " Scene " + e.getMessage() , Level.WARNING);
            e.printStackTrace();
        }
    }

    @FXML
    private void signUpOnAction(Event event) {
        if (event.getSource().equals(signUp)) {
            if (bundle == null) {
                bundle = App.getBundle();
            }
            loadStage("signUp.fxml", event, bundle);
        }
    }
    public void setBundle(ResourceBundle bundle) {
        this.bundle= bundle;
    }
}

