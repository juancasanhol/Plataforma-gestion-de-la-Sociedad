$(document).ready(function () {
    $(".error").hide()
    tipo = window.sessionStorage['tipo'];

    if (tipo == undefined || tipo == null || tipo == 'null') {
        $(".opcionesTodas").hide()
        $(".error").show()
    } 
    $(".error").hide()
    switch (tipo) {
        case "ADMIN":
            $(".opcionesTodas").show()
            break;

        case "PROFESOR":
            $(".opcionesProfesor").show()
            break;

        case "PROFESIONAL":
            $(".opcionesProfesional").show()
            break;

        default:
            break;
    }

});
