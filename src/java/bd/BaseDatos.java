package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import modelo.Propiedades;


/**
 *
 * @author carlosp
 */
 /*Descripcion: Clase de Base de datos donde de acuerdo a esta implementación se puede realizar por medio de dos llamados:
  * 1. Definiendo en cada clase DAO por medio de herencia la clase GestorBD.java
  * 2. Definiendo en cada clase DAO por medio de la clase Gestor que se encuentra en los paquetes del controlador
  */
public class BaseDatos {

    private Properties propiedades;
    
     /** Field description */
    private Connection conexion;

    /** Field description */
    private Statement query;

    /** Field description */
    private String url = "";

    public BaseDatos(Properties propiedades) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = propiedades.getProperty("controlador");
        Class.forName(controlador).newInstance();
        this.propiedades = propiedades;
    }

    public Connection getConexion() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user",propiedades.getProperty("usuario"));
        props.setProperty("password",propiedades.getProperty("clave"));
        if(Propiedades.getInstancia().getPropiedades().getProperty("verLogJdbc").toUpperCase().equals("SI"))
            props.setProperty("loglevel","2");               
        return java.sql.DriverManager.getConnection(propiedades.getProperty("urlbd"),props);
    }

     public BaseDatos() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String controlador = "org.postgresql.Driver";
        Class.forName(controlador).newInstance();
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
     //~--- methods ------------------------------------------------------------

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public int actualizar(String sql) throws SQLException {
        int totalRegistros = 0;

        totalRegistros = query.executeUpdate(sql);
        return totalRegistros;
    }

    /**
     * Method description
     *
     *
     * @param sql
     * @param colnames
     *
     * @return
     *
     * @throws SQLException
     */
    public int actualizar(String sql, String[] colnames) throws SQLException {
        int totalRegistros = 0;

        totalRegistros = query.executeUpdate(sql, colnames);
        return totalRegistros;
    }

    /**
     * Method description
     *
     *
     * @param usr
     * @param pwd
     *
     * @throws SQLException
     */
    public void conectar(String usr, String pwd) throws SQLException {

//      url = "jdbc:postgresql://" + SERVIDOR + ":" + PUERTO + "/" + BD;
      //url = "jdbc:postgresql://10.1.1.196:5430/dbsa";
      //url = "jdbc:postgresql://10.1.1.195:5432/dbcaf";
       // url = "jdbc:postgresql://10.1.1.197:6432/dbsa";

        //pruebas vieja
       url = "jdbc:postgresql://10.1.1.197:6432/dbsa";
      // url = "jdbc:postgresql://10.1.1.84:4489/dbsa";


        // url = "jdbc:postgresql://192.168.56.101:5432/dbcaf";
        conexion = java.sql.DriverManager.getConnection(url, usr, pwd);
//        AuditoriaRegistro.setActivo(true);
//        AuditoriaRegistro.setUltimaActualizacion(new Date(new java.util.Date().getTime()));
//        AuditoriaRegistro.setUsuarioActualiza(usr);
        query = conexion.createStatement();
    }

    /**
     * Method description
     *
     */
    public void desconectar() {
        if (query != null) {
            try {
                query.close();
            } catch (SQLException e) {}

            query = null;
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {}

            conexion = null;
        }
    }

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public ResultSet ejecutar(String sql) throws SQLException {
        return query.executeQuery(sql);
    }

    /**
     * Method description
     *
     *
     * @param sql
     *
     * @return
     *
     * @throws SQLException
     */
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conexion.prepareStatement(sql);
    }
}
