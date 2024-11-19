package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.ListaTramitesController;
import co.edu.uniquindio.poo.model.Tramite;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaTramitesViewController {

    ListaTramitesController listaTramitesController;
    ObservableList<Tramite> listTramites = FXCollections.observableArrayList();



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Tramite> tbListaTramites;

    @FXML
    private TableColumn<Tramite, String> tbcNombreEmpleado;

    @FXML
    private TableColumn<Tramite, String> tbcCodigo;

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<Tramite, String> tbcPlacaVehiculo;

    @FXML
    private TableColumn<Tramite, String> tbcNombreCliente;

    @FXML
    void onOpenCrudAdmin(ActionEvent event) {
        app.openMenuAdmin();

    }

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    void initialize() {
        setApp(app);
        listaTramitesController = new ListaTramitesController(app.consecionario);
        initView();
        
    }

    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();

        // Obtiene la lista
        obtenerTramites();
    }

    private void initDataBinding() {
        tbcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        tbcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmpleado().getNombre()));
        tbcPlacaVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().getPlaca()));
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodigoTramite())));

    }

    private void obtenerTramites() {
        listTramites.addAll(listaTramitesController.obtenerListaTramites());
    }
}


