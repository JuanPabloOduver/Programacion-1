package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudMotoViewController {

     App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<?> cbbCombustible;

    @FXML
    private TableColumn<?, ?> tbcCilindraje;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<?, ?> tbcVelocidad;

    @FXML
    private TableView<?> tbMoto;

    @FXML
    private TableColumn<?, ?> tbcColor;

    @FXML
    private ComboBox<?> cbbTransmision;

    @FXML
    private TextField txtPlaca;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private TableColumn<?, ?> tbcTransmision;

    @FXML
    private TextField txtColor;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TableColumn<?, ?> tbcEstado;

    @FXML
    private TableColumn<?, ?> tbcCombustible;

    @FXML
    private ComboBox<?> cbbEstado;

    @FXML
    private TextField txtMarca;

    @FXML
    void onRegistrar(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onLimpiar(ActionEvent event) {

    }

    @FXML
    void onOpenRegistrarVehiculo(ActionEvent event) {
        app.openRegistrarVehiculos();

    }

    @FXML
    void initialize() {
        
    }
}
