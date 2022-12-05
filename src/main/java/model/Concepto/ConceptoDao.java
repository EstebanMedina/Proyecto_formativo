package model.Concepto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Conexion;

public class ConceptoDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;


        //Registrar
       public int registrar(ConceptoVo Concepto, Double Censantias,Double SaludR, Double PensionR, Double SenaR, Double SeguridadSocialR, Double ValorTotalR) throws SQLException{
        sql="INSERT INTO Concepto(SalarioBase,DiasTrabajados,Cesantias,Salud,Pension,Sena,SeguridadSocial,ValorTotal,idEmpleado) values(?,?,?,?,?,?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setDouble(1, Concepto.getSalarioBase());
            ps.setDouble(2, Concepto.getDiasTrabajados());
            ps.setDouble(3, Censantias);
            ps.setDouble(4, SaludR);
            ps.setDouble(5, PensionR);
            ps.setDouble(6, SenaR);
            ps.setDouble(7, SeguridadSocialR);
            ps.setDouble(8, ValorTotalR);
            ps.setInt(9, Concepto.getIdEmpleado());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el concepto correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }

        //Listar Nomina
        public List<ConceptoVo> listar ()  throws SQLException{
            List<ConceptoVo> Concepto=new ArrayList<>();
            sql="SELECT C.idConcepto,C.SalarioBase,C.Cesantias,C.DiasTrabajados,C.Salud,C.Pension,C.Sena,C.SeguridadSocial,C.ValorTotal,C.idEmpleado,E.nombreEmpleado FROM Concepto C INNER JOIN Empleado E ON C.idEmpleado = E.idEmpleado;";
                try {   
                    con=Conexion.conectar();
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery(sql);
                    while(rs.next()){
                        ConceptoVo r=new ConceptoVo();  
                        r.setIdConcepto(rs.getInt("idConcepto"));
                        r.setSalarioBase(rs.getInt("Cesantias"));
                        r.setSalarioBaseLista(rs.getInt("SalarioBase"));
                        r.setDiasTrabajados(rs.getInt("DiasTrabajados"));
                        r.setSalud(rs.getInt("Salud"));
                        r.setPension(rs.getInt("Pension"));
                        r.setSena(rs.getInt("Sena"));
                        r.setSeguridadSocial(rs.getInt("SeguridadSocial"));  
                        r.setValorTotal(rs.getInt("ValorTotal"));                         
                        r.setIdEmpleado(rs.getInt("idEmpleado"));
                        r.setnombreEmpleado(rs.getString("nombreEmpleado"));

                        Concepto.add(r);
                    }
        
                    ps.close();
                    System.out.println("consulta exitosa");
                } catch (Exception e) { 
                    System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
                }
                finally{
                    con.close();
                }
        
                return Concepto;
            }

                    //Listar Nomina
        public List<ConceptoVo> listarconceto(int idConcepto)  throws SQLException{
            List<ConceptoVo> Concepto=new ArrayList<>();
            sql="SELECT C.idConcepto,C.SalarioBase,C.Cesantias,C.DiasTrabajados,C.Salud,C.Pension,C.Sena,C.SeguridadSocial,C.ValorTotal,C.idEmpleado,E.nombreEmpleado FROM Concepto C INNER JOIN Empleado E ON C.idEmpleado = E.idEmpleado WHERE idConcepto = "+idConcepto ;
                try {   
                    con=Conexion.conectar();
                    ps=con.prepareStatement(sql);
                    rs=ps.executeQuery(sql);
                    while(rs.next()){
                        ConceptoVo r=new ConceptoVo();  
                        r.setIdConcepto(rs.getInt("idConcepto"));
                        r.setSalarioBase(rs.getInt("Cesantias"));
                        r.setSalarioBaseLista(rs.getInt("SalarioBase"));
                        r.setDiasTrabajados(rs.getInt("DiasTrabajados"));
                        r.setSalud(rs.getInt("Salud"));
                        r.setPension(rs.getInt("Pension"));
                        r.setSena(rs.getInt("Sena"));
                        r.setSeguridadSocial(rs.getInt("SeguridadSocial"));  
                        r.setValorTotal(rs.getInt("ValorTotal"));                         
                        r.setIdEmpleado(rs.getInt("idEmpleado"));
                        r.setnombreEmpleado(rs.getString("nombreEmpleado"));

                        Concepto.add(r);
                    }
        
                    ps.close();
                    System.out.println("consulta exitosa");
                } catch (Exception e) { 
                    System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
                }
                finally{
                    con.close();
                }
        
                return Concepto;
            }
        //Listar Empleado (horas extra y vacaciones)    
            public List<ConceptoVo> listarEmpleado(int idNomina) throws SQLException{
                List<ConceptoVo> Concepto=new ArrayList<>();
                sql="SELECT C.idConcepto,C.SalarioBase,C.Cesantias,C.DiasTrabajados,C.Salud,C.Pension,C.Sena,C.SeguridadSocial,C.ValorTotal,C.idEmpleado,E.nombreEmpleado FROM Concepto C INNER JOIN Empleado E ON C.idEmpleado = E.idEmpleado WHERE idConcepto =" + idNomina;
                    try {   
                        con=Conexion.conectar();
                        ps=con.prepareStatement(sql);
                        rs=ps.executeQuery(sql);
                        while(rs.next()){
                            ConceptoVo r=new ConceptoVo();  
                            r.setIdConcepto(rs.getInt("idConcepto"));
                            r.setSalarioBase(rs.getInt("Cesantias"));
                            r.setSalarioBaseLista(rs.getInt("SalarioBase"));
                            r.setDiasTrabajados(rs.getInt("DiasTrabajados"));
                            r.setSalud(rs.getInt("Salud"));
                            r.setPension(rs.getInt("Pension"));
                            r.setSena(rs.getInt("Sena"));
                            r.setSeguridadSocial(rs.getInt("SeguridadSocial"));  
                            r.setValorTotal(rs.getInt("ValorTotal"));                         
                            r.setIdEmpleado(rs.getInt("idEmpleado"));
                            r.setnombreEmpleado(rs.getString("nombreEmpleado"));
    
                            Concepto.add(r);
                        }
            
                        ps.close();
                        System.out.println("consulta exitosa");
                    } catch (Exception e) { 
                        System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
                    }
                    finally{
                        con.close();
                    }
            
                    return Concepto;
                }

    //Eliminar
    public void eliminar(int idConcepto) throws SQLException{
        sql="DELETE FROM Concepto WHERE idConcepto="+idConcepto;
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se elimino correctamente");
            
        }catch(Exception e){
            System.out.println("Error en la eliminación "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }
//Listar 
    public List<ConceptoVo> ListarConcepto(int idConcepto) throws SQLException{
        List<ConceptoVo> Concepto = new ArrayList<>();
        sql = "SELECT * FROM Concepto WHERE idConcepto="+idConcepto;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                ConceptoVo fil = new ConceptoVo();
                
                fil.setIdConcepto(rs.getInt("idConcepto"));
                fil.setSalarioBaseLista(rs.getInt("SalarioBase"));
                fil.setSalarioBase(rs.getInt("Cesantias"));
                fil.setDiasTrabajados(rs.getInt("DiasTrabajados"));
                fil.setSalud(rs.getInt("Salud"));
                fil.setPension(rs.getInt("Pension"));
                fil.setSena(rs.getInt("Sena"));
                fil.setSeguridadSocial(rs.getInt("SeguridadSocial"));
                fil.setValorTotal(rs.getInt("ValorTotal"));   
                fil.setIdEmpleado(rs.getInt("idEmpleado"));
                Concepto.add(fil);
            }
            ps.close();
            System.out.println("Consulta exitosa especifico");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return Concepto;
    }
    //Listar Resultados
    public List<ConceptoVo> ListarConceptos(int Censantias,int SaludR, int PensionR, int SenaR, int SeguridadSocialR, int ValorTotalR ) throws SQLException{
        List<ConceptoVo> Concepto = new ArrayList<>();
        sql = "SELECT * FROM Concepto";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                ConceptoVo fil = new ConceptoVo();
                
                fil.setIdConcepto(rs.getInt("idConcepto"));
                fil.setSalarioBaseLista(rs.getInt("SalarioBase"));
                fil.setSalarioBase(Censantias);
                fil.setSalud(SaludR);
                fil.setPension(PensionR);
                fil.setSena(SenaR);
                fil.setSeguridadSocial(SeguridadSocialR);
                fil.setValorTotal(ValorTotalR);
                fil.setIdEmpleado(rs.getInt("idEmpleado"));
                Concepto.add(fil);
            }
            ps.close();
            System.out.println("Consulta exitosa de concepto");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return Concepto;
    }
