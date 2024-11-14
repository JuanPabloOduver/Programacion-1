import co.edu.uniquindio.poo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;


public class AppTest {

    @Test
    public void testPersona() {
        Persona persona = new Persona("Juan", "Pérez", "juan@correo.com", "12345", "contraseña", 30);
        assertEquals("Juan", persona.getNombre());
        assertEquals("Pérez", persona.getApellidos());
        assertEquals("juan@correo.com", persona.getEmail());
        assertEquals("12345", persona.getCedula());
        assertEquals(30, persona.getEdad());
        assertEquals("contraseña", persona.getContraseña());


        String expectedToString = "Persona = nombre = Juan, apellidos = Pérez, email = juan@correo.com, cedula = 12345, edad = 30";
        assertEquals(expectedToString, persona.toString());
    }

    @Test
    public void testCliente() {
        Cliente cliente = new Cliente("1234567890", "Ana", "López", "ana@correo.com", "67890", "clave", 25);
        assertEquals("1234567890", cliente.getTelefono());

        // Verificar la herencia de Persona
        assertEquals("Ana", cliente.getNombre());


        String expectedToString = "Cliente = nombre = Ana, apellidos = López, email = ana@correo.com, cedula = 67890, edad = 25, telefono = 1234567890";
        assertEquals(expectedToString, cliente.toString());    
    }



    @Test
    public void testEmpleado() {
        Empleado empleado = new Empleado("Pedro", "Ramírez", "1094975979", "contraseña123", 28);

        // Verificar la herencia de Persona
        assertEquals("Pedro", empleado.getNombre());

        //Verificar metodos
        assertEquals(0, empleado.getNumVehiculosVendidos());
        Cliente cliente1 = new Cliente("3105687452", "Johan", "Ibarra", "johan@correo.com", "1094975979", "contraseña123", 20);
        empleado.añadirClientes(cliente1);
        assertEquals(1, empleado.getNumClientesCreados());
        assertEquals(cliente1, empleado.getClientesCreados().getFirst());

        String expectedToString = "Empleado = nombre = Pedro, apellidos = Ramírez, email = 1094975979, cedula = 1094975979, edad = 28";
        assertEquals(expectedToString, empleado.toString());
    }



    @Test
    public void testAdministrador() {
        Administrador administrador = new Administrador("María", "García", "maria@correo.com", "112233", "admin", 40);
        assertEquals(0.0, administrador.getSalario());
        assertTrue(administrador.getEmpleadosContratados().isEmpty());


        String expectedToString = "Administrador = nombre = María, apellidos = García, email = maria@correo.com, cedula = 112233, edad = 40, salario = 0.0";
        assertEquals(expectedToString, administrador.toString());
    }

    @Test
    public void testConcesionario() {
        Concesionario concesionario = new Concesionario("Autos del Futuro", "Calle Principal 123");
        assertEquals("Autos del Futuro", concesionario.getNombre());
        assertEquals("Calle Principal 123", concesionario.getDireccion());
        assertNotNull(concesionario.getAdministrador());
        assertTrue(concesionario.getEmpleados().isEmpty());
        assertTrue(concesionario.getUsuarios().isEmpty());
        assertTrue(concesionario.getVehiculos().isEmpty());

        // Agregar empleados, clientes y vehículos

        String nombreAdmin = concesionario.getAdministrador().getNombre();
        assertEquals("Johan Sebastian", nombreAdmin);

        
    }


