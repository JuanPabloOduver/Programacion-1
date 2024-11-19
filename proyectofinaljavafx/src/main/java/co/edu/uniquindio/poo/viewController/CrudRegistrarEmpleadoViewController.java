package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CrudEmpleadoController;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudRegistrarEmpleadoViewController {

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    CrudEmpleadoController empleadoController;
    ObservableList<Empleado> listEmpleados = FXCollections.observableArrayList();
    Empleado selectedEmpleado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TextField txtEdad;

    @FXML
    private TableColumn<Empleado, String> tbcApellido;

    @FXML
    private TableView<Empleado> tbEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcCedula;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<Empleado, String> tbcContrasenia;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Empleado, Integer> tbcEdad;

    @FXML
    private Button btnRegistrarEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtContrasenia;


    @FXML
    void onRegistrarEmpleado() {
        registrarEmpleado();

    }

    @FXML
    void onEliminarEmpleado() {
        eliminarEmpleado();

    }

    @FXML
    void onLimpiar() {

    }

    @FXML
    void onOpenRegistrarVehiculo() {
        app.openMenuAdmin();

    }

    @FXML
    void initialize() {
       empleadoController = new CrudEmpleadoController(app.consecionario);
        initView();

    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerEmpleados();

        // Limpiar la tabla
        tbEmpleado.getItems().clear();

        // Agregar los elementos a la tabla
        tbEmpleado.setItems(listEmpleados);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        tbcEdad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));
        tbcContrasenia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContraseña()));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerEmpleados() {
        listEmpleados.addAll(empleadoController.obtenerListaEmpleados());
    }

    private void listenerSelection() {
        tbEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedEmpleado = newSelection;
            mostrarInformacionEmpleado(selectedEmpleado);
        });
    }

    private void mostrarInformacionEmpleado(Empleado empleado) {
        if (empleado != null) {
            txtCedula.setText(empleado.getCedula());
            txtNombre.setText(empleado.getNombre());
            txtApellido.setText(empleado.getApellidos());
            txtEdad.setText(String.valueOf(empleado.getEdad()));
            txtContrasenia.setText(empleado.getContraseña());
        }
    }

    private void registrarEmpleado() {
        Empleado empleado = buildEmpleado();
        if (empleado != null) {
        empleadoController.crearEmpleado(empleado);
            listEmpleados.add(empleado);
            limpiarCamposCliente();
        }
    }

    private Empleado buildEmpleado() {
        int edad = Integer.parseInt(txtEdad.getText());
        Empleado empleado = new Empleado(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(), txtContrasenia.getText(), edad  );
        return empleado;
    }

    private void eliminarEmpleado() {
        String cedula = txtCedula.getText(); // Obtén la cédula del TextField.
        empleadoController.eliminarCliente(cedula); // Llama al método para eliminar el cliente.
        listEmpleados.remove(selectedEmpleado); // Elimina el cliente de la lista local.
        limpiarCamposCliente(); // Limpia los campos.
        limpiarSeleccion(); // Limpia la selección, si hay alguna.
    }

    private void limpiarSeleccion() {
        tbEmpleado.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtContrasenia.clear();
    }
}

