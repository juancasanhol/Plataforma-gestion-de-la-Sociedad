$(document).ready(function () {
   
    $("#addUA").click(function (){

        if($("#passwd").val()==$("#passwdConf").val()){

            if ($('#profCheck').is(':checked')){
                profe=1;
            }else{
                profe=0;
            }
        
            $.ajax({
                type: "post",
                url: "../../Ajax",
                data: {
                    accion: "addPerfil",
                    usuario: $("#usuario").val(),
                    passwd: $("#passwd").val(),
                    prof: profe
                },
                success: function (respuesta) {
                    $("#usuario").val("")
                    $("#passwd").val("")
                    $("#passwdConf").val("")
                   
                  
                },
                error: function () {
                    console.log("ERROR!! error al comprobar el aceso");
                }
            });

        }
       

    });
    
});