package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class RegistrarVehiculosViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarMoto;

    @FXML
    private Button btnRegistrarCamion1;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnRegistrarCamion;

    @FXML
    private Button btnRegistrarCamioneta;

    @FXML
    private Button btnRegistrarPickUp;

    @FXML
    private Button btnRegistrarBus;

    @FXML
    private Button btnRegistrarSedan;

    @FXML
    private Button btnRegistrarVan;

    @FXML
    private Button btnRegistrarDeportivo;

    @FXML
    private Button btnRegistrarCamioneta1;

    @FXML
    private ImageView txtUsuario;

    

    @FXML
    void onOpenRegistrarPickUp() {
        app.openCrudPickUp();

    }

    @FXML
    void onOpenRegistrarVan() {
        app.openCrudVan();

    }

    @FXML
    void onOpenRegistrarBus() {
        app.openCrudBus();

    }

    @FXML
    void onOpenRegistrarDeportivo() {
        app.openCrudDeportivo();

    }

    @FXML
    void onOpenRegistrarSedan() {
        app.openCrudSedan();

    }

    

    @FXML
    void onOpenRegistrarMoto() {
        app.openCrudMoto();

    }

    @FXML
    void onOpenRegistrarCamioneta() {
        app.openCrudCamioneta();

    }

    @FXML
    void onOpenRegistrarCamion() {
        app.openCrudCamion();

    }

    @FXML
    void onOpenPrimary() {
        app.openGestionarVehiculos();

    }

    @FXML
    void onOpenRegistrarElectrico() {
        app.openCrudElectrico();

    }

    @FXML
    void onOpenRegistrarHibrido() {
        app.openCrudHibrido();

    }

     App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        
    }
}
