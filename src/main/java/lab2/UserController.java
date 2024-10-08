package lab2;

import java.util.ResourceBundle;

import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UserController {

    @FXML
    private Button inscribe;

    @FXML
    private Button cancel;

    private ResourceBundle bundle;

    @FXML
    public void inscribe(@SuppressWarnings("exports") ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("You have been inscribed successfull");
                alert.showAndWait();
    }
    @FXML
    public void cancel(@SuppressWarnings("exports") ActionEvent event){
        Utilities.getInstance().writeLog("Cancel action perfomed with errors", Level.INFO);

        if (bundle == null) {
            bundle = App.getBundle();
        }

        loadStage("login.fxml", event, bundle);
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
    public void setBundle(ResourceBundle bundle) {
        this.bundle= bundle;
    }
}
