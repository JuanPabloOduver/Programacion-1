package co.edu.uniquindio.poo;

import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

public class GeneradorCodigos {
    
    private static HashSet<String> codigosOctalesUsados = new HashSet<>();
    private static HashSet<String> codigosUsados = new HashSet<>();
    
    /**
     * Método que genera un código octal
     * @param longitud
     * @return 
     */
    public static String generarCodigoOctal(int longitud) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            sb.append(random.nextInt(8)); // Genera un dígito octal aleatorio (0-7)
        }
        return sb.toString();
    }
    
    /**
     * Método que genera un código octal sin duplicar
     * @param longitud
     * @return 
     */
    public static String generarCodigoOctalUnico(int longitud) {
        String codigo;
        do {
            codigo = generarCodigoOctal(longitud);
        } while (!codigosOctalesUsados.add(codigo)); // Intenta agregar el código al conjunto. Si devuelve false, el código ya existe
        return codigo;
    }
    
    /**
     * Método que genera un código hexadecimal
     * @param longitud
     * @return 
     */
    public static String generarHexaCode(int longitud){
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", ""); // Eliminar guiones
        return uuidString.substring(0, longitud);
    }
    
    /**
     * Método que genera un código hexadecimal sin duplicar
     * @param longitud
     * @return 
     */
    public static String generarHexaCodeUnico(int longitud) {
        String codigo;
        do {
            codigo = generarHexaCode(longitud); // Llama a la función anterior para generar el UUID
        } while (!codigosUsados.add(codigo)); // Intenta agregar el código al conjunto. Si devuelve false, el código ya existe
        return codigo;
    }
    
}
