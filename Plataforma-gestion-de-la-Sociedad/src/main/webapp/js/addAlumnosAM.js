$(document).ready(function () {

    $("#addAula").click(function (){

        let selecteds ="";
        $("#DesplegablesListaAlumnos").children(':selected').each((idx, el) => {
            // Obtenemos los atributos que necesitamos
            if (idx==0){
                selecteds +=el.value
            }else{
                selecteds +=";"+el.value
            }
        
          });

        $.ajax({
            type: "post",
            url: "../../Ajax",
            data: {
                accion: "adddAula",
                alumnos: selecteds,
                denom:$("#Denominacion").val(),
                profe:$("#Profesor").val(),
                
              
            },
            success: function (respuesta) {

            },
            error: function () {
                console.log("ERROR!!");
            }
        });

    });

   
    
});





