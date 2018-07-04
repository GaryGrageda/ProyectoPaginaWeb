package conexion;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @author Gary
 */
@WebServlet(name = "DameListaBolsos", urlPatterns = {"/DameListaBolsos"})
public class DameListaBolsos extends HttpServlet
{

    private ArrayList<String> lista;
    private Gson convertir = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //guardo datos en mi arrayList
        lista = new ArrayList();
        lista.add("Morrales");
        lista.add("Mochilas");
        lista.add("Botineros");
        lista.add("Materos");
        
        response.getWriter().print(convertir.toJson(lista));
        
    }
}
