package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CrudVehiculosController;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudCamionetaViewController {

    CrudVehiculosController crudVehiculoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Camioneta selectedCamioneta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcAireAcondicionado;

    @FXML
    private TableColumn<Camioneta, String> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcVelocidadCrucero;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcAsistentePermanenciaCarril;

    @FXML
    private TableColumn<Camioneta, Double> tbcVelocidad;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcEs4x4;

    @FXML
    private ComboBox<Transmision> cbbTransmision; //!

    @FXML
    private TableColumn<Camioneta, Integer>  tbcNumPuertas;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Camioneta, String> tbcModelo;

    @FXML
    private CheckBox cbSensorColision; //!

    @FXML
    private TableColumn<Camioneta, Integer> tbcNumPasajeros;

    @FXML
    private CheckBox cbSensorTraficoCruzado; //!

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private CheckBox cbAsistentePermanenciaCarril; //!

    @FXML
    private TextField txtModelo;

    @FXML
    private Button btnLimpiar;

    @FXML
    private CheckBox cbEs4x4;

    @FXML
    private ComboBox<Combustible> cbbCombustible; //!

    @FXML
    private TableColumn<Camioneta, Integer> tbcNumBolsasAire;

    @FXML
    private TableColumn<Camioneta, Double> tbcCilindraje;

    @FXML
    private TableColumn<Camioneta, Double> tbcCapacidad;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TextField txtPlaca;

    @FXML
    private CheckBox cbAbs; //!

    @FXML
    private TableColumn<Camioneta, Boolean> tbcCamaraReversa;

    @FXML
    private CheckBox cbVelocidadCrucero;

    @FXML
    private CheckBox cbAireAcondicionado;

    @FXML
    private TextField txtNumPuertas;

    @FXML
    private TableView<Vehiculo> tbCamioneta;

    @FXML
    private TableColumn<Camioneta, String> tbcTransmision;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcAbs;

    @FXML
    private TextField txtNumBolsasAire;

    @FXML
    private TableColumn<Camioneta, String> tbcPlaca;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcSensorTraficoCruzado;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TableColumn<Camioneta, String> tbcEstado;

    @FXML
    private TableColumn<Camioneta, String> tbcCombustible;

    @FXML
    private TableColumn<Camioneta, Boolean> tbcSensorColision;

    @FXML
    private ComboBox<Estado> cbbEstado;

    @FXML
    private TextField txtMarca;

    @FXML
    private CheckBox cbCamaraReversa;

    @FXML
    void onRegistrar(ActionEvent event) {
        registrarVehiculo();

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
    void onOpenRegistrarVehiculo() {
        app.openRegistrarVehiculos();
    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        setApp(app);
        crudVehiculoController = new CrudVehiculosController(app.consecionario);
        cbbEstado.getItems().addAll(Estado.values());
        cbbTransmision.getItems().addAll(Transmision.values());
        cbbCombustible.getItems().addAll(Combustible.values());
        initView();
        
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();

        // Limpiar la tabla
        tbCamioneta.getItems().clear();

        // Agregar los elementos a la tabla
        tbCamioneta.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEstado())));
        tbcVelocidad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getVelocidadMaxima()));
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
        tbcVelocidadCrucero.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isVelocidadCrucero()) );
        tbcAsistentePermanenciaCarril.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAsistentePermanenciaCarril()) );
        tbcSensorColision.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSensorColision()) );
        tbcEs4x4.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isEs4x4()) );
        tbcSensorTraficoCruzado.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSensorTraficoCruzado()) );

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(crudVehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tbCamioneta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCamioneta = (Camioneta) newSelection;
            mostrarInformacionVehiculo(selectedCamioneta);
        });
    }

    private void mostrarInformacionVehiculo(Camioneta camioneta) {
        if (camioneta != null) {
            txtPlaca.setText(camioneta.getPlaca());
            txtMarca.setText(camioneta.getMarca());
            txtModelo.setText(camioneta.getModelo());
            cbbEstado.setValue(camioneta.getEstado());
            txtVelocidadMax.setText(String.valueOf(camioneta.getVelocidadMaxima()));
            txtCilindraje.setText(String.valueOf(camioneta.getCilindraje()));
            cbbTransmision.setValue(camioneta.getTransmision());
            cbbCombustible.setValue(camioneta.getCombustible());
            cbAbs.setSelected(camioneta.isAbs());
            cbAireAcondicionado.setSelected(camioneta.isAireAcondicionado());
            cbCamaraReversa.setSelected(camioneta.isCamaraReversa());
            txtNumPasajeros.setText(String.valueOf(camioneta.getNumPasajeros()));
            txtNumPuertas.setText(String.valueOf(camioneta.getNumPuertas()));
            txtNumBolsasAire.setText(String.valueOf(camioneta.getNumBolsasAire()));
            cbVelocidadCrucero.setSelected(camioneta.isVelocidadCrucero());
            cbAsistentePermanenciaCarril.setSelected(camioneta.isAsistentePermanenciaCarril());
            cbSensorColision.setSelected(camioneta.isSensorColision());
            cbEs4x4.setSelected(camioneta.isEs4x4());
            cbSensorTraficoCruzado.setSelected(camioneta.isSensorTraficoCruzado());
        }
    }

    private void registrarVehiculo() {
        Camioneta camioneta = (Camioneta) buildCamioneta();
        if (camioneta != null) {
        crudVehiculoController.crearVehiculo(camioneta);
            listVehiculos.add(camioneta);
            limpiarCamposCliente();
        }
    }

    private Vehiculo buildCamioneta() {
        double velocidadMaxima = Double.parseDouble(txtVelocidadMax.getText());
        double cilindraje = Double.parseDouble(txtCilindraje.getText());
        double capacidad = Double.parseDouble(txtCapacidad.getText());
        int numPasajeros = Integer.parseInt(txtNumPasajeros.getText());
        int numPuertas = Integer.parseInt(txtNumPuertas.getText());
        int numBolsasAires = Integer.parseInt(txtNumBolsasAire.getText());
        Camioneta camioneta = new Camioneta(numPuertas, numBolsasAires,cbVelocidadCrucero.isSelected(), cbSensorColision.isSelected(), cbSensorTraficoCruzado.isSelected(), cbAsistentePermanenciaCarril.isSelected(),  cbEs4x4.isSelected(), cbAbs.isSelected(), cbAireAcondicionado.isSelected(), cbCamaraReversa.isSelected(), numPasajeros, capacidad, txtPlaca.getText(), txtMarca.getText(),cbbEstado.getValue(), txtModelo.getText(),  velocidadMaxima, cilindraje, cbbTransmision.getValue(), cbbCombustible.getValue());
        return camioneta;
    }

    private void eliminarVehiculo() {
        String placa = txtPlaca.getText(); // Obtén la cédula del TextField.
        crudVehiculoController.eliminarCliente(placa); // Llama al método para eliminar el cliente.
        listVehiculos.remove(selectedCamioneta); // Elimina el cliente de la lista local.
        limpiarCamposCliente(); // Limpia los campos.
        limpiarSeleccion(); // Limpia la selección, si hay alguna.
}

    
    private void limpiarSeleccion() {
        tbCamioneta.getSelectionModel().clearSelection();
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

