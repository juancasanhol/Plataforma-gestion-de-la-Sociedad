package es.juancarlos.controllers;

import es.juancarlos.beans.Acogida;
import es.juancarlos.beans.Alumno;
import es.juancarlos.beans.AtencionSocialIgualdad;
import es.juancarlos.beans.BancoAlimentos;
import es.juancarlos.beans.ConferenciaSantaMaria;
import es.juancarlos.beans.CursosFormacion;
import es.juancarlos.beans.FicheroAdjunto;
import es.juancarlos.beans.Observaciones;
import es.juancarlos.beans.ValorDesplegable;
import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.GuardarFicheros;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "Observacion", urlPatterns = {"/Observacion"})
public class Observacion extends HttpServlet {

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
        int id = 0;
        String url = "./html/MenuPrincipal/Menu.html";
        if (request.getSession().getAttribute("id") != null) {
            //request.getSession().setAttribute("id", request.getParameter("id"));
            id = Integer.parseInt(request.getSession().getAttribute("id").toString());
            //DAOFactory daof = DAOFactory.getDAOFactory();
            //IGenericoDAO gdao = daof.getGenericoDAO();
            switch (request.getParameter("tipo")) {
                case "cursoformacion":
                    log("OBSERVACION CURSO FORMACION AÑADIDA");
                    url = "./html/visualizaciones/VerCursosFormacion.html";
                    CursosFormacion c = (CursosFormacion) gdao.getById(id, CursosFormacion.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacioncurso = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        c.getObservaciones_cursos_formacion().add(observacioncurso);
                    }
                    gdao.insertOrUpdate(c);
                    break;
                case "acogida":
                    log("OBSERVACION ACOGIDA AÑADIDA");
                    url = "./html/visualizaciones/VerAcogidas.html";
                    Acogida a = (Acogida) gdao.getById(id, Acogida.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacionacogida = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        a.getObservaciones_acogida().add(observacionacogida);
                    }
                    try {
                        FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", "Acogida_" + a.getUsuario()), false);
                        a.getFicheros_acogida().add(f);
                    } catch (Exception e) {
                        //No hay fichero para hacer el submit
                        //He usado try catch porque para comprobar si hay fichero o no no sirve con comparar el campo a null
                    }
                    gdao.insertOrUpdate(a);
                    break;
                case "atencionsocialigualdad":
                    log("OBSERVACION ATENCION SOCIAL IGUALDAD AÑADIDA");
                    url = "./html/visualizaciones/VerFichasAtencionSocialIgualdad.html";
                    AtencionSocialIgualdad asi = (AtencionSocialIgualdad) gdao.getById(id, AtencionSocialIgualdad.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacionatencion = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        asi.getObservaciones_atencionsocial_igualdad().add(observacionatencion);
                    }
                    try {
                        FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", "AtencionSocialIgualdad_" + asi.getUsuario()), false);
                        asi.getFicheros_atencionsocial_igualdad().add(f);
                    } catch (Exception e) {
                        //No hay fichero para hacer el submit
                        //He usado try catch porque para comprobar si hay fichero o no no sirve con comparar el campo a null
                    }
                    gdao.insertOrUpdate(asi);
                    break;
                case "conferenciasantamaria":
                    log("OBSERVACION CONFERENCIA SANTA MARIA AÑADIDA");
                    url = "./html/visualizaciones/VerConferencias.html";
                    ConferenciaSantaMaria csm = (ConferenciaSantaMaria) gdao.getById(id, ConferenciaSantaMaria.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacionconferencia = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        csm.getObservaciones_conferencia().add(observacionconferencia);
                    }
                    try {
                        FicheroAdjunto f = new FicheroAdjunto(GuardarFicheros.GuardarFichero(request, getServletContext().getRealPath(getServletContext().getInitParameter("rutaFicheros")), "Fichero", "ConferenciaSM_" + csm.getNombre() + csm.getApellidos()), false);
                        csm.getFicheros_conferenciasantamaria().add(f);
                    } catch (Exception e) {
                        //No hay fichero para hacer el submit
                        //He usado try catch porque para comprobar si hay fichero o no no sirve con comparar el campo a null
                    }
                    gdao.insertOrUpdate(csm);
                    break;
                case "bancoalimentos":
                    log("OBSERVACION BANCOALIMENTOS AÑADIDA");
                    url = "./html/visualizaciones/VerBancosAlimentos.html";
                    BancoAlimentos ba = (BancoAlimentos) gdao.getById(id, BancoAlimentos.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacionbanco = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        ba.getObservaciones_id().add(observacionbanco);
                    }
                    gdao.insertOrUpdate(ba);
                    break;
                case "alumno":
                    log("OBSERVACION ALUMNO AÑADIDA");
                    url = "./html/visualizaciones/VerAlumnos.html";
                    Alumno al = (Alumno) gdao.getById(id, Alumno.class);
                    if (!request.getParameter("Observaciones").equals("")) {
                        Observaciones observacionalumno = new Observaciones(request.getParameter("Observaciones"), request.getSession().getAttribute("autor").toString());
                        al.getObservaciones_alumno().add(observacionalumno);
                    }
                    gdao.insertOrUpdate(al);
                    break;
                default:

                    break;
            }
        }
        response.sendRedirect(url);

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
