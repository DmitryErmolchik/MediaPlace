<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">

<!-- disable iPhone inital scale -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">

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



<!-- Catalog JS AJAX -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/context.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/catalogAJAX.js"></script>

<!-- Plugins JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/javascript/playerControllerAJAX.js"></script>

<title>Media place</title>
</head>
<body>
	<div id="pagewrap">
		<header id="header">
		<form id="searchform">
			<input type="search" id="s" placeholder="Search">
		</form>
		</header>
		<!-- Catalog navigation wiget -->
		<div id="content">
			<article class="post clearfix"> <header>
			<h1 class="post-title">
				<a href="#">Catalog</a>
			</h1>
			<p class="post-meta">
				<time class="post-date" datetime="2011-05-08" pubdate>May 8,
				2011</time>
				<em>in</em> <a href="#">Category</a>
			</p>
			</header> <!-- Ajax catalog loader -->
			<div id="ajaxCatalogCurrentPath"></div>
			<ul id="ajaxCatalogDirectories"></ul>
			<ul id="ajaxCatalogFiles"></ul>
			<div id="ajaxCatalogNavigation"></div>

			</article>
			<!-- /.post -->

		</div>
		<!-- /#content -->




		<aside id="sidebar"> 
			<section class="widget">
				<h4 class="widgettitle">Player control</h4>
				<ul id="ajaxPlayerControl"></ul>
			</section>
			<!-- /.widget --> 
			<section class="widget">
				<h4 class="widgettitle">System info</h4>
				<ul>
					<li>CPU: 15%</li>
					<li>RAM: 3Gb / 16Gb</li>
					<li>Space: 10Gb / 200Gb</li>
				</ul>
			</section> 
			<!-- /.widget -->
			<section class="widget clearfix">
				<h4 class="widgettitle">Flickr</h4>
				<script type="text/javascript"
					src="http://www.flickr.com/badge_code_v2.gne?count=8.&display=latest&size=s&layout=x&source=user&user=52839779@N02"></script>
			</section>
			<!-- /.widget --> 
		</aside>
		<!-- /#sidebar -->

		<footer id="footer">

		<p>
			Tutorial by <a href="http://webdesignerwall.com">Web Designer
				Wall</a>
		</p>

		</footer>
		<!-- /#footer -->
	</div>
</body>
</html>
