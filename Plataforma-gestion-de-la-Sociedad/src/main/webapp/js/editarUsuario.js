$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosUsuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
                //console.log("buena");
                $("#Nombre").val(respuesta.nombre);
                $("#Apellidos").val(respuesta.apellidos);
                $("#FechaAlta").val(respuesta.fechaalta);
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});