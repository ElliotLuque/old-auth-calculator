/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package net.ausiasmarch.oldauthcalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elliot
 */
public class sesiones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sesion</title>");    
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='row'>");
            out.println("<div class='col-12'>");
            
            String op = request.getParameter("op");
            HttpSession oSession = request.getSession();
            
            switch (op) {
                
                case "login":
                    String user = request.getParameter("user");
                    String pass = request.getParameter("pass");
                    
                    if (pass.equalsIgnoreCase("ausias")) {            
                        oSession.setAttribute("user", user);
                                           
                        out.println("<h1>Inciando sesión como " + user + "...</h1>");
                        out.println("<h4 class='text-primary'><a href=\"index.html\">Continuar</a></h4>");
                        out.println("</div>");
                    } else {
                        out.println("<h4><a href=\"login.html\">Volver atrás</a></h4>");
                        out.println("<h1>Login incorrecto!</h1>");
                        out.println("</div>");
                    }
                    break;
                case "logout":
                    oSession.invalidate();
                    out.println("<h4><a href=\"index.html\">Volver atrás</a></h4>");
                    out.println("<h1>Sesión cerrada!</h1>");
                    out.println("</div>");
                    break;
                case "calcular":
                    if (oSession.getAttribute("user") != null) {
                        out.println("<h1>Resultado:</h1>");
                        
                        int operator1 = Integer.parseInt(request.getParameter("op1"));
                        int operator2 = Integer.parseInt(request.getParameter("op2"));
                        String operation = request.getParameter("operation");
                        
                        int result;
                        switch (operation) {
                            case "add":                  
                                result = operator1 + operator2;
                                out.println("<h1>"+ result +"</h1>");
                                break;
                            case "minus":
                                result = operator1 - operator2;
                                out.println("<h1>"+ result +"</h1>");
                                break;
                            case "multiply":
                                result = operator1 * operator2;
                                out.println("<h1>"+ result +"</h1>");
                                break;
                            case "div":
                                result = operator1 / operator2;
                                out.println("<h1>"+ result +"</h1>");
                                break;
                        }
                        out.println("<h4><a href=\"calculator.html\">Volver atrás</a></h4>");
                        out.println("</div>");
                    } else {
                        out.println("<h4><a href=\"index.html\">Volver atrás</a></h4>");
                        out.println("<h1><span class='text-danger'>ERROR:</span> usuario no autenticado!</h1>");
                        out.println("</div>");
                    }
            }
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
