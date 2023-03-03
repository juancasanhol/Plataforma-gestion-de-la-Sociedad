$(document).ready(function () {

    $("#addUser").click(function () {
        //ENTRA EN EL CLICK DEL BOTON

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addUser",
                nombre: $("nombre").val(),
                tipoDoc: $("TipoDoc").val(),
                personaReferencia: $("personaReferencia").val(),
                nacionalidad: $("nacionalidad").val(),
                nivelEstudios: $("NivelEstudios").val(),
                centroEst: $("CentroEst").val(),
                formacionComp: $("FormacionComp").val(),
                denominacion: $("Denominacion").val(),
                direccion: $("Direccion").val(),
                costevivienda:$("CosteVivienda").val(),
                localidad: $("Localidad").val(),
                motivoCoste:$("MotivoCoste").val(),
                observacionesConvivencia:$("ObservacionesConvivencia").val(),
                fechaAlta_BancoAlimentos : $("FechaAlta_BancoAlimentos").val(),
                fechaBaja_BancoAlimentos: $("FechaBaja_BancoAlimentos").val(),
                fechaOrientacion : $("FechaOrientacion").val(),
                beneficiario : $("Beneficiario").val(),
                
//              $("#TipoDoc").val()
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });



});