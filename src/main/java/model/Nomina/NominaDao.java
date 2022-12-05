package model.Nomina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class NominaDao {
  Connection con; //objeto de  conexion
  PreparedStatement ps; //Objeto para sentencias preparadas
  ResultSet rs; //objeto para almacenar consultas
  String sql=null; //variable para guardar sentencias   
  int r;

  

    //Registrar Nomina
    public int registrar (NominaVo nomina, int ResultadoTotal) throws SQLException{

        sql="CALL add_Nomina(?,?,?,?,?,?,?)";
        try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        ps.setString(1, nomina.getFechaNomina());
        ps.setString(2, nomina.getNombreNovedad());
        ps.setString(3, nomina.getFechaNovedad());
        ps.setInt(4, ResultadoTotal);
        ps.setInt(5, nomina.getDiasNovedad());
        ps.setBoolean(6, nomina.getEstadoNovedad());
        ps.setString(7, nomina.getTipoNovedad());


           System.out.println(sql);
           ps.executeUpdate();
           ps.close();
           System.out.println("Registro exitoso");
        } catch (Exception e) {
            System.out.println("Error en el registro"+e.getMessage().toString());
            
        }
        finally{
            con.close();
        }
        return r;
    }

    //Listar Nomina
    public List<NominaVo> listar ()  throws SQLException{
        List<NominaVo> nomina=new ArrayList<>();
        sql="SELECT Nomina.idNomina, Novedad.idNovedad, Novedad.nombreNovedad, Novedad.valorNovedad, Novedad.diasNovedad, Novedad.estadoNovedad, Novedad.tipoNovedad FROM Novedad INNER JOIN Nomina ON Novedad.idNovedad=Nomina.idNomina WHERE Nomina.idNomina" ;
        try {
                con=Conexion.conectar();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery(sql);
                while(rs.next()){
                    NominaVo r=new NominaVo();  
                    r.setIdNomina(rs.getInt("idNomina"));
                    r.setIdNovedad(rs.getInt("idNovedad"));
                    r.setNombreNovedad(rs.getString("nombreNovedad"));
                    r.setValorNovedad(rs.getInt("valorNovedad"));
                    r.setDiasNovedad(rs.getInt("diasNovedad"));
                    r.setEstadoNovedad(rs.getBoolean("estadoNovedad"));
                    r.setTipoNovedad(rs.getString("tipoNovedad"));
                    nomina.add(r);
                }
    
                ps.close();
                System.out.println("consulta exitosa");
            } catch (Exception e) { 
                System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
            }
            finally{
                con.close();
            }
    
            return nomina;
        }
        //Listar empleado


        public void eliminar(int idNomina) throws SQLException{
            sql="DELETE FROM Nomina WHERE idNomina="+idNomina;
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

        //Listar Nomina
        public List<NominaVo> ListarNomina(int idNomina) throws SQLException{
            List<NominaVo> nomina=new ArrayList<>();
            sql="SELECT Nomina.idNomina, Novedad.idNovedad, Novedad.nombreNovedad, Novedad.valorNovedad, Novedad.diasNovedad, Novedad.estadoNovedad, Novedad.tipoNovedad FROM Novedad INNER JOIN Nomina ON Novedad.idNovedad=Nomina.idNomina WHERE Nomina.idNomina = "+ idNomina;
            try {
                con=Conexion.conectar();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery(sql);
                while(rs.next()){
                    NominaVo filas=new NominaVo();
                    filas.setIdNomina(rs.getInt("idNomina"));
                    filas.setIdNovedad(rs.getInt("idNovedad"));
                    filas.setNombreNovedad(rs.getString("nombreNovedad"));
                    filas.setValorNovedad(rs.getInt("valorNovedad"));
                    filas.setDiasNovedad(rs.getInt("diasNovedad"));
                    filas.setEstadoNovedad(rs.getBoolean("estadoNovedad"));
                    filas.setTipoNovedad(rs.getString("tipoNovedad"));
                    nomina.add(filas);
                }
                ps.close();
                System.out.println("consulta exitosa a nomina especifico");
            } catch (Exception e) {
                System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
            }
            finally{
                con.close();
            }
            return nomina;
        }


        //Editar Nomina
    public int editar(NominaVo nomina)throws SQLException{
        sql="CALL edit_Nomina(?,?,?,?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1, nomina.getIdNomina());
            ps.setInt(2, nomina.getIdNovedad());
            ps.setString(3, nomina.getNombreNovedad());
            ps.setInt(4, nomina.getValorNovedad());
            ps.setInt(5, nomina.getDiasNovedad());
            ps.setBoolean(6,nomina.getEstadoNovedad());
            ps.setString(7, nomina.getTipoNovedad());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close(); 
            System.out.println("Se edito la nomina correctamente");

            
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
        return r;
    }
            //Actualizar nomina(Horas extra)
            public int actualizarNomina(int idNomina, int horasExtra)throws SQLException{
                sql="UPDATE Concepto SET valorTotal ="+ horasExtra +" WHERE idConcepto = "+idNomina;
                try{
                    con=Conexion.conectar(); 
                    ps=con.prepareStatement(sql);
                    System.out.println(ps);
                    ps.executeUpdate();
                    ps.close(); 
                    System.out.println("Se Actualizo la nomina correctamente");
        
                    
                }catch(Exception e){
                    System.out.println("Error al editar "+e.getMessage().toString());
                }
        
                finally{
                    con.close();
                }
                return r;
            }
        

            
        //Actualizar Nomina
        public int actualizar(NominaVo nomina) throws SQLException{
            sql="CALL edit_Nomina(?,?,?,?,?,?,?)";
            try{
                con=Conexion.conectar(); 
                ps=con.prepareStatement(sql);
                System.out.println(ps);
                ps.setInt(1, nomina.getIdNomina());
                ps.setInt(2, nomina.getIdNovedad());
                ps.setString(3, nomina.getNombreNovedad());
                ps.setInt(4, nomina.getValorNovedad());
                ps.setInt(5, nomina.getDiasNovedad());
                ps.setBoolean(6,nomina.getEstadoNovedad());
                ps.setString(7, nomina.getTipoNovedad());
                System.out.println(ps);
                ps.executeUpdate();
                ps.close(); 
                System.out.println("Se edito la nomina correctamente :D");
    
                
            }catch(Exception e){
                System.out.println("Error al editar "+e.getMessage().toString());
            }
    
            finally{
                con.close();
            }
            return r;
        }
}

