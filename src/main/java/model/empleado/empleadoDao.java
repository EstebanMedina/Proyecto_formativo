package model.empleado;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
public class empleadoDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;

       public int registra(empleadoVo empleado) throws SQLException{
        sql="CALL add_Empleado(?,?,?,?,?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, empleado.getNombreEmpleado());
            ps.setString(2, empleado.getApellidoEmpleado());
            ps.setString(3, empleado.gettipoDocumento());
            ps.setInt(4, empleado.getdocumentoEmpleado());
            ps.setInt(5, empleado.gettelefonoEmpleado());
            ps.setBoolean(6, empleado.getestadoEmpleado());
            ps.setInt(7, empleado.getIdCargo());
            ps.setInt(8, empleado.getIdUsuario());
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

    public List<empleadoVo> listar() throws SQLException{
        List<empleadoVo> empleado=new ArrayList<>();
        sql="SELECT Empleado.idEmpleado, Empleado.nombreEmpleado, Empleado.apellidoEmpleado, Empleado.documentoEmpleado, Empleado.telefonoEmpleado, Cargo.nombreCargo, Cargo.sueldoCargo, Empleado.estadoEmpleado,Usuario.username FROM Cargo INNER JOIN Empleado ON Cargo.idCargo=Empleado.idCargo INNER JOIN Usuario ON Usuario.idUsuario=Empleado.idUsuario;";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                empleadoVo fil=new empleadoVo ();
                fil.setIdEmpleado(rs.getInt("idEmpleado"));
                fil.setNombreEmpleado(rs.getString("nombreEmpleado"));
                fil.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                fil.setdocumentoEmpleado(rs.getInt("documentoEmpleado"));
                fil.settelefonoEmpleado(rs.getInt("telefonoEmpleado"));
                fil.setNombreCargo(rs.getString("nombreCargo"));
                fil.setSueldoCargo(rs.getInt("sueldoCargo"));
                fil.setUserName(rs.getString("username"));
                fil.setestadoEmpleado(rs.getBoolean("estadoEmpleado"));
                empleado.add(fil);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return empleado;
    }
    
    public void eliminar(int idEmpleado) throws SQLException{
        sql="DELETE FROM Empleado WHERE idEmpleado="+idEmpleado;
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

    public void Estado(boolean estado, int idEmpleado)throws SQLException {
        sql="UPDATE Empleado SET estadoEmpleado="+estado+" WHERE idEmpleado="+idEmpleado;
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
    public List<empleadoVo> listarEmpleado(int idEmpleado) throws SQLException{
        List<empleadoVo> empleado = new ArrayList<>();
        sql = "SELECT * FROM Empleado WHERE idEmpleado="+idEmpleado;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                empleadoVo fil = new empleadoVo();
                
                fil.setIdEmpleado(rs.getInt("idEmpleado"));
                fil.setNombreEmpleado(rs.getString("nombreEmpleado"));
                fil.setApellidoEmpleado(rs.getString("apellidoEmpleado"));
                fil.settipoDocumento(rs.getString("tipoDocumento"));
                fil.setdocumentoEmpleado(rs.getInt("documentoEmpleado"));
                fil.settelefonoEmpleado(rs.getInt("telefonoEmpleado"));
                fil.setestadoEmpleado(rs.getBoolean("estadoEmpleado"));
                empleado.add(fil);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return empleado;
    }

    public int editar(empleadoVo empleado)throws SQLException{
        sql="UPDATE Empleado SET  nombreEmpleado=?, apellidoEmpleado=?, tipoDocumento=?, documentoEmpleado=?, telefonoEmpleado=?, estadoEmpleado=?  WHERE idEmpleado=?";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1,empleado.getNombreEmpleado());
            ps.setString(2,empleado.getApellidoEmpleado());
            ps.setString(3,empleado.gettipoDocumento());
            ps.setInt(4,empleado.getdocumentoEmpleado());
            ps.setInt(5,empleado.gettelefonoEmpleado());
            ps.setBoolean(6,empleado.getestadoEmpleado());
            ps.setInt(7,empleado.getIdEmpleado());
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

   
    public int actualizar(empleadoVo empleado) throws SQLException{
        sql="UPDATE Empleado SET nombreEmpleado=?, apellidoEmpleado=?, tipoDocumento=?, documentoEmpleado=?, telefonoEmpleado=?, estadoEmpleado=?  WHERE idEmpleado=?";
       try{
           con=Conexion.conectar();
           ps=con.prepareStatement(sql);
           System.out.println(ps);
           ps.setString(1,empleado.getNombreEmpleado());
           ps.setString(2,empleado.getApellidoEmpleado());
           ps.setString(3,empleado.gettipoDocumento());
           ps.setInt(4,empleado.getdocumentoEmpleado());
           ps.setInt(5,empleado.gettelefonoEmpleado());
           ps.setBoolean(6,empleado.getestadoEmpleado());
           ps.setInt(7,empleado.getIdEmpleado());
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