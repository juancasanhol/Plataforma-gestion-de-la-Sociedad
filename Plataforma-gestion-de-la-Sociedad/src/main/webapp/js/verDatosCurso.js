$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosCurso",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#NombreCurso").append(respuesta.nombrecurso);
            $("#TipoCurso").append(respuesta.tipocurso);
            $("#FechaInicio").append(respuesta.fechainicio);
            $("#FechaFin").append(respuesta.fechafin);
            $("#OtraInfo").append(respuesta.otrainfo);;
            //CONTINUAR AQUI CON LA INFO DE LAS LISTAS
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});