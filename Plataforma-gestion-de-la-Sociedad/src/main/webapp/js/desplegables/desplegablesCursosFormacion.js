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
                //if(option.alumno!==undefined){$("#nombreAlumno").append('<tr><td>'+option.alumno.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.alumno.replaceAll("_","&nbsp;")+' class="btn btn-success addAlumno">añadir</button></td></tr>');}    
                if(option.solicitante!==undefined){$("#nombreSolicitante").append('<tr><td>'+option.solicitante.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.idSol+' name='+option.solicitante.replaceAll("_","&nbsp;")+' class="btn btn-success addSolicitante">añadir</button></td></tr>');}    
                //if(option.seleccionado!==undefined){$("#nombreSeleccionado").append('<tr><td>'+option.seleccionado.replaceAll("_","&nbsp;")+'</td><td><button type="button" id='+option.seleccionado.replaceAll("_","&nbsp;")+' class="btn btn-success addSeleccionado">añadir</button></td></tr>');}    
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
    
    
    
    /////LISTA ALUMNOS
    
    $(document).on('click', '.addAlumno', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesListaAlumnos").append('<option value='+idD+' selected>'+nombreD+'</option>'); 
        $("#nombreAlumnoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-danger delAlumno">eliminar</button></td></tr>'); 
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delAlumno', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesListaAlumnos option[value='"+idD+"']").remove(); 
        $("#nombreAlumno").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-success addAlumno">añadir</button></td></tr>'); 
        $(this).closest('tr').remove();
    });
    
    
    /////LISTA SOLICITANTES
    
    $(document).on('click', '.addSolicitante', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesListaSolicitantes").append('<option value='+idD+' selected>'+nombreD+'</option>'); 
        $("#nombreSolicitanteDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-danger delSolicitante">eliminar</button></td></tr>'); 
       

        $("#nombreSeleccionado").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-success addSeleccionado">añadir</button></td></tr>'); 
       
        
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delSolicitante', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        console.log(idD);
        $("#DesplegablesListaSolicitantes option[value='"+idD+"']").remove(); 
        $("#nombreSolicitante").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-success addSolicitante">añadir</button></td></tr>'); 
        
        $("#DesplegablesListaSeleccionados option[value='"+idD+"']").remove(); 
        $("#nombreSeleccionado").children("tr").children("td:contains("+nombreD+")").parents("tr").remove()
        
        $(this).closest('tr').remove();
    });
    
    
    /////LISTA SELECCIONADOS
    
    $(document).on('click', '.addSeleccionado', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesListaSeleccionados").append('<option value='+idD+' selected>'+nombreD+'</option>'); 
        $("#nombreSeleccionadoDel").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-danger delSeleccionado">eliminar</button></td></tr>'); 

        $("#nombreAlumno").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-success addAlumno">añadir</button></td></tr>'); 
        
        $(this).closest('tr').remove();
    });

    $(document).on('click', '.delSeleccionado', function () {
        var nombreD = $(this).attr("name");
        var idD = $(this).attr("id");
        $("#DesplegablesListaSeleccionados option[value='"+idD+"']").remove(); 
        $("#nombreSeleccionado").append('<tr><td>'+nombreD+'</td><td><button type="button" id='+idD+' name='+nombreD+' class="btn btn-success addSeleccionado">añadir</button></td></tr>'); 
        $("#nombreSeleccionado").children("tr").children("td:contains("+nombreD+")").parents("tr").remove()
        $(this).closest('tr').remove();
    });
    
    
    $(document).on('click', '#addCurso', function () {

        let Lsol ="";
        $("#DesplegablesListaSolicitantes").children().each((idx, el) => {
            // Obtenemos los atributos que necesitamos
            if (idx==0){
                Lsol +=el.value
            }else{
                Lsol +=";"+el.value
            }
          });

          let LSel ="";
          $("#DesplegablesListaSeleccionados").children().each((idx, el) => {
              // Obtenemos los atributos que necesitamos
              if (idx==0){
                LSel +=el.value
              }else{
                LSel +=";"+el.value
              }
            });

            let LAlu ="";
            $("#DesplegablesListaAlumnos").children().each((idx, el) => {
                // Obtenemos los atributos que necesitamos
                if (idx==0){
                    LAlu +=el.value
                }else{
                    LAlu +=";"+el.value
                }
              });
        console.log(Lsol);
        console.log(LSel);
        console.log(LAlu);
        
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "CursosFormacionAdd",
                nombre: $("#NombreCurso").val(),
                tipo: $("#TipoCurso").val(),
                otra:$("#TipoDoc").val(),
                Fini:$("#FechaInicio").val(),
                Ffin:$("#FechaFin").val(),
                obs:$("#Observaciones").val(),
                LSol:Lsol,
                LSel:LSel,
                LAlu:LAlu,
 
            },
            success: function (respuesta) {
               
    
            },
            error: function () {
                console.log("ERROR CARGANDO");
            }
        });

    });

});