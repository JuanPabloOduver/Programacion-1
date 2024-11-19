package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CrudVehiculosController;
import co.edu.uniquindio.poo.model.Bus;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudBusViewController {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    CrudVehiculosController crudVehiculoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Bus selectedBus;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Bus, Boolean> tbcAireAcondicionado;

    @FXML
    private TableColumn<Bus, String> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private TextField txtNumSalidasEmergencia;

    @FXML
    private ComboBox<Transmision> cbbTransmision;

    @FXML
    private TableColumn<Bus, Integer> tbcNumPuertas;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Bus, String> tbcModelo;

    @FXML
    private TableColumn<Bus, Integer> tbcNumPasajeros;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private TableView<Vehiculo> tbBus;

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<Combustible> cbbCombustible;

    @FXML
    private TableColumn<Bus, Integer> tbcNumBolsasAire;

    @FXML
    private TableColumn<Bus, Double> tbcCilindraje;

    @FXML
    private TableColumn<Bus, Double> tbcCapacidad;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<Bus, Double> tbcVelocidadMax;

    @FXML
    private TableColumn<Bus, Integer> tbcNumSalidasEmergencia;

    @FXML
    private TextField txtPlaca;

    @FXML
    private CheckBox cbAbs;

    @FXML
    private TableColumn<Bus, Boolean> tbcCamaraReversa;

    @FXML
    private CheckBox cbAireAcondicionado;

    @FXML
    private TextField txtNumPuertas;

    @FXML
    private TableColumn<Bus, String> tbcTransmision;

    @FXML
    private TableColumn<Bus, Boolean> tbcAbs;

    @FXML
    private TableColumn<Bus, Integer> tbcNumEjes;

    @FXML
    private TextField txtNumEjes;

    @FXML
    private TextField txtNumBolsasAire;

    @FXML
    private TableColumn<Bus, String> tbcPlaca;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TableColumn<Bus, String> tbcEstado;

    @FXML
    private TableColumn<Bus, String> tbcCombustible;

    @FXML
    private ComboBox<Estado> cbbEstado;

    @FXML
    private TextField txtMarca;

    @FXML
    private CheckBox cbCamaraReversa;

    @FXML
    void onOpenRegistrarVehiculo() {
        app.openRegistrarVehiculos();
    }

    @FXML
    void onRegistrar() {
        eliminarVehiculo();
    }

    @FXML
    void onEliminar() {
        eliminarVehiculo();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void initialize() {
        setApp(app);
        crudVehiculoController = new CrudVehiculosController(app.consecionario);
        cbbEstado.getItems().addAll(Estado.values());
        cbbTransmision.getItems().addAll(Transmision.values());
        cbbCombustible.getItems().addAll( Combustible.values());
        initView();
        
    }

    private void initView() {
    // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();

        // Limpiar la tabla
        tbBus.getItems().clear();

        // Agregar los elementos a la tabla
        tbBus.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEstado())));
        tbcVelocidadMax.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVelocidadMaxima()));
        tbcCilindraje.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCilindraje()));
        tbcTransmision.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTransmision())));
        tbcCombustible.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCombustible())));
        tbcCapacidad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCapacidad()));
        tbcAbs.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAbs()) );
        tbcAireAcondicionado.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAireAcondicionado()) );
        tbcCamaraReversa.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isCamaraReversa()) );
        tbcNumPasajeros.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumPasajeros()));
        tbcNumPuertas.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumPuertas()));
        tbcNumBolsasAire.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumBolsasAire()));

    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(crudVehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tbBus.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedBus = (Bus) newSelection;
            mostrarInformacionVehiculo(selectedBus);
        });
    }

    private void mostrarInformacionVehiculo(Bus bus) {
        if (bus != null) {
            txtPlaca.setText(bus.getPlaca());
            txtMarca.setText(bus.getMarca());
            txtModelo.setText(bus.getModelo());
            cbbEstado.setValue(bus.getEstado());
            txtVelocidadMax.setText(String.valueOf(bus.getVelocidadMaxima()));
            txtCilindraje.setText(String.valueOf(bus.getCilindraje()));
            cbbTransmision.setValue(bus.getTransmision());
            cbbCombustible.setValue(bus.getCombustible());
            cbAbs.setSelected(bus.isAbs());
            cbAireAcondicionado.setSelected(bus.isAireAcondicionado());
            cbCamaraReversa.setSelected(bus.isCamaraReversa());
            txtNumPasajeros.setText(String.valueOf(bus.getNumPasajeros()));
            txtNumPuertas.setText(String.valueOf(bus.getNumPuertas()));
            txtNumBolsasAire.setText(String.valueOf(bus.getNumBolsasAire()));
            cbCamaraReversa.setSelected(bus.isCamaraReversa());
        }
    }

    private void registrarVehiculo() {
        Bus bus = (Bus) buildCamioneta();
        if (bus != null) {
        crudVehiculoController.crearVehiculo(bus);
            listVehiculos.add(bus);
            limpiarCamposCliente();
        }
    }

    private Vehiculo buildCamioneta() {
        double velocidadMaxima = Double.parseDouble(txtVelocidadMax.getText()); 
        double cilindraje = Double.parseDouble(txtCilindraje.getText());
        double capacidad = Double.parseDouble(txtCapacidad.getText());
        int numEjes = Integer.parseInt(txtNumEjes.getText());
        int numPasajeros = Integer.parseInt(txtNumPasajeros.getText());
        int numPuertas = Integer.parseInt(txtNumPuertas.getText());
        int numBolsasAires = Integer.parseInt(txtNumBolsasAire.getText());
        int numSalidasEmergencia = Integer.parseInt(txtNumSalidasEmergencia.getText());

        Bus bus = new Bus(numPuertas, numBolsasAires, numEjes, numSalidasEmergencia, cbAbs.isSelected(), cbAireAcondicionado.isSelected() ,  cbCamaraReversa.isSelected(), numPasajeros, capacidad, txtPlaca.getText(), txtMarca.getText(), cbbEstado.getValue(), txtModelo.getText(), capacidad, velocidadMaxima, cbbTransmision.getValue(), cbbCombustible.getValue());
        return bus;
    }

    private void eliminarVehiculo() {
        String placa = txtPlaca.getText(); // Obtén la cédula del TextField.
        crudVehiculoController.eliminarCliente(placa); // Llama al método para eliminar el cliente.
        listVehiculos.remove(selectedBus); // Elimina el cliente de la lista local.
        limpiarCamposCliente(); // Limpia los campos.
        limpiarSeleccion(); // Limpia la selección, si hay alguna.
}

    
    private void limpiarSeleccion() {
        tbBus.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtPlaca.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtVelocidadMax.clear();
        txtCilindraje.clear();
        txtCapacidad.clear();
        txtNumPasajeros.clear();
        txtNumPuertas.clear();
        txtNumBolsasAire.clear();
    }
    
}
