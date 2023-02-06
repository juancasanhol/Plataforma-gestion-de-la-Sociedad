package es.juancarlos.dao;

import es.juancarlos.beans.Desplegables;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IDesplegablesDAO;
import es.juancarlos.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
public class DesplegablesDAO implements IDesplegablesDAO {

    Session sesion;

       @Override
    public Desplegables getByID(String id) {
        
        Desplegables retorno  = null;
        Query q = null;
        try {
            startTransaction();
            q = sesion.createQuery("SELECT d.Nombre from Desplegables as d WHERE d.Nombre = :id");
            q.setParameter("id", id);
            retorno=(Desplegables) q.uniqueResult();
        } catch (HibernateException e) {
            this.handleExcepcion(e);
        } finally {

            endTransaction();
        }

        return  retorno;
    }

    private void startTransaction() {
        sesion = HibernateUtil.getSessionFactory().openSession();

        sesion.getTransaction().begin();

    }

    private void endTransaction() {
        if (sesion.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            sesion.getTransaction().commit();

        }
        sesion.close();

    }

    private void handleExcepcion(HibernateException he) throws HibernateException {
        if (sesion.getTransaction().isActive()) {
            sesion.getTransaction().rollback();

        }
        System.out.println("Ésta es la excepción de hibernate: " + he.getMessage());

        throw he;
    }



}
