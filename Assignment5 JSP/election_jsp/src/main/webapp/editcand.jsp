<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Candidate</title>
</head>
<body>
	Hello, ${lb.user.firstName} ${lb.user.lastName}
	<hr />
	<h3>Edit Candidate</h3>
<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"/>
	<jsp:setProperty name="fcb" property="candId" param="id"/>
	${fcb.fetchCandidate()}
	
	<form method="post" action="updatecand.jsp">
		<input type="hidden" name="id" value="${fcb.candidate.id}"/> <br/><br/>
		Name: <input type="text" name="name" value="${fcb.candidate.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.candidate.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly/> <br/><br/>
		<input type="submit" value="Update Candidate"/>
	</form>
</body>
</html>