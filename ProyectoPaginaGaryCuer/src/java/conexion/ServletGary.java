package conexion;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletGary", urlPatterns = {"/ServletGary"})
public class ServletGary extends HttpServlet
{
    private Gson convertir = new Gson();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
            response.getWriter().print(convertir.toJson("Funciona, aun con el Gson en privado!!"));
    }
}
