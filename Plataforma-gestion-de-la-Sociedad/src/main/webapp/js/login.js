$(document).ready(function () {
   
    $("#login").click(function (){

        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "login",
                usuario: $("#usuario").val(),
                passwd: $("#passwd").val()
            },
            success: function (respuesta) {
                location.href ='html/MenuPrincipal/Menu.html';
            },
            error: function () {
                console.log("ERROR!! error al comprobar el aceso");
            }
        });

    });
    
});