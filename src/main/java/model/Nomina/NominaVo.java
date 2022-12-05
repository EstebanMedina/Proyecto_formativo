package model.Nomina;


public class NominaVo {

         //Atributos
        //Datos de tabla Nomina
        private int idNomina;
        private String fechaNomina;
        private int idEmpleado;

        //Datos tabla Novedad
        private int idNovedad;
        private String nombreNovedad;
        private String fechaNovedad;
        private int valorNovedad;
        private int diasNovedad;
        private boolean estadoNovedad;
        private String tipoNovedad;

    //Metodo Constructor  vacio

    public void Nomina(){

    }

    //Metodo Constructor con parametros

    public void Nomina(String fechaNomina, int idEmpleado, int idNovedad, String nombreNovedad, String fechaNovedad, int valorNovedad, int diasNovedad, boolean estadoNovedad, String tipoNovedad, int idNomina){
        this.fechaNomina = fechaNomina;
        this.idEmpleado = idEmpleado;
        this.idNovedad = idNovedad;
        this.nombreNovedad = nombreNovedad;
        this.fechaNovedad = fechaNomina;
        this.valorNovedad = valorNovedad;
        this.diasNovedad = diasNovedad;
        this.estadoNovedad = estadoNovedad;
        this.idNomina = idNomina;
    }

    public int getIdNomina(){
        return idNomina;
    }

    public void setIdNomina(int idNomina){
        this.idNomina = idNomina;
    }

    public String getFechaNomina(){
        return fechaNomina;
    }

    public void setFechaNomina(String fechaNomina){
        this.fechaNomina = fechaNomina;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    public int getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(int idNovedad) {
        this.idNovedad = idNovedad;
    }
    
    public String getNombreNovedad(){
        return nombreNovedad;
    }

    public void setNombreNovedad(String nombreNovedad){
        this.nombreNovedad = nombreNovedad;
    }
    public String getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(String fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    public int getValorNovedad(){
        return valorNovedad;
    }

    public void setValorNovedad(int valorNovedad){
        this.valorNovedad = valorNovedad;
    }

    public int getDiasNovedad(){
        return diasNovedad;
    }

    public void setDiasNovedad(int diasNovedad){
        this.diasNovedad = diasNovedad;
    }

    public boolean getEstadoNovedad() {
        return estadoNovedad;
    }

    public void setEstadoNovedad(boolean estadoNovedad) {
        this.estadoNovedad = estadoNovedad;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }
}
