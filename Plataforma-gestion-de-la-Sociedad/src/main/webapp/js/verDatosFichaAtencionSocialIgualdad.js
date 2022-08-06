$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosFichaAtencionSocialIgualdad",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Fecha").append(respuesta.fecha);
            $("#MotivoConsulta").append(respuesta.motivoconsulta);
            $("#Intervencion").append(respuesta.intervencion);
            $("#EstadoResolucion").append(respuesta.estadoresolucion);
            $("#Trabajador").append(respuesta.trabajador);
            $("#Usuario").append(respuesta.usuario);
            $("#ProcedenciaDerivacion").append(respuesta.procedenciaderivacion);;
            //CONTINUAR AQUI CON LAS OBSERVACIONES Y LISTAS DE FICHEROS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});