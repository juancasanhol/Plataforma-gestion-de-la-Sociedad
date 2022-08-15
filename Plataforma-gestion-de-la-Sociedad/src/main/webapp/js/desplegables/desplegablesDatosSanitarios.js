$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "DatosSanitarios",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.tipodiscapacidad!==undefined){$("#DesplegablesTipoDiscapacidad").append('<option value="' + option.tipodiscapacidad + '">');}
                if(option.gradodiscapacidad!==undefined){$("#DesplegablesGradoDiscapacidad").append('<option value="' + option.gradodiscapacidad + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});