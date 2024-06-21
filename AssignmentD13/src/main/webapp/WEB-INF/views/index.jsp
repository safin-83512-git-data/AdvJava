<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h5>
		<a href="hello">Test Spring MVC Flow</a>
	</h5>
	<h5>
		<%--add c:url tag for URL rewriting --%>
		<c:url var="abc" value="/test/test1" />
		<a href="${abc}">Test Model And View</a>
	</h5>
	<h5>
		<%--add c:url tag for URL rewriting --%>
		<c:url var="abc" value="/test/test2" />
		<a href="${abc}">Test Model Map</a>
	</h5>
</body>
</html>