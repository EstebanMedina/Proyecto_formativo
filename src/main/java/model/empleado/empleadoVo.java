package model.empleado;



public class empleadoVo {
    //EMPLEADO
    private int idEmpleado;
    private String nombreEmpleado; 
    private String apellidoEmpleado; 
    private String tipoDocumento; 
    private int documentoEmpleado; 
    private int telefonoEmpleado; 
	private boolean estadoEmpleado;

    //CARGO
    private String nombreCargo;
    private int sueldoCargo;

    //USUARIO
    private String userName;
    

    private int idUsuario;
    private int idCargo;
    public empleadoVo() {

	}
    public empleadoVo(int idEmpleado, String nombreEmpleado, String apellidoEmpleado,String tipoDocumento,int documentoEmpleado, int telefonoEmpleado,
    boolean estadoEmpleado,String nombreCargo,int sueldoCargo, String userName, int idUsuario, int idCargo) {
    this.idEmpleado = idEmpleado;
    this.nombreEmpleado = nombreEmpleado;
    this.apellidoEmpleado = apellidoEmpleado;
    this.tipoDocumento = tipoDocumento;
    this.documentoEmpleado = documentoEmpleado;
    this.telefonoEmpleado = telefonoEmpleado;
    this.estadoEmpleado = estadoEmpleado;
    this.nombreCargo = nombreCargo;
    this.sueldoCargo = sueldoCargo;
    this.userName = userName;
    this.idUsuario = idUsuario;
    this.idCargo = idCargo;
}
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }
    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }
    public String gettipoDocumento() {
        return tipoDocumento;
    }
    public void settipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public int getdocumentoEmpleado() {
        return documentoEmpleado;
    }
    public void setdocumentoEmpleado(int documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }
    public int gettelefonoEmpleado() {
        return telefonoEmpleado;
    }
    public void settelefonoEmpleado(int telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }
    public boolean getestadoEmpleado() {
        return estadoEmpleado;
    }
    public void setestadoEmpleado(boolean estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
    
    
    public String getNombreCargo() {
        return nombreCargo;
    }
    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
    public int getSueldoCargo() {
        return sueldoCargo;
    }
    public void setSueldoCargo(int sueldoCargo) {
        this.sueldoCargo = sueldoCargo;
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
    

}
