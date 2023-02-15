$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosBancoAlimentos",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Titular").append(respuesta.titular);
            $("#Mes").append(respuesta.mes);
            if (respuesta.asiste === true) {
                $("#Asiste").append('Sí');
            }else{
                $("#Asiste").append('No');
            }
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE ALUMNOS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerObservacionesBancoAlimentos",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
                
                if(option.nombreAli!==undefined){$("#tbodyalimentos").append('<tr><td>'+option.nombreAli+'</td><td>'+option.unidadesAli+'</td></tr>');}

            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});