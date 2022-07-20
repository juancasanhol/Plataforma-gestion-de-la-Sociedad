package es.juancarlos.controllers;

import es.juancarlos.beans.Aportacion;
import es.juancarlos.beans.Categoria;
import es.juancarlos.beans.ConferenciaSantaMaria;
import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.Perfil;
import es.juancarlos.beans.Usuario;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.GuardarFicheros;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
@MultipartConfig
@WebServlet(name = "Conferencia", urlPatterns = {"/Conferencia"})
public class Conferencia extends HttpServlet {

    //para devolver un solo objeto
    JSONObject objeto = null;

    //para devolver uno o varios objetos (varios preferiblemente)
    JSONArray arrayJSON = null;

    /**
     * Servlet usado para consultas Ajax de las diferentes páginas
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException Si ocurre un error específico del Servlet
     * @throws IOException Si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        Observaciones observacion = new Observaciones(request.getParameter("Observaciones"), "ADMIN");
        Boolean accesoficha = false, permisoacceso = false;
        List<Observaciones> observaciones = new ArrayList<Observaciones>();
        if (request.getParameter("AccesoFichaIndividual") != null) {
            accesoficha = true;
        }
        if (request.getParameter("PermisoAcceso") != null) {
            permisoacceso = true;
        }
        observaciones.add(observacion);
        List<FicheroAdjunto> ficheros = new ArrayList<FicheroAdjunto>();
        try {
            FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", "ConferenciaSM_" + request.getParameter("Nombre") + request.getParameter("Apellidos")), false);
            ficheros.add(f);
        } catch (Exception e) {
            //No hay fichero para hacer el submit
            //He usado try catch porque para comprobar si hay fichero o no no sirve con comaprar el campo a null
        }
        float cuota;
        try {
            cuota = Float.parseFloat(request.getParameter("Cuota"));
        }catch(Exception e){
            cuota=0;
        }
        List<Categoria> categorias = new ArrayList<Categoria>();
        List<Aportacion> aportaciones = new ArrayList<Aportacion>();
        List<Perfil> perfiles = new ArrayList<Perfil>();
        //AÑADE AQUI LO QUE SEA DE LAS LISTAS DE DESPLEGABLES
        
        
        
        gdao.insertOrUpdate(new ConferenciaSantaMaria(request.getParameter("NumExtId"), request.getParameter("FechaAlta"), categorias, request.getParameter("Cargo"), request.getParameter("Nombre"), request.getParameter("Apellidos"), request.getParameter("Nif"), request.getParameter("Sexo"), request.getParameter("FechaNac"), request.getParameter("Direccion"), request.getParameter("CodigoPostal"), request.getParameter("Poblacion"), request.getParameter("Provincia"), request.getParameter("Telefono"), request.getParameter("Mail"), request.getParameter("CuentaBancaria"), cuota, aportaciones, request.getParameter("Actividad"), request.getParameter("TiempoDedicacion"), observaciones, permisoacceso, perfiles, accesoficha, request.getParameter("Usuario"), request.getParameter("Password"), ficheros));
        response.sendRedirect("./html/MenuPrincipal/Menu.html");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
