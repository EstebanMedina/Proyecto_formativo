//Paquete de la clase
//Paquete Controller
package controller;

//Declaración de imports


import java.io.IOException;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Declaración de imports en clases
//Declaración de VO Y DAOS
import model.Nomina.NominaDao;
import model.Nomina.NominaVo;
import model.empleado.empleadoVo;
import model.empleado.empleadoDao;

import model.Concepto.*;


//Declaración de clases
public class Nomina  extends HttpServlet{
    NominaVo r=new NominaVo();
    NominaDao rd=new NominaDao();

    empleadoVo rz=new empleadoVo();
    empleadoDao rx=new empleadoDao();

    ConceptoDao cd = new ConceptoDao();
    ConceptoVo c = new ConceptoVo();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch(a){
            case "abrir":
            listarEmpleado(req,resp);
            break;
            case "entrar":
            entrar(req, resp);
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
            case "addVacaciones":
            addVacaciones(req, resp);
            break;
            case "edit":
            edit(req, resp);
            break;  
        }
    }
//el formulario 
    private void abrir(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Nomina/RegistrarNomina.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    //el formulario 
    private void entrar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idNomina")!= null){
            r.setIdNomina(Integer.parseInt(req.getParameter("idNomina")));
        }
        try {
            List Concepto = cd.listarEmpleado(r.getIdNomina());
            req.setAttribute("listars", Concepto);
            req.getRequestDispatcher("views/Nomina/RegistralaNomina.jsp").forward(req, resp);
            System.out.println("Datos listados correctamentes");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    } 

    private void consultarEmpleado(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List idEmpleado=rx.listar();
            req.setAttribute("idEmpleado", idEmpleado);
            System.out.println("Datos de rol listados correctamente de empleado");
        }catch (Exception e){
            System.out.println("Hay problemas al listar el empleado del la nomina"+e.getMessage().toString());
        }
    }

 
//consultar las listas

