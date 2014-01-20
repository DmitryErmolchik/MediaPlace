<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Media place - Remote</title>
</head>
<body>
	<div class="remote">
		<c:forEach items="${listOfCommands}" var="command">
			<a href="/mediaplace/remote?command=${command.name}">${command.name}</a>
			<br>
		</c:forEach>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}">Home</a>
	</div>

</body>
</html>
