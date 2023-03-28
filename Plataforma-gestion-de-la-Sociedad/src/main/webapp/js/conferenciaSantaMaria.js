$(document).ready(function () {
    $(document).on('click', '.add', function () {


        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "addConferenciaSantaMaria",
//                Hay que poner cada campo y recogerlo
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR ");
            },

        });
    });
});

