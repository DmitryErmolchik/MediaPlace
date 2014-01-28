<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link rel="stylesheet" href="resources/css/style.css" type="text/css" />
<title>Media place - Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<div class="wrap">
		<div class="box">
			<div class="boxInner">
				<P>The time on the server is ${serverTime}.</P>
				<div>${playMovieScriptPath}</div>
			</div>
		</div>
		<div class="box">
			<div class="boxInner">
				<div class="catalog">
					<a href="${pageContext.request.contextPath}/catalog/">Catalog</a>
				</div>
			</div>
		</div>
		<%-- 	<c:forEach items="${listOfMediaFile}" var="mediaFile">
		<a href="playMovie?movie=${mediaFile}">${mediaFile}</a>
		<br>
	</c:forEach> --%>


		<div class="box">
			<div class="boxInner">Hello World!</div>
		</div>
	</div>
	
</body>
</html>
