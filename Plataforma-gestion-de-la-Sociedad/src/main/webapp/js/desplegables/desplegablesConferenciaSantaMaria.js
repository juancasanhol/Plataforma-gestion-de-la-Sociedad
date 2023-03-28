$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "ConferenciaSantaMaria",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if (option.categoria !== undefined) {
                    $("#DesplegablesCategoria").append('<option value="' + option.idCategoria + '">' + option.categoria + '</option>');
                }
                if (option.actividad !== undefined) {
                    $("#DesplegablesActividad").append('<option value="' + option.idActividad + '">' + option.actividad + '</option>');
                }
                if (option.cargo !== undefined) {
                    $("#DesplegablesCargo").append('<option value="' + option.idCargo + '">' + option.cargo + '</option>');
                }
                if (option.sexo !== undefined) {
                    $("#DesplegablesSexo").append('<option value="' + option.idSexo + '">' + option.sexo + '</option>');
                }
                if (option.colectivos !== undefined) {
                    $("#DesplegablesColectivo").append('<option value="' + option.idColectivos + '">' + option.colectivos + '</option>');
                }
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});