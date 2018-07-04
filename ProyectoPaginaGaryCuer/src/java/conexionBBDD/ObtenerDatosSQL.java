package conexionBBDD;

import conexion.Persona;
import java.sql.*;
import java.util.ArrayList;

public class ObtenerDatosSQL
{
    private Controlador contr;
    private ResultSet result;
    private ResultSetMetaData resultMTDT;
    private PreparedStatement miSentencia;
    private ArrayList<String> arrayDatos;
    private final String comandoVerificarClave;
    private final String comandoInsertarCliente;
    private final String comandoMostrarNombreProducto;    

    public ObtenerDatosSQL()
    {
        this.contr = new Controlador();
        this.arrayDatos = new ArrayList();
        this.contr.setUsuario("root");
        this.contr.setClave("");
        this.comandoVerificarClave="SELECT clave_cliente FROM cliente";
        this.comandoInsertarCliente="INSERT INTO `cliente` "
            + "(`nombre`,`apellido`,`dni`,`direccion_local`,`localidad`,`telefono_linea`,`celular`,`correo`,`clave_cliente`)"
            + "values(?,?,?,?,?,?,?,?,?);";
        this.comandoMostrarNombreProducto="SELECT nombre FROM productos;";
    }
    
    public ArrayList datos()
    {
        try {
            //mi consulta preparada
            this.miSentencia= this.contr.conectar().prepareStatement("SELECT * FROM productos WHERE precio=?");
            this.miSentencia.setString(1, "50");
            
            //guardo los resultados en mi ResulSet
            this.result = this.miSentencia.executeQuery();
            
            //quiero saber cuantas columnas tiene mi tabla asi que con ResulSetMetaData
            //puedo usarlo en el for para que mi codigo sea dinamico
            this.resultMTDT = this.result.getMetaData();
            
                while(this.result.next())
                {
                    for(int i=0; i<this.resultMTDT.getColumnCount(); i++)
                    {
                        this.arrayDatos.add(result.getString(i+1));
                    }
                }
                
            this.contr.conectar().close();     //cierre de mi conexion
            
            }catch(java.sql.SQLException ex){
                System.out.println(ex);
            }catch(Exception ex) {
                System.out.println(ex);
                } 
        
        return this.arrayDatos;
    }
    
    
    public String insertar(Persona a)
    {
        //Variable string que usare para verificar si logre o no cargar los datos en mi BBDD
        //si no lo logré, el valor retornado sera este, en caso de tener exito seteare un ok dentro del try
        String validado="No se pudo validar, verifique: ";
        
        //llamo al metodo verificar para constatar que la clave que se me generó no se repita con las anteriores
        verificarClave(a);
        
        try {    
            //guardo en PreparedStatement "miSentencia" el comando que me inserta los datos a la tabla "clientes"
            this.miSentencia= this.contr.conectar().prepareStatement(comandoInsertarCliente);
            
            //y luego hago SETTER a los datos colocados en las casillas del formulario,
            //gracias a que estos ya se guardaron en la clase Persona
            this.miSentencia.setString(1, a.getNombre());
            this.miSentencia.setString(2, a.getApellido());
            this.miSentencia.setString(3, a.getDni());
            this.miSentencia.setString(4, a.getDire_local());
            this.miSentencia.setString(5, a.getLocalidad());
            this.miSentencia.setString(6, a.getTel_linea());
            this.miSentencia.setString(7, a.getCelular());
            this.miSentencia.setString(8, a.getEmail());
            
            //con respecto a la contraseña es un caso especial, se va a generar automaticamente con una clave numerica al azar
            //presedida antes por lo que el usuario haya colocado en la casilla apellido de tal forma que sea, ej: apellido-1234
            this.miSentencia.setString(9, a.getNombre_local()+"-"+a.getClave_cliente());
            
            //este metodo es clave para que funcione el comando y todo se logre guardar en la tabla cliente
            if(!this.miSentencia.execute())
            {
                validado="Ok esta validado";
            }
//            this.contr.conectar().createStatement().executeUpdate("INSERT INTO `cliente` "
//            + "(`id`,`nombre`,`apellido`,`dni`,`direccion_local`,`localidad`,`telefono_linea`,`celular`,`correo`,`clave_cliente`)"
//            + "values(NULL,'"+a.getNombre()+"','"+a.getApellido()+"','"+a.getDni()+"','"+a.getDire_local()+"','"+a.getLocalidad()+"',"
//            + "'"+a.getTel_linea()+"','"+a.getCelular()+"','"+a.getEmail()+"','"+a.getApellido()+"-"+a.getClave_cliente()+"');");

            this.contr.conectar().close();     //cierre de mi conexion
        
        } catch(java.sql.SQLException ex){
                System.out.println(ex);
            }catch(Exception ex) {
                System.out.println(ex);
                }
        return validado;
    }
    
    private void verificarClave(Persona a)
    {
        try {
            this.result = this.contr.conectar().createStatement().executeQuery(comandoVerificarClave);
            
            while(this.result.next())
            {
                if(result.getInt(1) == a.getClave_cliente())
                {
                 a.setClave_cliente((int)(Math.random() * 9999 + 0000));
                }
            }
            
        this.contr.conectar().close();     //cierre de mi conexion
        
        }catch(java.sql.SQLException ex){
                System.out.println(ex);
            }catch(Exception ex) {
                System.out.println(ex);
                } 
    }
    
    public ArrayList dameNombreProductos()
    {
     try {
            this.result = this.contr.conectar().createStatement().executeQuery(comandoMostrarNombreProducto);
            
            while(this.result.next())
            {
                arrayDatos.add(result.getString(1));
            }
            
        this.contr.conectar().close();     //cierre de mi conexion
        
        }catch(java.sql.SQLException ex){
                System.out.println(ex);
            }catch(Exception ex) {
                System.out.println(ex);
                }
     return arrayDatos;
    }
}
