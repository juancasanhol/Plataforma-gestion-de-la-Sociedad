$( document ).ready(function() {
    

    $("#logueo").click(function (){
        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "logueo",
                dni: $("#dni").val(),
                passwd: $("#passwd").val(),
            },
            success: function(respuesta) {
            console.log("entra");
            console.log(respuesta);
            if(respuesta.error== 0 ){
                $("#acesso").click();
            }else{
               
            }
            },
            error: function() {
              
            }

        });
    });

});