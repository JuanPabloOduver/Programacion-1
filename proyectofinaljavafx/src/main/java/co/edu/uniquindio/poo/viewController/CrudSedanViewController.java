package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudSedanViewController {

     App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> tbcAireAcondicionado;

    @FXML
    private TableColumn<?, ?> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private TableColumn<?, ?> tbcVelocidadCrucero;

    @FXML
    private ComboBox<?> cbbTransmision;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> tbcModelo;

    @FXML
    private CheckBox cbSensorColision;

    @FXML
    private TableColumn<?, ?> tbcNumPasajeros;

    @FXML
    private CheckBox cbSensorTraficoCruzado;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<?> cbbCombustible;

    @FXML
    private CheckBox cbAsistentepPermanenciaCarril;

    @FXML
    private TableColumn<?, ?> tbcCilindraje;

    @FXML
    private TableColumn<?, ?> tbcCapacidad;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<?, ?> tbcVelocidadMax;

    @FXML
    private CheckBox cbAbs;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TableColumn<?, ?> tbcCamaraReversa;

    @FXML
    private CheckBox cbAireAcondicionado;

    @FXML
    private CheckBox cbVelocidadCrucero;

    @FXML
    private TableColumn<?, ?> tbcTransmision;

    @FXML
    private TableColumn<?, ?> tbcAbs;

    @FXML
    private TableColumn<?, ?> tbcAsistentePermanenciaCarill;

    @FXML
    private TextField txtNumBolsasAire;

    @FXML
    private TableColumn<?, ?> tbcPlaca;

    @FXML
    private TableColumn<?, ?> NumBolsasAire;

    @FXML
    private TableColumn<?, ?> tbcSensorTraficoCruzado;

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
    private TableColumn<?, ?> tbcSensorColision;

    @FXML
    private ComboBox<?> cbbEstado;

    @FXML
    private TextField txtMarca;

    @FXML
    private TableView<?> tbSedan;

    @FXML
    private CheckBox cbCamaraReversa;


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

