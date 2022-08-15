$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Alumnos",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.empresapracticas!==undefined){$("#DesplegablesEmpresaPracticas").append('<option value="' + option.empresapracticas + '">');}
                if(option.personas!==undefined){$("#DesplegablesPersona").append('<option value="' + option.personas + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});