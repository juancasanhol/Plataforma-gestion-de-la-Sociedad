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
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "usuariosProyectoadd",
                id: $("#usuarioadd").val(),
            },
            success: function (respuesta) {
                $("#tbodyProyecto option[value='" + respuesta.id + "']").remove();
                $("#tbodyProyecto").append("<tr class='fila' id ="+respuesta.id+"><td id=nom"+respuesta.id+">" + respuesta.nombre + "</td><td id=doc"+respuesta.id+">" + respuesta.numDoc + "</td><td><input required id='fecha" + respuesta.id + "' type='date' name=''></td>/tr>");


            },
            error: function () {
                console.log("ERROR!! error al comprobar el aceso");
            }
        });


    });
    
    
    //Change about the click getting the ids not the items
    $("#addProyecto").click(function () {
        let ids = "";
        let fechas=""
        let doc="";
                $("#tbodyProyecto").children().each((idx, el) => {
                    // Obtenemos los atributos que necesitamos
                    if (el.getAttribute('id') != null){
                    id=el.getAttribute('id');
                    fechas+=$("#fecha"+id).val();
                    fechas+=";";
                    doc+=$("#doc"+id).text()+";";
                    ids+=id+";";
                    }
                });

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addProyecto",
                nombre: $("#NombrePrograma").val(),
                actualizacion: $("#Actualizacion").val(),
                ids: ids,
                fechas: fechas,

            },
            success: function (respuesta) {
                window.location.reload();
            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });




});