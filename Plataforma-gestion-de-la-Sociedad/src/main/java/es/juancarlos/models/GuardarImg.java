package es.juancarlos.models;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Juan Carlos
 */
public class GuardarImg {
    
    /**
     *Clase con  el metodo encargado de nombrar y guardar la imagenes de los equipos 
     * 
     * @param request request de la aplicacion
     * @param savePath ruta donde se guardará
     * @param escribir si se va a gusardar o no
     * @return nombre y extension de la foto  
     * @throws ServletException si un error especifico de servlet ocurriera
     * @throws IOException si un error de I/O ocurriera
     */
    public static String GuardarImagen(HttpServletRequest request, String savePath, boolean escribir) throws IOException, ServletException {

        //Obtiene el archivo desde la petición
        Part file = request.getPart("imagen");
        String fileName = file.getSubmittedFileName();

        //extrae la extension y el nombre de archivo por separado
        int dot = fileName.lastIndexOf(".");
        String fileNameExt = fileName.substring(dot);
        
        //se asigna el numerode serie como nombre de la imagen para mayor facilidad a la hora de buscarla
        String nombre=request.getParameter("idUsuario");
        
        if(escribir){                
        file.write(savePath+File.separator+nombre+fileNameExt);
        }
        return nombre+fileNameExt;
    }
    
}
