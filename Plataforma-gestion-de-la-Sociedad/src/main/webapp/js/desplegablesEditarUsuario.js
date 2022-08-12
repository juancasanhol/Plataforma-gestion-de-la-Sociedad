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
            });
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "EditarUsuario",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.borrarcarnet!==undefined){$("#tiposCarnetDel").append('<tr><td>'+option.borrarcarnet+'</td><td><button type="button" id='+option.borrarcarnet+' class="btn btn-danger delCarnet">eliminar</button></td></tr>');
                    $("#DesplegablesTipoCarnetConducir").append('<option value='+option.borrarcarnet+' selected>'+option.borrarcarnet+'</option>'); 
                }
                if(option.borrarbolsa!==undefined){$("#nombreBolsaDel").append('<tr><td>'+option.borrarbolsa+'</td><td><button type="button" id='+option.borrarbolsa+' class="btn btn-danger delBolsa">eliminar</button></td></tr>'); 
                    $("#DesplegablesBolsaTrabajo").append('<option value='+option.borrarbolsa+' selected>'+option.borrarbolsa+'</option>'); 
                }
                if(option.addcarnet!==undefined){$("#tiposCarnet").append('<tr><td>'+option.addcarnet+'</td><td><button type="button" id='+option.addcarnet+' class="btn btn-success addCarnet">añadir</button></td></tr>'); }
                if(option.addbolsa!==undefined){$("#nombreBolsa").append('<tr><td>'+option.addbolsa+'</td><td><button type="button" id='+option.addbolsa+' class="btn btn-success addBolsa">añadir</button></td></tr>'); }
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


});
