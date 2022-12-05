package model.Usuario;

public class usuarioVo {
    private int idUsuario;
    private String username;
    private String pass;
    private Boolean estadoUsuario;
    private int sesion;


public usuarioVo(){
}
public usuarioVo(int idUsuario, String username, String pass, Boolean estadoUsuario, int sesion) {
    this.idUsuario = idUsuario;
    this.username = username;
    this.pass = pass;
    this.estadoUsuario = estadoUsuario;
    this.sesion = sesion;

}
public int getIdUsuario() {
    return idUsuario;
}
public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
}
public String getUserName() {
    return username;
}
public void setUserName(String username) {
    this.username = username;
}
public String getPass() {
    return pass;
}
public void setPass(String pass) {
    this.pass = pass;
}

public Boolean getEstadoUsuario() {
    return estadoUsuario;
}
public void setEstadoUsuario(Boolean estadoUsuario) {
    this.estadoUsuario = estadoUsuario;
}

public int getSesion(){
    return sesion;
}

public void setSesion(int sesion){
    this.sesion = sesion;
}

}
