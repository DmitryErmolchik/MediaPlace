<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Media place - Catalog</title>
</head>
<body>
	<c:if test="${category != null}">
		<div class="category">${category}</div>
	</c:if>
	<c:if test="${!empty categoriesList}">
		<div class="categoryList">
			<c:forEach items="${categoriesList}" var="category">
				<a href="${category}/">${category}</a>
				<br>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${!empty directoriesList}">
		<div class="directory">
			<c:forEach items="${directoriesList}" var="directory">
				<a href="${pageContext.request.contextPath}/catalog/${category}?pathToExplore=${directory.absolutePath}/">${directory.name}</a>
				<br>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${!empty filesList}">
		<div class="file">
			<c:forEach items="${filesList}" var="file">
				<a href="${pageContext.request.contextPath}/playMovie?movie=${file}">${file.name}</a>
				<br>
			</c:forEach>
		</div>
	</c:if>
	<div class="bottomNavigation">
		<table class="bottomNavigationTable">
			<tr>
				<td><a href="javascript:history.back()">Back</a></td>
				<td><a href="${pageContext.request.contextPath}">Home</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
