package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GestionarVehiculoViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrarVehiculo;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnMarketplaceVehiculos;

    @FXML
    private ImageView txtUsuario;

    @FXML
    void onOpenMarketplaceVehiculos() {
        app.onOpenMarketplaceVehiculos();

    }

    @FXML
    void onOpenRegistrarVehiculo() {
        app.openRegistrarVehiculos();

    }

    @FXML
    void onOpenIngresarComoEmpleado() {
        app.openMenuEmpleado();

    }

    App app;
    
    public void setApp(App app) {
        this.app = app;
    }


    @FXML
    void initialize() {

    }
}
