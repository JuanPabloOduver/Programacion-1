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
import javafx.scene.image.ImageView;

public class RecuperarContraseniaViewController {

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
    private Button btnVolver;

    @FXML
    private TextField txtNuevaContrasenia;

    @FXML
    private Button btnRestablecerContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtContrasenia;

    @FXML
    private ImageView txtUsuario;


    @FXML
    void onOpenIngresar() {
        Collection<Cliente> listaClientes = iniciarSesionController.obtenerListaClientes();
        Collection<Empleado> listaEmpleados = iniciarSesionController.obtenerListaEmpleados();
        Administrador administrador = iniciarSesionController.obtenerAdministrador();
        
        String correo = txtCorreo.getText().trim();
        String contrasenia = txtContrasenia.getText().trim();
        String nuevaContrasenia = txtContrasenia.getText().trim();

        boolean encontrado = false;
    
    
            if (administrador.getEmail().equals(correo)) { 
                encontrado = true;
                if(contrasenia.equals(nuevaContrasenia)){
                    administrador.setContraseña(contrasenia);
                    app.openIngresar();

                }     // Redirigir a la interfaz 1
            }
        
    
        if (!encontrado) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getEmail().equals(correo)) { // Cambia `getNombre()`
                    encontrado = true;
                    if(contrasenia.equals(nuevaContrasenia)){
                    cliente.setContraseña(contrasenia);
                    app.openIngresar(); // Redirigir a la interfaz 2
                    break;
                    }
                    
                }
            }
        }
    
        if (!encontrado) {
            for (Empleado empleado : listaEmpleados) {
                if (empleado.getEmail().equals(correo)) {
                    encontrado = true;
                    if(contrasenia.equals(nuevaContrasenia)){
                    empleado.setContraseña(contrasenia);
                    app.openMenuEmpleado();
                    break;
                    }

                    
                }
            }
        }
    
        if (!encontrado) {
            mostrarMensajeError("Correo no válido.");
        }
    }

    private void mostrarMensajeError(String mensaje) {
    Alert alerta = new Alert(Alert.AlertType.ERROR);
    alerta.setTitle("Usuario o Contraseña Incorrecto");
    alerta.setContentText(mensaje);
    alerta.showAndWait();
}

    @FXML
    void onOpenPrimary() {
        app.openIngresar();

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



    
    
