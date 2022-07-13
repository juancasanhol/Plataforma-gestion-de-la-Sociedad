$(document).ready(function () {
    
    MostrarDesplegables();

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

    $(document).on('click', '.delD', function () {
        var nombreD = $(this).attr("id");
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "delDValoresDesplegables",
                nombreD: $(this).attr("id"),
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },
            complete: function (xhr, status) {
                MostrarDesplegables();
            }
        });

    });


   /* $(document).on('click', '.del', function () {
        var nombreD = $(this).attr("id");
        console.log($(this).attr("id"));
        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "delValoresDesplegables",
                nombreD: $(this).attr("id")
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },
            complete: function (xhr, status) {
                MostrarValores(nombreD.split("-")[0]);
            }
        });



    });*/


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
    
                $("#thead").append('<tr><td>Desplegable</td><td>Valores</td><td></td></tr>');
    
                $.each(respuesta, function (i, option) {
    
                    if (i == 0) {
                        $("#tbody").append('<tr><td>' + separa(option.nombre) + '</td><td>' + option.valor + '</td><td><button id="'+option.nombre+'-'+ option.valor+'" type="button" class="btn btn-danger del">Borrar valor</button></td></tr>');
                        $("#botonera").html('<a class="col-4 btn btn-warning offset-1" href="../desplegables/VerDesplegables.html" role="button">Volver </a> <button type="button" class="btn btn-success col-4 mb-2 mt-2" data-bs-toggle="modal" data-bs-target="#ModalValor">Añadir valor</button>');
                        $(".add").attr("id", option.nombre);
                    } else {
                        $("#tbody").append('<tr><td></td><td>' + option.valor + '</td><td><button id="'+option.nombre+'-'+ option.valor+'" type="button" class="btn btn-danger del">Borrar valor</button></td></tr>');
                    }
    
                });
    
    
    

            }else{
                $("#thead").html("");
                $("#tbody").html("");
    
                
                $("#botonera").html('<a class="col-4 btn btn-warning offset-1" href="../desplegables/VerDesplegables.html" role="button">Volver </a> <button type="button" class="btn btn-success col-4 mb-2 mt-2" data-bs-toggle="modal" data-bs-target="#ModalValor">Añadir valor</button>');
                $(".add").attr("id", nombreDesplegable);
            }
            
        },
        error: function () {
            console.log("ERROR ");
        }
    });

}

function MostrarDesplegables(){

    $.ajax({
        type: "post",
        url: "../../Ajax",
        data: {
            accion: "VerDesplegables",
        },
        success: function (respuesta) {
            $("#tbody").html("");console.log("ENTRA");
            $.each(respuesta, function (i, option) {

                $("#tbody").append('<tr><td>' +option.nombre+ '</td><td><button class="btn btn-success btnVerValores" id="' + option.nombre + '">Ver valores</button></td></tr>');

                $("#botonera").html('<a class="col-4 btn btn-warning offset-1" href="../MenuPrincipal/Menu.html" role="button">Volver </a>');
            });

        },
        error: function () {
            console.log("ERROR");
        }
    });

}

//boton para borrar desplegable junto al ajax cometado
//<td><button id="'+option.nombre+'" type="button" class="btn btn-danger delD">Borrar Desplegable</button></td>