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
            $("#Nombre").val(respuesta.nombre);
            $("#Apellidos").val(respuesta.apellidos);
            $("#FechaAlta").val(respuesta.fechaalta);
            $("#FechaBaja").val(respuesta.fechabaja);
            $("#TipoDoc").val(respuesta.tipodoc);
            $("#NumDoc").val(respuesta.numdoc);
            $("#Telefono").val(respuesta.telefono);
            $("#Correo").val(respuesta.correo);
            $("#PersonaReferencia").val(respuesta.personareferencia);
            $("#Sexo").val(respuesta.sexo);
            $("#FechaNac").val(respuesta.fechanac);
            $("#PaisOrigen").val(respuesta.paisorigen);
            $("#Nacionalidad").val(respuesta.nacionalidad);
            console.log(respuesta.perteneceminoria)
            if (respuesta.perteneceminoria === true) {
                $("#PerteneceMinoria").val('Sí');
            }else{
                $("#PerteneceMinoria").val('No');
            }
            $("#Minoria").val(respuesta.minoria);
            if (respuesta.solicitaayudafarmaceutica === true) {
                $("#SolicitaAyudaFarmaceutica").val('Sí');
            }else{
                $("#SolicitaAyudaFarmaceutica").val('No');
            }
            $("#TratSanitario").val(respuesta.tratsanitario);
            if (respuesta.drogodependencia === true) {
                $("#Drogodependencia").val('Sí');
            }else{
                $("#Drogodependencia").val('No');
            }
            $("#TipoDiscapacidad").val(respuesta.tipodiscapacidad);
            $("#GradoDiscapacidad").val(respuesta.gradodiscapacidad);
            if (respuesta.permisoresidencia === true) {
                $("#PermisoResidencia").val('Sí');
            }else{
                $("#PermisoResidencia").val('No');
            }
            if (respuesta.permisotrabajo === true) {
                $("#PermisoTrabajo").val('Sí');
            }else{
                $("#PermisoTrabajo").val('No');
            }
            if (respuesta.carnetconducir === true) {
                $("#CarnetConducir").val('Sí');
            }else{
                $("#CarnetConducir").val('No');
            }
            $("#TipoCarnetConducir").val(respuesta.tipocarnetconducir);
            $("#SituacionLaboral").val(respuesta.situacionlaboral);
            $("#UltTrabajo").val(respuesta.ulttrabajo);
            $("#PrefLaboral").val(respuesta.preflaboral);
            $("#NivelEstudios").val(respuesta.nivelestudios);
            $("#FormacionComp").val(respuesta.formacioncomp);
            if (respuesta.estaestudiando === true) {
                $("#EstaEstudiando").val('Sí');
            }else{
                $("#EstaEstudiando").val('No');
            }
            if (respuesta.fracasoescolar === true) {
                $("#FracasoEscolar").val('Sí');
            }else{
                $("#FracasoEscolar").val('No');
            }
            $("#CentroEst").val(respuesta.centroest);
            $("#Importe").val(respuesta.importe);
            $("#OrigenIngresos").val(respuesta.origeningresos);
            $("#Denominacion").val(respuesta.denominacion);
            $("#Direccion").val(respuesta.direccion);
            $("#Localidad").val(respuesta.localidad);
            if (respuesta.familiamonoparental === true) {
                $("#FamiliaMonoparental").val('Sí');
            }else{
                $("#FamiliaMonoparental").val('No');
            }
            if (respuesta.sinhogar === true) {
                $("#SinHogar").val('Sí');
            }else{
                $("#SinHogar").val('No');
            }
            $("#CosteVivienda").val(respuesta.costevivienda);
            $("#MotivoCoste").val(respuesta.motivocoste);
            if (respuesta.estabanco === true) {
                $("#EstaBanco").val('Sí');
            }else{
                $("#EstaBanco").val('No');
            }
            $("#FechaAlta_BancoAlimentos").val(respuesta.fechaalta_bancoalimentos);
            $("#FechaBaja_BancoAlimentos").val(respuesta.fechabaja_bancoalimentos);
            $("#FechaOrientacion").val(respuesta.fechaorientacion);
            $("#Beneficiario").val(respuesta.beneficiario);
            $("#TipoCarnetConducir").val(respuesta.tipocarnetconducir);

            $.each(respuesta.ingresos, function (i, option) {
                $("#tbodyIng").append("<tr><td  scope='row'><input disabled type='number' name='' id='importeIng" + i + "' min='0' value="+option.importe+"></td><td><input disabled type='text' name='' id='procedenciaIng" + i + "' value="+option.concepto+"></td></tr>");
            });

            $.each(respuesta.unidadConvivencia, function (i, option) {
                if(option.ayudaHijo){

                    if(option.parentezco=="Hijos"){
                        $('#tbodyUC').append("<tr id='row" + i + "'><td scope='row'><input disabled type='text' name='' id='nomUC" + i + "' value="+option.nombre+"></td><td ><input disabled type='text' name='' id='parenUC" + i + "' value="+option.parentezco+" class='parent'></td><td><input disabled type='date' name='' id='fechaUC" + i + "' min='0' value="+option.fechaNacimiento+"></td><td><input disabled type='text' name='' id='profesUC" + i + "' value="+option.profesion+"></td><td id='tdAyudaHijo" + i + "'><input disabled type='checkbox' id='ayudaHijo" + i + "' checked></td></tr>");

                    }else{
                        $('#tbodyUC').append("<tr id='row" + i + "'><td scope='row'><input disabled type='text' name='' id='nomUC" + i + "' value="+option.nombre+"></td><td ><input disabled type='text' name='' id='parenUC" + i + "' value="+option.parentezco+" class='parent'></td><td><input disabled type='date' name='' id='fechaUC" + i + "' min='0' value="+option.fechaNacimiento+"></td><td><input disabled type='text' name='' id='profesUC" + i + "' value="+option.profesion+"></td><td id='tdAyudaHijo" + i + "'hidden><input disabled type='checkbox' id='ayudaHijo" + i + "' checked></td></tr>");

                    }

                }else{
                    if(option.parentezco=="Hijos"){
                        $('#tbodyUC').append("<tr id='row" + i + "'><td scope='row'><input disabled type='text' name='' id='nomUC" + i + "' value="+option.nombre+"></td><td ><input disabled type='text' name='' id='parenUC" + i + "' value="+option.parentezco+" class='parent'></td><td><input disabled type='date' name='' id='fechaUC" + i + "' min='0' value="+option.fechaNacimiento+"></td><td><input disabled type='text' name='' id='profesUC" + i + "' value="+option.profesion+"></td><td id='tdAyudaHijo" + i + "'><input disabled type='checkbox' id='ayudaHijo" + i + "' ></td></tr>");
                    }else{
                        $('#tbodyUC').append("<tr id='row" + i + "'><td scope='row'><input disabled type='text' name='' id='nomUC" + i + "' value="+option.nombre+"></td><td ><input disabled type='text' name='' id='parenUC" + i + "' value="+option.parentezco+" class='parent'></td><td><input disabled type='date' name='' id='fechaUC" + i + "' min='0' value="+option.fechaNacimiento+"></td><td><input disabled type='text' name='' id='profesUC" + i + "' value="+option.profesion+"></td><td id='tdAyudaHijo" + i + "'hidden><input disabled type='checkbox' id='ayudaHijo" + i + "' ></td></tr>");
                    }


                }

            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });

   /* $.ajax({
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
                if(option.textoobs!==undefined){$("#Observaciones").val('Observación: '+option.textoobs+' | Fecha: '+option.fechaobs+' | Autor de observación: '+option.autorobs+'<br>');}
                if(option.textoobssanitarias!==undefined){$("#ObservacionesSanitarias").val('Observación: '+option.textoobssanitarias+' | Fecha: '+option.fechaobssanitarias+' | Autor de observación: '+option.autorobssanitarias+'<br>');}
                if(option.textoobslaborales!==undefined){$("#ObservacionesLaborales").val('Observación: '+option.textoobslaborales+' | Fecha: '+option.fechaobslaborales+' | Autor de observación: '+option.autorobslaborales+'<br>');}
                if(option.textoobsformacion!==undefined){$("#ObservacionesFormacion").val('Observación: '+option.textoobsformacion+' | Fecha: '+option.fechaobsformacion+' | Autor de observación: '+option.autorobsformacion+'<br>');}
                if(option.textoobsingresos!==undefined){$("#ObservacionesIngresos").val('Observación: '+option.textoobsingresos+' | Fecha: '+option.fechaobsingresos+' | Autor de observación: '+option.autorobsingresos+'<br>');}
                if(option.textoobsconvivencia!==undefined){$("#ObservacionesConvivencia").val('Observación: '+option.textoobsconvivencia+' | Fecha: '+option.fechaobsconvivencia+' | Autor de observación: '+option.autorobsconvivencia+'<br>');}
                if(option.textoobsorientacion!==undefined){$("#ObservacionesOrientacion").val('Observación: '+option.textoobsorientacion+' | Fecha: '+option.fechaobsorientacion+' | Autor de observación: '+option.autorobsorientacion+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
*/
/*
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
                if(option.bolsatrabajo!==undefined){$("#BolsaTrabajo").val(option.bolsatrabajo+'<br>');}
            });
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });*/
});