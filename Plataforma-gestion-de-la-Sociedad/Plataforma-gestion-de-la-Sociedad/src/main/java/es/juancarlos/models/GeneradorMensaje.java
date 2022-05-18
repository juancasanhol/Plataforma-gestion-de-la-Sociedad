package es.juancarlos.models;

/**
 *
 * @author junco
 */
public class GeneradorMensaje {

    /**
     *
     * @param caso      Caso por el  cual se va a generar el mensaje predefinido, nuevo usuario o reseteo de la contraseña
     * @param usuario   Correo del usuario 
     * @param passwd    Contraseña asociada al usuario
     * @return          String con el mensaje formado para ser enviado
     */
    public static String Mensaje(String caso, String usuario,String passwd) {

        String retorno = "Sin retorno";
        switch (caso) {

            case "add":
                retorno = "Le damos la bienvenida como usuario/a de CV Software a continuación le facilitamos sus credenciales de inicio\nUsuario: "+usuario+" \nContraseña: "+passwd;
                break;

            case "reset":

                retorno = "Se ha recibido peticion para restablecer sus credenciales de unicia a Cv Software\nSus nuevas credenciales de inicio son\nUsuario: "+usuario+" \nContraseña: "+passwd;

                break;

            default:
                retorno = "Seleccion no valida";
                break;

        }

        return retorno;
    }

}
