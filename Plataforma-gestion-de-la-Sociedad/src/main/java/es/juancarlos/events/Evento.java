/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.juancarlos.events;

import Enum.TipoPerfil;
import es.juancarlos.beans.Desplegables;
import es.juancarlos.beans.Perfil;
import es.juancarlos.beans.Usuario;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import java.util.ArrayList;
import java.util.Iterator;
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
    //para eliminar todos los desplegables 
        Iterator i = (Iterator) gdao.get(Desplegables.class).iterator();
        while (i.hasNext()) {

            Desplegables d = (Desplegables) i.next();
            gdao.delete(d);
        }
        //para eliminar todos los valores de los desplegables 
        i = (Iterator) gdao.get(ValorDesplegable.class).iterator();
        while (i.hasNext()) {

            ValorDesplegable v = (ValorDesplegable) i.next();
            gdao.delete(v);
        }

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
        List<ValorDesplegable> lista9 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista10 = new ArrayList<ValorDesplegable>();
        List<ValorDesplegable> lista11 = new ArrayList<ValorDesplegable>();
        
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
        lista3.add(new ValorDesplegable("ESPAÑA"));
        lista3.add(new ValorDesplegable("ITALIA"));
        lista3.add(new ValorDesplegable("BRASIL"));
        lista3.add(new ValorDesplegable("ARGENTINA"));
        lista3.add(new ValorDesplegable("COLOMBIA"));
        lista3.add(new ValorDesplegable("PERÚ"));
        lista3.add(new ValorDesplegable("CHILE"));
        lista3.add(new ValorDesplegable("ECUADOR"));
        lista3.add(new ValorDesplegable("VENEZUELA"));
        lista3.add(new ValorDesplegable("BOLIVIA"));
        lista3.add(new ValorDesplegable("URUGUAY"));
        lista3.add(new ValorDesplegable("PARAGUAY"));
        lista3.add(new ValorDesplegable("RUMANIA"));
        lista3.add(new ValorDesplegable("BULGARIA"));
        lista3.add(new ValorDesplegable("UCRANIA"));
        lista3.add(new ValorDesplegable("ESLOVENIA"));
        lista3.add(new ValorDesplegable("POLONIA"));
        lista3.add(new ValorDesplegable("GUINEA ECUATORIAL"));
        lista3.add(new ValorDesplegable("SAHARA"));
        lista3.add(new ValorDesplegable("MARRUECOS"));

        lista4.add(new ValorDesplegable("ESPAÑOLA"));
        lista4.add(new ValorDesplegable("ITALIANA"));
        lista4.add(new ValorDesplegable("BRASILEÑA"));
        lista4.add(new ValorDesplegable("ARGENTINA"));
        lista4.add(new ValorDesplegable("COLOMBIANA"));
        lista4.add(new ValorDesplegable("PERUANA"));
        lista4.add(new ValorDesplegable("CHILENA"));
        lista4.add(new ValorDesplegable("VENEZOLANA"));
        lista4.add(new ValorDesplegable("BOLIVIANA"));
        lista4.add(new ValorDesplegable("URUGUAYA"));
        lista4.add(new ValorDesplegable("PARAGUAYANA"));
        lista4.add(new ValorDesplegable("RUMANA"));
        lista4.add(new ValorDesplegable("UCRANIANA"));
        lista4.add(new ValorDesplegable("ESLOVENA"));
        lista4.add(new ValorDesplegable("POLACA"));
        lista4.add(new ValorDesplegable("ECUATOGUINEANA"));
        lista4.add(new ValorDesplegable("SAHARIANA"));
        lista4.add(new ValorDesplegable("MARROQUÍ"));

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
        vd = new ValorDesplegable("COCHE");
        lista9.add(vd);
        vd = new ValorDesplegable("MOTO");
        lista9.add(vd);
        vd = new ValorDesplegable("AVION");
        lista9.add(vd);
        vd = new ValorDesplegable("SES");
        lista10.add(vd);
        vd = new ValorDesplegable("SATSE");
        lista10.add(vd);
        vd = new ValorDesplegable("UEX");
        lista10.add(vd);
        
        lista11.add(new ValorDesplegable("FAMILIAS"));
        lista11.add(new ValorDesplegable("INFANCIA Y JUVENTUD"));
        lista11.add(new ValorDesplegable("MAYORES"));
        lista11.add(new ValorDesplegable("DROGODEPENDIENTES"));
        lista11.add(new ValorDesplegable("SIN HOGAR"));
        lista11.add(new ValorDesplegable("MUJER"));
        lista11.add(new ValorDesplegable("INMIGRANTES"));
        lista11.add(new ValorDesplegable("HOSPITALIZADAS"));
        
        gdao.insertOrUpdate(new Usuario("Gonzalo", "Potro"));
        gdao.insertOrUpdate(new Usuario("Iker", "Casillas"));
        gdao.insertOrUpdate(new Usuario("Dolores", "Fuertes"));
        gdao.insertOrUpdate(new Usuario("Manuela", "Macias"));
        gdao.insertOrUpdate(new Usuario("Juan", "Gonzalez"));
        //////////////////////////////////////////////////////////
        gdao.insertOrUpdate(new Desplegables("TipoDocumentoIdentificativo", lista1));
        gdao.insertOrUpdate(new Desplegables("Sexo", lista2));
        gdao.insertOrUpdate(new Desplegables("PaisOrigen", lista3));
        gdao.insertOrUpdate(new Desplegables("Nacionalidad", lista4));
        gdao.insertOrUpdate(new Desplegables("MinoriaEtnica", lista5));
        gdao.insertOrUpdate(new Desplegables("TipoDiscapacidad", lista6));
        gdao.insertOrUpdate(new Desplegables("GradoDiscapacidad", lista7));
        gdao.insertOrUpdate(new Desplegables("TipoCarnetConducir", lista9));
        gdao.insertOrUpdate(new Desplegables("OtrosCarnets", lista));
        gdao.insertOrUpdate(new Desplegables("Profesion", lista));
        gdao.insertOrUpdate(new Desplegables("SituacionLaboral", lista8));
        gdao.insertOrUpdate(new Desplegables("BolsaTrabajo", lista10));
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
        gdao.insertOrUpdate(new Desplegables("TiposColaboracion", lista));
        gdao.insertOrUpdate(new Desplegables("ClasesSocios", lista));
        gdao.insertOrUpdate(new Desplegables("Categoria", lista));
        gdao.insertOrUpdate(new Desplegables("Cargo", lista));
        gdao.insertOrUpdate(new Desplegables("Profesores", lista));
        gdao.insertOrUpdate(new Desplegables("Colectivos", lista11));

        //usuario administrador
        gdao.insertOrUpdate(new Perfil("admin", "admin", TipoPerfil.ADMIN));

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
