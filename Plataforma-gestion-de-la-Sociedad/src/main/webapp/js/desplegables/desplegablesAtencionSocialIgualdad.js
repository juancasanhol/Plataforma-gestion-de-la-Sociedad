$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "AtencionSocialIgualdad",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if (option.usuarios !== undefined) { $("#DesplegablesUsuario").append('<option value="' + option.idUsuarios + '">"' + option.usuarios + '"</option>'); }
                if (option.procedenciaderivacion !== undefined) { $("#DesplegablesProcedenciaDerivacion").append('<option value="' + option.idProcedenciaderivacion + '">' + option.procedenciaderivacion + '"</option>'); }
                if (option.motivoconsulta !== undefined) { $("#DesplegablesMotivoConsulta").append('<option value="' + option.idMotivoconsulta + '">' + option.motivoconsulta + '"</option>'); }
                if (option.intervencion !== undefined) { $("#DesplegablesIntervencion").append('<option value="' + option.idIntervencion + '">' + option.intervencion + '"</option>'); }
                if (option.estadoresolucion !== undefined) { $("#DesplegablesEstadoResolucion").append('<option value="' + option.idEstadoresolucion + '">' + option.estadoresolucion + '"</option>'); }
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });



    $("#addFicha").click(function () {

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addFicha",
                fecha: $("#Fecha").val(),
                usuario: $("#Usuario").val(),
                procedenciaDerivacion: $("#ProcedenciaDerivacion").val(),
                motivoConsulta: $("#MotivoConsulta").val(),
                intervencion: $("#Intervencion").val(),
                estadoResolucion: $("#EstadoResolucion").val(),
                Observaciones:$("#Observaciones").val(),
            },
            success: function (respuesta) {


            },
            error: function () {
                console.log("ERROR!! error al comprobar el aceso");
            }
        });


    });

});