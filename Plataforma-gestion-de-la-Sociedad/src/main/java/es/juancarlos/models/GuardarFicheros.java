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
public class GuardarFicheros {

    /**
     * Clase con el metodo encargado de nombrar y guardar la imagenes de los
     * equipos
     *
     * @param request request de la aplicacion
     * @param savePath ruta donde se guardará
     * @param nombreFichero
     * @param nombreGuardado
     * @return nombre y extension de la foto
     * @throws ServletException si un error especifico de servlet ocurriera
     * @throws IOException si un error de I/O ocurriera
     */
    public static String GuardarFichero(HttpServletRequest request, String savePath, String nombreFichero, String nombreGuardado) throws IOException, ServletException {
        //Obtiene el archivo desde la petición
        Part file = request.getPart(nombreFichero);
        String fileName = file.getSubmittedFileName();
        File f = new File(savePath + File.separator + nombreGuardado);
        File carpeta = new File(savePath);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        //extrae extension
        int dot = fileName.lastIndexOf(".");
        String fileNameExt = fileName.substring(dot);
        String fileNameReal = fileName.substring(0, dot);
        file.write(savePath + File.separator + nombreGuardado + "_" + fileNameReal + fileNameExt);
        return savePath + File.separator + nombreGuardado + "_" + fileNameReal + fileNameExt;
    }

}
