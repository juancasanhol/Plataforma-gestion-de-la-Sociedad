$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosFichaAcogida",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Fecha").append(respuesta.fecha);
            $("#AyudaGeneral").append(respuesta.ayudageneral);
            $("#AyudaRecibos").append(respuesta.ayudarecibos);
            $("#AyudaSanitaria").append(respuesta.ayudasanitaria);
            $("#AyudaOtra").append(respuesta.ayudaotra);
            $("#EstadoResolucion").append(respuesta.estadoresolucion);
            $("#Trabajador").append(respuesta.trabajador);
            $("#Usuario").append(respuesta.usuario);
            $("#ProcedenciaDerivacion").append(respuesta.procedenciaderivacion);;
            //CONTINUAR AQUI CON LA INFO DE LAS LISTAS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerObservacionesFichaAcogida",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
                if(option.fichero!==undefined){$("#Ficheros").append('Ruta: '+option.fichero+' | Fecha: '+option.fecha+'<br>');}
                if(option.ag!==undefined){$("#AyudaGeneral").append(option.ag+'</br>');}
                if(option.ao!==undefined){$("#AyudaOtra").append(option.ao+'</br>');}
                if(option.as!==undefined){$("#AyudaSanitaria").append(option.as+'</br>');}
                if(option.ar!==undefined){$("#AyudaRecibos").append(option.ar+'</br>');}

            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});