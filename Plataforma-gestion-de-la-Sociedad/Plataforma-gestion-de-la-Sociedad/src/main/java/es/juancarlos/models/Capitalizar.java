package es.juancarlos.models;

/**
 * Clase para capitalizar cadenas de caracteres
 *
 * @author Juan Carlos Sánchez Holguín
 */
public class Capitalizar {

    /**
     * Metodo quecapitaliza la cadena pasada por parametro
     *
     * @param cadena cadena a capitalizar
     * @return cadena ya capitalizada
     */
    public static String CapitalizarCadena(String cadena) {
        // Separar palabras de la cadena
        String[] separadaPorEspacios = cadena.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int indice = 0; indice < separadaPorEspacios.length; indice++) {
            String palabra = separadaPorEspacios[indice];
            // De la palabra, primero agregar la primera letra ya convertida a mayúscula
            char primeraLetra = palabra.charAt(0);
            sb.append(Character.toUpperCase(primeraLetra));
            // Luego agregarle "lo sobrante" de la palabra
            sb.append(palabra.substring(1));
            // Y si no es el último elemento del arreglo, le añadimos un espacio
            if (indice < separadaPorEspacios.length - 1) {
                sb.append(" ");
            }
        }
        // Finalmente regresamos la cadena
        return sb.toString();
    }

}
