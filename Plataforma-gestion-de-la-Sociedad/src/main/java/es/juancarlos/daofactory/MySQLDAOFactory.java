package es.juancarlos.daofactory;

import es.juancarlos.dao.AjaxDAO;
import es.juancarlos.dao.DesplegablesDAO;
import es.juancarlos.dao.GenericoDAO;
import es.juancarlos.dao.ListaDao;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IDesplegablesDAO;
import es.juancarlos.interfaces.IListaDao;



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
    
    @Override
    public IListaDao getListaDAO() {
        return (IListaDao) new ListaDao();
    }
    
    @Override
    public IDesplegablesDAO getDesplegablesDAO() {
        return (IDesplegablesDAO) new DesplegablesDAO();
    }
}