    @Test
    public void testAccionesVehiculo() {

        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", Estado.NUEVO, "Corolla", 200.0, 2.0, Transmision.MANUAL, Combustible.GASOLINA);

        Empleado empleado = new Empleado("Vendedor", "1", "1234567890", "contraseña", 35);

        Cliente cliente = new Cliente("3001234567", "Comprador", "1", "comprador@correo.com", "9876543210", "clave123", 28);


        AccionesVehiculo acciones = new AccionesVehiculo(vehiculo, empleado, cliente, "TRAMITE001");


        assertEquals(vehiculo, acciones.getVehiculo());
        assertEquals(empleado, acciones.getEmpleado());
        assertEquals(cliente, acciones.getCliente());
        assertEquals("TRAMITE001", acciones.getCodigoTramite());
        assertEquals(EstadoTramite.SELECCIONE_ESTADO, acciones.getEstadoTramite());


        String expectedToString = "AccionesVehiculo= Vehículo = Vehiculo= Placa =ABC123, estado de uso = NUEVO, marca = Toyota, modelo = Corolla, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 200.0, cilindraje =  2.0, trasmision = MANUAL, tipo de combustible = GASOLINA, cambios = [R, 1, 2, 3, 4, 5], empleado = Empleado = nombre = Vendedor, apellidos = 1, email = 1234567890, cedula = 1234567890, edad = 35, cliente = Cliente = nombre = Comprador, apellidos = 1, email = comprador@correo.com, cedula = 9876543210, edad = 28, telefono = 3001234567, estado del tramite = SELECCIONE_ESTADO, còdigo del tramite: TRAMITE001";

        assertEquals(expectedToString, acciones.toString());



    }


    @Test
    public void testAlquiler() {
        Vehiculo vehiculo = new Vehiculo("XYZ789", "Ford", Estado.USADO, "Focus", 180.0, 1.6, Transmision.AUTOMATICA, Combustible.GASOLINA);
        Empleado empleado = new Empleado("Alquilador", "2", "0987654321", "clave456", 30);
        Cliente cliente = new Cliente("3105687452", "Arrendatario", "2", "arrendatario@correo.com", "1011121314", "contraseña789", 22);
        Alquiler alquiler = new Alquiler("DEV-001", vehiculo, empleado, cliente, "ALQ-001");

        // Verificar la herencia de AccionesVehiculo
        assertEquals(vehiculo, alquiler.getVehiculo());
        assertEquals("DEV-001", alquiler.getCodigoDevolucion());


        String expectedToString = "Alquiler= Vehículo = Vehiculo= Placa =XYZ789, estado de uso = USADO, marca = Ford, modelo = Focus, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 180.0, cilindraje =  1.6, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, empleado = Empleado = nombre = Alquilador, apellidos = 2, email = 0987654321, cedula = 0987654321, edad = 30, cliente = Cliente = nombre = Arrendatario, apellidos = 2, email = arrendatario@correo.com, cedula = 1011121314, edad = 22, telefono = 3105687452, estado del tramite = SELECCIONE_ESTADO, còdigo del tramite: ALQ-001, código para devolver el alquiler = DEV-001";
        assertEquals(expectedToString, alquiler.toString());

    }

    @Test
    public void testCompra() {
        Vehiculo vehiculo = new Vehiculo("MNO456", "Chevrolet", Estado.NUEVO, "Spark", 160.0, 1.2, Transmision.MANUAL, Combustible.GASOLINA);
        Empleado empleado = new Empleado("Vendedor", "3", "1100112233", "clave789", 32);
        Cliente cliente = new Cliente("3124785412", "Comprador", "3", "comprador2@correo.com", "4455667788", "contraseña001", 27);

        Compra compra = new Compra("COMPRA-002", vehiculo, empleado, cliente, "TRAMITE-002");

        assertEquals("COMPRA-002", compra.getCodigoCompra());
        String expectedToString = "Compra= Vehículo = Vehiculo= Placa =MNO456, estado de uso = NUEVO, marca = Chevrolet, modelo = Spark, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 160.0, cilindraje =  1.2, trasmision = MANUAL, tipo de combustible = GASOLINA, cambios = [R, 1, 2, 3, 4, 5], empleado = Empleado = nombre = Vendedor, apellidos = 3, email = 1100112233, cedula = 1100112233, edad = 32, cliente = Cliente = nombre = Comprador, apellidos = 3, email = comprador2@correo.com, cedula = 4455667788, edad = 27, telefono = 3124785412, estado del tramite = SELECCIONE_ESTADO, còdigo del tramite: TRAMITE-002, codigo de la compra = COMPRA-002";
        assertEquals(expectedToString, compra.toString());

    }


