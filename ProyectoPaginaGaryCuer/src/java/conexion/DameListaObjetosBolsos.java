package conexion;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gary
 */
@WebServlet(name = "DameListaObjetosBolsos", urlPatterns = {"/DameListaObjetosBolsos"})
public class DameListaObjetosBolsos extends HttpServlet
{
    private Gson convertir = new Gson();
    private ArrayList<Map> textoAEnviar;
    private TreeMap<String, String> info = new TreeMap();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //instancio el arrayList Map
        textoAEnviar = new ArrayList();
        
        //cargo los datos de cierto elemento y luego lo guardo en "textoAEnviar"
        info.put("gusto", "Lemon Pie");
        info.put("calorias", "500");
        textoAEnviar.add(info);
        
        info.put("gusto", "Chocolate");
        info.put("calorias", "3000");
        textoAEnviar.add(info);
        
        info.put("gusto", "Vainilla");
        info.put("calorias", "1000");
        textoAEnviar.add(info);
        
        info.put("gusto", "Frutilla");
        info.put("calorias", "200");
        textoAEnviar.add(info);

        response.getWriter().print(convertir.toJson(String.valueOf(textoAEnviar)));
}
}
