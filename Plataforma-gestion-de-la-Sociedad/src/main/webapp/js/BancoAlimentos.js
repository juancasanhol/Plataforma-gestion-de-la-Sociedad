$(document).ready(function(){
    $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "VisualizarAlimentos",
                dato:"" // aqui se pasan los datos que se quiera en forma de string o int 
            },
            success: function(respuesta) {
                console.log("buena");
                $.each(respuesta,function(i,option){
                    $("#tbodyalimentos").append("<tr><td><b>"+option.alimento+"</b></td><td> </td><td><input type='number' min='0'/></td></tr>");
                });
            },
            error: function() {
                console.log("mala");
            }

        });
        
    $(document).on('click', '.add', function () {
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addAlimentos",
                TitularUnidad: $("#Titular").val(),
                Mes_anio: $("#Mes").val(),
                Asiste: $("#Asiste").val(),
                observaciones_id: $("#Observaciones").val(),
                lista_alimentos: $("#tbodyalimentos").val()
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },
            complete: function (xhr, status) {
                $("#valor").val("")
                MostrarValores(nombreD);
            }
        });
    });    
});