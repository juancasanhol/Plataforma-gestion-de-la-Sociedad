$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDatosAlumno",
        },
        success: function (respuesta) {
            console.log("Desplegables cargados correctamente");
            //console.log("buena");
            $("#Nombre").append(respuesta.nombre);
            $("#EmpresaPracticas").append(respuesta.empresapracticas);
            $("#FechaAlta").append(respuesta.fechaalta);
            $("#FechaBaja").append(respuesta.fechabaja);
            $("#CursoEscolar").append(respuesta.cursoescolar);
            if (respuesta.aprovechamiento === true) {
                $("#Aprovechamiento").append('Sí');
            }else{
                $("#Aprovechamiento").append('No');
            }
            if (respuesta.finaliza === true) {
                $("#Finaliza").append('Sí');
            }else{
                $("#Finaliza").append('No');
            }
            if (respuesta.promociona === true) {
                $("#Promociona").append('Sí');
            }else{
                $("#Promociona").append('No');
            }
            
            //CONTINUAR AQUI CON LA INFO DE LA LISTA DE ALUMNOS
            
        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});