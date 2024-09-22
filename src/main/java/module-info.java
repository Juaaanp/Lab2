module lab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.logging;

    opens lab2 to javafx.fxml;
    exports lab2;
}
