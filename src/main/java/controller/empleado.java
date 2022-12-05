package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo.CargoDao;
import model.Cargo.CargoVo;
import model.Usuario.usuarioDao;
import model.Usuario.usuarioVo;
import model.empleado.empleadoDao;
import model.empleado.empleadoVo;

public class empleado  extends HttpServlet{
    empleadoVo r=new empleadoVo();
    empleadoDao rd=new empleadoDao();

    usuarioVo rv= new usuarioVo();
    usuarioDao rb=new usuarioDao();

    CargoVo xd=new CargoVo();
    CargoDao xx=new CargoDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "abrirFormulario":
                ConsultarCargo(req,resp);
                ConsultarUsuario(req,resp);
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


    private void ConsultarCargo(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List idCargo=xx.listar();
            req.setAttribute("idCargo", idCargo);
            System.out.println("Datos del cargo listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar el cargo del empleado"+e.getMessage().toString());
        }
    }


    private void ConsultarUsuario(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List idUsuario=rb.listar();
            req.setAttribute("idUsuario", idUsuario);
            System.out.println("Datos de usuario listados correctamente");
        }catch (Exception e){
            System.out.println("Hay problemas al listar el rol del usuario"+e.getMessage().toString());
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
            req.getRequestDispatcher("views/empleado/Empleado.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

//agregar lo del formulario 
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreEmpleado")!=null){
            r.setNombreEmpleado(req.getParameter("nombreEmpleado"));
        }
        if(req.getParameter("apellidoEmpleado")!=null){
            r.setApellidoEmpleado(req.getParameter("apellidoEmpleado"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            r.settipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("documentoEmpleado")!=null){
            r.setdocumentoEmpleado(Integer.parseInt(req.getParameter("documentoEmpleado")));
        }
        if(req.getParameter("telefonoEmpleado")!=null){
            r.settelefonoEmpleado(Integer.parseInt(req.getParameter("telefonoEmpleado")));
        }
        if(req.getParameter("idUsuario")!=null){
            r.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        }
        if(req.getParameter("idCargo")!=null){
            r.setIdCargo(Integer.parseInt(req.getParameter("idCargo")));
        }
        if(req.getParameter("estadoEmpleado")!=null){
            r.setestadoEmpleado(true);
        }
        else{
            r.setestadoEmpleado(false);
        }
        System.out.println(r.getNombreEmpleado());
        System.out.println(r.getestadoEmpleado());
        try {
            rd.registra(r);
            System.out.println("Registro insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

 
//consultar las listas

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {

        List<empleadoVo> empleadoA = rd.listar();
        req.setAttribute("empleadoA", empleadoA);
        req.getRequestDispatcher("views/empleado/Listar.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}

private void Estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setIdEmpleado(Integer.parseInt(req.getParameter("id")));
    }
    if(req.getParameter("estado")!=null){
        r.setestadoEmpleado(Boolean.parseBoolean(req.getParameter("estado")));
    }
    try{
        rd.Estado(r.getestadoEmpleado(), r.getIdEmpleado());
        System.out.println("El estado se cambio correctamente");
        listar(req, resp);
    }catch(Exception e){
        System.out.println("Error en el cambio de estado"+e.getMessage().toString());
    }
}

private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("idEmpleado")!= null){
        r.setIdEmpleado(Integer.parseInt(req.getParameter("idEmpleado")));
    }
    try {
        rd.eliminar(r.getIdEmpleado());
        System.out.println("El estado se elimino correctamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" + e.getMessage().toString());
    }
}

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idEmpleado")!=null)
        r.setIdEmpleado(Integer.parseInt(req.getParameter("idEmpleado")));{
        }
        try{
            List<empleadoVo> empleadoA = rd.listarEmpleado(r.getIdEmpleado());
            req.setAttribute("listar", empleadoA);
            req.getRequestDispatcher("views/empleado/Editar.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch(Exception e){
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idEmpleado")!=null){
            r.setIdEmpleado(Integer.parseInt(req.getParameter("idEmpleado")));
        }
        if(req.getParameter("nombreEmpleado")!=null){
            r.setNombreEmpleado(req.getParameter("nombreEmpleado"));
        }
        if(req.getParameter("apellidoEmpleado")!=null){
            r.setApellidoEmpleado(req.getParameter("apellidoEmpleado"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            r.settipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("documentoEmpleado")!=null){
            r.setdocumentoEmpleado(Integer.parseInt(req.getParameter("documentoEmpleado")));
        }
        if(req.getParameter("telefonoEmpleado")!=null){
            r.settelefonoEmpleado(Integer.parseInt(req.getParameter("telefonoEmpleado")));
        }
        if(req.getParameter("estadoEmpleado")!=null){
            r.setestadoEmpleado(true);
        }
        else{
            r.setestadoEmpleado(false);
        }
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de empleado");
            listar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro del empeado"+e.getMessage().toString());
        }
    }


}