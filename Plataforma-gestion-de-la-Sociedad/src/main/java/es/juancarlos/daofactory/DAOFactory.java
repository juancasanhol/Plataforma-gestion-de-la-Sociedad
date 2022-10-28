package es.juancarlos.daofactory;


import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IListaDao;

/**
 * 
 * @author Juan Carlos Sánchez Holguín 
 */
public abstract class DAOFactory {

    /**
     *
     * @return GenericoDAO
     */
    public abstract IGenericoDAO getGenericoDAO();
    
       /**
     *
     * @return GenericoDAO
     */
    public abstract IAjaxDAO getAjaxDAO();
   
    /**
     *
     * @return DAOFactory()
     */
    public abstract IListaDao getListaDAO ();
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
