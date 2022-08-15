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
                if(option.actividad!==undefined){$("#tiposActividad").append('<tr><td>'+option.actividad+'</td><td><button type="button" id='+option.actividad+' class="btn btn-success addActividad">añadir</button></td></tr>');}
                if(option.tiposcolaboracion!==undefined){$("#tiposColaboracion").append('<tr><td>'+option.tiposcolaboracion+'</td><td><button type="button" id='+option.tiposcolaboracion+' class="btn btn-success addColaboracion">añadir</button></td></tr>');}
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    
    
    //LISTA ACTIVIDADES   
    
    $(document).on('click', '.addActividad', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesTipoActividad").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#tiposActividadDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delActividad">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delActividad', function () {
        var nombreD = $(this).attr("id");
        $("option[value='"+nombreD+"']").remove(); 
        $("#tiposActividad").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addActividad">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
    
    
    
    //LISTA COLABORACIONES   
    
    $(document).on('click', '.addColaboracion', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesTipoColaboracion").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#tiposColaboracionDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delColaboracion">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delColaboracion', function () {
        var nombreD = $(this).attr("id");
        $("option[value='"+nombreD+"']").remove(); 
        $("#tiposColaboracion").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addColaboracion">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
});