package model.TipoConcepto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
public class TipoConceptoDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;

    //Registrar----------------------------------------------------------------

       public int registra(TipoConceptoVo TipoConcepto) throws SQLException{
        sql="INSERT INTO TipoConcepto(nombreTipoConcepto) values(?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, TipoConcepto.getNombreTipoConcepto());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el tipoconcepto correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }

    //Listar----------------------------------------------------------------
    
    public List<TipoConceptoVo> listar() throws SQLException{
        List<TipoConceptoVo> TipoConcepto=new ArrayList<>();
        sql="SELECT * FROM TipoConcepto";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                TipoConceptoVo fil=new TipoConceptoVo ();
                fil.setIdTipoConcepto(rs.getInt("idTipoConcepto"));
                fil.setNombreTipoConcepto(rs.getString("nombreTipoConcepto"));
                TipoConcepto.add(fil);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return TipoConcepto;
    }
    


    public List<TipoConceptoVo> listarTipoConcepto(int idTipoConcepto) throws SQLException{
        List<TipoConceptoVo> TipoConcepto = new ArrayList<>();
        sql = "SELECT * FROM TipoConcepto WHERE idTipoConcepto="+idTipoConcepto;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                TipoConceptoVo fil = new TipoConceptoVo();
                
                fil.setIdTipoConcepto(rs.getInt("idTipoConcepto"));
                fil.setNombreTipoConcepto(rs.getString("nombreTipoConcepto"));
                TipoConcepto.add(fil);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return TipoConcepto;
    }


        //Eliminar-------------------------------------------------

        public void eliminar(int idTipoConcepto) throws SQLException{
            sql="DELETE FROM TipoConcepto WHERE idTipoConcepto="+idTipoConcepto;
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

    //Editar----------------------------------------------------------------

    public int editar(TipoConceptoVo TipoConcepto)throws SQLException{
        sql="UPDATE TipoConcepto SET  nombreTipoConcepto=? WHERE idTipoConcepto=?";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, TipoConcepto.getNombreTipoConcepto());
            ps.setInt(2,TipoConcepto.getIdTipoConcepto());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito al tipoconcepto correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }

    //Actualizar----------------------------------------------------------------
   
    public int actualizar(TipoConceptoVo TipoConcepto) throws SQLException{
        sql="UPDATE TipoConcepto SET nombreTipoConcepto=?  WHERE idTipoConcepto=?";
       try{
           con=Conexion.conectar();
           ps=con.prepareStatement(sql);
           System.out.println(ps);
           ps.setString(1, TipoConcepto.getNombreTipoConcepto());
           ps.setInt(2,TipoConcepto.getIdTipoConcepto());
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