//Listar Resultados
public List<ConceptoVo> ListarNomina() throws SQLException{
    List<ConceptoVo> Concepto = new ArrayList<>();
    sql = "SELECT Empleado.nombreEmpleado, Empleado.documentoEmpleado, novedad.nombreNovedad, novedad.fechaNovedad, novedad.valorNovedad, novedad.diasNovedad, concepto.SalarioBase, concepto.Cesantias, concepto.DiasTrabajados, concepto.Salud, concepto.Pension, concepto.Sena, concepto.SeguridadSocial, concepto.Valortotal From concepto INNER JOIN novedad ON concepto.idConcepto = novedad.idConcepto INNER JOIN Empleado ON Empleado.idEmpleado=concepto.idEmpleado"; 
    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
        while(rs.next()){
            ConceptoVo fil = new ConceptoVo();
            
            fil.setnombreEmpleado(rs.getString("nombreEmpleado"));
            fil.setDocumentoEmpleado(rs.getInt("documentoEmpleado"));
            fil.setNombreNovedad(rs.getString("nombreNovedad"));
            fil.setFechaNovedad(rs.getDate("fechaNovedad"));
            fil.setValorNovedad(rs.getInt("valorNovedad"));
            fil.setDiasNovedad(rs.getInt("diasNovedad"));
            fil.setSalarioBase(rs.getInt("SalarioBase"));
            fil.setCesantias(rs.getInt("Cesantias"));
            fil.setDiasTrabajados(rs.getInt("DiasTrabajados"));
            fil.setSalud(rs.getInt("Salud"));
            fil.setPension(rs.getInt("Pension"));
            fil.setSena(rs.getInt("Sena"));
            fil.setSeguridadSocial(rs.getInt("SeguridadSocial"));
            fil.setValorTotal(rs.getInt("ValorTotal"));
            Concepto.add(fil);
        }
        ps.close();
        System.out.println("Consulta exitosa de concepto");
    }catch(Exception e){
        System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
    }
    finally{
        con.close();
    }
    return Concepto;
}
    

