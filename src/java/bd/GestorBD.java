/* * To change this template, choose Tools | Templates * and open the template in the editor. */package bd;import java.sql.ResultSet;/** * * @autor carlosv */public abstract class GestorBD {    protected BaseDatos bd;    protected ResultSet resultSet;    protected String sql;    private String usuario;    private String clave;    private String USUARIO = "postgres";    private String CLAVE = "1234";    private String servidor = "localhost";    private String puerto = "5432";    private String basedatos = "gestorServicios";        public GestorBD(String usuario, String clave, String servidor, String puerto, String basedatos) {        this.usuario = usuario;        this.clave = clave;        this.servidor = servidor;        this.puerto = puerto;        this.basedatos = basedatos;    }    public GestorBD(String servidor, String puerto, String basedatos) {        this.servidor = servidor;        this.puerto = puerto;        this.basedatos = basedatos;        this.usuario = USUARIO;        this.clave = CLAVE;        try {            bd = new BaseDatos();        } catch (Exception e) {            e.printStackTrace();        }    }    public GestorBD(String usuario, String clave) {        this.usuario = usuario;        this.clave = clave;        try {            bd = new BaseDatos();        } catch (Exception e) {            e.printStackTrace();        }    }    public GestorBD() {        this.usuario = USUARIO;        this.clave = CLAVE;        try {            bd = new BaseDatos();        } catch (Exception e) {            e.printStackTrace();        }    }    /**     * @return the usuario     */    public String getUsuario() {        return usuario;    }    /**     * @param usuario the usuario to set     */    public void setUsuario(String usuario) {        this.usuario = usuario;    }    /**     * @return the clave     */    public String getClave() {        return clave;    }    /**     * @param clave the clave to set     */    public void setClave(String clave) {        this.clave = clave;    }    /**     * @return the servidor     */    public String getServidor() {        return servidor;    }    /**     * @param servidor the servidor to set     */    public void setServidor(String servidor) {        this.servidor = servidor;    }    /**     * @return the puerto     */    public String getPuerto() {        return puerto;    }        /**     * @param puerto the puerto to set     */    public void setPuerto(String puerto) {        this.puerto = puerto;    }    /**     * @return the basedatos     */    public String getBasedatos() {        return basedatos;    }    /**     * @param basedatos the basedatos to set     */    public void setBasedatos(String basedatos) {        this.basedatos = basedatos;    }}