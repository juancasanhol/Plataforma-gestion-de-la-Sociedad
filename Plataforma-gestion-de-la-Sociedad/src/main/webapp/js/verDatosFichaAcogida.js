$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosFichaAcogida",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Fecha").append(respuesta.fecha);
            $("#AyudaGeneral").append(respuesta.ayudageneral);
            $("#AyudaRecibos").append(respuesta.ayudarecibos);
            $("#AyudaSanitaria").append(respuesta.ayudasanitaria);
            $("#AyudaOtra").append(respuesta.ayudaotra);
            $("#EstadoResolucion").append(respuesta.estadoresolucion);
            $("#Trabajador").append(respuesta.trabajador);
            $("#Usuario").append(respuesta.usuario);
            $("#ProcedenciaDerivacion").append(respuesta.procedenciaderivacion);;
            //CONTINUAR AQUI CON LA INFO DE LAS LISTAS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});