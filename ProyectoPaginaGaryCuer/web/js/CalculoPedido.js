class Producto
{
    static consultar()
    {
    const traer = async() =>
        {
            let producto = {};
            producto.nombreProducto = document.querySelector("#nombreProducto" + paramId).value;
            producto.precioUnidad = document.querySelector("#precioUnidad" + paramId).value;
            let respuesta = await fetch("../ProductosParaPedir", {method: 'GET'});
            let productos = JSON.parse(await respuesta.text());
            let templatePersonas = await document.querySelector("#templatePersonasES6").innerHTML;
            document.querySelector('#panelResultados').innerHTML = await eval(templatePersonas);
        };
        traer()
            .catch(ex =>
            {
                document.querySelector("#panelMensajes").innerHTML = 'ERROR: ' + ex.message;
            });
    }
}
 Producto.consultar();