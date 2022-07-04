$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "EditarUsuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //$.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#Nombre").val('ANTONIO');
           // });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});