$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosEmpresa",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Nombre").append(respuesta.nombre);
            $("#Direccion").append(respuesta.direccion);
            $("#FechaAlta").append(respuesta.fechaalta);
            $("#FechaBaja").append(respuesta.fechabaja);
            $("#CodigoPostal").append(respuesta.codigopostal);
            $("#Poblacion").append(respuesta.poblacion);
            $("#PersonaContacto").append(respuesta.personacontacto);
            $("#Provincia").append(respuesta.provincia);;
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
            accion: "VerListasEmpresa",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.actividad!==undefined){$("#Actividades").append(option.actividad+'<br>');}
                if(option.colaboracion!==undefined){$("#Colaboraciones").append(option.colaboracion+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});