$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDesplegables",
        },
        success: function (respuesta) {

            $.each(respuesta, function (i, option) {

                $("#tbody").append('<tr><td>' + option.nombre + '</td><td><button class="btn btn-success btnVerValores" id="' + option.nombre + '">Ver valores</button></td></tr>');


            });

        },
        error: function () {
            console.log("ERROR");
        }
    });

    $(document).on('click', '.btnVerValores', function () {

        MostrarValores($(this).attr("id"));


    });



    $(document).on('click', '.add', function () {
        var nombreD = $(this).attr("id");
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addValoresDesplegables",
                nombre: $(this).attr("id"),
                valor: $("#valor").val()
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },
            complete: function (xhr, status) {
                $("#valor").val("")
                MostrarValores(nombreD);
            }
        });



    });

});

function MostrarValores(nombreDesplegable) {

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerValoresDesplegables",
            nombre: nombreDesplegable
        },
        success: function (respuesta) {
           
            if(respuesta!=""){

                $("#thead").html("");
                $("#tbody").html("");
    
                $("#thead").append('<tr><td>Desplegable</td><td>Valores</td></tr>');
    
                $.each(respuesta, function (i, option) {
    
                    if (i == 0) {
                        $("#tbody").append('<tr><td>' + option.nombre + '</td><td>' + option.valor + '</td></tr>');
                        $("#botonera").html('<a class="col-4 btn btn-warning offset-1" href="../MenuPrincipal/Menu.html" role="button">Volver </a> <button type="button" class="btn btn-success col-4 mb-2 mt-2" data-bs-toggle="modal" data-bs-target="#ModalValor">Añadir valor</button>');
                        $(".add").attr("id", option.nombre);
                    } else {
                        $("#tbody").append('<tr><td></td><td>' + option.valor + '</td></tr>');
                    }
    
                });
    
    
    

            }else{
                $("#thead").html("");
                $("#tbody").html("");
    
                $("#thead").append('<tr><td>Desplegable</td><td>Valores</td></tr>');
                $("#botonera").html('<a class="col-4 btn btn-warning offset-1" href="../MenuPrincipal/Menu.html" role="button">Volver </a> <button type="button" class="btn btn-success col-4 mb-2 mt-2" data-bs-toggle="modal" data-bs-target="#ModalValor">Añadir valor</button>');
                $(".add").attr("id", nombreDesplegable);
            }
            
        },
        error: function () {
            console.log("ERROR ");
        }
    });

}