function separa(palabra){

    var retorno=palabra.charAt(0);

    for(var index = 1; index < palabra.length; index++)
    {
        var letraActual = palabra.charAt(index);
        if(letraActual==letraActual.toUpperCase())
        {
            retorno=retorno+" "+letraActual
        }else{

            retorno=retorno+letraActual
        }
    
           
    }
    console.log(retorno);
return retorno;
}
