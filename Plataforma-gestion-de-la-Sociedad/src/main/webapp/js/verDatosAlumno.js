$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosAlumno",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Nombre").append(respuesta.nombre);
            $("#EmpresaPracticas").append(respuesta.empresapracticas);
            $("#FechaAlta").append(respuesta.fechaalta);
            $("#FechaBaja").append(respuesta.fechabaja);
            $("#CursoEscolar").append(respuesta.cursoescolar);
            if (respuesta.aprovechamiento === true) {
                $("#Aprovechamiento").append('Sí');
            }else{
                $("#Aprovechamiento").append('No');
            }
            if (respuesta.finaliza === true) {
                $("#Finaliza").append('Sí');
            }else{
                $("#Finaliza").append('No');
            }
            if (respuesta.promociona === true) {
                $("#Promociona").append('Sí');
            }else{
                $("#Promociona").append('No');
            }
            
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE ALUMNOS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});


$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerObservacionesAlumno",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});