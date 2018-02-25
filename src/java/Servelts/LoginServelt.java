/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelts;

import classes.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

/**
 *
 * @author M.Gebaly
 */
public class LoginServelt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection conn;
    ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        String userName = request.getParameter("rEmail");
        String userPassword = request.getParameter("rPassword");
        try {
            
            conn = (Connection) getServletContext().getAttribute("conn");
            String query = "SELECT * FROM LOGIN WHERE lower(USERNAME) = lower(?) AND PASSWORD = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, userName);
            pre.setString(2, userPassword);
            rs = pre.executeQuery();
            if(!rs.next()){
                String sql = "insert Into LOGIN values('"+userName+"' , '"+userPassword+"')";
                PreparedStatement pres = conn.prepareStatement(sql);
                pres.executeUpdate();
                response.sendRedirect("index.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String userName =  request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        
        
        
        try {
            conn = (Connection) getServletContext().getAttribute("conn");
            String query = "SELECT * FROM LOGIN WHERE lower(USERNAME) = lower(?) AND PASSWORD = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, userName);
            pre.setString(2, userPassword);
            rs = pre.executeQuery();
            
            
            if(rs.next()){
                User user = new User();
                user.setName(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
//                String sql = "update LOGIN set statuse = 'online' WHERE lower(USERNAME)";
//                PreparedStatement preq = conn.prepareStatement(sql);
//                preq.setString(1, userName);
//                preq.executeUpdate();
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("userName", userName);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("ChatPage.jsp");
                dispatcher.forward(request, response);
            }else{
                response.sendRedirect("index.html");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServelt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
