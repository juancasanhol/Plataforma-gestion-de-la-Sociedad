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
                $("#tbody").append('<tr><td class="d-none" >' + option.id + '</td><td>' + option.nombre+ '</td><td>' + option.apellidos +'</td>'+ '<td><a href="../../Redireccion?accion=verusuario"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Editar</button></a></td>'+ '<td><a href="VerDatosUsuario.html"><button onclick="enviaId('+option.id+')" type="button" class="btn btn-primary mb-2">Ver datos</button></a></td><td><button title="Doble click para borrar" ondblclick="enviaId2('+option.id+')" type="button" class="btn btn-danger del">Borrar</button></td>'+'</tr>');
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
    url:"../../Redireccion", 
    data:{id:id}
});
};

function enviaId2(id) {
  $.ajax({
    type:"POST", 
    url:"../../Borrar", 
    data:{id:id}
});
window.location.href = "../../Borrar?accion=borrarusuario";
};