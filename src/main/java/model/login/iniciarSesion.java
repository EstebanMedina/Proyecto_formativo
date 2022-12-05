package model.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class iniciarSesion {

    String driver;
     String url;
     String uss;
     String contra;

     public iniciarSesion(){
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/nomina";
        uss = "root";
        contra= "";
     }

     public int loguear(String us, String pass){
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        int sesion = 0; 
        String sql= "select sesion from usuario where username='"+us+"' and pass='"+pass+"'";
        try{
            Class.forName(this.driver);
            conn = DriverManager.getConnection(
                this.url, 
                this.uss, 
                this.contra
                );
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                sesion = rs.getInt(1);
            }
            conn.close();
        }catch(ClassNotFoundException | SQLException e){
        }
        return sesion;
     }

    
}
