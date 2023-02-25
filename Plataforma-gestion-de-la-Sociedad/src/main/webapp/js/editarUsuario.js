
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
            if (respuesta.perteneceminoria === true) {
                $("#PerteneceMinoria").prop("checked", true);
            }
            $("#Minoria").val(respuesta.minoria);
            if (respuesta.solicitaayudafarmaceutica === true) {
                $("#SolicitaAyudaFarmaceutica").prop("checked", true);
            }
            $("#TratSanitario").val(respuesta.tratsanitario);
            if (respuesta.drogodependencia === true) {
                $("#Drogodependencia").prop("checked", true);
            }
            $("#TipoDiscapacidad").val(respuesta.tipodiscapacidad);
            $("#GradoDiscapacidad").val(respuesta.gradodiscapacidad);
            if (respuesta.permisoresidencia === true) {
                $("#PermisoResidencia").prop("checked", true);
            }
            if (respuesta.permisotrabajo === true) {
                $("#PermisoTrabajo").prop("checked", true);
            }
            if (respuesta.carnetconducir === true) {
                $("#CarnetConducir").prop("checked", true);
            }
            $("#TipoCarnetConducir").val(respuesta.tipocarnetconducir);
            $("#SituacionLaboral").val(respuesta.situacionlaboral);
            $("#UltTrabajo").val(respuesta.ulttrabajo);
            $("#PrefLaboral").val(respuesta.preflaboral);
            $("#NivelEstudios").val(respuesta.nivelestudios);
            $("#FormacionComp").val(respuesta.formacioncomp);
            if (respuesta.estaestudiando === true) {
                $("#EstaEstudiando").prop("checked", true);
            }
            if (respuesta.fracasoescolar === true) {
                $("#FracasoEscolar").prop("checked", true);
            }
            $("#CentroEst").val(respuesta.centroest);
            $("#Importe").val(respuesta.importe);
            $("#OrigenIngresos").val(respuesta.origeningresos);
            $("#Denominacion").val(respuesta.denominacion);
            $("#Direccion").val(respuesta.direccion);
            $("#Localidad").val(respuesta.localidad);
            if (respuesta.familiamonoparental === true) {
                $("#FamiliaMonoparental").prop("checked", true);
            }
            if (respuesta.sinhogar === true) {
                $("#SinHogar").prop("checked", true);
            }
            $("#CosteVivienda").val(respuesta.costevivienda);
            $("#MotivoCoste").val(respuesta.motivocoste);
            if (respuesta.estabanco === true) {
                $("#EstaBanco").prop("checked", respuesta.estabanco);
            }
            $("#FechaAlta_BancoAlimentos").val(respuesta.fechaalta_bancoalimentos);
            $("#FechaBaja_BancoAlimentos").val(respuesta.fechabaja_bancoalimentos);
            $("#FechaOrientacion").val(respuesta.fechaorientacion);
            $("#Beneficiario").val(respuesta.beneficiario);
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
 
   
});
