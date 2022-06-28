$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerUsuarios",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#ListaUsuarios").append('<tr><td>Numero de identificación: ' + option.id + '</td>&nbsp;&nbsp;&nbsp;<td>Nombre: ' + option.nombre+ '</td>&nbsp;&nbsp;&nbsp;<td>Apellidos: ' + option.apellidos +'</td></tr>');
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});