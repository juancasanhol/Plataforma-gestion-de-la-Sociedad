package es.juancarlos.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Juan Carlos Sánchez Holguín
 * @param <T> 
 */
public interface IGenericoDAO<T> {

   /**
     *
     * @param objeto Objeto que se quiere persistir 
     */
    public void insertOrUpdate(T objeto);

    /**
     *
     * @param <T>
     * @param claseEntidad Clase de la que se quiere hacer la consulta
     * @return  Lista de array de objetos con los datos
     */
    public <T> List<T> get(Class<T> claseEntidad);

   /**
     *
     * @param <T> 
     * @param pk Identificador o PK de la clase que se quiere obtener los datos 
     * @param claseEntidad Clase de la que se quiere hacer la consulta
     * @return Lista de array de objetos con los datos
     */
    public <T> T getById(Serializable pk, Class<T> claseEntidad);

  /**
     *
     * @param objeto Objeto que se quiere realizar un borrado
     */
    public void delete(T objeto);

}
