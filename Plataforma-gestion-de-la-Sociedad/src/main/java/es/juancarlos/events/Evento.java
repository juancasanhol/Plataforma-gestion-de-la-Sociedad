/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.events;

import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.util.ArrayList;
import java.util.List;
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
        List<ValorDesplegable> lista = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista1 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista2 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista3 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista4 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista5 = new ArrayList<ValorDesplegable>();
        ValorDesplegable vd = new ValorDesplegable("DNI");
        lista1.add(vd);
        vd = new ValorDesplegable("Driving license");
        lista1.add(vd);
        vd = new ValorDesplegable("Tarjeta del Game");
        lista1.add(vd);
        vd = new ValorDesplegable("Maricon");
        lista2.add(vd);
        vd = new ValorDesplegable("No maricon");
        lista2.add(vd);
        vd = new ValorDesplegable("FRANCIA");
        lista3.add(vd);
        vd = new ValorDesplegable("ESPAÑA");
        lista3.add(vd);
        vd = new ValorDesplegable("ITALIA");
        lista3.add(vd);
        vd = new ValorDesplegable("ALEMANIA");
        lista3.add(vd);
        vd = new ValorDesplegable("Aleman");
        lista4.add(vd);
        vd = new ValorDesplegable("Nazi");
        lista4.add(vd);
        vd = new ValorDesplegable("Moro");
        lista4.add(vd);
        vd = new ValorDesplegable("Cojos");
        lista5.add(vd);
        vd = new ValorDesplegable("Mancos");
        lista5.add(vd);
        vd = new ValorDesplegable("Virgenes");
        lista5.add(vd);
        vd = new ValorDesplegable("Jugadores de lol");
        lista5.add(vd);
        vd = new ValorDesplegable("Maricones");
        lista5.add(vd);
        vd = new ValorDesplegable("Pichacortas");
        lista5.add(vd);
        vd = new ValorDesplegable("Gordos");
        lista5.add(vd);
        gdao.insertOrUpdate(new Usuario("Gonzalo De Guei","Puto Subnormal"));
        gdao.insertOrUpdate(new Usuario("Iker","Casillas"));
        gdao.insertOrUpdate(new Usuario("Dolores Crotal","Fuertes de Barriga"));
        gdao.insertOrUpdate(new Usuario("Manuela","Macias Pajas"));
        gdao.insertOrUpdate(new Usuario("El chimbi","Omar Ikon"));
        gdao.insertOrUpdate(new Desplegables("TipoDocumentoIdentificativo", lista1));
        gdao.insertOrUpdate(new Desplegables("Sexo", lista2));
        gdao.insertOrUpdate(new Desplegables("PaisOrigen", lista3));
        gdao.insertOrUpdate(new Desplegables("Nacionalidad", lista4));
        gdao.insertOrUpdate(new Desplegables("MinoriaEtnica", lista5));
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
        gdao.insertOrUpdate(new Desplegables("Cargo", lista));
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
