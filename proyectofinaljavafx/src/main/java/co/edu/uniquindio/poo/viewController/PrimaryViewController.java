package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    void onOpenIngresar() {
        app.openIngresar();

    }
    
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        
    }
}




 
