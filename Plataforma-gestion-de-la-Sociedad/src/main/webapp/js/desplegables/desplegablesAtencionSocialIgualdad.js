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
                if(option.usuarios!==undefined){$("#DesplegablesUsuario").append('<option value="' + option.usuarios + '">');}
                if(option.procedenciaderivacion!==undefined){$("#DesplegablesProcedenciaDerivacion").append('<option value="' + option.procedenciaderivacion + '">');}
                if(option.motivoconsulta!==undefined){$("#DesplegablesMotivoConsulta").append('<option value="' + option.motivoconsulta + '">');}
                if(option.intervencion!==undefined){$("#DesplegablesIntervencion").append('<option value="' + option.intervencion + '">');}
                if(option.estadoresolucion!==undefined){$("#DesplegablesEstadoResolucion").append('<option value="' + option.estadoresolucion + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});