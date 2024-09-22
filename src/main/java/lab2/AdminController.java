package lab2;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AdminController {
    
    @FXML
    private Button sports;
    @FXML
    private Button trainingSessions;
    @FXML
    private Button trainers;
    @FXML
    private Button back;

    private ResourceBundle bundle;


    @FXML
    private void eventOnAction(ActionEvent event) throws IOException {
        Object obj = event.getSource();
        if (obj.equals(sports)) {
            loadStage("sports.fxml", event, bundle);
        } else if (obj.equals(trainingSessions)) {
            loadStage("trainingSessions.fxml", event, bundle);
        } else if (obj.equals(trainers)) {
            loadStage("trainers.fxml", event, bundle);
        }
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
}

