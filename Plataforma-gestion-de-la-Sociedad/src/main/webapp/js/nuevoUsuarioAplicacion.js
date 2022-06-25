$(document).ready(function () {
   
    $("#addUA").click(function (){


        if($("#Passwd").val()==$("#Passwd2").val()){

            $.ajax({
                type: "post",
                url: "../../Ajax",
                data: {
                    accion: "addPerfil",
                    usuario: $("#Nombre").val(),
                    passwd: $("#Passwd").val()
                },
                success: function (respuesta) {
                    location.href ='../MenuPrincipal/Menu.html';
                },
                error: function () {
                    console.log("ERROR!! error al comprobar el aceso");
                }
            });

        }
       

    });
    
});