$(document).ready(function () {

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "usuariosProyecto",
        },
        success: function (respuesta) {
            $.each(respuesta, function (i, option) {

                $("#DesplegablesUsuario").append("<option value='" + option.id + "'>" + option.nombre + "</option>");
            });

        },
        error: function () {
            console.log("ERROR!! error al comprobar el aceso");
        }
    });

    $("#usuarioadd").change(function () {
        console.log("entra");
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "usuariosProyectoadd",
                id: $("#usuarioadd").val(),
            },
            success: function (respuesta) {
                console.log(respuesta);
                $("#tbodyProyecto option[value='" + respuesta.id + "']").remove();
                $("#tbodyProyecto").append("<tr><td>" + respuesta.nombre + "</td><td>" + respuesta.numDoc + "</td><td><input required id='fecha" + respuesta.id + "' type='date' name=''></td>/tr>");


            },
            error: function () {
                console.log("ERROR!! error al comprobar el aceso");
            }
        });


    });
    //Change about the click getting the ids not the items
    $("#addProyecto").click(function () {
        let selecteds = "";
        $("#tbodyProyecto").children(':selected').each((idx, el) => {
            // Obtenemos los atributos que necesitamos
            if (idx == 0) {
                selecteds += el.value
            } else {
                selecteds += ";" + el.value
            }

        });

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                //change names
                accion: "adddAula",
                usuarios: selecteds,
                denom: $("#Denominacion").val(),
                profe: $("#Profesor").val(),

            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });




});