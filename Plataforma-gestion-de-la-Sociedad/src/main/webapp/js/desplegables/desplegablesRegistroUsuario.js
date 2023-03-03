var numFilaIngreso = 1;
var numFilaUnidadFamiliar = 1;
var idHijos = -1;
$(document).ready(function () {



    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "Usuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if (option.tipodocumento !== undefined) { $("#DesplegablesTipoDoc").append('<option value="' + option.tipodocumento + '">'); }
                if (option.sexo !== undefined) { $("#DesplegablesSexo").append('<option value="' + option.sexo + '">'); }
                if (option.paisorigen !== undefined) { $("#DesplegablesPaisOrigen").append('<option value="' + option.paisorigen + '">'); }
                if (option.nacionalidad !== undefined) { $("#DesplegablesNacionalidad").append('<option value="' + option.nacionalidad + '">'); }
                if (option.minoriaetnica !== undefined) { $("#DesplegablesMinoria").append('<option value="' + option.minoriaetnica + '">'); }
                if (option.usuarios !== undefined) { $("#DesplegablesPersonaReferencia").append('<option value="' + option.usuarios + '">'); }
                if (option.origenIngresos !== undefined) { $("#DesplegablesOrigenIngresos").append('<option value="' + option.idOrigenIngresos + '">' + option.origenIngresos + '</option');}
                if (option.tipoCarnetConducir !== undefined) { $("#tiposCarnet").append('<tr><td>' + option.tipoCarnetConducir + '</td><td><button type="button" id=' + option.tipoCarnetConducir + ' class="btn btn-success addCarnet">añadir</button></td></tr>'); }
                if (option.nombreBolsa !== undefined) { $("#nombreBolsa").append('<tr><td>' + option.nombreBolsa + '</td><td><button type="button" id=' + option.nombreBolsa + ' class="btn btn-success addBolsa">añadir</button></td></tr>'); }
                if (option.parentesco !== undefined) {
                    if (option.parentesco == "Hijos") {
                        idHijos = option.idParentesco;
                    }
                    $("#DesplegablesParentesco").append('<option value="' + option.idParentesco + '">' + option.parentesco + '</option');
                }

            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });


    //LISTA OTROS CARNETS   

    $(document).on('click', '.addCarnet', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesTipoCarnetConducir").append('<option value=' + nombreD + ' selected>' + nombreD + '</option>');
        $("#tiposCarnetDel").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + nombreD + ' class="btn btn-danger delCarnet">eliminar</button></td></tr>');
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delCarnet', function () {
        var nombreD = $(this).attr("id");
        $("option[value='" + nombreD + "']").remove();
        $("#tiposCarnet").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + nombreD + ' class="btn btn-success addCarnet">añadir</button></td></tr>');
        $(this).closest('tr').remove();
    });


    /////BOLSA TRABAJO

    $(document).on('click', '.addBolsa', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesBolsaTrabajo").append('<option value=' + nombreD + ' selected>' + nombreD + '</option>');
        $("#nombreBolsaDel").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + nombreD + ' class="btn btn-danger delBolsa">eliminar</button></td></tr>');
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delBolsa', function () {
        var nombreD = $(this).attr("id");
        $("option[value='" + nombreD + "']").remove();
        $("#nombreBolsa").append('<tr><td>' + nombreD + '</td><td><button type="button" id=' + nombreD + ' class="btn btn-success addBolsa">añadir</button></td></tr>');
        $(this).closest('tr').remove();
    });



    $(document).on('click', '#addFilaIngreso', function () {
        numFilaIngreso += 1;
        $("#tbodyIng").append("<tr><td  scope='row'><input type='number' name='' id='importeIng" + numFilaIngreso + "' min='0'></td><td><input type='text' name='' id='procedenciaIng" + numFilaIngreso + "' list='DesplegablesOrigenIngresos'></td></tr>");
    });


    $(document).on('click', '#addFilaUC', function () {
        numFilaUnidadFamiliar += 1;
        $('#tbodyUC').append("<tr id='row" + numFilaUnidadFamiliar + "'><td scope='row'><input type='text' name='' id='nomUC" + numFilaUnidadFamiliar + "'></td><td ><input type='text' name='' id='parenUC" + numFilaUnidadFamiliar + "' list='DesplegablesParentesco' class='parent'></td><td><input type='date' name='' id='fechaUC" + numFilaUnidadFamiliar + "' min='0'></td><td><input type='text' name='' id='profesUC" + numFilaUnidadFamiliar + "'></td><td id='tdAyudaHijo" + numFilaUnidadFamiliar + "'hidden><input type='checkbox' id='ayudaHijo" + numFilaUnidadFamiliar + "'></td></tr>");
    });

    $(document).on('change', '.parent', function () {

        var aux = $(this).attr('id');
        aux=aux.replace('parenUC', '');

         if ($(this).val() == idHijos) {
             $("#thAyudaHijo").attr('hidden', false);
             $('#tdAyudaHijo'+ aux).attr('hidden', false);
         }else{
            $('#tdAyudaHijo'+ aux).attr('hidden', true);
         }
    });

    $(document).on('click', '#registrarButton', function () {
        var formData = new FormData(document.getElementById("Identificacion"));
        var numIng=$("#tbodyIng").find('tr').toArray().length;
        var numUC=$("#tbodyUC").find('tr').toArray().length;
        var datosIng;
        var datosUC;
        for (i=1;i<=numIng;i++){
            if (datosIng==undefined){
                datosIng=$("#importeIng"+i).val()+";"+$("#procedenciaIng"+i).val()+";;"
            }else{
                datosIng=datosIng+$("#importeIng"+i).val()+";"+$("#procedenciaIng"+i).val()+";;"
            }

        }

        for (i=1;i<=numUC;i++){
            if (datosUC==undefined){
                if($("#tdAyudaHijo"+i).children().is(":checked")){
                    datosUC=$("#nomUC"+i).val()+";"+$("#parenUC"+i).val()+";"+$("#fechaUC"+i).val()+";"+$("#profesUC"+i).val()+";true;;"
                }else{
                    datosUC=$("#nomUC"+i).val()+";"+$("#parenUC"+i).val()+";"+$("#fechaUC"+i).val()+";"+$("#profesUC"+i).val()+";false;;"
                }
            }else{

                if($("#tdAyudaHijo"+i).children().is(":checked")){
                    datosUC=datosUC+$("#nomUC"+i).val()+";"+$("#parenUC"+i).val()+";"+$("#fechaUC"+i).val()+";"+$("#profesUC"+i).val()+";true;;"
                }else{
                    datosUC=datosUC+$("#nomUC"+i).val()+";"+$("#parenUC"+i).val()+";"+$("#fechaUC"+i).val()+";"+$("#profesUC"+i).val()+";false;;"
                }

            }

        }
        console.log(datosUC)
        formData.append("datosIng", datosIng);
        formData.append("datosUC", datosUC );

        $.ajax({
            url: "../../RegistroUsuario",
            type: "post",
            dataType: "json",
            data: formData,
            cache: false,
            contentType: false,
            processData: false,

        })

        $(location).attr('href',"../MenuPrincipal/Menu.html");
    });
   
    //$('#tbodyUC').append("<tr id='row" + numFilaUnidadFamiliar + "'><td scope='row'><input type='text' name='' id='nomUC" + numFilaUnidadFamiliar + "'></td><td ><input type='text' name='' id='parenUC" + numFilaUnidadFamiliar + "' list='DesplegablesParentesco' ></td><td><input type='date' name='' id='fechaUC" + numFilaUnidadFamiliar + "' min='0'></td><td><input type='text' name='' id='profesUC" + numFilaUnidadFamiliar + "'></td></tr>");

    //<input type="checkbox" id="EstaEstudiando" name="EstaEstudiando">
    /*if (option.parentesco == "Hijos") {

    } else {*/
});
