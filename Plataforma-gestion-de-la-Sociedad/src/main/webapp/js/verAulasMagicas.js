$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerAulas",
        },
        success: function (respuesta) {
            //console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#tbody").append('<tr><td class="d-none" >' + option.id + '</td><td>' + option.denominacion+ '</td><td>' + option.profesor +'</td>'+ '<td><a href="VerAula.html"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Ver datos</button></a></td>'+'</tr>');
            });

        },
        error: function () {
            console.log("ERROR CARGANDO DESPLEGABLES");
        }
    });
});

function enviaId(id) {
  $.ajax({
    type:"POST", 
    url:"../../VerAula", 
    data:{id:id}
});
};