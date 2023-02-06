$(document).ready(function () {
   

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "tipos",
        },
        success: function (respuesta) {

            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#tipoUsu").append("<option value='"+option.tipo+"'>"+option.tipo+"</option>");
            });

          
        },
        error: function () {
            console.log("ERROR!! error al comprobar el aceso");
        }
    });



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
                    tipo: $("#tipoUsu").val()
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