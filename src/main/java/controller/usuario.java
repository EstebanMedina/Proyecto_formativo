package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rol.rolDao;
import model.Rol.rolVo;
import model.Usuario.usuarioDao;
import model.Usuario.usuarioVo;

public class usuario extends HttpServlet{
    usuarioVo r=new usuarioVo();
    usuarioDao rd=new usuarioDao();

    rolVo rv=new rolVo();
    rolDao rb=new rolDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "Formulario":
            consultarRol(req,resp);
            Formulario(req,resp);
            break;
            case "Listar":
            Listar(req,resp);
             break;
             case "Eliminar":
             Eliminar(req, resp);
             break;
             case "estado":
            Estado(req, resp);
            break;
            case "Editar":
             Editar(req, resp);
             break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "add":
                add(req,resp);
            break; 
            case "edit":
            edit(req, resp);
            break;
                
        }
    }

    //el formulario 
    private void Formulario(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Usuario/RegistrarUsuario.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void consultarRol(HttpServletRequest req, HttpServletResponse resp){
        try {
            List idRol=rb.listar();
            req.setAttribute("idRol", idRol);
            System.out.println("Datos de rol listados correctamente de rol");
        }catch (Exception e){
            System.out.println("Hay problemas al listar el rol del usuario"+e.getMessage().toString());
        }
    }

    private void Listar(HttpServletRequest req, HttpServletResponse resp) {
        try {

            List<usuarioVo> usuarioA = rd.listar();
            req.setAttribute("listar", usuarioA);
            req.getRequestDispatcher("views/Usuario/ConsultarUsuario.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }


    private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idUsuario")!= null){
            r.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        }
        try {
            rd.eliminar(r.getIdUsuario());
            System.out.println("El estado se elimino correctamente");
            Listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado" + e.getMessage().toString());
        }
    }

    private void Estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdUsuario(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("estado")!=null){
            r.setEstadoUsuario(Boolean.parseBoolean(req.getParameter("estado")));
        }
        try{
            rd.Estado(r.getEstadoUsuario(), r.getIdUsuario());
            System.out.println("El estado se cambio correctamente");
            Listar(req, resp);
        }catch(Exception e){
            System.out.println("Error en el cambio de estado"+e.getMessage().toString());
        }
    }
    

    private void Editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idUsuario")!=null)
        r.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));{
        }
        try{
            List<usuarioVo> usuarioA = rd.ListarUsuario(r.getIdUsuario());
            req.setAttribute("usuarioA", usuarioA);
            req.getRequestDispatcher("views/Usuario/ActualizarUsuario.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch(Exception e){
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }

    }


//agregar lo del formulario 
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("username")!=null){
            r.setUserName(req.getParameter("username"));
        }
        if(req.getParameter("pass")!=null){
            r.setPass(req.getParameter("pass"));
        }
        if(req.getParameter("estadoUsuario")!=null){
            r.setEstadoUsuario(true);
        }
        else{
            r.setEstadoUsuario(false);
        }
        if(req.getParameter("sesion")!=null){
            r.setSesion(Integer.parseInt(req.getParameter("sesion")));
        }
        try {
            rd.registra(r);
            System.out.println("Registro insertado correctamente");
            Listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
        
    }




    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idUsuario")!=null){
            r.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        }
        if(req.getParameter("username")!=null){
            r.setUserName(req.getParameter("username"));
        }
        if(req.getParameter("pass")!=null){
            r.setPass(req.getParameter("pass"));
        }

        if(req.getParameter("estadoUsuario")!=null){
            r.setEstadoUsuario(true);
        }
        else{
            r.setEstadoUsuario(false);
        }
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de usuario");
            Listar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro de usuario"+e.getMessage().toString());
        }
    }
}
