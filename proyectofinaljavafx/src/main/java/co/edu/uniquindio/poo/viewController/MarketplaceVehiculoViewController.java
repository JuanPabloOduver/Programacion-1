package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MarketplaceVehiculoViewController {
    
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnEliminarVehiculo;

    @FXML
    void onOpenGestionarVehiculos() {
        app.openRegistrarVehiculos();

    }

    @FXML
    void onAlquilarVehiculo() {

    }

    @FXML
    void onVenderVehiculo() {

    }

    @FXML
    void initialize() {
        
    }
}

