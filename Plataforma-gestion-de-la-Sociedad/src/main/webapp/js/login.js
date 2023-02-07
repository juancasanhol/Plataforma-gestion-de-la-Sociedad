$(document).ready(function () {

    $("body").keyup(function (event){

       if(event.which==13){

        Loging();

       }

    });

    $("#login").click(function (){

        Loging();

    });
    
});

function Loging(){

    $.ajax({
        type: "post",
        url: "Ajax",
        data: {
            accion: "login",
            usuario: $("#usuario").val(),
            passwd: $("#passwd").val()
        },
        success: function (respuesta) {

            if(respuesta.aceso){
                location.href ='html/MenuPrincipal/Menu.html';
                window.sessionStorage['tipo']= respuesta.tipo
            }else{
                
            }
          
        },
        error: function () {
            console.log("ERROR!! error al comprobar el aceso");
        }
    });

}