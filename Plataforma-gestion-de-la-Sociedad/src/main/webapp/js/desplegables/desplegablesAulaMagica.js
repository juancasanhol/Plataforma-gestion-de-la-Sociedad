$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "AulaMagicaProf",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                    $("#DesplegablesProfesor").append('<option value="' + option.nombre + '"></option>');
                //if(option.alumno!==undefined){$("#nombreAlumno").append('<tr><td>'+option.alumno.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.alumno.replaceAll("_","&nbsp;")+' class="btn btn-success addAlumno">añadir</button></td></tr>');}                   
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    /////LISTA ALUMNOS
    
    $("#addAlumno").click(function (){

        $("#DesplegablesListaAlumnos").append('<option value='+$("#nomAlum").val()+'-'+$("#apeAlum").val()+'-'+$("#curAlum").val()+'-'+$("#colAlum").val()+' selected>'+$("#nomAlum").val()+'-'+$("#apeAlum").val()+'-'+$("#curAlum").val()+'-'+$("#colAlum").val()+'</option>'); 
       // $("#nombreAlumnoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+nombreD+' class="btn btn-danger delAlumno">eliminar</button></td></tr>'); 
        //$(this).closest('tr').remove();
        $("#nombreAlumnoDel").append('<tr><td>'+$("#nomAlum").val()+'-'+$("#apeAlum").val()+'</td><td><button type="button" id='+$("#nomAlum").val()+'-'+$("#apeAlum").val()+'-'+$("#curAlum").val()+'-'+$("#colAlum").val()+' class="btn btn-danger delAlumno">Quitar</button></td></tr>');

    });

    $(document).on('click', '.delAlumno', function () {
        valores=[] 
        valor=$(this).attr('id');
        console.log($(this).attr('id'));

        $("#DesplegablesListaAlumnos option[value='"+valor+"']").remove(); 
        //$("#nombreAlumnoDel").append('<tr><td>'+valores[0]+'</td><td><button type="button" id='+valores[0]+' class="btn btn-success addAlumno">añadir</button></td></tr>'); 
        //$(this).closest('tr').remove();
        $("#nombreAlumnoDel").html("");
        $("#DesplegablesListaAlumnos option").each(function() {
            
            valores=$(this).val().split('-');
            $("#nombreAlumnoDel").append('<tr><td>'+valores[0]+'-'+valores[1]+'</td><td><button type="button" id='+valores[0]+'-'+valores[1]+'-'+valores[2]+'-'+valores[3]+' class="btn btn-danger delAlumno">Quitar</button></td></tr>');

        });
    });
    
});