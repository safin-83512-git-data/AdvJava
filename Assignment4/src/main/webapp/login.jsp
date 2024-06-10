<%@ page import="com.sunbeam.beans.LoginBean" %>
<%@ page import="com.sunbeam.pojos.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    LoginBean loginBean = new LoginBean();
    loginBean.setEmail(email);
    loginBean.setPassword(password);

    User user = loginBean.authenticateUser();
    if (user != null) {
        session.setAttribute("curuser", user);
        if ("voter".equals(user.getRole())) {
            response.sendRedirect("candlist.jsp");
        } else {
            response.sendRedirect("result.jsp");
        }
    } else {
        out.println("<h4>Invalid email or password. <a href='index.jsp'>Login Again</a></h4>");
    }
%>
</body>
</html>
