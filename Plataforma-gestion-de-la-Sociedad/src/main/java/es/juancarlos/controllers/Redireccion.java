package es.juancarlos.controllers;

import es.juancarlos.daofactory.DAOFactory;
import es.juancarlos.interfaces.IGenericoDAO;
import es.juancarlos.models.Impresiones;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;

/**
 *
 * @author Juan Carlos Sánchez Holguín
 */
@WebServlet(name = "Redireccion", urlPatterns = {"/Redireccion"})
public class Redireccion extends HttpServlet {

    /**
     * Procesa solicitudes para ambos HTTP <code>GET</code> y <code>POST</code>
     * métodos.
     *
     * Servlet usado para las diferentes redireciones de la aplicación de una
     * página html a otra
     *
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException Si ocurre un error específico del Servlet
     * @throws IOException Si ocurre un error de I/O
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //log("ID  " + request.getParameter("id"));
        if (request.getParameter("id") != null) {
            request.getSession().setAttribute("id", request.getParameter("id"));
        }
        String url = "";
        Impresiones generatePDFFileIText;
        File carpeta;
        //DAOFactory daof = DAOFactory.getDAOFactory();
        //IGenericoDAO gdao = daof.getGenericoDAO();
        if (request.getParameter("accion") != null) {
            switch (request.getParameter("accion")) {
                case "verusuario":
                    url = "./html/usuario/EditarUsuario.html";
                    break;
                case "vercursoformacion":
                    url = "./html/visualizaciones/VerCurso.html";
                    //log("ID CURSO  "+request.getSession().getAttribute("id"));
                    break;
                case "verempresa":
                    url = "./html/visualizaciones/VerEmpresa.html";
                    break;
                case "verfichaacogida":
                    url = "./html/visualizaciones/VerFichaAcogida.html";
                    break;
                case "veraulamagica":
                    url = "./html/visualizaciones/VerAula.html";
                    break;
                case "verfichaatencionsocialigualdad":
                    url = "./html/visualizaciones/VerFichaAtencionSocialIgualdad.html";
                    break;
                case "verconferencia":
                    url = "./html/visualizaciones/VerConferencia.html";
                    break;
                case "veralumnos":
                    url = "./html/visualizaciones/VerAlumno.html";
                    break;
                case "verbancos":
                    url = "./html/visualizaciones/VerBancoAlimentos.html";
                    break;
                case "observacioncurso":
                    url = "./html/observaciones/ObservacionesCursosFormacion.html";
                    break;
                case "observacionacogida":
                    url = "./html/observaciones/ObservacionesAcogida.html";
                    break;
                case "atencionsocialigualdad":
                    url = "./html/observaciones/ObservacionesAtencionSocialIgualdad.html";
                    break;
                case "conferencia":
                    url = "./html/observaciones/ObservacionesConferencia.html";
                    break;
                case "alumnos":
                    url = "./html/observaciones/ObservacionesAlumnos.html";
                    break;
                case "banco":
                    url = "./html/observaciones/ObservacionesBanco.html";
                    break;

                case "imp":
                    generatePDFFileIText = new Impresiones();

                    carpeta = new File(this.getClass().getClassLoader().getResource("").getPath() + "../../PDF");
                    if (!carpeta.exists()) {
                        carpeta.mkdir();
                    }
                    generatePDFFileIText.TablaBancoAlimentos(new File(carpeta + "/BancoAlimento_prueba" + ".pdf"));

                    url = "./html/MenuPrincipal/Menu.html";
                    break;

                case "imp2":
                    generatePDFFileIText = new Impresiones();

                    carpeta = new File(this.getClass().getClassLoader().getResource("").getPath() + "../../PDF");
                    if (!carpeta.exists()) {
                        carpeta.mkdir();
                    }
                    generatePDFFileIText.AyudaMenores(new File(carpeta + "/PRUEBA_" + "prueba" + ".pdf"));

                    url = "./html/MenuPrincipal/Menu.html";
                    break;

                default:

                    break;
            }
            response.sendRedirect(url);
        }
        //request.getRequestDispatcher(url).forward(request, response);

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
