package conexion;

import conexionBBDD.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductosParaPedir", urlPatterns = {"/ProductosParaPedir"})
public class ProductosParaPedir extends HttpServlet
{
    
    private ObtenerDatosSQL datosSQL;     //declaro mi variable de la clase que obtengo mis datos SQL
    private ArrayList<String> arrayDatos = new ArrayList();
    private Gson convertir = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        datosSQL = new ObtenerDatosSQL();
        convertir.toJson(datosSQL.dameNombreProductos());
//        response.getWriter().print(convertir.toJson(datosSQL.dameNombreProductos()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
    }
}
