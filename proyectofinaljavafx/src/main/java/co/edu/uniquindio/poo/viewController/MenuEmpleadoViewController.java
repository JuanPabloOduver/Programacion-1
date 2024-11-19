package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MenuEmpleadoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGestionarClientes;

    @FXML
    private Button btnGestionarVehiculos;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnRegistrarTramites;

    @FXML
    private ImageView txtUsuario;

    @FXML
    void onOpenRegistrarTramites() {
        app.openRegistrarTramites();

    }

    @FXML
    void onOpenGestionarClientes() {
        app.openGestionarClientes();

    }

    @FXML
    void onOpenGestionarvehiculos() {
        app.openGestionarVehiculos();

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }
    
    @FXML
    void onOpenIniciarSesion() {
        app.openIngresar();


    }

    @FXML
    void initialize() {
        

    }
}
