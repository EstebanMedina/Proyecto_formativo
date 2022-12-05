package model.Cargo;

public class CargoVo {
    private int idCargo;
    private String nombreCargo;
    private int sueldoCargo;

    public CargoVo(){

    }
    public CargoVo(int idCargo, String nombreCargo, int sueldoCargo){
        this.idCargo=idCargo;
        this.nombreCargo=nombreCargo;
        this.sueldoCargo=sueldoCargo;
    }
    public int getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
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
}