private void listar (HttpServletRequest req, HttpServletResponse resp) {
    try {

        List<NominaVo> nomina =rd.listar();
        req.setAttribute("nomina", nomina);
        req.getRequestDispatcher("views/Nomina/ConsultarNomina.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}


private void ConsultarConcepto(HttpServletRequest req, HttpServletResponse resp) {
    try {

        List Concepto = cd.listar();
        req.setAttribute("listars", Concepto);
        req.getRequestDispatcher("views/Concepto/ConsultarConcepto.jsp").forward(req, resp);
        System.out.println("Datos listados correctamentes");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
} 

private void listarEmpleado(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("idNomina")!= null){
        r.setIdNomina(Integer.parseInt(req.getParameter("idNomina")));
    }
    try {
        List Concepto = cd.listarEmpleado(r.getIdNomina());
        req.setAttribute("listars", Concepto);
        req.getRequestDispatcher("views/Nomina/RegistrarNomina.jsp").forward(req, resp);
        System.out.println("Datos listados correctamentes");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
} 




private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("idNomina")!= null){
        r.setIdNomina(Integer.parseInt(req.getParameter("idNomina")));
    }
    try {
        rd.eliminar(r.getIdNomina());
        System.out.println("El estado se elimino correctamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" + e.getMessage().toString());
    }
}




private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idNomina")!=null)
    r.setIdNomina(Integer.parseInt(req.getParameter("idNomina")));{
    }
    try{
        List<NominaVo> NominaA = rd.ListarNomina(r.getIdNomina());
        req.setAttribute("listar", NominaA);
        req.getRequestDispatcher("views/Nomina/ActualizarNomina.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente para la edicion");
    } catch(Exception e){
        System.out.println("Error al listar los datos"+e.getMessage().toString());
    }
}
    //Metodos del DoPost


    private void add(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("fechaNomina")!=null){
            r.setFechaNomina(req.getParameter("fechaNomina"));
        }
        System.out.println(r.getFechaNomina());
        if(req.getParameter("fechaNovedad")!=null){
            r.setFechaNovedad(req.getParameter("fechaNovedad"));
        }
        System.out.println(r.getFechaNovedad());
        if(req.getParameter("diasNovedad")!=null){
            r.setDiasNovedad(Integer.parseInt(req.getParameter("diasNovedad")));
        }
        System.out.println(r.getEstadoNovedad());
            r.setEstadoNovedad(true);

        if(req.getParameter("diasNovedad")!=null){
            r.setTipoNovedad(req.getParameter("diasNovedad"));
        }
        System.out.println(r.getTipoNovedad());
        
        if(req.getParameter("tipoNovedad")!=null){
            r.setNombreNovedad(req.getParameter("tipoNovedad"));
        }
        if(req.getParameter("idConcepto")!=null){
            r.setIdNomina(Integer.parseInt(req.getParameter("idConcepto")));
        }

        try {

            int SueldoBase = Integer.parseInt(req.getParameter("SueldoBase"));
            System.out.println("El sueldo base es de" + SueldoBase);
            int HorasExtra = Integer.parseInt(req.getParameter("diasNovedad"));
            System.out.println("las horas extra son" + HorasExtra);
            
            int ResultadoSalario = SueldoBase/240;

            System.out.println("el primer resultado es" + ResultadoSalario);

            int ResultadoTotal = ResultadoSalario * HorasExtra;

            System.out.println("el resultado total es " + ResultadoTotal);

            rd.registrar(r, ResultadoTotal);
            System.out.println("Registro insertado correctamente");

            int ValorTotal = Integer.parseInt(req.getParameter("ValorTotal"));

            int TotalNomina = ValorTotal + ResultadoTotal;

            rd.actualizarNomina(r.getIdNomina(), TotalNomina);
        
            ConsultarConcepto(req, resp);

        } catch (Exception e) {
            System.out.println("Error en registro de Genero "+e.getMessage().toString());
        }
    }

    //----------------------------

    private void addVacaciones(HttpServletRequest req, HttpServletResponse resp) {
        
        if(req.getParameter("fechaNomina")!=null){
            r.setFechaNomina(req.getParameter("fechaNomina"));
        }
        System.out.println(r.getFechaNomina());
        if(req.getParameter("fechaNovedad")!=null){
            r.setFechaNovedad(req.getParameter("fechaNovedad"));
        }
        System.out.println(r.getFechaNovedad());
        if(req.getParameter("diasNovedad")!=null){
            r.setDiasNovedad(Integer.parseInt(req.getParameter("diasNovedad")));
        }
        System.out.println(r.getEstadoNovedad());
            r.setEstadoNovedad(true);

        if(req.getParameter("diasNovedad")!=null){
            r.setTipoNovedad(req.getParameter("diasNovedad"));
        }
        System.out.println(r.getTipoNovedad());
        
        if(req.getParameter("tipoNovedad")!=null){
            r.setNombreNovedad(req.getParameter("tipoNovedad"));
        }
        if(req.getParameter("idConcepto")!=null){
            r.setIdNomina(Integer.parseInt(req.getParameter("idConcepto")));
        }

        try {

            int SueldoBase = Integer.parseInt(req.getParameter("SueldoBase"));
            System.out.println("El sueldo base es de" + SueldoBase);
            int DiasTrabajados = Integer.parseInt(req.getParameter("diasNovedad"));
            System.out.println("los  días trabajados son" + DiasTrabajados);
            
            int ResultadoSalario = (SueldoBase*DiasTrabajados)/720;

            System.out.println("El resultado" + ResultadoSalario);
            
            rd.registrar(r, ResultadoSalario);

            System.out.println("Registro insertado correctamente");

            int ValorTotal = Integer.parseInt(req.getParameter("ValorTotal"));

            int TotalNomina = ValorTotal - ResultadoSalario;

            rd.actualizarNomina(r.getIdNomina(), TotalNomina);
        
            ConsultarConcepto(req, resp);

        } catch (Exception e) {
            System.out.println("Error en registro de Genero "+e.getMessage().toString());
        }
    }

    //-------------------------
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idNomina")!=null){
            r.setIdNomina(Integer.parseInt(req.getParameter("idNomina")));
        }
        if(req.getParameter("idNovedad")!=null){
            r.setIdNovedad(Integer.parseInt(req.getParameter("idNovedad")));
        }
        if(req.getParameter("nombreNovedad")!=null){
            r.setNombreNovedad(req.getParameter("nombreNovedad"));
        }
        if(req.getParameter("valorNovedad")!=null){
            r.setValorNovedad(Integer.parseInt(req.getParameter("valorNovedad")));
        }
        if(req.getParameter("diasNovedad")!=null){
            r.setDiasNovedad(Integer.parseInt(req.getParameter("diasNovedad")));
        }
        if(req.getParameter("estadoNovedad")!=null){
            r.setEstadoNovedad(true);
        }
        if(req.getParameter("tipoNovedad")!=null){
            r.setTipoNovedad(req.getParameter("tipoNovedad"));
        } 
        try{
            rd.actualizar(r);
            System.out.println("Editar el registro de nomina");
            listar(req, resp);
        }catch (Exception e){
            System.out.println("Error al editar el registro del nomina"+e.getMessage().toString());
        }
    }


}

