package model.TipoConcepto;

public class TipoConceptoVo {
    private int idTipoConcepto;
    private String nombreTipoConcepto;

    public TipoConceptoVo(){

    }

    public TipoConceptoVo(int idTipoConcepto, String nombreTipoConcepto){
        this.idTipoConcepto = idTipoConcepto;
        this.nombreTipoConcepto = nombreTipoConcepto;
    }

    public int getIdTipoConcepto(){
        return idTipoConcepto;
    }

    public void setIdTipoConcepto(int idTipoConcepto){
        this.idTipoConcepto = idTipoConcepto;
    }

    public String getNombreTipoConcepto(){
        return nombreTipoConcepto;
    }

    public void setNombreTipoConcepto(String nombreTipoConcepto){
        this.nombreTipoConcepto = nombreTipoConcepto;
    }
}
