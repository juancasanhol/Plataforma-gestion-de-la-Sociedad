$(document).ready(function () {
   

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "DatosEstadisticos",
        },
        success: function (respuesta) {

            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#tBodyEstadistico").append("<tr><td>"+option.value+"</td><td></td></tr>");
            });

          
        },
        error: function () {
            console.log("ERROR!! error al comprobar el aceso");
        }
    });



    
});