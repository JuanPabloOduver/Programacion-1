module proyectofinaljavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens proyectofinaljavafx to javafx.fxml;
    exports proyectofinaljavafx;
}
