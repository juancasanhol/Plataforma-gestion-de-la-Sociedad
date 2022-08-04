/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.events;

import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.Perfil;
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
        List<ValorDesplegable> lista6 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista7 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista8 = new ArrayList<ValorDesplegable>();
        ValorDesplegable vd = new ValorDesplegable("DNI");
        lista1.add(vd);
        vd = new ValorDesplegable("Driving license");
        lista1.add(vd);
        vd = new ValorDesplegable("Tarjeta del Game");
        lista1.add(vd);
        vd = new ValorDesplegable("Homosexual");
        lista2.add(vd);
        vd = new ValorDesplegable("Heterosexual");
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
        vd = new ValorDesplegable("Musulman");
        lista4.add(vd);
        vd = new ValorDesplegable("Discapacitado (sin brazo)");
        lista5.add(vd);
        vd = new ValorDesplegable("Discapacitado (sin pierna)");
        lista5.add(vd);
        vd = new ValorDesplegable("Jugadores de lol");
        lista5.add(vd);
        vd = new ValorDesplegable("Homosexual");
        lista5.add(vd);
        vd = new ValorDesplegable("Gordos");
        lista5.add(vd);
        vd = new ValorDesplegable("Ciego");
        lista6.add(vd);
        vd = new ValorDesplegable("Discapacitado (sin pierna)");
        lista6.add(vd);
        vd = new ValorDesplegable("Discapacitado (sin brazo)");
        lista6.add(vd);
        vd = new ValorDesplegable("Poco");
        lista7.add(vd);
        vd = new ValorDesplegable("Mucho");
        lista7.add(vd);
        vd = new ValorDesplegable("Mucho");
        lista7.add(vd);
        vd = new ValorDesplegable("Demasiado");
        lista7.add(vd);
        vd = new ValorDesplegable("Parado");
        lista8.add(vd);
        vd = new ValorDesplegable("Contrato indefinido");
        lista8.add(vd);
        vd = new ValorDesplegable("Contrato temporal");
        lista8.add(vd);
        gdao.insertOrUpdate(new Usuario("Gonzalo","Potro"));
        gdao.insertOrUpdate(new Usuario("Iker","Casillas"));
        gdao.insertOrUpdate(new Usuario("Dolores","Fuertes"));
        gdao.insertOrUpdate(new Usuario("Manuela","Macias"));
        gdao.insertOrUpdate(new Usuario("Juan","Gonzalez"));
        //////////////////////////////////////////////////////////
        gdao.insertOrUpdate(new Desplegables("TipoDocumentoIdentificativo", lista1));
        gdao.insertOrUpdate(new Desplegables("Sexo", lista2));
        gdao.insertOrUpdate(new Desplegables("PaisOrigen", lista3));
        gdao.insertOrUpdate(new Desplegables("Nacionalidad", lista4));
        gdao.insertOrUpdate(new Desplegables("MinoriaEtnica", lista5));
        gdao.insertOrUpdate(new Desplegables("TipoDiscapacidad", lista6));
        gdao.insertOrUpdate(new Desplegables("GradoDiscapacidad", lista7));
        gdao.insertOrUpdate(new Desplegables("TipoCarnetConducir", lista));
        gdao.insertOrUpdate(new Desplegables("OtrosCarnets", lista));
        gdao.insertOrUpdate(new Desplegables("Profesion", lista));
        gdao.insertOrUpdate(new Desplegables("SituacionLaboral", lista8));
        gdao.insertOrUpdate(new Desplegables("BolsaTrabajo", lista));
        gdao.insertOrUpdate(new Desplegables("NivelEstudios", lista));
        gdao.insertOrUpdate(new Desplegables("OrigenIngresos", lista));
        gdao.insertOrUpdate(new Desplegables("MotivoCosteVivienda", lista));
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
        gdao.insertOrUpdate(new Desplegables("ClasesSocios", lista));
        gdao.insertOrUpdate(new Desplegables("Categoria", lista));
        gdao.insertOrUpdate(new Desplegables("Cargo", lista));
        gdao.insertOrUpdate(new Desplegables("Profesores", lista));
        
        //usuario administrador
        gdao.insertOrUpdate(new Perfil("admin","admin"));
        
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
