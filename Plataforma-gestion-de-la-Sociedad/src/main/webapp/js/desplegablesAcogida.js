$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Acogida",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.usuarios!==undefined){$("#DesplegablesUsuario").append('<option value="' + option.usuarios + '">');}
                if(option.procedenciaderivacion!==undefined){$("#DesplegablesProcedenciaDerivacion").append('<option value="' + option.procedenciaderivacion + '">');}
                if(option.ayudageneral!==undefined){$("#DesplegablesAyudaGeneral").append('<option value="' + option.ayudageneral + '">');}
                if(option.ayudarecibos!==undefined){$("#DesplegablesAyudaRecibos").append('<option value="' + option.ayudarecibos + '">');}
                if(option.ayudasanitaria!==undefined){$("#DesplegablesAyudaSanitaria").append('<option value="' + option.ayudasanitaria + '">');}
                if(option.ayudaotra!==undefined){$("#DesplegablesAyudaOtra").append('<option value="' + option.ayudaotra + '">');}
                if(option.estadoresolucion!==undefined){$("#DesplegablesEstadoResolucion").append('<option value="' + option.estadoresolucion + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});