<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
<jsp:setProperty  name="vb"  property="candId" param="candidate"/>
<jsp:setProperty  name="vb"  property="userId" value="${lb.user.id}"/>
${vb.registerVote()}
<h4>${vb.message}</h4>
	<a href="logout.jsp">Sign Out</a>

</body>
</html>