    @Test
    public void testVenta() {
        Vehiculo vehiculo = new Vehiculo("GHI012", "Renault", Estado.USADO, "Logan", 170.0, 1.4, Transmision.AUTOMATICA, Combustible.GASOLINA);
        Empleado empleado = new Empleado("Vendedor", "4", "2233445566", "clave123", 31);
        Cliente cliente = new Cliente("3148529635", "Comprador", "4", "comprador3@correo.com", "7788990011", "contraseña456", 29);

        Venta venta = new Venta(12, vehiculo, empleado, cliente, "VENTA-003");


        assertEquals(12, venta.getCuotaIntereses());

        String expectedToString = "Venta= Vehículo = Vehiculo= Placa =GHI012, estado de uso = USADO, marca = Renault, modelo = Logan, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 170.0, cilindraje =  1.4, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, empleado = Empleado = nombre = Vendedor, apellidos = 4, email = 2233445566, cedula = 2233445566, edad = 31, cliente = Cliente = nombre = Comprador, apellidos = 4, email = comprador3@correo.com, cedula = 7788990011, edad = 29, telefono = 3148529635, estado del tramite = SELECCIONE_ESTADO, còdigo del tramite: VENTA-003, pagos en 12 cuota(s) con interes. ";
        assertEquals(expectedToString, venta.toString());
    }


    @Test
    public void testVehiculo() {
        Vehiculo vehiculo = new Vehiculo("PLACA123", "Marca", Estado.NUEVO, "Modelo", 200.0, 2.0, Transmision.AUTOMATICA, Combustible.GASOLINA);

        assertEquals("Marca", vehiculo.getMarca());
        assertEquals("Modelo", vehiculo.getModelo());
        assertEquals(Disponibilidad.VEHICULO_DISPONIBLE, vehiculo.getDisponibilidad());
        assertEquals(200.0, vehiculo.getVelocidadMaxima());
        assertEquals(2.0, vehiculo.getCilindraje());
        assertEquals(Transmision.AUTOMATICA, vehiculo.getTransmision());
        assertEquals(Combustible.GASOLINA, vehiculo.getCombustible());
        assertNull(vehiculo.getCambios()); // Debe ser null para transmisión automática



        Vehiculo vehiculoManual = new Vehiculo("PLACA123", "Marca", Estado.NUEVO, "Modelo", 200.0, 2.0, Transmision.MANUAL, Combustible.GASOLINA);
        assertArrayEquals(new char[]{'R', '1', '2', '3', '4', '5'}, vehiculoManual.getCambios());
        String toStringManual = vehiculoManual.toString();
        assertTrue(toStringManual.contains("cambios = [R, 1, 2, 3, 4, 5]"));
    }


    @Test

    public void testVehiculoCargaPasajeros() {

        VehiculoCargaPasajeros vehiculo = new VehiculoCargaPasajeros(true, true, true, 5, 500.0, "PLACA456", "Marca2", Estado.USADO, "Modelo2", 180.0, 1.8, Transmision.MANUAL, Combustible.DIESEL);

        assertTrue(vehiculo.isAbs());
        assertTrue(vehiculo.isAireAcondicionado());
        assertTrue(vehiculo.isCamaraReversa());
        assertEquals(5, vehiculo.getNumPasajeros());
        assertEquals(500.0, vehiculo.getCapacidad());

        // Verificar herencia
        assertEquals("Marca2", vehiculo.getMarca());

        String expectedToString = "VehiculoCargaPasajeros= Placa =PLACA456, estado de uso = USADO, marca = Marca2, modelo = Modelo2, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 180.0, cilindraje =  1.8, trasmision = MANUAL, tipo de combustible = DIESEL, cambios = [R, 1, 2, 3, 4, 5], tiene abs = true, tiene aire acondicionado = true, tiene camara reversa = true, numero de pasajeros = 5, capacidad de carga= 500.0";
        assertEquals(expectedToString, vehiculo.toString());
    }

    @Test
    public void testMotocicleta() {
        Motocicleta motocicleta = new Motocicleta("Azul", "MOTO789", "Yamaha", Estado.USADO, "R1", 300.0, 1.0, Transmision.MANUAL, Combustible.GASOLINA);

        assertEquals("Azul", motocicleta.getColor());

        String expectedToString = "Motocicleta= Placa =MOTO789, estado de uso = USADO, marca = Yamaha, modelo = R1, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 300.0, cilindraje =  1.0, trasmision = MANUAL, tipo de combustible = GASOLINA, cambios = [R, 1, 2, 3, 4, 5], color = Azul";
        assertEquals(expectedToString, motocicleta.toString());
    }



