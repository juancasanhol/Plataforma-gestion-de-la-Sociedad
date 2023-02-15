$(document).ready(function(){
ListaAlimentos=""
ListaAlimentosValores=""

    $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "VerValoresDesplegables",
                nombre: "Alimento" // aqui se pasan los datos que se quiera en forma de string o int 
            },
            success: function(respuesta) {
                console.log("buena");
                $.each(respuesta,function(i,option){
                    console.log(i);
                    if (i=0){
                        ListaAlimentos+=option.valor;
                    }else{
                        ListaAlimentos+=option.valor+";";
                    }
                  
                    $("#tbodyalimentos").append("<tr><td><b>"+option.valor+"</b></td><td> </td><td><input id='"+option.valor+"' type='number' min='0'/></td></tr>");
                });
            },
            error: function() {
                console.log("mala");
            }

        });
        
    $(document).on('click', '.add', function () {
        alimetos=ListaAlimentos.split(";")
        for (e = 0;e<alimetos.length-1; e++){
            if (i=0){
                ListaAlimentosValores+=$('#'+alimetos[i]).val();
            }else{
                ListaAlimentosValores+=$('#'+alimetos[i]).val()+";";
            }
        }

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addAlimentos",
                TitularUnidad: $("#Titular").val(),
                Mes_anio: $("#Mes").val(),
                Asiste: $('#Asiste').is(':checked'),
                observaciones: $("#Observaciones").val(),
                lista_alimentos: ListaAlimentos,
                lista_alimentos_valores: ListaAlimentosValores,
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },

        });
    });   
     
});