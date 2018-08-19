class Imagenes
{
    static inicializar()
    {
        var texto,i;
        
        for (i=0; i <= 9; i++)
        {
            texto+="<div class='col-sm-4'><img src='../img/002.jpg'></div>";
        }
        
        document.querySelector("#historia").innerHTML += texto;
    }
}

Imagenes.inicializar();
