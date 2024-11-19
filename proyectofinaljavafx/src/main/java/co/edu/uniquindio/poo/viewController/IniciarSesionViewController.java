package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.IniciarSesionController;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class IniciarSesionViewController {

    IniciarSesionController iniciarSesionController;

    App app;

    public void setApp(App app) {
        this.app = app;
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRecuperarContrasenia;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    
    @FXML
    void onOpenUI() {
        Collection<Cliente> listaClientes = iniciarSesionController.obtenerListaClientes();
        Collection<Empleado> listaEmpleados = iniciarSesionController.obtenerListaEmpleados();
        Administrador administrador = iniciarSesionController.obtenerAdministrador();
        
        
        
        String usuario = txtUsuario.getText().trim();
        String contrasenia = txtContrasenia.getText().trim();
    
        boolean encontrado = false;
    
    
            if (administrador.getCedula().equals(usuario) && administrador.getContraseña().equals(contrasenia)) { // Cambia `getNombre()` por el método relevante
                encontrado = true;
                app.openMenuAdmin(); // Redirigir a la interfaz 1
            }
        
    
        if (!encontrado) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getCedula().equals(usuario) && cliente.getContraseña().equals(contrasenia)) { // Cambia `getNombre()`
                    encontrado = true;
                    app.openMenuCliente(); // Redirigir a la interfaz 2
                    break;
                }
            }
        }
    
        if (!encontrado) {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.getCedula().equals(usuario) && empleado.getContraseña().equals(contrasenia)) {
                    encontrado = true;
                    app.openMenuEmpleado();
                    break;
                }
            }
        }
    
        if (!encontrado) {
            mostrarMensajeError("Usuario no válido.");
        }
    }

    private void mostrarMensajeError(String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("Usuario o Contraseña Incorrecto");
    alerta.setContentText(mensaje);
    alerta.showAndWait();
}

@FXML
void onOpenRecuperarContrasenia() {
    app.onOpenRecuperarContrasenia();
}

    @FXML
    void onOpenPrimary() {
        app.openPrimary();

    }


    @FXML
    void initialize() {
        this.iniciarSesionController = new IniciarSesionController();

    }

    public void setConcesionario(Concesionario concesionario) {
        if (iniciarSesionController != null) {
            iniciarSesionController.setConcesionario(concesionario);
                 }
            }
        }
