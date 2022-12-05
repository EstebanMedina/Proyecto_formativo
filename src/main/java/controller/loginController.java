package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.login.iniciarSesion;

public class loginController  extends HttpServlet{

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        iniciarSesion o = new iniciarSesion();

        if(req.getParameter("Botoncito")!=null){
        String name=req.getParameter("correo");
        String password=req.getParameter("ingreso");
          
          HttpSession sesion = req.getSession();
  
            switch(o.loguear(name, password)){
              case 1:
                sesion.setAttribute("username", name);
                sesion.setAttribute("sesion", "1");
                resp.sendRedirect("menu.jsp");
              break;
  
              case 2:
                sesion.setAttribute("username", name);
                sesion.setAttribute("sesion", "2");
                resp.sendRedirect("menu.jsp");
              break;

              case 3:
                sesion.setAttribute("username", name);
                sesion.setAttribute("sesion", "3");
                resp.sendRedirect("menu.jsp");
              break;

              case 4:
                sesion.setAttribute("username", name);
                sesion.setAttribute("sesion", "4");
                resp.sendRedirect("menu.jsp");
              break;

              case 5:
                sesion.setAttribute("username", name);
                sesion.setAttribute("sesion", "5");
                resp.sendRedirect("menu.jsp");
              break;

              case 6:
              sesion.setAttribute("username", name);
              sesion.setAttribute("sesion", "6");
              resp.sendRedirect("./views/empleado/Empleado.jsp");
            break;
  
              default: 
              resp.sendRedirect("index.jsp");
                break;
              
            }
        }
    }
}