package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			processRequest(req, resp);
		}
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form data
        String id = req.getParameter("id");
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dob = req.getParameter("dob");
        String role = req.getParameter("role");
        

        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/election", "root", "manager");
//            
          
            String sql = "INSERT INTO users (id, first_name, last_name, email, password, dob, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, dob);
            pstmt.setString(7, role);
            

            int rows = pstmt.executeUpdate();
            

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            if (rows > 0) {
                out.println("<h3>Registration successful!</h3>");
            } else {
                out.println("<h3>Registration failed... Please try again.</h3>");
            }
            out.println("<a href='index.html'>Home</a>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
