/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Test para devolver un alquiler
     */
    @Test
    public void testDevolverAlquiler() {
        LOG.info("Inicio test testDevolverAlquiler");

        // Caso 1: Código válido
        administrador.devolverAlquiler("TR001");
        assertEquals(EstadoTramite.ALQUILER_REGRESADO, administrador.getTramites().get(0).getEstadoTramite(),
                "El estado debería ser ALQUILER_REGRESADO tras devolver el alquiler con código válido");

        // Caso 2: Código no válido
        administrador.devolverAlquiler("CodigoInexistente");
        // Verificamos que el estado no haya cambiado para el trámite existente
        assertEquals(EstadoTramite.ALQUILER_REGRESADO, administrador.getTramites().get(0).getEstadoTramite(),
                "El estado debería seguir siendo ALQUILER_REGRESADO si el código no coincide");

        LOG.info("Fin test testDevolverAlquiler");
}
