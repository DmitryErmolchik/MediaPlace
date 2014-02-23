<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">

<!-- disable iPhone inital scale -->
<meta name="viewport" content="width=device-width; initial-scale=1.0">

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
	<div id="pagewrap">

		<header id="header">
		<form id="searchform">
			<input type="search" id="s" placeholder="Search">
		</form>

		<c:if test="${!empty categories}">
			<nav>
			<ul id="main-nav" class="clearfix">
				<c:forEach items="${categories}" var="category">
					<li><a
						href="${pageContext.request.contextPath}/catalog/${category}/">${category}</a></li>
				</c:forEach>
			</ul>
			<!-- /#main-nav --> </nav>
		</c:if> </header>

		<div id="content">

			<article class="post clearfix"> <header>
			<h1 class="post-title">
				<a href="#">Just a Post Title</a>
			</h1>
			<p class="post-meta">
				<time class="post-date" datetime="2011-05-08" pubdate>May 8,
				2011</time>
				<em>in</em> <a href="#">Category</a>
			</p>
			</header> <figure class="post-image"> <img
				src="images/sample-image.jpg" /> </figure>
			<p>Fusce ut sem est. In eu sagittis felis. In gravida arcu ut
				neque ornare vitae rutrum turpis vehicula. Nunc ultrices sem mollis
				metus rutrum non malesuada metus fermentum. Vestibulum ante ipsum
				primis in faucibus orci luctus et ultrices posuere cubilia Curae;
				Pellentesque interdum rutrum quam, a pharetra est pulvinar ac.
				Vestibulum congue nisl magna. Ut vulputate odio id dui convallis in
				adipiscing libero condimentum. Nunc et pharetra enim. Praesent
				pharetra, neque et luctus tempor, leo sapien faucibus leo, a
				dignissim turpis ipsum sed libero. Sed sed luctus purus. Aliquam
				faucibus turpis at libero consectetur euismod. Nam nunc lectus,
				congue non egestas quis, condimentum ut arcu. Nulla placerat, tortor
				non egestas rutrum, mi turpis adipiscing dui, et mollis turpis
				tortor vel orci. Cras a fringilla nunc. Suspendisse volutpat, eros
				congue scelerisque iaculis, magna odio sodales dui, vitae vulputate
				elit metus ac arcu. Mauris consequat rhoncus dolor id sagittis. Cras
				tortor elit, aliquet quis tincidunt eget, dignissim non tortor.</p>

			<h3>Vimeo Video</h3>
			<div class="video">
				<iframe src="http://player.vimeo.com/video/6284199" width="550"
					height="400" frameborder="0"></iframe>
			</div>
			<!-- /.video -->

			<h3>YouTube</h3>
			<div class="video">
				<object width="500" height="400">
					<param name="movie"
						value="http://www.youtube.com/v/NmRTreaCJXs?version=3">
					</param>
					<param name="allowFullScreen" value="true">
					</param>
					<param name="allowscriptaccess" value="always">
					</param>
					<param name="wmode" value="transparent">
					</param>
					<embed wmode="transparent"
						src="http://www.youtube.com/v/NmRTreaCJXs?version=3"
						type="application/x-shockwave-flash" width="600" height="420"
						allowscriptaccess="always" allowfullscreen="true"></embed>
				</object>
			</div>
			<!-- /.video --> </article>
			<!-- /.post -->

		</div>
		<!-- /#content -->




		<aside id="sidebar"> <section class="widget">
		<h4 class="widgettitle">Navigation</h4>
		<ul>
			<li><a href="javascript:history.back()" class="navigationWidget">Back</a></li>
			<li><a href="${pageContext.request.contextPath}"
				class="navigationWidget">Home</a></li>
		</ul>
		</section> <!-- /.widget --> <section class="widget">
		<h4 class="widgettitle">System info</h4>
		<ul>
			<li>CPU: 15%</li>
			<li>RAM: 3Gb / 16Gb</li>
			<li>Space: 10Gb / 200Gb</li>
		</ul>
		</section> <!-- /.widget --> <section class="widget clearfix">
		<h4 class="widgettitle">Flickr</h4>
		<script type="text/javascript"
			src="http://www.flickr.com/badge_code_v2.gne?count=8.&display=latest&size=s&layout=x&source=user&user=52839779@N02"></script>
		</section> <!-- /.widget --> </aside>
		<!-- /#sidebar -->

		<footer id="footer">

		<p>
			Tutorial by <a href="http://webdesignerwall.com">Web Designer
				Wall</a>
		</p>

		</footer>
		<!-- /#footer -->


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
