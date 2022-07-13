$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Empresas",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.actividad!==undefined){$("#DesplegablesActividades").append('<option value="' + option.actividad + '">');}
                if(option.tiposcolaboracion!==undefined){$("#DesplegablesColaboraciones").append('<option value="' + option.tiposcolaboracion + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});