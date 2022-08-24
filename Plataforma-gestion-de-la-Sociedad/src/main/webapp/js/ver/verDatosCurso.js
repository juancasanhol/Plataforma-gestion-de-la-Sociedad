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

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerObservacionesCurso",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
                if(option.alumno!==undefined){$("#Alumnos").append(option.alumno+'<br>');}
                if(option.seleccionado!==undefined){$("#Seleccionados").append(option.seleccionado+'<br>');}
                if(option.solicitante!==undefined){$("#Solicitantes").append(option.solicitante+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});