//Editar
    public int editar(ConceptoVo Concepto)throws SQLException{
        sql="UPDATE Concepto SET  SalarioBase=?, Cesantias=?, DiasTrabajados=?, Salud=?, Pension=?, Sena=?, SeguridadSocial=? , ValorTotal=? WHERE idConcepto=?";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1,Concepto.getSalarioBase());
            ps.setInt(2,Concepto.getDiasTrabajados());
            ps.setInt(3,Concepto.getSalud());
            ps.setInt(4,Concepto.getPension());
            ps.setInt(5,Concepto.getSena());
            ps.setInt(6,Concepto.getSeguridadSocial());
            ps.setInt(7,Concepto.getValorTotal());
            ps.setInt(8,Concepto.getIdConcepto());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito al Concepto correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }

    //Editar
    public int actualizar(ConceptoVo Concepto) throws SQLException{
        sql="UPDATE Concepto SET  SalarioBase=?, Cesantias=?, DiasTrabajados=?, Salud=?, Pension=?, Sena=?, SeguridadSocial=?, ValorTotal=? WHERE idConcepto=?";
       try{
           con=Conexion.conectar();
           ps=con.prepareStatement(sql);
           System.out.println(ps);
           ps.setDouble(1,Concepto.getSalarioBase());
            ps.setDouble(2,Concepto.getDiasTrabajados());
            ps.setInt(3,Concepto.getIdConcepto());
           System.out.println(ps);
           ps.executeUpdate();
           ps.close();
           System.out.println("se edito correctamente");
       } catch(Exception e){
           System.err.println("Error al editar"+e.getMessage().toString());
       }
       finally{
           con.close();
       }
       return fil;
    }
}

