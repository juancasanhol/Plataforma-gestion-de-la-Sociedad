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
                if(option.alumno!==undefined){$("#nombreAlumno").append('<tr><td>'+option.alumno.replace("_"," ")+'</td><td><button type="button" id='+option.alumno+' class="btn btn-success addAlumno">añadir</button></td></tr>');}    
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    
    
    /////LISTA ALUMNOS
    
    $(document).on('click', '.addAlumno', function () {
        var nombreD = $(this).attr("id").replace("_"," ");
        $("#DesplegablesListaAlumnos").append('<option value='+nombreD+' selected>'+nombreD+'</option>'); 
        $("#nombreAlumnoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD.replace(" ","_")+' class="btn btn-danger delAlumno">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delAlumno', function () {
        var nombreD = $(this).attr("id").replace("_"," ");
        console.log(nombreD);
        $("option[value='"+nombreD+"']").remove(); 
        $("#nombreAlumno").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD.replace(" ","_")+' class="btn btn-success addAlumno">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
});