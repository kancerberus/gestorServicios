package modelo;
        
public class Acceso {
    private String nom_acceso;
    private String ip_local;
    private String ip_externa;
    private String user_acceso;
    private String contraseña;
    
    //private String cod_acceso; Se elimina este atributo ya que se pone de forma automatica por bd.
    //también se elimina getter y setter
    
    private Empresa empresa;
    private SubEmpresa sub_empresa;
    
    //Constructor
    
    public Acceso(){
        
        empresa = new Empresa();
        sub_empresa = new SubEmpresa();
      
    }  
    
    //Getters y Setters
    
    
    public String getNom_acceso() {
        return nom_acceso;
    }

    public void setNom_acceso(String nom_acceso) {
        this.nom_acceso = nom_acceso;
    }

    public String getIp_local() {
        return ip_local;
    }

    public void setIp_local(String ip_local) {
        this.ip_local = ip_local;
    }

    public String getIp_externa() {
        return ip_externa;
    }

    public void setIp_externa(String ip_externa) {
        this.ip_externa = ip_externa;
    }

    public String getUser_acceso() {
        return user_acceso;
    }

    public void setUser_acceso(String user_acceso) {
        this.user_acceso = user_acceso;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public SubEmpresa getSub_empresa() {
        return sub_empresa;
    }

    public void setSub_empresa(SubEmpresa sub_empresa) {
        this.sub_empresa = sub_empresa;
        
    }

}
