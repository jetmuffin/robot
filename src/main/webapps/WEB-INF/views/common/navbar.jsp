<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
		<!-- start preloader -->
		<div class="preloader">
			<div class="sk-spinner sk-spinner-rotating-plane"></div>
    	 </div>

<header>
	<div class="header">
		<div class="wrap">
			<div class="logo">
	<a href="#"><img alt="logo" class="pngfix" src="" width="110" height="40"></a>
			</div>
			<nav>
				<ul>
					<li data-name="home" <c:if test="${module eq 'index'}">class="active"</c:if> ><a href="/robot/index">首页</a></li>
					<li data-name="expert" <c:if test="${module eq 'searchExpert'}">class="active"</c:if> ><a href="#">查专家</a></li>
					<li data-name="field" <c:if test="${module eq 'searchField'}">class="active"</c:if> ><a href="#">查研究领域</a></li>
					<li data-name="topic" <c:if test="${module eq 'searchTopic'}">class="active"</c:if> ><a href="#">查研究方向</a></li>
				</ul>
			</nav>
		</div>
	</div>
</header>