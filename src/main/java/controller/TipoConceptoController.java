package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TipoConcepto.TipoConceptoDao;
import model.TipoConcepto.TipoConceptoVo;



public class TipoConceptoController extends HttpServlet{
    
    TipoConceptoVo rv=new TipoConceptoVo();
    TipoConceptoDao rb=new TipoConceptoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "registrar":
            registrar(req, resp);
            break;
            case "visualizar":
            visualizar(req,resp);
            break;
            case "Eliminar":
            Eliminar(req, resp);
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
//el formulario------------------------------------------------------------------------

    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/TipoConcepto/RegistrarTipoConcepto.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

//agregar lo del formulario--------------------------------------------------------------
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreTipoConcepto")!=null){
            rv.setNombreTipoConcepto(req.getParameter("nombreTipoConcepto"));
        }
        try {
            rb.registra(rv);
            System.out.println("Registro insertado correctamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

 
//consultar las listas-----------------------------------------------------------

private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
    try {

        List<TipoConceptoVo> TipoConcepto = rb.listar();
        req.setAttribute("listar", TipoConcepto);
        req.getRequestDispatcher("views/TipoConcepto/ConsultarTipoConcepto.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}




    //eliminar
    private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
                rv.setIdTipoConcepto(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rb.eliminar(rv.getIdTipoConcepto());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
        }
     

    //Editar----------------------------------------------------------------------

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null)
        rv.setIdTipoConcepto(Integer.parseInt(req.getParameter("id")));{
        }
        try{
            List<TipoConceptoVo> TipoConcepto = rb.listarTipoConcepto(rv.getIdTipoConcepto());
            req.setAttribute("TipoConcepto", TipoConcepto);
            req.getRequestDispatcher("views/TipoConcepto/ActualizarTipoConcepto.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente para la edicion");
        } catch(Exception e){
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }
    }


    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            rv.setIdTipoConcepto(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("nombreTipoConcepto")!=null){
            rv.setNombreTipoConcepto(req.getParameter("nombreTipoConcepto"));
        }
        try{
            rb.actualizar(rv);
            System.out.println("Editar el registro de tipoconcepto");
            visualizar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro de tipoconcepto"+e.getMessage().toString());
        }
    }


}
