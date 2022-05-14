package es.juancarlos.dao;



import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.persistencia.HibernateUtil;
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * 
 * @author Juan Carlos Sánchez Holguín
 * @param <T> 
 */
public class GenericoDAO<T> implements IGenericoDAO<T> {
    
    private Session sesion;
    
    private void startTransaction(){
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.getTransaction().begin();
    }
    
    private void endTransaction(){
        if (sesion.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            sesion.getTransaction().commit();
        }
        sesion.close();
    }
    
    private void handleExcepcion(HibernateException he) throws HibernateException {
        if (sesion.getTransaction().isActive()) {
            sesion.getTransaction().rollback();
        }
        throw he;
    } 

    /**
     *
     * @param objeto Objeto que se quiere persistir 
     */
    @Override
    public void insertOrUpdate(T objeto) {
        try {
            startTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.flush();
            
        } catch (HibernateException he){
            handleExcepcion(he);
        } finally {
            endTransaction();
        }
    }

    /**
     *
     * @param <T>
     * @param claseEntidad Clase de la que se quiere hacer la consulta
     * @return  Lista de array de objetos con los datos
     */
    @Override
    public <T> List<T> get(Class<T> claseEntidad) {
        List<T> listadoResultados = null;
        try {
            startTransaction();
            listadoResultados = sesion.createQuery(" from " + claseEntidad.getSimpleName()).list();
        } catch(HibernateException he){
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        return listadoResultados;
    }

    /**
     *
     * @param <T> 
     * @param pk Identificador o PK de la clase que se quiere obtener los datos 
     * @param claseEntidad Clase de la que se quiere hacer la consulta
     * @return Lista de array de objetos con los datos
     */
    @Override
    public <T> T getById(Serializable pk, Class<T> claseEntidad) {
        T objetoRecuperado = null;
        
        try {
            startTransaction();
            objetoRecuperado = sesion.get(claseEntidad, pk);
        } catch(HibernateException he){
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
        
        return objetoRecuperado;
    }

    /**
     *
     * @param objeto Objeto que se quiere realizar un borrado
     */
    @Override
    public void delete(T objeto) {
        try {
            startTransaction();
            sesion.delete(objeto);
        } catch(HibernateException he){
            this.handleExcepcion(he);
        } finally {
            this.endTransaction();
        }
    }
    
 }
