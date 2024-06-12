<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>
<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean" scope="request" />
<jsp:setProperty name="dcb" property="candId" param="id"/>
	${dcb.deleteCandidate()}
	<jsp:forward page="result.jsp"/>


</body>
</html>