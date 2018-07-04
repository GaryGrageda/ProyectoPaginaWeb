class Persona
{
    static inicializar()
    {
        let elemRegistrar = document.querySelector('#btnRegistrar');
        elemRegistrar.setAttribute('onclick', "Persona.insertar();");
    }
    
    static insertar()
    {
        const traer = async() =>
        {
            let persona = {};
            persona.nombre = document.querySelector("#persona_nombre").value;
            persona.apellido = document.querySelector("#persona_apellido").value;
            persona.dni = document.querySelector("#persona_dni").value;
            persona.dire_local = document.querySelector("#persona_dire_local").value;
            persona.localidad = document.querySelector("#persona_localidad").value;
            persona.nombre_local = document.querySelector("#persona_nombre_local").value;
            persona.tel_linea = document.querySelector("#persona_tel_linea").value;
            persona.celular = document.querySelector("#persona_celular").value;
            persona.email = document.querySelector("#persona_email").value;
            let personaStringJSON = JSON.stringify(persona);
            
            let respuesta = await fetch("../DameDatosSQL",
                    {method: 'POST', body: personaStringJSON});

            let datotexto = JSON.parse(await respuesta.text());
            
            document.querySelector('#msgOK').innerHTML = datotexto;
        };
        traer()
                .catch(ex =>
                {
                    document.querySelector("#msgERROR").innerHTML = 'ERROR: ' + ex.message;
                });

    }
}
///////////////////////////////////////// main() // Ejecucion Inicial Default
Persona.inicializar();
/////////////////////////////////////////
