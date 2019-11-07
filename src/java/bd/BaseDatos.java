package bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import modelo.Propiedades;

/**
 *
 * @author carlosv
 */

public class BaseDatos {

    private Properties propiedades;
    private Statement query;
    private Connection conexion;
    private String url = "";



    public BaseDatos(Properties propiedades) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = propiedades.getProperty("controlador");
        Class.forName(controlador).newInstance();
        this.propiedades = propiedades;
    }
    
        public BaseDatos() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = "org.postgresql.Driver";
        Class.forName(controlador).newInstance();
    }



    public void conectar(String usuario, String clave, String servidor, String puerto, String basedatos) throws SQLException {

    String url = "jdbc:postgresql://"+servidor+":"+puerto+"/"+basedatos+"";
    conexion = java.sql.DriverManager.getConnection(url, usuario, clave);
    query = conexion.createStatement();
    }
    
    public Connection getConexion() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user",propiedades.getProperty("usuario"));
        props.setProperty("password",propiedades.getProperty("clave"));
        if(Propiedades.getInstancia().getPropiedades().getProperty("verLogJdbc").toUpperCase().equals("SI"))
            props.setProperty("loglevel","2");               
        return java.sql.DriverManager.getConnection(propiedades.getProperty("urlbd"),props);
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



public void ejecutar(Connection conexion, String sql) throws SQLException {
        Statement consulta = conexion.createStatement();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (consulta != null) {
                consulta.close();
            }
        }
    }

    public int actualizar(String sql) throws SQLException {
        int totalRegistros = 0;
        totalRegistros = query.executeUpdate(sql);
        return totalRegistros;
    }
    
        public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conexion.prepareStatement(sql);
    }

}

