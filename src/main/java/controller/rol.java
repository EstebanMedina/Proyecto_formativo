package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Rol.rolDao;
import model.Rol.rolVo;

public class rol extends HttpServlet{
    
    rolVo rv=new rolVo();
    rolDao rb=new rolDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "abrirFormulario":
                abrirFormulario(req,resp);
            break;
            case "estado":
            Estado(req, resp);
            break;
            case "listar":
            listar(req,resp);
             break;
             case "eliminar":
             eliminar(req, resp);
             break;
             case "editar":
             editar(req, resp);
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
    private void abrirFormulario(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Rol/Rol.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

//agregar lo del formulario 
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreRol")!=null){
            rv.setNombreRol(req.getParameter("nombreRol"));
        }
        if(req.getParameter("estadoRol")!=null){
            rv.setEstadoRol(true);
        }
        else{
            rv.setEstadoRol(false);
        }
        try {
            rb.registra(rv);
            System.out.println("Registro insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

 
//consultar las listas

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {

        List<rolVo> rolA = rb.listar();
        req.setAttribute("listar", rolA);
        req.getRequestDispatcher("views/Rol/Listar.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}
private void Estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        rv.setIdRol(Integer.parseInt(req.getParameter("id")));
    }
    if(req.getParameter("estado")!=null){
        rv.setEstadoRol(Boolean.parseBoolean(req.getParameter("estado")));
    }
    try{
        rb.Estado(rv.isEstadoRol(), rv.getIdRol());
        System.out.println("El estado se cambio correctamente");
        listar(req, resp);
    }catch(Exception e){
        System.out.println("Error en el cambio de estado"+e.getMessage().toString());
    }
}

private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("idRol")!= null){
        rv.setIdRol(Integer.parseInt(req.getParameter("idRol")));
    }
    try {
        rb.eliminar(rv.getIdRol());
        System.out.println("El estado se elimino correctamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" + e.getMessage().toString());
    }
}

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idRol")!=null)
        rv.setIdRol(Integer.parseInt(req.getParameter("idRol")));{
        }
        try{
            List<rolVo> rolA = rb.listarRol(rv.getIdRol());
            req.setAttribute("listar", rolA);
            req.getRequestDispatcher("views/Rol/Editar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch(Exception e){
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idRol")!=null){
            rv.setIdRol(Integer.parseInt(req.getParameter("idRol")));
        }
        if(req.getParameter("nombreRol")!=null){
            rv.setNombreRol(req.getParameter("nombreRol"));
        }
        if(req.getParameter("estadoRol")!=null){
            rv.setEstadoRol(true);
        }   
        else{
            rv.setEstadoRol(false);
        }
        try{
            rb.actualizar(rv);
            System.out.println("Editar el registro de genero");
            listar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro de genero"+e.getMessage().toString());
        }
    }


}
