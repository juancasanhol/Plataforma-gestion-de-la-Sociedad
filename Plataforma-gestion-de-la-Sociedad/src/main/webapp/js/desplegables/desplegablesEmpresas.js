$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Empresas",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if (option.actividad !== undefined) { $("#tiposActividad").append('<tr><td>' + option.actividad + '</td><td><button type="button" id=' + option.idActividad + ' name=' + option.actividad + ' class="btn btn-success addActividad">añadir</button></td></tr>'); }
                if (option.tiposcolaboracion !== undefined) { $("#tiposColaboracion").append('<tr><td>' + option.tiposcolaboracion + '</td><td><button type="button" id=' + option.idTiposcolaboracion + ' name=' + option.tiposcolaboracion + ' class="btn btn-success addColaboracion">añadir</button></td></tr>'); }
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });



    //LISTA ACTIVIDADES   

    $(document).on('click', '.addActividad', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesTipoActividad").append('<option value=' + idD + ' selected>' + nombreD + '</option>');
        $("#tiposActividadDel").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + idD + ' class="btn btn-danger delActividad">eliminar</button></td></tr>');
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delActividad', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("option[value='" + idD + "']").remove();
        $("#tiposActividad").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + idD + ' class="btn btn-success addActividad">añadir</button></td></tr>');
        $(this).closest('tr').remove();
    });





    //LISTA COLABORACIONES   

    $(document).on('click', '.addColaboracion', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesTipoColaboracion").append('<option value=' + idD + ' selected>' + nombreD + '</option>');
        $("#tiposColaboracionDel").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + idD + ' class="btn btn-danger delColaboracion">eliminar</button></td></tr>');
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delColaboracion', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("option[value='" + idD + "']").remove();
        $("#tiposColaboracion").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + idD + ' class="btn btn-success addColaboracion">añadir</button></td></tr>');
        $(this).closest('tr').remove();
    });



    $(document).on('click', '#addEmpresa', function () {

        let actividades ="";
        $("#DesplegablesTipoActividad").children().each((idx, el) => {
            // Obtenemos los atributos que necesitamos
            if (idx==0){
                actividades +=el.value
            }else{
                actividades +=";"+el.value
            }
          });
          
          let colab ="";
          $("#DesplegablesTipoColaboracion").children().each((idx, el) => {
              // Obtenemos los atributos que necesitamos
              if (idx==0){
                colab +=el.value
              }else{
                colab +=";"+el.value
              }
            });

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addEmpresa",
                nombre: $("#Nombre").val(),
                fechaAlta: $("#FechaAlta").val(),
                fechaBaja: $("#FechaBaja").val(),
                personaContacto: $("#PersonaContacto").val(),
                direccion: $("#Direccion").val(),
                codigoPostal: $("#CodigoPostal").val(),
                localidad: $("#Localidad").val(),
                provincia: $("#Provincia").val(),
                actividad:actividades,
                colab:colab

            },
            success: function (respuesta) {



            },
            error: function () {
                console.log("ERROR CARGANDO DESPLEGABLES");
            }

        });

    });


});