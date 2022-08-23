$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "CursosFormacion",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                if(option.tipocurso!==undefined){$("#DesplegablesTipoCurso").append('<option value="' + option.tipocurso + '">');}
                if(option.alumno!==undefined){$("#nombreAlumno").append('<tr><td>'+option.alumno.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.alumno.replaceAll("_","&nbsp;")+' class="btn btn-success addAlumno">añadir</button></td></tr>');}    
                if(option.solicitante!==undefined){$("#nombreSolicitante").append('<tr><td>'+option.solicitante.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.solicitante.replaceAll("_","&nbsp;")+' class="btn btn-success addSolicitante">añadir</button></td></tr>');}    
                if(option.seleccionado!==undefined){$("#nombreSeleccionado").append('<tr><td>'+option.seleccionado.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.seleccionado.replaceAll("_","&nbsp;")+' class="btn btn-success addSeleccionado">añadir</button></td></tr>');}    
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    
    
    /////LISTA ALUMNOS
    
    $(document).on('click', '.addAlumno', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaAlumnos").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#nombreAlumnoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delAlumno">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delAlumno', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaAlumnos option[value='"+nombreD+"']").remove(); 
        $("#nombreAlumno").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addAlumno">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
    /////LISTA SOLICITANTES
    
    $(document).on('click', '.addSolicitante', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaSolicitantes").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#nombreSolicitanteDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delSolicitante">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delSolicitante', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaSolicitantes option[value='"+nombreD+"']").remove(); 
        $("#nombreSolicitante").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addSolicitante">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
    /////LISTA SELECCIONADOS
    
    $(document).on('click', '.addSeleccionado', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaSeleccionados").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#nombreSeleccionadoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delSeleccionado">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delSeleccionado', function () {
        var nombreD = $(this).attr("id");
        $("#DesplegablesListaSeleccionados option[value='"+nombreD+"']").remove(); 
        $("#nombreSeleccionado").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-success addSeleccionado">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
});