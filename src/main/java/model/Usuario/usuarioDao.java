package model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Conexion;

public class usuarioDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;

       public int registra(usuarioVo Usuario) throws SQLException{
        sql="INSERT INTO Usuario(username,pass,estadoUsuario,sesion) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, Usuario.getUserName());
            ps.setString(2, Usuario.getPass());
            ps.setBoolean(3, Usuario.getEstadoUsuario());
            ps.setInt(4, Usuario.getSesion());
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
    public List<usuarioVo> listar() throws SQLException{
        List<usuarioVo> usuario=new ArrayList<>();
        sql="SELECT * from Usuario" ;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); 
            rs=ps.executeQuery(sql);
            while(rs.next()){
                usuarioVo fil=new usuarioVo ();
                fil.setIdUsuario(rs.getInt("idUsuario"));
                fil.setUserName(rs.getString("username"));
                fil.setPass(rs.getString("pass"));
                fil.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
                fil.setSesion(rs.getInt("sesion"));
                usuario.add(fil);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usuario;
    }


    public List<usuarioVo> ListarUsuario(int idUsuario) throws SQLException{
        List<usuarioVo> usuario=new ArrayList<>();
        sql="SELECT * from Usuario WHERE idUsuario=" + idUsuario;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql); 
            rs=ps.executeQuery(sql);
            while(rs.next()){
                usuarioVo fil=new usuarioVo ();
                fil.setIdUsuario(rs.getInt("idUsuario"));
                fil.setUserName(rs.getString("username"));
                fil.setPass(rs.getString("pass"));
                fil.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
                usuario.add(fil);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usuario;
    }



    public void eliminar(int idUsuario) throws SQLException{
        sql="DELETE FROM Usuario WHERE idUsuario="+idUsuario;
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
    public void Estado(boolean estadoUsuario, int idUsuario)throws SQLException {
        sql="UPDATE Usuario SET estadoUsuario="+estadoUsuario+" WHERE idUsuario="+idUsuario;
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
    public int editar(usuarioVo usuario)throws SQLException{
        sql="UPDATE Usuario SET  username=?, pass=?, estadoUsuario=?  WHERE idUsuario=?";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1,usuario.getUserName());
            ps.setString(2,usuario.getPass());
            ps.setBoolean(3,usuario.getEstadoUsuario());
            ps.setInt(4,usuario.getIdUsuario());


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
    public int actualizar(usuarioVo usuario) throws SQLException{
        sql="UPDATE Usuario SET  username=?, pass=?, estadoUsuario=?  WHERE idUsuario=?";
       try{
           con=Conexion.conectar();
           ps=con.prepareStatement(sql);
           System.out.println(ps);
           ps.setString(1,usuario.getUserName());
           ps.setString(2,usuario.getPass());
           ps.setBoolean(3,usuario.getEstadoUsuario());
           ps.setInt(4,usuario.getIdUsuario());
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

