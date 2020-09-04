package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author carlosv
 */

public class BaseDatos1 {

    private Statement query;
    private Connection conexion;



    public BaseDatos1() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = "org.postgresql.Driver";
        Class.forName(controlador).newInstance();
    }



    public void conectar(String usuario, String clave, String servidor, String puerto, String basedatos) throws SQLException {

    String url = "jdbc:postgresql://"+servidor+":"+puerto+"/"+basedatos+"";
    conexion = java.sql.DriverManager.getConnection(url, usuario, clave);
    query = conexion.createStatement();
    }

    public void desconectar() {
        if (query != null) {
            try {
                query.close();
            } catch (SQLException e) {
            }
           query = null;
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
            }
            conexion = null;
        }
    }

    

    public void abrirConexion(String usuario) throws SQLException {
        query = conexion.createStatement();
        query.executeUpdate("set role=" + usuario + ";");       
    }    



    public ResultSet ejecutar(String sql) throws SQLException {
        return query.executeQuery(sql);
    }



    public int actualizar(String sql) throws SQLException {
        int totalRegistros = 0;
        totalRegistros = query.executeUpdate(sql);
        return totalRegistros;
    }

}

