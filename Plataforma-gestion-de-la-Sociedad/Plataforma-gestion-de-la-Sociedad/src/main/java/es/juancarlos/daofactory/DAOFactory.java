package es.juancarlos.daofactory;


import es.juancarlos.interfaces.IGenericoDAO;


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
     * @return DAOFactory()
     */
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
