package lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class App extends Application {
    private static ResourceBundle bundle;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        @SuppressWarnings("deprecation")
        Locale locale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("lab2.messages", locale);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("started-menu.fxml"), bundle);
        Parent root = loader.load();

        // StartedController controller = loader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static ResourceBundle getBundle() {
        return bundle;
    }
}
