package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MenuAdminViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnReporteTramites;

    @FXML
    private Button btnGestionarEmpleados;

    @FXML
    private ImageView txtUsuario;


    @FXML
    void onOpenGestionarEmpleados() {
        app.openGestionarEmpleados();

    }

    @FXML
    void onOpenReporteTramites() {
        app.openReporteTramites();

    }

    @FXML
    void onOpenIniciarSesion() {
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

