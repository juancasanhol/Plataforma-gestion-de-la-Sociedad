$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosUsuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Nombre").append(respuesta.nombre);
            $("#Apellidos").append(respuesta.apellidos);
            $("#FechaAlta").append(respuesta.fechaalta);
            $("#FechaBaja").append(respuesta.fechabaja);
            $("#TipoDoc").append(respuesta.tipodoc);
            $("#NumDoc").append(respuesta.numdoc);
            $("#Telefono").append(respuesta.telefono);
            $("#Correo").append(respuesta.correo);
            $("#PersonaReferencia").append(respuesta.personareferencia);
            $("#Sexo").append(respuesta.sexo);
            $("#FechaNac").append(respuesta.fechanac);
            $("#PaisOrigen").append(respuesta.paisorigen);
            $("#Nacionalidad").append(respuesta.nacionalidad);
            if (respuesta.perteneceminoria === true) {
                $("#PerteneceMinoria").append('Sí');
            }else{
                $("#PerteneceMinoria").append('No');
            }
            $("#Minoria").append(respuesta.minoria);
            if (respuesta.solicitaayudafarmaceutica === true) {
                $("#SolicitaAyudaFarmaceutica").append('Sí');
            }else{
                $("#SolicitaAyudaFarmaceutica").append('No');
            }
            $("#TratSanitario").append(respuesta.tratsanitario);
            if (respuesta.drogodependencia === true) {
                $("#Drogodependencia").append('Sí');
            }else{
                $("#Drogodependencia").append('No');
            }
            $("#TipoDiscapacidad").append(respuesta.tipodiscapacidad);
            $("#GradoDiscapacidad").append(respuesta.gradodiscapacidad);
            if (respuesta.permisoresidencia === true) {
                $("#PermisoResidencia").append('Sí');
            }else{
                $("#PermisoResidencia").append('No');
            }
            if (respuesta.permisotrabajo === true) {
                $("#PermisoTrabajo").append('Sí');
            }else{
                $("#PermisoTrabajo").append('No');
            }
            if (respuesta.carnetconducir === true) {
                $("#CarnetConducir").append('Sí');
            }else{
                $("#CarnetConducir").append('No');
            }
            $("#TipoCarnetConducir").append(respuesta.tipocarnetconducir);
            $("#SituacionLaboral").append(respuesta.situacionlaboral);
            $("#UltTrabajo").append(respuesta.ulttrabajo);
            $("#PrefLaboral").append(respuesta.preflaboral);
            $("#NivelEstudios").append(respuesta.nivelestudios);
            $("#FormacionComp").append(respuesta.formacioncomp);
            if (respuesta.estaestudiando === true) {
                $("#EstaEstudiando").append('Sí');
            }else{
                $("#EstaEstudiando").append('No');
            }
            if (respuesta.fracasoescolar === true) {
                $("#FracasoEscolar").append('Sí');
            }else{
                $("#FracasoEscolar").append('No');
            }
            $("#CentroEst").append(respuesta.centroest);
            $("#Importe").append(respuesta.importe);
            $("#OrigenIngresos").append(respuesta.origeningresos);
            $("#Denominacion").append(respuesta.denominacion);
            $("#Direccion").append(respuesta.direccion);
            $("#Localidad").append(respuesta.localidad);
            if (respuesta.familiamonoparental === true) {
                $("#FamiliaMonoparental").append('Sí');
            }else{
                $("#FamiliaMonoparental").append('No');
            }
            if (respuesta.sinhogar === true) {
                $("#SinHogar").append('Sí');
            }else{
                $("#SinHogar").append('No');
            }
            $("#CosteVivienda").append(respuesta.costevivienda);
            $("#MotivoCoste").append(respuesta.motivocoste);
            if (respuesta.estabanco === true) {
                $("#EstaBanco").append('Sí');
            }else{
                $("#EstaBanco").append('No');
            }
            $("#FechaAlta_BancoAlimentos").append(respuesta.fechaalta_bancoalimentos);
            $("#FechaBaja_BancoAlimentos").append(respuesta.fechabaja_bancoalimentos);
            $("#FechaOrientacion").append(respuesta.fechaorientacion);
            $("#Beneficiario").append(respuesta.beneficiario);
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
            accion: "VerObservacionesUsuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.textoobs!==undefined){$("#Observaciones").append('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
                if(option.textoobssanitarias!==undefined){$("#ObservacionesSanitarias").append('Observación: '+option.textoobssanitarias+' | Fecha: '+option.fechaobssanitarias+' | Autor de observación: '+option.autorobssanitarias+'<br>');}
                if(option.textoobslaborales!==undefined){$("#ObservacionesLaborales").append('Observación: '+option.textoobslaborales+' | Fecha: '+option.fechaobslaborales+' | Autor de observación: '+option.autorobslaborales+'<br>');}
                if(option.textoobsformacion!==undefined){$("#ObservacionesFormacion").append('Observación: '+option.textoobsformacion+' | Fecha: '+option.fechaobsformacion+' | Autor de observación: '+option.autorobsformacion+'<br>');}
                if(option.textoobsingresos!==undefined){$("#ObservacionesIngresos").append('Observación: '+option.textoobsingresos+' | Fecha: '+option.fechaobsingresos+' | Autor de observación: '+option.autorobsingresos+'<br>');}
                if(option.textoobsconvivencia!==undefined){$("#ObservacionesConvivencia").append('Observación: '+option.textoobsconvivencia+' | Fecha: '+option.fechaobsconvivencia+' | Autor de observación: '+option.autorobsconvivencia+'<br>');}
                if(option.textoobsorientacion!==undefined){$("#ObservacionesOrientacion").append('Observación: '+option.textoobsorientacion+' | Fecha: '+option.fechaobsorientacion+' | Autor de observación: '+option.autorobsorientacion+'<br>');}
            });
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
            accion: "VerTiposCarnet",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.tipocarnet!==undefined){$("#TipoCarnetConducir").append(option.tipocarnet+'<br>');}
            });
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
            accion: "VerBolsaTrabajo",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.bolsatrabajo!==undefined){$("#BolsaTrabajo").append(option.bolsatrabajo+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});