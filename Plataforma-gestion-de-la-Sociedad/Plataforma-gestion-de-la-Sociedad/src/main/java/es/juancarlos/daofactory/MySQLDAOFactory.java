package es.juancarlos.daofactory;

import es.juancarlos.dao.GenericoDAO;
import es.juancarlos.interfaces.IGenericoDAO;



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

}
