$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "DatosLaborales",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                //if(option.tipocarnetconducir!==undefined){$("#DesplegablesTipoCarnetConducir").append('<option value="' + option.tipocarnetconducir + '">');}
                if(option.situacionlaboral!==undefined){$("#DesplegablesSituacionLaboral").append('<option value="' + option.situacionlaboral + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});