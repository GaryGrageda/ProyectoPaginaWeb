package conexion;

/**
* Simple base class.
* Class Naming Conventions.
* attributes.
* methods.
* Encapsulation. ( getter and setters )
* Overriding. ( toString )
*/

public class Persona
{

    private String id,nombre,apellido,dni,dire_local,localidad,nombre_local,tel_linea,celular,email;
    private int clave_cliente;

    public Persona()
    {
        clave_cliente = (int)(Math.random() * 9999 + 0000);
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) throws Exception
    {
        if ( email.contains("@") )
        {
            this.email = email;
        } else {
            throw new Exception("Ponele Arroba al Email!!!!");
        }

    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public void setDire_local(String dire_local)
    {
        this.dire_local = dire_local;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    public void setTel_linea(String tel_linea)
    {
        this.tel_linea = tel_linea;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getDni()
    {
        return dni;
    }

    public String getDire_local()
    {
        return dire_local;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public String getNombre_local()
    {
        return nombre_local;
    }

    public void setNombre_local(String nombre_local)
    {
        this.nombre_local = nombre_local;
    }
    
    public String getTel_linea()
    {
        return tel_linea;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setClave_cliente(int clave_cliente)
    {
        this.clave_cliente = clave_cliente;
    }

    public int getClave_cliente()
    {
        return clave_cliente;
    }

    @Override
    public String toString()
    {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" 
                + apellido + ", dni=" + dni + ", dire_local=" + dire_local + 
                ", localidad=" + localidad + ", nombre_local="+nombre_local+
                ", tel_linea=" + tel_linea + ", celular=" + celular + 
                ", email=" + email + ", clave_cliente=" + clave_cliente + '}';
    }
    
    public void validar() throws Exception
    {
        this.setEmail( this.getEmail() );
    }
}