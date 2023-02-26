$(document).ready(function () {

    $("#addUser").click(function () {
        //ENTRA EN EL CLICK DEL BOTON

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addUser",
                id:$("#addUser")
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