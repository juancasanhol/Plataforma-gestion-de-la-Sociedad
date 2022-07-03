$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Usuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.tipodocumento!==undefined){$("#DesplegablesTipoDoc").append('<option value="' + option.tipodocumento + '">');}
                if(option.sexo!==undefined){$("#DesplegablesSexo").append('<option value="' + option.sexo + '">');}
                if(option.paisorigen!==undefined){$("#DesplegablesPaisOrigen").append('<option value="' + option.paisorigen + '">');}
                if(option.nacionalidad!==undefined){$("#DesplegablesNacionalidad").append('<option value="' + option.nacionalidad + '">');}
                if(option.minoriaetnica!==undefined){$("#DesplegablesMinoria").append('<option value="' + option.minoriaetnica + '">');}
                if(option.usuarios!==undefined){$("#DesplegablesPersonaReferencia").append('<option value="' + option.usuarios + '">');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});