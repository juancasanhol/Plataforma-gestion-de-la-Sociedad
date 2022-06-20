$( document ).ready(function() {
    

    $("#prueba1B").click(function (){
        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "prueba1",
                dato:"1" // aqui se pasan los datos que se quiera en forma de string o int 
            },
            success: function(respuesta) {
                console.log("buena");
                 $("#prueba1Id").val(respuesta.id)
                 $("#prueba1Nombre").val(respuesta.nombre)
            },
            error: function() {
                console.log("mala");
            }

        });
    });
    $("#prueba2B").click(function (){
        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "prueba2",
                 // aqui se pasan los datos que se quiera en forma de string o int 
            },
            success: function(respuesta) {
                console.log("buena");
            $.each(respuesta, function(i, option) {
                //console.log("buena");
                    $("#Prueba2").append('<br>');
                    $("#Prueba2").append('<label>vuelta ' +i+ ' Id: </label><input type="text" value="'+option.id+'"><br>');
                    $("#Prueba2").append('<label>vuelta ' +i+ ' Nombre: </label><input type="text" value="'+option.nombre+'"><br>');
                    $("#Prueba2").append('<br>');
                });
           
            },
            error: function() {
                console.log("mala");
            }

        });
    });
    
    /////////////////////////PARA DESPLEGABLES///////////////////////////////////
    $("#TipoDoc").click(function (){
        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "Usuario",
            },
            success: function(respuesta) {
                console.log("Desplegables cargados correctamente");
            $.each(respuesta, function(i, option) {
                //console.log("buena");
                    $("#DesplegableTipoDoc").append('<option value="'+option.nombre+'">');
                    console.log(option.nombre);
                });
           
            },
            error: function() {
                console.log("ERROR CARGANDO DESPLEGABLES");
            }

        });
    });
    /////////////////////////PARA DESPLEGABLES///////////////////////////////////
//<label>Prueba 1 Nombre: </label><input type="text" name="" id="prueba1Nombre">
});