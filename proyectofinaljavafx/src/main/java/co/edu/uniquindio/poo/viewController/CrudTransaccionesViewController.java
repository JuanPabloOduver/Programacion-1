package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CrudTransaccionesViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEmpleado;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private TextField txtCuota;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtVehiculo;

    @FXML
    private TextField txtCliente;

    


    @FXML
    void onRegistrarTransaccion() {

    }

    @FXML
    void onEliminarTransaccion() {

    }

    @FXML
    void onLimpiar() {

    }

    @FXML
    void onOpenMenuClientes() {
        app.openGestionarClientes();
        

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }


    @FXML
    void initialize() {
        

    }
}
