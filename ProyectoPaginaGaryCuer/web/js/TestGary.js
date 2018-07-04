class TestGary
{
    static inicializar()
    {
        let btnConsultar = document.querySelector("#datosbolsos");
        btnConsultar.setAttribute("onclick","TestGary.consultaGustos()");

        let btnConsultar1 = document.querySelector("#datosbolsos1");
        btnConsultar1.setAttribute("onclick","TestGary.consultaListaBolsos()");

        let btnConsultar2 = document.querySelector("#datosbolsos2");
        btnConsultar2.setAttribute("onclick","TestGary.consultaListaObjetosBolsos()");

        let btnConsultar3 = document.querySelector("#datosbolsos3");
        btnConsultar3.setAttribute("onclick","TestGary.consultaDatosSQLBolsos()");
    }

    static consultaGustos()
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
    
    static consultaListaBolsos()
    {
        const traer = async() =>
        {
            let respuesta = await fetch(".../DameListaBolsos", {method: 'GET'});

            let textoRespuesta = JSON.parse(await respuesta.text());

            document.querySelector("#msgOK").innerHTML += 
                "<strong style='color: peru'>"+ textoRespuesta +"</strong> " +
                "<br></br>"+
                "<strong style='color: peru'>"+ textoRespuesta[3] +"</strong> " +
                "<br></br>"+
                "<strong style='color: peru'>"+ textoRespuesta[0] +"</strong> "+
                "<br></br>";
        };

            traer()
            .catch(ex =>
            {
                document.querySelector("#msgERROR").innerHTML += 
                "<strong style='color: red'>"+ ex.message + "</strong> ";
            });
    }
    
    static consultaListaObjetosBolsos()
    {
        const traer = async() =>
        {
            let respuesta = await fetch(".../DameListaObjetosBolsos", {method: 'GET'});

            let textoRespuesta = JSON.parse(await respuesta.text());

            document.querySelector("#msgOK").innerHTML += 
                "<strong style='color: peru'>"+ textoRespuesta +"</strong> "+
                "<br></br>";
        };

            traer()
            .catch(ex =>
            {
                document.querySelector("#msgERROR").innerHTML += 
                "<strong style='color: red'>"+ ex.message + "</strong> ";
            });   
    }
    
    static consultaDatosSQLBolsos()
    {
        const traer = async() =>
        {
            let respuesta = await fetch(".../DameDatosSQL", {method: 'GET'});

            let textoRespuesta = JSON.parse(await respuesta.text());

            document.querySelector("#msgOK").innerHTML += 
                "<strong style='color: peru'>"+ textoRespuesta +"</strong> "+
                "<br></br>";
        };

            traer()
            .catch(ex =>
            {
                document.querySelector("#msgERROR").innerHTML += 
                "<strong style='color: red'>"+ ex.message + "</strong> ";
            });
    }   
}
    TestGary.inicializar();