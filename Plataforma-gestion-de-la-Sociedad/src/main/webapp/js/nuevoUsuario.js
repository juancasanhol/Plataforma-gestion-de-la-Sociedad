$(document).ready(function () {

    $("#addUser").click(function () {
        //ENTRA EN EL CLICK DEL BOTON

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addUser",
                nombre: $("nombre").val(),
                tipoDoc: $("TipoDoc").val(),
                personaReferencia: $("personaReferencia").val(),
                nacionalidad: $("nacionalidad").val(),
                nombre: $("nombre").val(),
                nombre: $("nombre").val(),
                nombre: $("nombre").val(),
//                HAY QUE PILLAR LOS DATOS
            },
            success: function (respuesta) {
                
            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });



});