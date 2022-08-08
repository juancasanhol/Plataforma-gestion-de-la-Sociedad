$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosBancoAlimentos",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Titular").append(respuesta.titular);
            $("#Mes").append(respuesta.mes);
            if (respuesta.asiste === true) {
                $("#Asiste").append('Sí');
            }else{
                $("#Asiste").append('No');
            }
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE ALUMNOS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});