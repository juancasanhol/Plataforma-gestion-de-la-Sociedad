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
});