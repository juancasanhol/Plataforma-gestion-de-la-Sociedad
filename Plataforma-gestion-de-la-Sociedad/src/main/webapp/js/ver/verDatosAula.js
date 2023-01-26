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
    
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerAlumnosAula",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.alumno!==undefined){$("#Alumnos").append(option.alumno.replace("_"," ")+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});