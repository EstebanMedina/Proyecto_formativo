package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Concepto.ConceptoDao;
import model.Concepto.ConceptoVo;
import model.empleado.empleadoDao;
import model.empleado.empleadoVo;

public class ConceptoController extends HttpServlet {

    ConceptoVo r=new ConceptoVo();
    ConceptoDao rd=new ConceptoDao();

    empleadoVo rz=new empleadoVo();
    empleadoDao rx=new empleadoDao();


    @Override
    //doGet
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("estas en el DoGet");
        String a=req.getParameter("accion");

        switch(a){
        case "Registro":
        consultarEmpleado(req,resp);
        Registro(req,resp);
        break;
        case "Consultar":
        Consultar(req,resp);
        break;
        case "ConsultarNomina":
        ConsultarNomina(req, resp);
        break;
        case "Eliminar":
        Eliminar(req, resp);
        break;
        case "Editar":
        Editar(req, resp);
        break;
        }
    }
 



    private void ConsultarNomina(HttpServletRequest req, HttpServletResponse resp) {
        try {

            List Concepto = rd.ListarNomina();
            req.setAttribute("nomina", Concepto);
            req.getRequestDispatcher("views/Concepto/resumen.jsp").forward(req, resp);
            System.out.println("Datos listados correctamentes");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }




    //doPost
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

    

//registra
private void Registro(HttpServletRequest req, HttpServletResponse resp) {

    try{
        req.getRequestDispatcher("views/Concepto/RegistrarConcepto.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    }catch(Exception e){
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
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



private void Consultar(HttpServletRequest req, HttpServletResponse resp) {
    try {

        List Concepto = rd.listar();
        req.setAttribute("listars", Concepto);
        req.getRequestDispatcher("views/Concepto/ConsultarConcepto.jsp").forward(req, resp);
        System.out.println("Datos listados correctamentes");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
} 



    //eliminar
    private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdConcepto(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        try {
            rd.eliminar(r.getIdConcepto());;
            System.out.println("El estado se cambio exitosamente");
            Consultar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
 


    //editar
    private void Editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdConcepto(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
        }
        try {
            List<ConceptoVo> Concepto=rd.ListarConcepto(r.getIdConcepto());
            req.setAttribute("Concepto", Concepto);
            req.getRequestDispatcher("views/Concepto/ActualizarConcepto.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    

    //METODOS DOPOST

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("SalarioBase")!=null){
            r.setSalarioBase(Integer.parseInt(req.getParameter("SalarioBase")));
        }
        
        if(req.getParameter("DiasTrabajados")!=null){
            r.setDiasTrabajados(Integer.parseInt(req.getParameter("DiasTrabajados")));
        }

        if(req.getParameter("idEmpleado")!=null){
            r.setIdEmpleado(Integer.parseInt(req.getParameter("idEmpleado")));
        }

        try {
            Double SalarioBase = Double.parseDouble(req.getParameter("SalarioBase"));
            Double DiasTrabajados = Double.parseDouble(req.getParameter("DiasTrabajados"));
            ConceptoVo con=new ConceptoVo();
            Double Censantias = con.Cesantias(SalarioBase, DiasTrabajados);
            Double resultadosCensatias = Censantias;
            System.out.println(resultadosCensatias+"Este es el resultado de centias");

            
            Double SaludR = con.Salud(SalarioBase);
            Double ResultadoSalud = SaludR;
            System.out.println(ResultadoSalud+"Resultado de salud");

            Double PensionR = con.Pension(SalarioBase);
            Double ResultadoPension = PensionR;

    
            Double SenaR = con.Sena(SalarioBase);
            Double ResultadoSena = SenaR;
    
            Double SeguridadSocialR = con.SeguridadSocial(SalarioBase);
            Double ResultadoSeguridadSocial = SeguridadSocialR;

            Double ValorTotalR = con.ValorTotal(SalarioBase,ResultadoSalud,resultadosCensatias,ResultadoPension,ResultadoSena,ResultadoSeguridadSocial);
            Double ResultadoValorTotal = ValorTotalR;

          

            rd.registrar(r,resultadosCensatias,ResultadoSalud,ResultadoPension,ResultadoSena,ResultadoSeguridadSocial,ResultadoValorTotal);
            System.out.println("Registro insertado correctamente");
            Consultar(req, resp);

    
        } catch (Exception e) {
            System.out.println("Error en registro de Concepto"+e.getMessage().toString());
        }
    }
    


    //-------------------------------------------------------------------------------------------//
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("id")!=null){
            r.setIdConcepto(Integer.parseInt(req.getParameter("id")));
        }
        if(req.getParameter("SalarioBase")!=null){
            r.setSalarioBase(Integer.parseInt(req.getParameter("SalarioBase")));
        }
        if(req.getParameter("DiasTrabajados")!=null){
            r.setDiasTrabajados(Integer.parseInt(req.getParameter("DiasTrabajados")));
        }
        if(req.getParameter("SalarioBase1")!=null){
            r.setSalarioBase(Integer.parseInt(req.getParameter("SalarioBase1")));
        }
        if(req.getParameter("Salud")!=null){
            r.setSalud(Integer.parseInt(req.getParameter("Salud")));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de Concepto");
            Consultar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
