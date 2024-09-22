package lab2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class StartedController {
   
    @FXML
    private ChoiceBox<String> choiceBox; 
    @FXML
    private Button continueButton;

    @FXML
    private Label languageLabel; 
    
    private ResourceBundle bundle;
    private Locale currentLocale;


    @SuppressWarnings("deprecation")
    @FXML
    public void initialize() {

        choiceBox.getItems().addAll("English", "Spanish");
        choiceBox.setValue("English");

        currentLocale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("lab2.messages", currentLocale);
        updateLabels(bundle); 

        //This just set up like a onChangeEvent for the selector 
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Spanish")) {
                currentLocale = new Locale("es", "ES");
            } else {
                currentLocale = new Locale("en", "US");
            }
            bundle = ResourceBundle.getBundle("lab2.messages", currentLocale);
            updateLabels(bundle); 
        });
    }

    // Method to update the componecitos base on the properties, bro 
    private void updateLabels(ResourceBundle bundle) {
        Utilities.getInstance().writeLog("Language updated successfully",Level.INFO);
        languageLabel.setText(bundle.getString("language"));
        continueButton.setText(bundle.getString("continue"));
    }

    @FXML
    public void handleButtonAction() {
        try {
            Utilities.getInstance().writeLog("Continue button pressed, moving to the Login Scene.",Level.INFO);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"), bundle);
            Parent root = loader.load();

            LoginController controller = loader.getController();
            controller.setResourceBundle(bundle);

            Stage stage = (Stage) continueButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            Utilities.getInstance().writeLog("Failed to load the Login Scene " + e.getMessage() , Level.SEVERE);
            e.printStackTrace();
        }
    }
}