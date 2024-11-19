package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.CrudClientesController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudClientesViewController {

    CrudClientesController crudClientesController;
    ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    Cliente selectedCliente;

    @FXML
    private TableColumn<Cliente, String> tbcContraseniaCliente;

    @FXML
    private TableColumn<Cliente, String> tbcCedulaCliente;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<Cliente, String> tbcApellidoCliente;

    @FXML
    private TextField txxtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Cliente, Integer> tbcEdadCliente;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Cliente, String> tbcEmailCliente;

    @FXML
    private TableColumn<Cliente, String> tbcNombreCliente;

    @FXML
    private TableColumn<Cliente, String> tbcTelefonoCliente;

    @FXML
    private TableView<Cliente> tbClientes;

    @FXML
    private TextField txtContrasenia;



    @FXML
    void onRegistrarCliente() {
        registrarCliente();

    }

    @FXML
    void onEliminarCliente() {
        eliminarCliente();

    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();

    }

    @FXML
    void onOpenMenuEmpleado(ActionEvent event) {
        app.openMenuEmpleado();

    }

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        crudClientesController = new CrudClientesController(app.consecionario);
       initView();
       
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerClientes();

        // Limpiar la tabla
        tbClientes.getItems().clear();

        // Agregar los elementos a la tabla
        tbClientes.setItems(listClientes);

        // Seleccionar elemento de la tabla
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellidoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        tbcCedulaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcEdadCliente.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdad()));
        tbcEmailCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tbcTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tbcContraseniaCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContraseña()));
    }

    private void obtenerClientes() {
        listClientes.addAll(crudClientesController.obtenerListaClientes());
    }

    private void listenerSelection() {
        tbClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellidos());
            txtCedula.setText(cliente.getCedula());
            txtEdad.setText(String.valueOf(cliente.getEdad()));
            txxtEmail.setText(cliente.getEmail());
            txtTelefono.setText(cliente.getTelefono());
            txtContrasenia.setText(cliente.getContraseña());
        }
    }

    private void registrarCliente() {
        Cliente cliente = buildCliente();
        if (cliente != null) {
        crudClientesController.crearCliente(cliente);
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    private Cliente buildCliente() {
        int edad = Integer.parseInt(txtEdad.getText());
        Cliente cliente = new Cliente(txtTelefono.getText(), txtNombre.getText(), txtApellido.getText(), txxtEmail.getText(), txtCedula.getText(), txtContrasenia.getText(), edad);
        return cliente;
    }

    private void eliminarCliente() {
        String cedula = txtCedula.getText(); // Obtén la cédula del TextField.
        crudClientesController.eliminarCliente(cedula); // Llama al método para eliminar el cliente.
        listClientes.remove(selectedCliente); // Elimina el cliente de la lista local.
        limpiarCamposCliente(); // Limpia los campos.
        limpiarSeleccion(); // Limpia la selección, si hay alguna.
}
   
    private void limpiarSeleccion() {
        tbClientes.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txxtEmail.clear();
        txtTelefono.clear();
        txtContrasenia.clear();
    }
}

