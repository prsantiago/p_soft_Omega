package mx.uam.azc.p_soft_omega.logica;

import java.io.IOException;
import java.sql.SQLException;
import mx.uam.azc.p_soft_omega.datos.Producto;
import mx.uam.azc.p_soft_omega.servicios.Conexion;

/**
 *
 * @author Omega
 */
public class AdministradorProducto {
    
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
    public AdministradorProducto(Conexion conexion) {
            _conexion = conexion;
    }

    /////////////////////////////////////////////
    // Metodos Publicos

    /**
     * Metodo que permite buscar un producto existente en la base de datos
     * y regresar su informacion
     * @param clave A not-null not-empty Identificador del producto
     * @return Una instancia not-null posiblemente vacia de Producto
     * @throws IOException 
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public Producto buscarProducto(String clave) throws IOException, ClassNotFoundException, SQLException {
        Producto producto = new Producto();
        _conexion.abrirConexion();

        try {
            StringBuffer buffer = new StringBuffer(40);

            buffer.append("SELECT * FROM producto ")
                    .append(" WHERE clave_producto = '")
                    .append(clave).append("'");

            producto = _conexion.ejecutarQueryProducto(buffer.toString());

        } finally {
            _conexion.cerrarConexion();
        }

        return producto;
    }
}
