$(document).ready(function () {
   
    $("#addUA").click(function (){


        if($("#Passwd").val()==$("#Passwd2").val()){

            if ($('#profCheck').is(':checked')){
                profe=1;
            }else{
                profe=0;
            }
        
            $.ajax({
                type: "post",
                url: "Ajax",
                data: {
                    accion: "addPerfil",
                    usuario: $("#usuario").val(),
                    passwd: $("#passwd").val(),
                    prof: profe
                },
                success: function (respuesta) {
        
                    if(respuesta.aceso){
                        location.href ='html/MenuPrincipal/Menu.html';
                    }else{
                        
                    }
                  
                },
                error: function () {
                    console.log("ERROR!! error al comprobar el aceso");
                }
            });

        }
       

    });
    
});