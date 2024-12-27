/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Data.UserDAO;
import Model.User;
import Utils.MD5Encoding;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author DUY
 */
public class SignupServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.jsp");
        rd.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String account = request.getParameter("account");
        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int gender = Integer.parseInt(request.getParameter("gender"));
        
        String statusOfAccount = "";
        String statusOfRePassword = "";
        
        UserDAO usd = new UserDAO();
        
        if(usd.checkExistsAccount(account)){
            statusOfAccount = "This account already exists";
        }else{
            if(!pass1.equals(pass2)){
                statusOfRePassword ="Wrong password";
            }else{
                 pass1 = new MD5Encoding().md5(pass1);
                 User user = new User(0, account, pass1, null, phone, email, gender , null);
                 usd.createUser(user);
                 response.sendRedirect("LoginServlet");
            }
        }
        
        if(statusOfAccount.length() > 0 || statusOfRePassword.length()> 0){
            request.setAttribute("statusOfAccount", statusOfAccount);
            request.setAttribute("statusOfPassword", statusOfRePassword);
            request.setAttribute("account", account);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("gender", gender);
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUp.jsp");
            rd.forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
