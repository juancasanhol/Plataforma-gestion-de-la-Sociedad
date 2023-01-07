$(document).ready(function () {

    $("#addAlumno").click(function (){

        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "verProfesores",
              
            },
            success: function (respuesta) {
    console.log("pollo");
            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });

   
    
});





