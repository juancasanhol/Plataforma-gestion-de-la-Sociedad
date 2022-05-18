/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.events;

import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Juan Carlos Sánchez Holguín
 */
public class Evento implements ServletContextListener {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
    /**
     * 
     * @param sce ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) { 
        Set<Observaciones> lista = new HashSet<Observaciones>();
        Observaciones obs = new Observaciones("LA COSA ESTA PUTA", "ANTONIO");//Cositassssssssss
        lista.add(obs);
       gdao.insertOrUpdate(new Usuario(0,"PROBANDO","PROBANDO2",new java.sql.Date(new Date().getTime()),new java.sql.Date(new Date().getTime()),lista));
    }

    /**
     *
     * @param sce ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.print("aplicacion web parada");
    }
}
