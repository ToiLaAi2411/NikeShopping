/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Data.CartaDAO;
import Data.UserDAO;
import Model.User;
import Utils.MD5Encoding;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 *
 * @author DUY
 */
public class LoginServlet extends HttpServlet {
   
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
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
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
       String password = request.getParameter("password");
       String isRemember = request.getParameter("rememberMe");
       HttpSession session = request.getSession();
       
        UserDAO usd = new UserDAO();
        CartaDAO crd = new CartaDAO();
        MD5Encoding md5 = new MD5Encoding();
        String status = "";
        String statusPass = "";
        String statusAccount = "";
        
        if(!usd.checkExistsAccount(account)){
            statusAccount = "this account does not exists!";
        }else{
            User user = usd.getUser(account, md5.md5(password));
            
            if(user == null){
                statusPass = "wrong password!";
            }else{
                
                if(isRemember != null){
                    Cookie passCookie = new Cookie("password", password);
                    Cookie accountCookie = new Cookie("account", account);
                    passCookie.setMaxAge(120);
                    accountCookie.setMaxAge(120);
                    response.addCookie(passCookie);
                    response.addCookie(accountCookie);
                   
                    session.setAttribute("user", user);            
                }else{
                    session.setAttribute("user", user);   
                    session.setMaxInactiveInterval(60);
                }
                int cartID = crd.getCartID(user.getUserID());             
                session.setAttribute("cartID", cartID);
                response.sendRedirect("HomePage");
                
            }
        }
        
        if(status.length() > 0 || statusAccount.length() > 0 || statusPass.length() > 0){
             request.setAttribute("account", account);
             request.setAttribute("statusPass", statusPass);
             request.setAttribute("statusAccount", statusAccount);
             request.setAttribute("status", status);
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
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
