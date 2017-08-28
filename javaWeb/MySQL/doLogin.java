/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebTest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author wlw
 */
public class doLogin extends HttpServlet {

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
        String name = request.getParameter("userName");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet doLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet doLogin at " + request.getContextPath() + "</h1>");
            
            Connection conn = null; //声明一个Connection对象，用来连接数据库
            PreparedStatement pstmt = null; //声明PreparedStatement对象，用来向数据库插入数据条数据
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                out.println("创建驱动成功！");
                out.println("<br>");
                //连接数据库foo
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foo", "root", "root");
                out.println("连接数据库成功！");
                out.println("<br>");
                //query
                String sql = "select * from children;";
                Statement statement = conn.createStatement();
                //ResultSet类，用来存放获取的结果集！！
                ResultSet rs = statement.executeQuery(sql);
                out.println("姓名" + "\t" + "年龄");
                out.println("<br>");
                out.println("-----------------");
                out.println("<br>");
                String fname = null;
                String age = null;
                while(rs.next())
                {
                    fname = rs.getString("fname");
                    age = rs.getString("age");
                    out.println(fname + "\t" + age);
                    out.println("<br>");
                }
                
            } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
            
            out.println("</body>");
            out.println("</html>");
            out.flush();
            out.close();
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
