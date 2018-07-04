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

@WebServlet(name = "DameDatosSQL", urlPatterns = {"/DameDatosSQL"})
public class DameDatosSQL extends HttpServlet
{
    private ObtenerDatosSQL datosSQL;     //declaro mi variable de la clase que obtengo mis datos SQL
    private ArrayList<String> arrayDatos = new ArrayList();
    private Gson convertir = new Gson();
    private Persona personaParametro;
    private PrintWriter out;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        datosSQL = new ObtenerDatosSQL();   //instancio la clase
        
        response.getWriter().print(convertir.toJson(datosSQL.datos()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        out = response.getWriter();
        
        datosSQL = new ObtenerDatosSQL();   //instancio la clase
        
        try {
            String texto = request.getReader().readLine();

            personaParametro = convertir.fromJson(texto, Persona.class);
            personaParametro.validar();
            
            out.println(convertir.toJson(datosSQL.insertar(personaParametro)));
            
        } catch (ClassNotFoundException ex) {
            out.println("Verificar: " + ex.getMessage());
        } catch (SQLException ex) {
            out.println("Verificar:" + ex.getMessage());
        } catch (Exception ex) {
            out.println("Verificar:" + ex.getMessage());
        } finally {
            out.close();
        }
    }
}
