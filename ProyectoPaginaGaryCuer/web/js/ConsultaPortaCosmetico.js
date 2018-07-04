class ConsultaPortaCosmetico
{
    static inicializar()
    {
        let btnVerDetalles= document.querySelector("#btnDetalles");
        btnVerDetalles.setAttribute("onclick","ConsultaPortaCosmetico.buscarId()");

        let btnComprar = document.querySelector("#btnComprar");
        btnComprar.setAttribute("onclick","ConsultaPortaCosmetico.buscarColor()");
    }
    
    static buscarId()
    {
        const traer = async() =>
        {
            let respuesta = await fetch(".../ServletGary", {method: 'GET'});

            let textoRespuesta = JSON.parse(await respuesta.text());

            document.querySelector("#msgOK").innerHTML += 
                "<strong style='color: peru'>"+ textoRespuesta +"</strong> "+"<br></br>";
        };

        traer()
        .catch(ex =>
        {
            document.querySelector("#msgERROR").innerHTML += 
            "<strong style='color: red'>"+ ex.message + "</strong> ";
        });
    }
    
    static buscarColor()
    {
        
    }
    
}
ConsultaPortaCosmetico.inicializar();


