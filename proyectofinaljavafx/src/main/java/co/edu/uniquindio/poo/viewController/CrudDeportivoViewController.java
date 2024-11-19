package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.Deportivo;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.Transmision;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudDeportivoViewController {

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Deportivo, String> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private ComboBox<Deportivo> cbbTransmision;

    @FXML
    private TableColumn<Deportivo, Integer> tbcNumPuertas;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Deportivo, String> tbcModelo;

    @FXML
    private TableColumn<Deportivo, Integer> tbcNumPasajeros;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<Deportivo> cbbCombustible;

    @FXML
    private TextField btnText211211;

    @FXML
    private TableColumn<Deportivo, Integer> tbcNumBolsasAire;

    @FXML
    private TableColumn<Deportivo, Integer> tbcCilindraje;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<Deportivo, Double> tbcVelocidadMax;

    @FXML
    private TextField txt;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TableColumn<Deportivo, Transmision> tbcTransmision;

    @FXML
    private TextField btnText21122;

    @FXML
    private TextField btnText21121;

    @FXML
    private TableColumn<Deportivo, String> tbcPlaca;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TableColumn<Deportivo, Estado> tbcEstado;

    @FXML
    private TableColumn<Deportivo, Combustible> tbcCombustible;

    @FXML
    private ComboBox<Deportivo> cbbEstado;

    @FXML
    private TableView<Deportivo> tbcDeportivo;

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
    void onOpenRegistrarVehiculo() {
        app.openRegistrarVehiculos();

    }

    @FXML
    void initialize() {
        
    }
}

