package es.juancarlos.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
public class Codificar {

    /**
     *
     * @param password Contraseña que se quiere cifrar en MD5
     * @return String con la contraseña ya cifrada
     * @throws java.security.NoSuchAlgorithmException Si ocurre un error
     * relacionado con la codificación MD5( posible error de algoritmo)
     */
    public static String Codificar(String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
