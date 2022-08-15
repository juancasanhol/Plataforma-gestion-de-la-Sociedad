$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosConferencia",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Nombre").append(respuesta.nombre);
            $("#Apellidos").append(respuesta.apellidos);
            $("#NumExtId").append(respuesta.numextid);
            $("#FechaNac").append(respuesta.fechanac);
            $("#Provincia").append(respuesta.provincia);
            $("#Cuota").append(respuesta.cuota);
            $("#Usuario").append(respuesta.usuario);
            $("#FechaAlta").append(respuesta.fechaalta);
            $("#Direccion").append(respuesta.direccion);
            $("#Telefono").append(respuesta.telefono);
            $("#Password").append(respuesta.password);
            $("#Nif").append(respuesta.nif);
            $("#CodigoPostal").append(respuesta.codigopostal);
            $("#Mail").append(respuesta.mail);
            $("#Actividad").append(respuesta.actividad);
            $("#Cargo").append(respuesta.cargo);
            $("#Sexo").append(respuesta.sexo);
            $("#Poblacion").append(respuesta.poblacion);
            $("#CuentaBancaria").append(respuesta.cuentabancaria);
            $("#TiempoDedicacion").append(respuesta.tiempodedicacion);
            $("#Categoria").append(respuesta.categoria);
            if (respuesta.permisoacceso === true) {
                $("#PermisoAcceso").append('Sí');
            }else{
                $("#PermisoAcceso").append('No');
            }
            if (respuesta.accesofichaindividual === true) {
                $("#AccesoFichaIndividual").append('Sí');
            }else{
                $("#AccesoFichaIndividual").append('No');
            }
            
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE FICHEROS, OBSERVACIONES, APORTACIONES, PERFILES DE USUARIO Y CATEGORIAS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});


$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerObservacionesConferencia",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});