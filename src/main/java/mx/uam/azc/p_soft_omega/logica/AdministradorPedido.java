package mx.uam.azc.p_soft_omega.logica;

import java.io.IOException;
import java.sql.SQLException;
import mx.uam.azc.p_soft_omega.datos.Pedido;
import mx.uam.azc.p_soft_omega.servicios.Conexion;

/**
 *
 * @author Omega
 */
public class AdministradorPedido {
    
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
    public AdministradorPedido(Conexion conexion) {
           _conexion = conexion;
    }

    /////////////////////////////////////////////
    // Metodos Publicos

    /**
    * Metodo que permite agregar un usuario a la base de datos
    * 
    * @param usuario A not-null instancia de DatosUsuario
    * @throws ValidationException 
    * @throws IOException 
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
    public void agregarPedido(Pedido pedido) throws ValidationException, IOException, ClassNotFoundException, SQLException {

        if (validarPedido(pedido)==false) {
            throw new ValidationException();
        }

        _conexion.abrirConexion();
        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("INSERT INTO pedido"+"(clave_pedido,claveCliente_pedido,claveProducto_pedido,cantidadProducto_pedido,total_pedido) "
                                     +"VALUES ('").
                    append(pedido.getClave()).append("','").
                    append(pedido.getClaveCliente()).append("','").
                    append(pedido.getClaveProducto(0)).append("','").
                    append(pedido.getCantidadProducto(0)).append("','").
                    append(pedido.getTotal()).append("')");

            _conexion.ejecutarSQL(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }	
    }

    /**
    * Metodo que permite modificar un pedido existente en la base de datos
    * @param usuario A not-null instancia de Pedido
    * @throws ValidationException 
    * @throws IOException 
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
    public void modificarPedido(Pedido pedido) throws ValidationException, IOException, ClassNotFoundException, SQLException {
        if (validarPedido(pedido)==false) {
            throw new ValidationException();
        }

        _conexion.abrirConexion();
        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("UPDATE pedido SET ")
                    .append("claveCliente_pedido = ").append(pedido.getClaveCliente())
                    .append(", claveProducto_pedido ").append(pedido.getClaveProducto(0))
                    .append(", cantidadProducto_pedido = ").append(pedido.getCantidadProducto(0))
                    .append(", total_pedido = ").append(pedido.getTotal())
                    .append("' WHERE clave_pedido = '").append(pedido.getClave())
                    .append("'");

            _conexion.ejecutarSQL(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }
    }

    /**
    * Metodo que permite borrar un pedido existente en la base de datos
    * @param clave A not-null not-empty Identificador del pedido
    * @throws IOException 
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
    public void borrarPedido(String clave) throws IOException, ClassNotFoundException, SQLException {
        _conexion.abrirConexion();
        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("DELETE FROM pedido WHERE clave_pedido = '")
                    .append(clave).append("'");

            _conexion.ejecutarSQL(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }
    }

    /**
    * Metodo que permite buscar un pedido existente en la base de datos
    * y regresar su informacion
    * @param clave A not-null not-empty Identificador del pedido
    * @return Una instancia not-null posiblemente vacia de Pedido
    * @throws IOException 
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
    public Pedido buscarPedido(String clave) throws IOException, ClassNotFoundException, SQLException {
        Pedido pedido = new Pedido();
        _conexion.abrirConexion();

        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("SELECT * FROM pedido ")
                    .append(" WHERE clave_pedido = '")
                    .append(clave).append("'");

            pedido = _conexion.ejecutarQueryPedido(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }

        return pedido;
    }

    ///////////////////////////////////////////////////
    // Metodos Privados

    /**
    * Validar los datos de un pedido antes de insertar o modificar
    * datos en la base.
    * @param pedido A not-null instancia de Pedido
    * @return Un boleano que indica que los valores de Pedido son validos
    */
    private boolean validarPedido(Pedido pedido) {
        if(pedido==null || pedido.getClave()==null || pedido.getClaveCliente()==null ||
           pedido.getTotal() <= 0)
            return false;

        for (int i=0; i<5; ++i) {
            if(pedido.getClaveProducto(i) == null || 
               pedido.getCantidadProducto(i) <= 0)
                return false;
        }

        return true;
    }
}
