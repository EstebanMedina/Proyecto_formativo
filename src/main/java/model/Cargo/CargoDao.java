package model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class CargoDao {
    Connection con; 
    PreparedStatement ps; 
    ResultSet rs; 
    String sql=null;
    int fil;

    //Registrar
    public int registrar(CargoVo Cargo, String nombreCargo, int sueldoCargo) throws SQLException{
        sql="INSERT INTO Cargo(nombreCargo, sueldoCargo) values(?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, Cargo.getNombreCargo());
            ps.setInt(2, Cargo.getSueldoCargo());
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
public List<CargoVo> listar ()  throws SQLException{
    List<CargoVo> Cargo=new ArrayList<>();
    sql="SELECT * FROM Cargo";
        try {   
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CargoVo r=new CargoVo();  
                r.setIdCargo(rs.getInt("idCargo"));
                r.setNombreCargo(rs.getString("nombreCargo"));
                r.setSueldoCargo(rs.getInt("sueldoCargo"));
                Cargo.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) { 
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return Cargo;
}  
//Eliminar
public void eliminar(int idCargo) throws SQLException{
    sql="DELETE FROM Cargo WHERE idCargo="+idCargo;
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
public List<CargoVo> ListarCargo(int idCargo) throws SQLException{
    List<CargoVo> Cargo = new ArrayList<>();
    sql = "SELECT * FROM Cargo WHERE idCargo="+idCargo;
    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery(sql);
        while(rs.next()){
            CargoVo fil = new CargoVo();
            
            fil.setIdCargo(rs.getInt("idCargo"));
            fil.setNombreCargo(rs.getString("nombreCargo"));
            fil.setSueldoCargo(rs.getInt("sueldoCargo"));
            Cargo.add(fil);
        }
        ps.close();
        System.out.println("Consulta exitosa especifico");
    }catch(Exception e){
        System.out.println("La consulta no pudo ser ejecutado"+e.getMessage().toString());
    }
    finally{
        con.close();
    }
    return Cargo;
}
//Editar
public int editar(CargoVo Cargo)throws SQLException{
    sql="UPDATE Cargo SET  nombreCargo=?, sueldoCargo=? WHERE idCargo=?";
    try{
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        System.out.println(ps);
        ps.setString(1,Cargo.getNombreCargo());
        ps.setInt(2,Cargo.getSueldoCargo());
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
public int actualizar(CargoVo Cargo) throws SQLException{
    sql="UPDATE Cargo SET  nombreCargo=?, sueldoCargo=?, WHERE idCargo=?";
   try{
       con=Conexion.conectar();
       ps=con.prepareStatement(sql);
       System.out.println(ps);
       ps.setString(1,Cargo.getNombreCargo());
        ps.setInt(2,Cargo.getSueldoCargo());
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