    @Test
    public void testDeportivo() {
        Deportivo deportivo = new Deportivo(2, 2, 4, 500, 3.5, "DEP001", "Porsche", Estado.NUEVO, "911", 350.0, 4.0, Transmision.AUTOMATICA, Combustible.GASOLINA);


        assertEquals(2, deportivo.getNumPasajeros());
        assertEquals(3.5, deportivo.getTiempoAlcanza100Km());

        String expectedToString = "Deportivo= Placa =DEP001, estado de uso = NUEVO, marca = Porsche, modelo = 911, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 350.0, cilindraje =  4.0, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, capacidad de pasajeros = 2, cantidad de puertas = 2, número de bolsas de aire = 4, numero de caballos de fuerza = 500, tiempo en el que alcanza los 100Km = 3.5s";
        assertEquals(expectedToString, deportivo.toString());

    }


    @Test
    public void testElectrico() {
        Electrico electrico = new Electrico("ELEC002", "Tesla", Estado.NUEVO, "Model S", 250.0, 0.0, Transmision.AUTOMATICA, Combustible.GASOLINA, 8.0, 2.0);


        assertEquals(8.0, electrico.getDuracionBateria());
        assertEquals(2.0, electrico.getTiempoEnCargar());

        String expectedToString = "class co.edu.uniquindio.poo.model.Electrico= duraciòn de la baterìa = 8.0 horas, tiempo que tarda en cargar completamente = 2.0 horas.";
        assertEquals(expectedToString, electrico.toString());

    }


    @Test
    public void testHibrido() {


        Hibrido hibridoEnchufable = new Hibrido("HIBR003", "Toyota", Estado.USADO, "Prius", 190.0, 1.8, Transmision.AUTOMATICA, Combustible.GASOLINA, true);
        assertTrue(hibridoEnchufable.getesEnchufable());

        String expectedToStringEnchufable = "Hibrido= Placa =HIBR003, estado de uso = USADO, marca = Toyota, modelo = Prius, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 190.0, cilindraje =  1.8, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, ¿es enchufable?: Sí, ¿es hìbrido ligero?: No";


        Hibrido hibridoNoEnchufable = new Hibrido("HIBR004", "Honda", Estado.USADO, "Insight", 180.0, 1.5, Transmision.AUTOMATICA, Combustible.GASOLINA, false);
        assertFalse(hibridoNoEnchufable.getesEnchufable());

        String expectedToStringNoEnchufable = "Hibrido= Placa =HIBR004, estado de uso = USADO, marca = Honda, modelo = Insight, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 180.0, cilindraje =  1.5, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, ¿es enchufable?: No, ¿es hìbrido ligero?: No";
        assertEquals(expectedToStringNoEnchufable, hibridoNoEnchufable.toString());

    }


    @Test
    public void testBus() {

        Bus bus = new Bus(2, 6, 3, 2, true, true, true, 40, 1000.0, "BUS001", "Mercedes-Benz", Estado.NUEVO, "Citaro", 120.0, 12.0, Transmision.AUTOMATICA, Combustible.DIESEL);

        assertEquals(2, bus.getNumPuertas());
        assertEquals(6, bus.getNumBolsasAire());
        assertEquals(3, bus.getNumEjes());
        assertEquals(2, bus.getNumSalidasEmergencia());

        String expectedToString = "Bus= Placa =BUS001, estado de uso = NUEVO, marca = Mercedes-Benz, modelo = Citaro, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 120.0, cilindraje =  12.0, trasmision = AUTOMATICA, tipo de combustible = DIESEL, cambios = null, tiene abs = true, tiene aire acondicionado = true, tiene camara reversa = true, numero de pasajeros = 40, capacidad de carga= 1000.0, numero de puertas = 2, numero de bolsas de aire = 6, numero de ejes = 3, numero de salidas de emergencia = 2";
        assertEquals(expectedToString, bus.toString());
    }


