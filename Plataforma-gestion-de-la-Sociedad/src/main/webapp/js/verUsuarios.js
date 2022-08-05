$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerUsuarios",
        },
        success: function (respuesta) {
            //console.log("Desplegables cargados correctamente");
            $.each(respuesta, function (i, option) {
                //console.log("buena");
                $("#tbody").append('<tr><td class="d-none" >' + option.id + '</td><td>' + option.nombre+ '</td><td>' + option.apellidos +'</td>'+ '<td><a href="../../redireccion?accion=verusuario"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Editar</button></a></td>'+ '<td><a href="VerDatosUsuario.html"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Ver datos</button></a></td>'+'</tr>');
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
    url:"../../EditarUsuario", 
    data:{id:id}
});
};