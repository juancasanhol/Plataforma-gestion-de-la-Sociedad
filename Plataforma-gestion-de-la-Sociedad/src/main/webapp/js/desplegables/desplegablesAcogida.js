$(document).ready(function () {

    $("#AyudaRecibosDiv").hide();
    $("#AyudaAsistenciaSanitariaDiv").hide();
    $("#AyudaGeneralDiv").hide();
    $("#OtrasAyudasDiv").hide();

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Acogida",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                console.log(option.usuarios);
                if (option.usuarios !== undefined) {
                    $("#DesplegablesUsuario").append('<option value="' + option.idUsuario + '">' + option.usuarios + '</option>');
                }
                if (option.procedenciaderivacion !== undefined) {
                    $("#DesplegablesProcedenciaDerivacion").append('<option value="' + option.idProcedenciaderivacion + '">' + option.procedenciaderivacion + '</option>');
                }
                if (option.ayudageneral !== undefined) {
                    $("#DesplegablesAyudaGeneral").append('<option value="' + option.idAyudageneral + '">' + option.ayudageneral + '</option>');
                }
                if (option.ayudarecibos !== undefined) {
                    $("#DesplegablesAyudaRecibos").append('<option value="' + option.idAyudarecibos + '">' + option.ayudarecibos + '</option>');
                }
                if (option.ayudasanitaria !== undefined) {
                    $("#DesplegablesAyudaSanitaria").append('<option value="' + option.idAyudasanitaria + '">' + option.ayudasanitaria + '</option>');
                }
                if (option.ayudaotra !== undefined) {
                    $("#DesplegablesAyudaOtra").append('<option value="' + option.idAyudaotra + '">' + option.ayudaotra + '</option>');
                }
                if (option.estadoresolucion !== undefined) {
                    $("#DesplegablesEstadoResolucion").append('<option value="' + option.idEstadoresolucion + '">' + option.estadoresolucion + '</option>');
                }
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });

    $(document).on('change', '#ayudas', function () {

        $("#AyudaRecibosDiv").hide();
        $("#AyudaAsistenciaSanitariaDiv").hide();
        $("#AyudaGeneralDiv").hide();
        $("#OtrasAyudasDiv").hide();

        switch ($("#ayudas").val()) {
            case 'AyudaRecibos':
                $("#AyudaRecibosDiv").show();
                break;
            case 'AyudaAsistenciaSanitaria':
                $("#AyudaAsistenciaSanitariaDiv").show();
                break;
            case 'AyudaGeneral':
                $("#AyudaGeneralDiv").show();
                break;
            case 'OtrasAyudas':
                $("#OtrasAyudasDiv").show();
                break;

        }

    });

    $("#addAcogida").click(function () {
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addAcogida",
                fecha: $("#Fecha").val(),
                usuario: $("#Usuario").val(),
                pd: $("#ProcedenciaDerivacion").val(),
                ag: $("#AyudaGeneral").val(),
                ar: $("#AyudaRecibos").val(),
                aas: $("#AyudaAsistenciaSanitaria").val(),
                oa: $("#OtrasAyudas").val(),
                obs: $("#Observaciones").val(),
                er: $("#EstadoResolucion").val(),
                its: $("#TecnicoPrevencionSocial").val(),
            },
            success: function (respuesta) {


            },
            error: function () {
                console.log("mala");
            }

        });
    });

});


