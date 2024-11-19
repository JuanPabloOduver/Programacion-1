package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CrudVehiculosController;
import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.TipoCamion;
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

public class CrudCamionViewController {
    CrudVehiculosController crudVehiculoController;
    ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    Camion selectedCamion;

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Camion, Boolean> tbcAireAcondicionado;

    @FXML
    private TableColumn<Camion, String> tbcMarca;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private ComboBox<Transmision> cbbTransmision;

    @FXML
    private ComboBox<Combustible> cbbCombustible;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Camion, String> tbcModelo;

    @FXML
    private TableColumn <Camion, Integer> tbcNumPasajeros;

    @FXML
    private TextField btnText211;

    @FXML
    private TextField txtNumPasajeros;

    @FXML
    private TextField btnText2;

    @FXML
    private Button btnLimpiar;

    @FXML
    private ComboBox<TipoCamion> cbbTipoCamion;

    @FXML
    private TableColumn<Camion, String> tbcCilindraje;

    @FXML
    private TableColumn<Camion, Integer> tbcCapacidad;

    @FXML
    private TableView<Vehiculo> tbCamion;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    private TableColumn<Camion, String> tbcTipoCamion;

    @FXML
    private TableColumn<Camion, Integer> tbcVelocidadMax;

    @FXML
    private TextField txtPlaca;

    @FXML
    private CheckBox cbAbs;

    @FXML
    private TableColumn<Camion, Boolean> tbcCamaraReversa;

    @FXML
    private TableColumn<Camion, String> tbcTransmision;

    @FXML
    private TableColumn<Camion, Boolean> tbcAbs;

    @FXML
    private TableColumn<Camion, String> tbcPlaca;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtVelocidadMax;

    @FXML
    private TableColumn<Camion, Boolean> tbcEstado;

    @FXML
    private TableColumn<Camion, String> tbcCombustible;

    @FXML
    private ComboBox<Estado> cbbEstado;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtNumEjes;

    @FXML
    private CheckBox bcAireAcondicionado;

    @FXML
    private CheckBox cbCamaraReversa;

    
    @FXML
    void onRegistrar() {
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

    @FXML
    void initialize() {
        setApp(app);
        crudVehiculoController = new CrudVehiculosController(app.consecionario);
        cbbEstado.getItems().addAll(Estado.values());
        cbbTransmision.getItems().addAll(Transmision.values());
        cbbTipoCamion.getItems().addAll(TipoCamion.values());
        cbbCombustible.getItems().addAll(Combustible.values());
        initView();
        
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerVehiculos();

        // Limpiar la tabla
        tbCamion.getItems().clear();

        // Agregar los elementos a la tabla
        tbCamion.setItems(listVehiculos);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcPlaca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        //tbcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEstado())));
        //tbcCombustible.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCombustible()));
        //tbcCilindraje.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCilindraje()));
        tbcTransmision.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTransmision())));
        tbcCombustible.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCombustible())));
        //tbcCapacidad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCapacidad()));
        tbcAbs.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAbs()) );
        tbcAireAcondicionado.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isAireAcondicionado()) );
        tbcCamaraReversa.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isCamaraReversa()) );
        tbcNumPasajeros.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumPasajeros()));
        //tbcTipoCamion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTipoCamion()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(crudVehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tbCamion.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCamion = (Camion) newSelection;
            mostrarInformacionVehiculo(selectedCamion);
        });
    }

    private void mostrarInformacionVehiculo(Camion camion) {
        if (camion != null) {
            txtPlaca.setText(camion.getPlaca());
            txtMarca.setText(camion.getMarca());
            cbbEstado.setValue(camion.getEstado());
            txtVelocidadMax.setText(String.valueOf(camion.getVelocidadMaxima()));
            txtCilindraje.setText(String.valueOf(camion.getCilindraje()));
            cbbTransmision.setValue(camion.getTransmision());
            cbAbs.setSelected(camion.isAbs());
            cbCamaraReversa.setSelected(camion.isCamaraReversa());
            txtNumPasajeros.setText(String.valueOf(camion.getNumPasajeros()));
    
           
        }
    }

    private void registrarVehiculo() {
        Camion camion = (Camion) buildCamion();
        if (camion != null) {
        crudVehiculoController.crearVehiculo(camion);
            listVehiculos.add(camion);
            limpiarCamposVehiculo();
        }
    }
    /* */

    private Vehiculo buildCamion() {
        double velocidadMaxima = Double.parseDouble(txtVelocidadMax.getText());
        double cilindraje = Double.parseDouble(txtCilindraje.getText());
        int numPasajeros = Integer.parseInt(txtNumPasajeros.getText());
        int numEjes = Integer.parseInt(txtNumEjes.getText());
        double capacidad = Double.parseDouble(btnText211.getText());
        Camion camion = new Camion(numEjes, cbbTipoCamion.getValue(),cbAbs.isSelected(), bcAireAcondicionado.isSelected(), cbCamaraReversa.isSelected(), numPasajeros,  capacidad, txtPlaca.getText(), txtMarca.getText(),cbbEstado.getValue(), btnText2.getText(),  velocidadMaxima, cilindraje, cbbTransmision.getValue(), cbbCombustible.getValue());
        return camion;
    }

    private void eliminarVehiculo() {
        String placa = txtPlaca.getText(); // Obtén la cédula del TextField.
        crudVehiculoController.eliminarCliente(placa); // Llama al método para eliminar el cliente.
        listVehiculos.remove(selectedCamion); // Elimina el cliente de la lista local.
        limpiarCamposVehiculo(); // Limpia los campos.
        limpiarSeleccion(); // Limpia la selección, si hay alguna.
    }

    
    private void limpiarSeleccion() {
        tbCamion.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        txtPlaca.clear();
        txtMarca.clear();
        //txtModelo.clear();
        txtVelocidadMax.clear();
        txtCilindraje.clear();
        //txtCapacidad.clear();
        //txtNumPasajeros.clear();
        //txtNumPuertas.clear();
        //txtNumBolsasAire.clear();
    }



}


