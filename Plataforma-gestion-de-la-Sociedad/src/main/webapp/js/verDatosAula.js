$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosAula",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Denominacion").append(respuesta.denominacion);
            $("#Profesor").append(respuesta.profesor);
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE ALUMNOS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});