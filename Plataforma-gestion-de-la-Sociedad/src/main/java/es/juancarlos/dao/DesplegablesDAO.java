package es.juancarlos.dao;

import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.interfaces.IDesplegablesDAO;
import es.juancarlos.persistencia.HibernateUtil;
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
    public ValorDesplegable getByID(String val) {
        
        ValorDesplegable retorno  = null;
        Query q = null;
        try {
            startTransaction();
            q = sesion.createQuery("SELECT v from ValorDesplegable as v WHERE v.valor = :val");
            q.setParameter("val", val);
            retorno=(ValorDesplegable) q.uniqueResult();
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
