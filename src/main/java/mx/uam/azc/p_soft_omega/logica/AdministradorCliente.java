package mx.uam.azc.p_soft_omega.logica;

import java.io.IOException;
import java.sql.SQLException;
import mx.uam.azc.p_soft_omega.datos.Cliente;
import mx.uam.azc.p_soft_omega.servicios.Conexion;

/**
 *
 * @author Omega
 */
public class AdministradorCliente {
    
    /**
    * Conexion privada hacia la base de datos
    */
    private Conexion _conexion;

    /////////////////////////////////////////////
    // Constructores

    /**
     * Constructor publico
     * @param conexion A not-null Conexion a la base de datos
     */
    public AdministradorCliente(Conexion conexion) {
            _conexion = conexion;
    }

    /////////////////////////////////////////////
    // Metodos Publicos

    /**
    * Metodo que permite agregar un cliente a la base de datos
    * 
    * @param cliente A not-null instancia de DatosUsuario
    * @throws ValidationException 
    * @throws IOException 
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
    public void agregarCliente(Cliente cliente) throws ValidationException, IOException, ClassNotFoundException, SQLException {

        if (validarCliente(cliente)==false) {
            throw new ValidationException();
        }

        _conexion.abrirConexion();
        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("INSERT INTO cliente(clave_cliente,nombre_cliente,telefono_cliente,direccion_cliente) VALUES ('").
                    append(cliente.getClave()).append("','").
                    append(cliente.getNombre()).append("','").
                    append(cliente.getTelefono()).append("','").
                    append(cliente.getDireccion()).append("')");

            _conexion.ejecutarSQL(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }
    }

    /**
     * Metodo que permite buscar un cliente existente en la base de datos
     * y regresar su informacion
     * @param clave A not-null not-empty Identificador del cliente
     * @return Una instancia not-null posiblemente vacia de Cliente
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public Cliente buscarUsuario(String clave) throws IOException, ClassNotFoundException, SQLException {
        Cliente cliente = new Cliente();
        _conexion.abrirConexion();

        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("SELECT * FROM cliente ")
                    .append(" WHERE clave_cliente = '")
                    .append(clave).append("'");

            cliente = _conexion.ejecutarQueryCliente(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }

        return cliente;
    }

    ///////////////////////////////////////////////////
    // Metodos Privados

    /**
     * Validar los datos de un usuario antes de insertar o modificar
     * datos en la base.
     * @param usuario A not-null instancia de DatosUsuario
     * @return Un boleano que indica que los valores de DatosUsuario son validos
     */
    private boolean validarCliente(Cliente cliente) {
        if(cliente==null || cliente.getClave()==null || cliente.getNombre()==null ||
           cliente.getTelefono()==null || cliente.getDireccion()==null)
            return false;

        return true;
    }
    
}
