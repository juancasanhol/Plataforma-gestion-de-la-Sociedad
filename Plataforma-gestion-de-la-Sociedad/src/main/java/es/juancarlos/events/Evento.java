/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.events;

import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashSet;
import java.util.List;
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
        //Creacion de los desplegables en la base de datos
        List<String> lista = new ArrayList<String>();
        lista.add("PRUEBA");
        gdao.insertOrUpdate(new Desplegables(1, lista));
        /*gdao.insertOrUpdate(new Desplegables("Sexo", lista));
        gdao.insertOrUpdate(new Desplegables("PaisOrigen", lista));
        gdao.insertOrUpdate(new Desplegables("Nacionalidad", lista));
        gdao.insertOrUpdate(new Desplegables("MinoriaEtnica", lista));
        gdao.insertOrUpdate(new Desplegables("TipoDiscapacidad", lista));
        gdao.insertOrUpdate(new Desplegables("GradoDiscapacidad", lista));
        gdao.insertOrUpdate(new Desplegables("TipoCarnetConducir", lista));
        gdao.insertOrUpdate(new Desplegables("OtrosCarnets", lista));
        gdao.insertOrUpdate(new Desplegables("Profesion", lista));
        gdao.insertOrUpdate(new Desplegables("SituacionLaboral", lista));
        gdao.insertOrUpdate(new Desplegables("BolsaTrabajo", lista));
        gdao.insertOrUpdate(new Desplegables("NivelEstudios", lista));
        gdao.insertOrUpdate(new Desplegables("OrigenIngresos", lista));
        gdao.insertOrUpdate(new Desplegables("MotivoCoste", lista));
        gdao.insertOrUpdate(new Desplegables("RelacionTitular", lista));
        gdao.insertOrUpdate(new Desplegables("TipoServicio", lista));
        gdao.insertOrUpdate(new Desplegables("TipoCurso", lista));
        gdao.insertOrUpdate(new Desplegables("EmpresaPracticas", lista));
        gdao.insertOrUpdate(new Desplegables("ProcedenciaDerivacion", lista));
        gdao.insertOrUpdate(new Desplegables("MotivoConsulta", lista));
        gdao.insertOrUpdate(new Desplegables("Intervencion", lista));
        gdao.insertOrUpdate(new Desplegables("EstadoResolucion", lista));
        gdao.insertOrUpdate(new Desplegables("AyudaGeneral", lista));
        gdao.insertOrUpdate(new Desplegables("AyudaRecibos", lista));
        gdao.insertOrUpdate(new Desplegables("AyudaAsistenciaSanitaria", lista));
        gdao.insertOrUpdate(new Desplegables("OtrasAyudas", lista));
        gdao.insertOrUpdate(new Desplegables("Alimento", lista));
        gdao.insertOrUpdate(new Desplegables("Actividad", lista));
        gdao.insertOrUpdate(new Desplegables("TiposColaboracion", lista));
        gdao.insertOrUpdate(new Desplegables("Categoria", lista));
        gdao.insertOrUpdate(new Desplegables("Cargo", lista));*/
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
