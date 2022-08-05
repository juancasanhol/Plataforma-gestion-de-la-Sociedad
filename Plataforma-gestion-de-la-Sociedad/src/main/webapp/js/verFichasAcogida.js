$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerFichasAcogida",
        },
        success: function (respuesta) {
            //console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#tbody").append('<tr><td class="d-none" >' + option.id + '</td><td>' + option.nombre+ '</td><td></td>'+ '<td><a href="VerFichaAcogida.html"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Ver datos</button></a></td>'+'</tr>');
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
    url:"../../VerFichaAcogida", 
    data:{id:id}
});
};