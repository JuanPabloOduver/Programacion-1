package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.MenuClienteController;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MenuClienteViewController {

    MenuClienteController menuClienteController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Vehiculo, String> tbcMarca;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcEsEnchufable;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcSensorDeColision;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcVelocidadCrucero;

    @FXML
    private TableColumn<Vehiculo, Double> tbcDuracionBateria;

    @FXML
    private TableColumn<Vehiculo, Integer> tbcNumBolsasAire;

    @FXML
    private TableColumn<Vehiculo, Double> tbcCilindraje;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcAsistentePermanenciaCarril;

    @FXML
    private TableColumn<Vehiculo, Double> tbcTiempoEnCargar;

    @FXML
    private TableColumn<Vehiculo, Double> tbcVelocidad;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcEs4x4;

    @FXML
    private TableColumn<Vehiculo, String> tbcColor;

    @FXML
    private TableColumn<Vehiculo, Integer> tbcNumPuertas;

    @FXML
    private Button btnVolver;

    @FXML
    private TableView<Vehiculo> tbMenuCliente;

    @FXML
    private TableColumn<Vehiculo, String> tbcModelo;

    @FXML
    private TableColumn<Vehiculo, String> tbcTransmision;

    @FXML
    private TableColumn<Vehiculo, Double> tbcEnCuantoAlcanza100km;

    @FXML
    private TableColumn<Vehiculo, String> tbcPlaca;

    @FXML
    private TableColumn<Vehiculo, Boolean> tbcSensorTraficoCruzado;

    @FXML
    private TableColumn<String, String> tbcEstado;

    @FXML
    private TableColumn<Vehiculo, String> tbcCombustible;

    @FXML
    private TableColumn<Vehiculo, Integer> tbcNumCaballosFuerza;

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void onOpenIniciarSesion(ActionEvent event) {
        app.openIngresar();

    }

    @FXML
    void initialize() {
        setApp(app);
        menuClienteController = new MenuClienteController(app.consecionario);
        initView();
       
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();
    }

    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        //tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEstado())));
        tbcTransmision.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTransmision())));
        tbcCombustible.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCombustible())));
        tbcVelocidad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVelocidadMaxima()));
        tbcCilindraje.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCilindraje()));
        /** 
        tbcCapacidad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCapacidad()));
        tbcAbs.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().getAbs()) );
        tbcAireAcondicionado.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAireAcondicionado()) );
        tbcCamaraReversa.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isCamaraReversa()) );
        tbcNumPasajeros.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumPasajeros()));
        tbcNumPuertas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumPuertas()));
        tbcNumBolsasAire.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumBolsasAire()));
        tbcVelocidadCrucero.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isVelocidadCrucero()) );
        tbcAsistentePermanenciaCarril.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAsistentePermanenciaCarril()) );
        tbcSensorDeColision.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSensorColision()) );
        tbcEs4x4.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEs4x4()) );
        tbcSensorTraficoCruzado.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSensorTraficoCruzado()) );
        /* */
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(menuClienteController.obtenerListaVehiculos());
    }
}



