package es.juancarlos.dao;

import es.juancarlos.interfaces.IAjaxDAO;
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
public class AjaxDAO implements IAjaxDAO {

    Session sesion;

    /**
     *
     * @param dirCorreo Correo el cual se va a verificar su existencia
     * @return Boleano que indicara la existencia del correo pasado por
     * parametro  <strong>true</strong>=No existe <strong>false</strong>= Existe
     */
    @Override
    public boolean Login (String usuario,String pass) {

        List<Object> listadoResultados = null;
        Query q = null;
        int valor = 0;
        try {
            startTransaction();
            q = sesion.createQuery("SELECT COUNT(u) from Usuario as u WHERE u.Nombre = :usu AND u.Passwd = :passwd");
            q.setParameter("usu", usuario);
            q.setParameter("passwd", pass);
            listadoResultados = q.list();
            valor = Integer.parseInt(String.valueOf(listadoResultados.get(0)));

        } catch (HibernateException e) {
            this.handleExcepcion(e);
        } finally {

            endTransaction();
        }

        return valor == 1;

    }

    /**
     *
     * @param dni Dni el cual se va a verificar su existencia
     * @return Boleano que indicara la existencia del correo pasado por
     * parametro  <strong>true</strong>=Existe <strong>false</strong>= NO Existe
     */
    @Override
    public boolean ExistenciaDNI(String dni) {

        List<Object> listadoResultados = null;
        Query q = null;
        int valor = 0;
        try {
            startTransaction();

            q = sesion.createQuery("SELECT COUNT(u.dni) from Usuario as u WHERE u.dni= :dni");
            q.setParameter("dni", dni);
            listadoResultados = q.list();
            valor = Integer.parseInt(String.valueOf(listadoResultados.get(0)));

        } catch (HibernateException e) {
            this.handleExcepcion(e);
        } finally {

            endTransaction();
        }

        return valor != 0;

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
