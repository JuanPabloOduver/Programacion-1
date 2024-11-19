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

public class CrudElectricoViewController {

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
    private ComboBox<?> cbbTransmision;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private TextField txtTiempoEnCargar;

    @FXML
    private TextField txtDuracionBateria;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<?> cbbCombustible;

    @FXML
    private TableView<?> tbElectrico;

    @FXML
    private TableColumn<?, ?> tbcDuracionBateria;

    @FXML
    private TableColumn<?, ?> tbcCilindraje;

    @FXML
    private TableColumn<?, ?> tbcTiempoEnCargar;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<?, ?> tbcVelocidadMax;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TableColumn<?, ?> tbcTransmision;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TableColumn<?, ?> tbcEstado;

    @FXML
    private TableColumn<?, ?> tbcCombustible;

    @FXML
    private ComboBox<?> cbbEstado;

    @FXML
    private TextField txtMarca;


    @FXML
    void onRegistrar() {

    }

    @FXML
    void onEliminar() {

    }

    @FXML
    void onLimpiar() {

    }

    @FXML
    void onOpenRegistrarVehiculo(ActionEvent event) {
        app.openRegistrarVehiculos();

    }

    @FXML
    void initialize() {
        assert tbcMarca != null : "fx:id=\"tbcMarca\" was not injected: check your FXML file 'crudRegistrarElectrico.fxml'.";
        assert btnRegistrarVehiculo != null : "fx:id=\"btnRegistrarVehiculo\" was not injected: check your FXML file 'crudRegistrarElectrico.fxml'.";
        assert cbbTransmision != null : "fx:id=\"cbbTransmision\" was not injected: check your FXML file 'crudRegistrarElectrico.fxml'.";
        
    }
}

