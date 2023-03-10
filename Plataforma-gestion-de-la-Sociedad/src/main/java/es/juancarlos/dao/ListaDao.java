/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.juancarlos.dao;

import es.juancarlos.beans.Alimentos;
import es.juancarlos.beans.Usuario;
import es.juancarlos.interfaces.IAjaxDAO;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.interfaces.IListaDao;
import es.juancarlos.persistencia.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 *
 * @author Pablo
 */
public class ListaDao implements IListaDao {
    
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

    

    @Override
    public List OrderList() {
        List<Alimentos> listadoAlimentos = null;
        Query q = null;
        try {
            startTransaction();
            q = sesion.createQuery("SELECT d.Nombre FROM Desplegables AS d");
            //q.setParameter("cadena", "Alimento");
            listadoAlimentos = q.list();

        } catch (HibernateException e) {
            this.handleExcepcion(e);
        } finally {
            endTransaction();
        }

        return listadoAlimentos;
    }
    @Override
    public List<Usuario> ListadoXBanco_Fega(Boolean banco, boolean fega){
         List<Usuario> listadoUsuarios = null;
        Query q = null;
        try {
            startTransaction();
            q = sesion.createQuery("SELECT u FROM Usuario AS u where u.EstaBanco = :banco and u.EstaFEGA = :fega");
            q.setParameter("banco", banco );
            q.setParameter("fega", fega);
            listadoUsuarios = q.list();

        } catch (HibernateException e) {
            this.handleExcepcion(e);
        } finally {
            endTransaction();
        }

        
          return listadoUsuarios;
     }
}
