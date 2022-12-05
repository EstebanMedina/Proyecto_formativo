package model.Concepto;

import java.sql.Date;

import controller.Cesantia;

public class ConceptoVo extends Cesantia {
    private int idConcepto;
    private int idEmpleado;
    private String nombreEmpleado;
    private int documentoEmpleado;
    private String nombreNovedad;
    private Date fechaNovedad;
    private int valorNovedad;
    private int diasNovedad;
    private int Cesantias;

    // Cesantias
    private int SalarioBase;
    private int SalarioBaseLista;
    private int DiasTrabajados;

    // Salud
    private int Salud;

    // Pension
    private int Pension;

    // Sena
    private int Sena;

    // Seguridad Social
    private int SeguridadSocial;

    //Valor Total
    private int ValorTotal;

    public ConceptoVo() {

    }

    public ConceptoVo(int documentoEmpleado, String nombreNovedad, Date fechaNovedad, int valorNovedad, int diasNovedad,
            int cesantias) {
        this.documentoEmpleado = documentoEmpleado;
        this.nombreNovedad = nombreNovedad;
        this.fechaNovedad = fechaNovedad;
        this.valorNovedad = valorNovedad;
        this.diasNovedad = diasNovedad;
        Cesantias = cesantias;
    }

    public ConceptoVo(int idConcepto, int idEmpleado, int idCargo, int salarioBase, int salarioBaseLista,
            int diasTrabajados, int salud, int pension, int sena, int seguridadSocial, int valorTotal, String nombreEmpleado) {
        this.idConcepto = idConcepto;
        this.idEmpleado = idEmpleado;
        SalarioBase = salarioBase;
        SalarioBaseLista = salarioBaseLista;
        DiasTrabajados = diasTrabajados;
        Salud = salud;
        Pension = pension;
        Sena = sena;
        SeguridadSocial = seguridadSocial;
        ValorTotal = valorTotal;
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getnombreEmpleado() {
        return nombreEmpleado;
    }

    public void setnombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        SalarioBase = salarioBase;
    }

    public int getSalarioBaseLista() {
        return SalarioBaseLista;
    }

    public void setSalarioBaseLista(int salarioBaseLista) {
        SalarioBaseLista = salarioBaseLista;
    }

    public int getDiasTrabajados() {
        return DiasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        DiasTrabajados = diasTrabajados;
    }

    public int getSalud() {
        return Salud;
    }

    public void setSalud(int salud) {
        Salud = salud;
    }

    public int getPension() {
        return Pension;
    }

    public void setPension(int pension) {
        Pension = pension;
    }

    public int getSena() {
        return Sena;
    }

    public void setSena(int sena) {
        Sena = sena;
    }

    public int getSeguridadSocial() {
        return SeguridadSocial;
    }

    public void setSeguridadSocial(int seguridadSocial) {
        SeguridadSocial = seguridadSocial;
    }

    public int getValorTotal(){
        return ValorTotal;
    }

    public void setValorTotal(int valorTotal){
        this.ValorTotal = valorTotal;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setDocumentoEmpleado(int documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public String getNombreNovedad() {
        return nombreNovedad;
    }

    public void setNombreNovedad(String nombreNovedad) {
        this.nombreNovedad = nombreNovedad;
    }

    public Date getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(Date fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    public int getValorNovedad() {
        return valorNovedad;
    }

    public void setValorNovedad(int valorNovedad) {
        this.valorNovedad = valorNovedad;
    }

    public int getDiasNovedad() {
        return diasNovedad;
    }

    public void setDiasNovedad(int diasNovedad) {
        this.diasNovedad = diasNovedad;
    }

    public int getCesantias() {
        return Cesantias;
    }

    public void setCesantias(int cesantias) {
        Cesantias = cesantias;
    }

    public double Cesantias(double SalarioBase, double DiasTrabajados) {
        System.out.println("El salario base es  " + SalarioBase + " y los dias trabajados son " + DiasTrabajados + "");
        double Cesantias = (SalarioBase * DiasTrabajados) / 360;
        System.out.println("Las cesantias son " + Cesantias + "");
        return Cesantias;
    }

    public double Salud(double SalarioBase) {
        System.out.println("El salario base es  " + Salud + "");
        double Cesantias = (SalarioBase * 0.04);
        System.out.println("La Salud son " + Cesantias + "");
        return Cesantias;
    }

    public double Pension(double SalarioBase) {
        System.out.println("El salario base es  " + Pension + "");
        double Cesantias = (SalarioBase * 0.04);
        System.out.println("La Pension es " + Cesantias + "");
        return Cesantias;
    }

    public double Sena(double SalarioBase) {
        System.out.println("El salario base es  " + Sena + "");
        double Cesantias = (SalarioBase * 0.02);
        System.out.println("El beneficio del sena es " + Cesantias + "");
        return Cesantias;
    }

    public double SeguridadSocial(double SalarioBase) {
        System.out.println("El salario base es  " + SeguridadSocial + "");
        double Cesantias = (SalarioBase * 0.07);
        System.out.println("La seguridad social es " + Cesantias + "");
        return Cesantias;
    }

    public double ValorTotal(double SalarioBase,double ResultadoSalud,double resultadosCensatias,double ResultadoPension,double ResultadoSena,double ResultadoSeguridadSocial){
        System.out.println("Salario base de " + SalarioBase+ "");
        System.out.println("Salud " + ResultadoSalud+ "");
        System.out.println("Cesantias " + resultadosCensatias+ "");
        System.out.println("Pension " + ResultadoPension+ "");
        System.out.println("Sena " + ResultadoSena+ "");
        System.out.println("Seguridad social " + ResultadoSeguridadSocial+ "");
        System.out.println("");
        double ValorTotal = (SalarioBase + ResultadoSalud + resultadosCensatias +ResultadoPension + ResultadoSena + ResultadoSeguridadSocial);
        System.out.println("El total de nomina es " + ValorTotal+ "");
        return ValorTotal;
    }

}
