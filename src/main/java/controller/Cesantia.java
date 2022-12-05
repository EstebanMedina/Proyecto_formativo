package controller;

public abstract class Cesantia {
    public abstract double Cesantias(double SalarioBase, double DiasTrabajados);
    public abstract double Salud(double Salud);
    public abstract double Pension(double Pension);
    public abstract double Sena(double Sena);
    public abstract double SeguridadSocial(double SeguridadSocial);
    public abstract double ValorTotal(double SalarioBase,double ResultadoSalud,double resultadosCensatias,double ResultadoPension,double ResultadoSena,double ResultadoSeguridadSocial);
}
