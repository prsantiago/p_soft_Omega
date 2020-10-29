/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.p_soft_omega.servicios;

import mx.uam.azc.p_soft_omega.datos.Producto;
import mx.uam.azc.p_soft_omega.datos.Pedido;
import mx.uam.azc.p_soft_omega.datos.Cliente;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Santiago PG
 */
public interface Conexion {
    
    Connection connection = null;
	
    /**
     * Abrir una conexion hacia la base de datos
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public abstract void abrirConexion() throws ClassNotFoundException, SQLException;

    /**
     * Ejecutar una consulta SQL en la base de datos
     * 
     * @return
     * 
     * @throws SQLException
     */
    public abstract Cliente ejecutarQueryCliente(String sql) throws SQLException;
    
    /**
     * Ejecutar una consulta SQL en la base de datos
     * 
     * @return
     * 
     * @throws SQLException
     */
    public abstract Pedido ejecutarQueryPedido(String sql) throws SQLException;
    
    /**
     * Ejecutar una consulta SQL en la base de datos
     * 
     * @return
     * 
     * @throws SQLException
     */
    public abstract Producto ejecutarQueryProducto(String sql) throws SQLException;

    /**
     * Ejecutar una peticion SQL en la base de datos
     * @param sql A not-empty not-null String que contiene la instruccion a ejecutar
     */
    public abstract void ejecutarSQL(String sql) throws SQLException;

    /**
     * Cerrar una conexion hacia la base de datos
     */
    public abstract void cerrarConexion() throws SQLException;
    
}
