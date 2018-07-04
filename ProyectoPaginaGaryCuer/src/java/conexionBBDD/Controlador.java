package conexionBBDD;

import java.sql.*;

/**
 * @author Gary
 */
public class Controlador
{
    private String url,usuario,clave;
    private Connection connec;

    public Controlador()
    {
        this.url = "jdbc:mysql://localhost/datosportacosmeticos";
    }

    //SETTERS
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }
    
    public Connection conectar()
    { // para usar este metodo primero debo darle un valor a los String "usuario" y "clave"
        try{
            this.connec = DriverManager.getConnection(url, usuario, clave); //me conecto a mi base de datos
        }catch(java.sql.SQLException ex)
            {
            System.out.println(ex);
            }catch(Exception ex)
                {
                    System.out.println(ex);
                }
        return this.connec; //me retorna la connecion a mi base de datos
    }
}