    @Test
    public void testCamion() {

        Camion camion = new Camion(4, TipoCamion.PESADO, true, false, true, 2, 5000.0, "CAM001", "Kenworth", Estado.USADO, "T680", 110.0, 15.0, Transmision.MANUAL, Combustible.DIESEL);


        assertEquals(4, camion.getNumEjes());
        assertEquals(TipoCamion.PESADO, camion.getTipoCamion());


        String expectedToString = "Camion= Placa =CAM001, estado de uso = USADO, marca = Kenworth, modelo = T680, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 110.0, cilindraje =  15.0, trasmision = MANUAL, tipo de combustible = DIESEL, cambios = [R, 1, 2, 3, 4, 5], tiene abs = true, tiene aire acondicionado = false, tiene camara reversa = true, numero de pasajeros = 2, capacidad de carga= 5000.0, numero de ejes = 4, tipo de camion = PESADO";
        assertEquals(expectedToString, camion.toString());
    }


    @Test
    public void testCamioneta() {
        Camioneta camioneta = new Camioneta(4, 6, true, true, true, true, true, true, true, true, 7, 750.0, "CAM002", "Jeep", Estado.NUEVO, "Grand Cherokee", 200.0, 3.6, Transmision.AUTOMATICA, Combustible.GASOLINA);

        assertTrue(camioneta.isVelocidadCrucero());
        assertTrue(camioneta.isSensorColision());
        assertTrue(camioneta.isSensorTraficoCruzado());
        assertTrue(camioneta.isAsistentePermanenciaCarril());
        assertTrue(camioneta.isEs4x4());

        String expectedToString = "Camioneta= Placa =CAM002, estado de uso = NUEVO, marca = Jeep, modelo = Grand Cherokee, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 200.0, cilindraje =  3.6, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, tiene abs = true, tiene aire acondicionado = true, tiene camara reversa = true, numero de pasajeros = 7, capacidad de carga= 750.0, numero de puertas = 4, numero de bolsas de aire = 6, tiene velocidad Crucero = true, tiene sensor de colision = true, tiene sensor de trafico cruzado = true, tiene asistente de permanencia en el carril = true, el vehiculo es 4x4 = true";
        assertEquals(expectedToString, camioneta.toString());
    }



    @Test
    public void testPickUp() {

        PickUp pickUp = new PickUp(2, 2, true, true, false, true, 2, 1000.0, "PICK001", "Ford", Estado.USADO, "F-150", 180.0, 5.0, Transmision.AUTOMATICA, Combustible.GASOLINA);


        assertEquals(2, pickUp.getNumPuertas());
        assertEquals(2, pickUp.getNumBolsasAire());
        assertTrue(pickUp.isEs4x4());


        String expectedToString = "PickUp= Placa =PICK001, estado de uso = USADO, marca = Ford, modelo = F-150, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 180.0, cilindraje =  5.0, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, tiene abs = true, tiene aire acondicionado = false, tiene camara reversa = true, numero de pasajeros = 2, capacidad de carga= 1000.0, número de puertas = 2, número de bolsas de aire = 2, el vehículo es 4x4 = true";
        assertEquals(expectedToString, pickUp.toString());

    }

    @Test

    public void testSedan() {

        Sedan sedan = new Sedan(true, true, false, true, 8, true, true, false, 5, 400.0, "SED001", "Honda", Estado.NUEVO, "Civic", 190.0, 2.0, Transmision.MANUAL, Combustible.GASOLINA);

        assertTrue(sedan.getVelocidadCrucero());
        assertTrue(sedan.isSensorColision());
        assertFalse(sedan.isSensorTraficoCruzado());
        assertTrue(sedan.isAsistentePermanenciaCarril());
        assertEquals(8, sedan.getNumBolsasAire());



        String expectedToString = "Sedan= Placa =SED001, estado de uso = NUEVO, marca = Honda, modelo = Civic, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 190.0, cilindraje =  2.0, trasmision = MANUAL, tipo de combustible = GASOLINA, cambios = [R, 1, 2, 3, 4, 5], tiene abs = true, tiene aire acondicionado = true, tiene camara reversa = false, numero de pasajeros = 5, capacidad de carga= 400.0, tiene velocidad crucero = true, tiene sensor de colision = true, tiene sensor de trafico cruzado = false, tiene asistente de permanencia en el carril = true, numero de bolsas de aire = 8";
        assertEquals(expectedToString, sedan.toString());

    }



