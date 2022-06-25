package es.juancarlos.daofactory;

import es.juancarlos.dao.AjaxDAO;
import es.juancarlos.dao.GenericoDAO;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.interfaces.IAjaxDAO;



/**
 * 
 * @author Juan Carlos Sánchez Holguín 
 */
public class MySQLDAOFactory extends DAOFactory{

    /**
     *
     * @return GenericoDAO
     */
    @Override
    public IGenericoDAO getGenericoDAO() {
        return (IGenericoDAO) new GenericoDAO();
    }
    
        /**
     *
     * @return AjaxDAO
     */
    @Override
    public IAjaxDAO getAjaxDAO() {
        return (IAjaxDAO) new AjaxDAO();
    }

}
