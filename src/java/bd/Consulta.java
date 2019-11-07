/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author carlosp
 */
 /*Descripcion: Clase generica para las utilidades de las consultas o transacciones del sistema
  * utilizado solo para las consultas que utilicen Gestor.java
  */
public class Consulta {

    private Statement query;

    public Consulta(Connection conexion) throws SQLException {
        query = conexion.createStatement();
    }

    public ResultSet ejecutar(String sql) throws SQLException {
        return query.executeQuery(sql);
    }
    
    public ResultSet ejecutar(StringBuilder sql) throws SQLException {
        return query.executeQuery(sql.toString());
    }

    public int actualizar(String sql) throws SQLException {
        return query.executeUpdate(sql);
    }
    
    public int actualizar(StringBuilder sql) throws SQLException {
        return query.executeUpdate(sql.toString());
    }

    public void desconectar() {
        if (query != null) {
            try {
                query.close();
            } catch (SQLException e) {
            }
            query = null;
        }
    }
}
