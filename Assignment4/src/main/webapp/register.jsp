<%@ page import="com.sunbeam.beans.RegistrationBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String dob = request.getParameter("dob");
    String role = request.getParameter("role");

    RegistrationBean regBean = new RegistrationBean();
    regBean.setFirstName(firstName);
    regBean.setLastName(lastName);
    regBean.setEmail(email);
    regBean.setPassword(password);
    regBean.setDob(dob);
    regBean.setRole(role);

    boolean isSuccess = regBean.registerUser();
%>
    <h3>Registration</h3>
    <%
        if (isSuccess) {
            out.println("<h4>Registration successful!</h4>");
        } else {
            out.println("<h4>Registration failed. Please try again.</h4>");
        }
    %>
    <br/>
    <a href="index.jsp">Home</a>
</body>
</html>
