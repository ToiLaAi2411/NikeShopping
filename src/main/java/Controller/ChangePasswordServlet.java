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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author DUY
 */
public class ChangePasswordServlet extends HttpServlet {
   
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
            out.println("<title>Servlet ChangePasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath () + "</h1>");
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ChangePasswordView.jsp");
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
        String currentPass = request.getParameter("currentPass");
        String newPass1 = request.getParameter("newPass1");
        String newPass2 = request.getParameter("newPass2");
        
        String statusOfCurrentPass = "";
        String statusOfNewPass= "";
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        UserDAO usd = new UserDAO();
        MD5Encoding md = new MD5Encoding();
        
        if(user.getPassword().equals(md.md5(currentPass))){
            if(newPass1.equals(newPass2)){
                boolean check = usd.changePassword(user.getAccount(), md.md5(newPass2));
                if(check){
                    response.sendRedirect("LogoutServlet");
                }
            }else{
                statusOfNewPass = "Wrong Password";
            }
        }else{
            statusOfCurrentPass = "Current password wrong";
        }
        
        if(statusOfCurrentPass.length() > 0 || statusOfNewPass.length() > 0){
            request.setAttribute("statusOfCurrentPass", statusOfCurrentPass);
            request.setAttribute("statusOfNewPass", statusOfNewPass);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/ChangePasswordView.jsp");
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