    @Test
    public void testVan() {


        Van van = new Van(4, 4, false, true, true, 8, 600.0, "VAN001", "Dodge", Estado.USADO, "Grand Caravan", 170.0, 3.6, Transmision.AUTOMATICA, Combustible.GASOLINA);


        assertEquals(4, van.getNumPuertas());
        assertEquals(4, van.getNumBolsasAire());


        String expectedToString = "Van= Placa =VAN001, estado de uso = USADO, marca = Dodge, modelo = Grand Caravan, disponibilidad del vehículo = VEHICULO_DISPONIBLE, velocidad maxima = 170.0, cilindraje =  3.6, trasmision = AUTOMATICA, tipo de combustible = GASOLINA, cambios = null, tiene abs = false, tiene aire acondicionado = true, tiene camara reversa = true, numero de pasajeros = 8, capacidad de carga= 600.0, numero de puertas=4, numero de bolsas de aire = 4";
        assertEquals(expectedToString, van.toString());

    }



    @Test

    public void concesionarioTest(){
        Concesionario concesionario = new Concesionario("Autos del Futuro", "Calle Principal 123");


        //Registro Empleado
        Empleado empleado = new Empleado("Pedro", "Ramírez", "1094975979", "contraseña123", 28);
        concesionario.registrarEmpleado(empleado);
        assertTrue(concesionario.verificarEmpleado("1094975979"));

        //Bloquear Empleado
        concesionario.bloquearEmpleado("1094975979");
        assertFalse(concesionario.verificarEmpleado("1094975979"));

        //Registrar Vehiculo Comprado
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", Estado.NUEVO, "Corolla", 200.0, 2.0, Transmision.MANUAL, Combustible.GASOLINA);
        Cliente cliente = new Cliente("3001234567", "Comprador", "1", "comprador@correo.com", "9876543210", "clave123", 28);
        empleado = new Empleado("Pedro", "Ramírez", "1094975979", "contraseña123", 28); //Registrar de nuevo al empleado
        concesionario.registrarEmpleado(empleado);
        Compra compra = new Compra("COMPRA001", vehiculo, empleado, cliente, "TRAMITE001");
        concesionario.registrarVehiculoComprado(compra);
        assertTrue(concesionario.verificarVehiculo("ABC123"));

        //Registrar Vehiculo Alquilado
        Alquiler alquiler = new Alquiler("DEV-001", vehiculo, empleado, cliente, "ALQ-001");
        concesionario.registrarVehiculoAlquilado(alquiler);
        assertEquals(Disponibilidad.VEHICULO_ALQUILADO, vehiculo.getDisponibilidad());

        //Registrar Vehiculo Vendido
        Venta venta = new Venta(12, vehiculo, empleado, cliente, "VENTA-003");
        concesionario.registrarVehiculoVendido(venta);
        assertFalse(concesionario.verificarVehiculo("ABC123"));

        //Devolver Vehiculo Alquilado
        concesionario.registrarVehiculoComprado(compra); //Registrar de nuevo el vehiculo
        concesionario.registrarVehiculoAlquilado(alquiler);
        concesionario.devolverAlquiler("ALQ-001");
        assertEquals(EstadoTramite.ALQUILER_REGRESADO, alquiler.getEstadoTramite());

        //Registrar Cliente
        concesionario.registrarCliente(cliente);
        assertTrue(concesionario.verificarCliente("comprador@correo.com"));


        //Buscar Vehiculo por Placa
        String mensaje = concesionario.buscarPlacaVehiculo("ABC123");
        assertTrue(mensaje.contains("Vehiculo"));


        //Eliminar Empleado
        concesionario.eliminarEmpleado("1094975979");
        assertFalse(concesionario.verificarEmpleado("1094975979"));
    }

}