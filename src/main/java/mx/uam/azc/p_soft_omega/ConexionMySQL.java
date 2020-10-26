/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uam.azc.p_soft_omega;

import java.sql.*;

/**
 *
 * @author Santiago PG
 */
public class ConexionMySQL implements Conexion {
    
    Connection connection = null;

    /**
     * Abrir una conexion hacia la base de datos
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    @Override
    public void abrirConexion() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        // Se crea una cadena que almacena el JDBC URL
        String url = "jdbc:mysql://localhost:3306/usuario";
        String login = "usuariouser";
        String password = "usuariopassword";
        System.out.println("Abriendo conexion a MySQL");
        // Se carga el driver para la comunicacion entre jdbc y la base de
        // datos.
        // En caso de error se lanza una excepcion
        Class.forName(driverClassName);
        System.out.println("Driver cargado.");

        // Se realiza la coneion con la base de datos.
        // En caso de error se lanza una excepcion
        connection = DriverManager.getConnection(url,login,password);
    }

    /**
     * Ejecutar una consulta SQL en la base de datos.
     * 
     * @throws SQLException
     */
    @Override
    public Cliente ejecutarQueryCliente(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet cursor = stmt.executeQuery(sql);

        int total = 0;
        Cliente usuarioNivelacion = new Cliente();
        try {
            while (cursor.next())
                total++;
        } finally {
            cursor.close();
        }

        if (total != 0) {
            cursor = stmt.executeQuery(sql);
            try {
                while (cursor.next()) {

                }
            } finally {
                cursor.close();
            }
        }
        stmt.close();
        System.out.println("Ejecutando consulta SQL en MySQL:" + sql);
        return usuarioNivelacion;
    }

    /**
     * Ejecutar una consulta SQL en la base de datos.
     * 
     * @throws SQLException
     */
    @Override
    public Pedido ejecutarQueryPedido(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet cursor = stmt.executeQuery(sql);

        int total = 0;
        Pedido usuarioNivelacion = new Pedido();
        try {
            while (cursor.next())
                total++;
        } finally {
            cursor.close();
        }

        if (total != 0) {
            cursor = stmt.executeQuery(sql);
            try {
                while (cursor.next()) {

                }
            } finally {
                cursor.close();
            }
        }
        stmt.close();
        System.out.println("Ejecutando consulta SQL en MySQL:" + sql);
        return usuarioNivelacion;
    }

    /**
     * Ejecutar una consulta SQL en la base de datos.
     * 
     * @throws SQLException
     */
    @Override
    public Producto ejecutarQueryProducto(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet cursor = stmt.executeQuery(sql);

        int total = 0;
        Producto usuarioNivelacion = new Producto();
        try {
            while (cursor.next())
                total++;
        } finally {
            cursor.close();
        }

        if (total != 0) {
            cursor = stmt.executeQuery(sql);
            try {
                while (cursor.next()) {

                }
            } finally {
                cursor.close();
            }
        }
        stmt.close();
        System.out.println("Ejecutando consulta SQL en MySQL:" + sql);
        return usuarioNivelacion;
    }

    /**
     * Ejecutar una peticion SQL en la base de datos
     */
    @Override
    public void ejecutarSQL(String sql) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);

        System.out.println("Ejecutando peticion SQL en MySQL: "+sql);
    }

    /**
     * Cerrar una conexion hacia la base de datos
     */
    @Override
    public void cerrarConexion() throws SQLException{
        // Se cierra la conexion con la base de datos.
        // En caso de error se lanza una excepcion
        connection.close();
        System.out.println("Cerrando conexion a MySQL");
    }

    /**
     * @see java.lang.Object#finalize()
     */
    protected void finalize() throws Throwable {
        try {
            cerrarConexion();
        } finally {
            super.finalize();
        }
    }
}
