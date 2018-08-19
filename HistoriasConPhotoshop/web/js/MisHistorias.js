class Imagenes
{
    static inicializar()
    {
        var texto,i;
        
        for (i=1; i <= 112; i++)
        {
            texto+="<div class='col-sm-4'><img src='../img/"+i+".jpg' width='350' height='250'></div>";
        }
        
        document.querySelector("#historia").innerHTML += texto;
    }
    
    static inicializarGaryVSDiego()
    {
        var texto,i;
        
        for (i=1; i <= 112; i++)
        {
            texto+="<div class='col-sm-4'><img src='../img/img/00"+i+".jpg' width='350' height='250'></div>";
        }
        
        document.querySelector("#historiaBatman").innerHTML += texto;
    }
}

Imagenes.inicializar();

Imagenes.inicializarGaryVSDiego();
