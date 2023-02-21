var numFilaIngreso=1;
var numFilaUnidadFamiliar=1;
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
                if(option.nombreBolsa!==undefined){$("#nombreBolsa").append('<tr><td>'+option.nombreBolsa+'</td><td><button type="button" id='+option.nombreBolsa+' class="btn btn-success addBolsa">añadir</button></td></tr>');} 
                if(option.parentesco!==undefined){$("#DesplegablesParentesco").append('<option value="' + option.idParentesco + '">' + option.parentesco + '</option');}     
            
            });
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    
    //LISTA OTROS CARNETS   
    
    $(document).on('click', '.addCarnet', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesTipoCarnetConducir").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#tiposCarnetDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delCarnet">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delCarnet', function () {
        var nombreD = $(this).attr("id");
        $("option[value='"+nombreD+"']").remove(); 
        $("#tiposCarnet").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addCarnet">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
    /////BOLSA TRABAJO
    
    $(document).on('click', '.addBolsa', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesBolsaTrabajo").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#nombreBolsaDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delBolsa">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delBolsa', function () {
        var nombreD = $(this).attr("id");
        $("option[value='"+nombreD+"']").remove(); 
        $("#nombreBolsa").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addBolsa">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    

    $(document).on('click', '#addFilaIngreso', function () {
    numFilaIngreso+=1;
    $("#tbodyIng").append("<tr><td scope='row'><input type='text' id='origenIng"+numFilaIngreso+"' list='DesplegablesOrigenIngresos'></td><td><input type='number' name='' id='importeIng"+numFilaIngreso+"' min='0'></td><td><input type='text' name='' id='procedenciaIng"+numFilaIngreso+"'></td></tr>");
    });


    $(document).on('click', '#addFilaUC', function () {
        numFilaUnidadFamiliar+=1;
        $('#tbodyUC').append("<tr><td scope='row'><input type='text' name='' id='nomUC"+numFilaUnidadFamiliar+"'></td><td ><input type='text' name='' id='parenUC"+numFilaUnidadFamiliar+"' list='DesplegablesParentesco' ></td><td><input type='date' name='' id='fechaUC"+numFilaUnidadFamiliar+"' min='0'></td><td><input type='text' name='' id='profesUC"+numFilaUnidadFamiliar+"'></td></tr>");
        });
});
