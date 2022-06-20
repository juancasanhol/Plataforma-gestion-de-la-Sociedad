$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "Ajax",
        data: {
            accion: "Usuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#DesplegablesTipoDoc").append('<option value="' + option.nombre + '">');
                console.log(option.nombre);
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});