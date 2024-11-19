package co.edu.uniquindio.poo;

import java.io.IOException;

import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.viewController.CrudBusViewController;
import co.edu.uniquindio.poo.viewController.CrudCamionViewController;
import co.edu.uniquindio.poo.viewController.CrudCamionetaViewController;
import co.edu.uniquindio.poo.viewController.CrudClientesViewController;
import co.edu.uniquindio.poo.viewController.CrudDeportivoViewController;
import co.edu.uniquindio.poo.viewController.CrudElectricoViewController;
import co.edu.uniquindio.poo.viewController.CrudHibridoViewController;
import co.edu.uniquindio.poo.viewController.CrudMotoViewController;
import co.edu.uniquindio.poo.viewController.CrudPickUpViewController;
import co.edu.uniquindio.poo.viewController.CrudRegistrarEmpleadoViewController;
import co.edu.uniquindio.poo.viewController.CrudSedanViewController;
import co.edu.uniquindio.poo.viewController.CrudTransaccionesViewController;
import co.edu.uniquindio.poo.viewController.CrudVanViewController;
import co.edu.uniquindio.poo.viewController.GestionarVehiculoViewController;
import co.edu.uniquindio.poo.viewController.IniciarSesionViewController;
import co.edu.uniquindio.poo.viewController.ListaTramitesViewController;
import co.edu.uniquindio.poo.viewController.MarketplaceVehiculoViewController;
import co.edu.uniquindio.poo.viewController.MenuAdminViewController;
import co.edu.uniquindio.poo.viewController.MenuClienteViewController;
import co.edu.uniquindio.poo.viewController.MenuEmpleadoViewController;
import co.edu.uniquindio.poo.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.viewController.RecuperarContraseniaViewController;
import co.edu.uniquindio.poo.viewController.RegistrarVehiculosViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    //------------------------------------------------------------------//

    //Inicializando los atributos de la clase

    private Stage primaryStage;
    public static Concesionario consecionario = new Concesionario("Tu Carro UQ", "Cra 15 #12N");

    //------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método main para ejecutar y producir la interfaz
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Método Para Configurar La Primera interfaz e Iniciar la aplicacion
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Clientes");
        openViewPrincipal();
    }

    /**
     *Método Para Iniciar La Primera Inerfaz de JavaFX
     */
    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.Pane rootLayout = (javafx.scene.layout.Pane) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);
            

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Método para abrir la interfaz de Iniciar Sesion del admin
     */
    public void openIngresar() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("iniciarSesion.fxml"));
            Parent rootLayout = loader.load();
            IniciarSesionViewController iniciarSesionViewController = loader.getController();
            iniciarSesionViewController.setApp(this);
            iniciarSesionViewController.setConcesionario(consecionario);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Método para regresar a la interfaz inicial
     */
    public void openPrimary() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            Parent rootLayout = loader.load();
            PrimaryViewController primaryViewController = loader.getController();
            primaryViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onOpenRecuperarContrasenia() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("recuperarContrasenia.fxml"));
            Parent rootLayout = loader.load();
            RecuperarContraseniaViewController recuperarContraseniaViewController = loader.getController();
            recuperarContraseniaViewController.setApp(this);
            recuperarContraseniaViewController.setConcesionario(consecionario);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    /**
     * Método para ingresar al menú del administrador
     */
    public void openMenuAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuAdmin.fxml"));
            Parent rootLayout = loader.load();
            MenuAdminViewController menuAdminViewController = loader.getController();
            menuAdminViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Metodo para ingresar al menu del empleado
     */
    public void openMenuEmpleado() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuEmpleado.fxml"));
            Parent rootLayout = loader.load();
            MenuEmpleadoViewController menuEmpleadoViewController = loader.getController();
            menuEmpleadoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Método para ingresar al menu del cliente
     */
    public void openMenuCliente() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuCliente.fxml"));
            Parent rootLayout = loader.load();
            MenuClienteViewController menuClienteViewController = loader.getController();
            menuClienteViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openGestionarClientes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudClientes.fxml"));
            Parent rootLayout = loader.load();
            CrudClientesViewController crudClientesViewController = loader.getController();
            crudClientesViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openRegistrarTramites() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudTransacciones.fxml"));
            Parent rootLayout = loader.load();
            CrudTransaccionesViewController crudTransaccionesViewController = loader.getController();
            crudTransaccionesViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openGestionarVehiculos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionarVehiculo.fxml"));
            Parent rootLayout = loader.load();
            GestionarVehiculoViewController gestionarVehiculoViewController = loader.getController();
            gestionarVehiculoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openRegistrarVehiculos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("registrarVehiculo.fxml"));
            Parent rootLayout = loader.load();
            RegistrarVehiculosViewController registrarVehiculosViewController = loader.getController();
            registrarVehiculosViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openReporteTramites() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("listaTramites.fxml"));
            Parent rootLayout = loader.load();
            ListaTramitesViewController listaTramitesViewController = loader.getController();
            listaTramitesViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openGestionarEmpleados() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarEmpleado.fxml"));
            Parent rootLayout = loader.load();
            CrudRegistrarEmpleadoViewController crudRegistrarEmpleadoViewController = loader.getController();
            crudRegistrarEmpleadoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudBus() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarBus.fxml"));
            Parent rootLayout = loader.load();
            CrudBusViewController crudBusViewController = loader.getController();
            crudBusViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudCamion() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarCamion.fxml"));
            Parent rootLayout = loader.load();
            CrudCamionViewController crudCamionViewController = loader.getController();
            crudCamionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudCamioneta() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarCamioneta.fxml"));
            Parent rootLayout = loader.load();
            CrudCamionetaViewController crudCamionetaViewController = loader.getController();
            crudCamionetaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudElectrico() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarElectrico.fxml"));
            Parent rootLayout = loader.load();
            CrudElectricoViewController crudElectricoViewController = loader.getController();
            crudElectricoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudHibrido() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarHibrido.fxml"));
            Parent rootLayout = loader.load();
            CrudHibridoViewController crudHibridoViewController = loader.getController();
            crudHibridoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudSedan() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarSedan.fxml"));
            Parent rootLayout = loader.load();
            CrudSedanViewController crudSedanViewController = loader.getController();
            crudSedanViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudPickUp() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarPickUp.fxml"));
            Parent rootLayout = loader.load();
            CrudPickUpViewController crudPickUpViewController = loader.getController();
            crudPickUpViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudDeportivo() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarDeportivo.fxml"));
            Parent rootLayout = loader.load();
            CrudDeportivoViewController crudDeportivoViewController = loader.getController();
            crudDeportivoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudVan() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarVan.fxml"));
            Parent rootLayout = loader.load();
            CrudVanViewController crudVanViewController = loader.getController();
            crudVanViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void openCrudMoto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudRegistrarMoto.fxml"));
            Parent rootLayout = loader.load();
            CrudMotoViewController crudMotoViewController = loader.getController();
            crudMotoViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void onOpenMarketplaceVehiculos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("marketplaceVehiculo.fxml"));
            Parent rootLayout = loader.load();
            MarketplaceVehiculoViewController marketplaceViewController = loader.getController();
            marketplaceViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Método que añade datos a las listas de la empresa
     */
    public void inicializarData(){

        Cliente cliente1 = new Cliente("3218980435", "Daniel Esteban", "Murcia Trujillo", "daniele.murciat@uqvirtual.edu.co", "1117509157", "manzana2", 17);
        consecionario.registrarCliente(cliente1);

        Empleado empleado1 = new Empleado("Juan Pablo", "Oduver Garcia", "1126625017", "manzana3", 18);
        consecionario.registrarEmpleado(empleado1);

        //Administrador administrador1 = new Administrador("Johan Sebastian Leonidas", "Echeverri Ibarra", "johans.echeverrii@uqvirtual.edu.co", "1097722436", "")

        consecionario.getAdministrador();

        Camioneta camioneta1 = new Camioneta(4,2,true,true,true,true,true,true,false,false,4,24,"ADF","Toyota", Estado.NUEVO, "2008", 500, 23, Transmision.MANUAL, Combustible.GASOLINA);
        consecionario.registrarVehiculo(camioneta1);
    
    }

    //------------------------------------------------------------------//
    //Terminado
}