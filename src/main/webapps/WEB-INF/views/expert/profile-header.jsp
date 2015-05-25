	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
	<div class="profile-head">
		<div class="container">
			<div class="head-text">
				<div class="logo">
					<img src="/robot/resources/img/common/user.png" alt="">
				</div>
				<div class="text-area">
					<h1>${expert.name}</h1>
					<div class="line">
						<span class="orgnization">${expert.orgnization.name}</span>
					</div>
					<br />
				</div>
				<div class="text-area basic-info">
					<ul class="attr">
						<li>主页： <c:if test="${empty expert.homepage}">暂未收录</c:if>${expert.homepage}</li>
						<li>地址：
						<c:if test="${empty expert.address}">暂未收录</c:if>${expert.address}</li>
						<br />
						<li>Email：
					<c:if test="${empty expert.email}">暂未收录</c:if>${expert.email}</li>
					</ul>
				</div>
			</div>
			<div class="head-statics">
				<div class="score">
					<div class="text">专家评分</div>
					<div class="total-score">
						${expert.rate}
					</div>
					<ul class="sub-score">
						<li>论文数 <span>${expert.paperNum}</span></li>
						<li>专利数 <span>${expert.patentNum}</span></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>