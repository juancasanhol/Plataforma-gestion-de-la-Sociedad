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
                if(option.tipodocumento!==undefined){$("#DesplegablesTipoDoc").append('<option value="' + option.tipodocumento + '">');}
                if(option.sexo!==undefined){$("#DesplegablesSexo").append('<option value="' + option.sexo + '">');}
                if(option.paisorigen!==undefined){$("#DesplegablesPaisOrigen").append('<option value="' + option.paisorigen + '">');}
                if(option.nacionalidad!==undefined){$("#DesplegablesNacionalidad").append('<option value="' + option.nacionalidad + '">');}
                if(option.minoriaetnica!==undefined){$("#DesplegablesMinoria").append('<option value="' + option.minoriaetnica + '">');}
                if(option.usuarios!==undefined){$("#DesplegablesPersonaReferencia").append('<option value="' + option.usuarios + '">');}
                if(option.tipoCarnetConducir!==undefined){$("#tiposCarnet").append('<tr><td>'+option.tipoCarnetConducir+'</td><td><button type="button" id='+option.tipoCarnetConducir+' class="btn btn-success addCarnet">añadir</button></td></tr>');}    
            });
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    $(document).on('click', '.addCarnet', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesTipoCarnetConducir").append('<option value='+nombreD+'>'+nombreD+'</option>'); 
        $("#tiposCarnetDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delCarnet">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delCarnet', function () {
        var nombreD = $(this).attr("id");
        console.log(nombreD);
        $("option[value='"+nombreD+"']").remove(); 
        $("#tiposCarnet").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addCarnet">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });


});
