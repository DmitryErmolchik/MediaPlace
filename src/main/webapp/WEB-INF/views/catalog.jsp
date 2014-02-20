<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<!-- main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" />

<!-- media queries css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/media-queries.css"
	type="text/css" />

<!-- html5.js for IE less than 9 -->
<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- css3-mediaqueries.js for IE less than 9 -->
<!--[if lt IE 9]>
	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
<title>Media place - Catalog</title>
</head>
<body>
	<c:if test="${category != null}">
		<div class="category">${category}</div>
	</c:if>


	<div id="pagewrap">

		<header id="header">
		<form id="searchform">
			<input type="search" id="s" placeholder="Search">
		</form>
		<c:if test="${!empty categoriesList}">
			<nav>
			<ul id="main-nav" class="clearfix">

				<c:forEach items="${categoriesList}" var="category">
					<li><a href="${category}/">${category}</a></li>
				</c:forEach>
			</ul>
			<!-- /#main-nav --> </nav>
		</c:if> </header>

	</div>



	<!-- 
	<div class="wrap">
		<c:if test="${!empty categoriesList}">
			<div class="box">
				<div class="boxInner">
					<div class="categoryList">
						<c:forEach items="${categoriesList}" var="category">
							<a href="${category}/">${category}</a>
							<br>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${!empty directoriesList}">
			<div class="box">
				<div class="boxInner">
					<div class="directory">
						<c:forEach items="${directoriesList}" var="directory">
							<a
								href="${pageContext.request.contextPath}/catalog/${category}?pathToExplore=${directory.absolutePath}/">${directory.name}</a>
							<br>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${!empty filesList}">
			<div class="box">
				<div class="boxInner">
					<div class="file">
						<c:forEach items="${filesList}" var="file">
							<a
								href="${pageContext.request.contextPath}/playMovie?movie=${file}">${file.name}</a>
							<br>
						</c:forEach>
					</div>
				</div>
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
	</div>
-->

</body>
</html>
