package model.Rol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class rolDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;

       public int registra(rolVo rol) throws SQLException{
        sql="INSERT INTO Rol(nombreRol,estadoRol) values(?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, rol.getNombreRol());
            ps.setBoolean(2, rol.isEstadoRol());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registró el empleado correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }


    public List<rolVo> listar() throws SQLException{
        List<rolVo> rol=new ArrayList<>();
        sql="SELECT *from Rol";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                rolVo fil=new rolVo ();
                fil.setIdRol(rs.getInt("idRol"));
                fil.setEstadoRol(rs.getBoolean("estadoRol"));
                fil.setNombreRol(rs.getString("nombreRol"));
                fil.isEstadoRol();
                rol.add(fil);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return rol;
    }
    
    public void eliminar(int idRol) throws SQLException{
        sql="DELETE FROM Rol WHERE idRol="+idRol;
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

    public void Estado(boolean estadoRol, int idRol)throws SQLException {
        sql="UPDATE Rol SET estadoRol="+estadoRol+" WHERE idRol="+idRol;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("estado modificado con exito");
            
        }catch(Exception e){
            System.out.println("Error al modificar el estado "+e.getMessage().toString());
        }

        finally{
            con.close();
        }
    }
    public List<rolVo> listarRol(int idRol) throws SQLException{
        List<rolVo> rol = new ArrayList<>();
        sql = "SELECT * FROM Rol WHERE idRol="+idRol;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                rolVo fil = new rolVo();
                
                fil.setIdRol(rs.getInt("idRol"));
                fil.setNombreRol(rs.getString("nombreRol"));
                fil.setEstadoRol(rs.getBoolean("estadoRol"));
                rol.add(fil);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return rol;
    }

    public int editar(rolVo rol)throws SQLException{
        sql="UPDATE Rol SET  nombreRol=?, estadoRol=?  WHERE idRol=?";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1,rol.getNombreRol());
            ps.setBoolean(2,rol.isEstadoRol());
            ps.setInt(3,rol.getIdRol());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se edito al empleado correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return fil;
    }

   
    public int actualizar(rolVo rol) throws SQLException{
        sql="UPDATE Rol SET nombreRol=?, estadoRol=?  WHERE idRol=?";
       try{
           con=Conexion.conectar();
           ps=con.prepareStatement(sql);
           System.out.println(ps);
           ps.setString(1,rol.getNombreRol());
           ps.setBoolean(2,rol.isEstadoRol());
           ps.setInt(3,rol.getIdRol());
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
