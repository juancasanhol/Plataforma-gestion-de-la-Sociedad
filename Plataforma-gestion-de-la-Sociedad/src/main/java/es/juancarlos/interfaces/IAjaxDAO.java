package es.juancarlos.interfaces;

/**
 * 
 * @author Juan Carlos Sánchez Holguín
 * @param <T> 
 */
public interface IAjaxDAO<T> {

    /**
     *
     * @param usuario 
     * @param pass 
     * @return Boleano que indicara la existencia del correo pasado por
     * parametro  <strong>true</strong>=No existe <strong>false</strong>= Existe
     */
    public boolean Login(String usuario,String pass);

    /**
     *
     * @param dni Dni el cual se va a verificar su existencia
     * @return Boleano que indicara la existencia del correo pasado por
     * parametro  <strong>true</strong>=Existe <strong>false</strong>= NO Existe
     */
    public boolean ExistenciaDNI(String dni);

}
