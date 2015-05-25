<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家机器人 - 搜索</title>
<!-- animate css -->
<link rel="stylesheet"
	href="/robot/resources/css/common/animate.min.css">
<!-- bootstrap css -->
<link rel="stylesheet"
	href="/robot/resources/css/bootstrapv3/bootstrap.min.css">
<!-- font-awesome -->
<link rel="stylesheet"
	href="/robot/resources/font/css/font-awesome.min.css">
<link rel="stylesheet" href="/robot/resources/css/common/common.css" />
<!-- custom css -->
<link rel="stylesheet" href="/robot/resources/css/topic/topic.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>

	<section id="main">
	<div class="breadcrumb">
		<div class="container">
			<div class="content">
				<a href="/robot/index">首页</a><span> &gt; </span><a href="#">${module}</a><span>
					&gt; </span>${topic.name}
			</div>
		</div>
	</div>
	<jsp:include page="profile-header.jsp"></jsp:include>
	<div class="profile-main">
		<div class="container">

			<ul class="profile-nav">
				<li><h2>
						<span>目录</span>
					</h2></li>
  			<li><a
					href="/robot/topic/basic/${topic.topicId}">基本概况</a></li>
				<li class="selected"><a href="/robot/topic/network/${topic.topicId}">专家网络</a></li>
				<li><a href="/robot/topic/knowledge/${topic.topicId}">知识图谱</a></li>
			</ul>

			<div class="profile-bd">
				<div class="profile-block">
					<div class="block-title">专家网络</div>
					<div class="block-content">
						<div class="expert-network">
							<div class="static-item  row">
								<div class="static-title">专家关联网络</div>
								<div class="static-graph col-md-12">
									<div id="expertNetwork" style="height:400px">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="profile-block">
					<div class="block-title">核心专家</div>
					<div class="block-content">
												<div class="table-title static-title">最近发表论文</div>
						<table class="table table-hover paper-table">
							<thead>
								<tr>
									<th>专家</th>
									<th>发表论文数</th>
									<th>论文引用数</th>
									<th>专利数</th>
									<th>核心论文数</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${expert.papers}" var="paper">
								<tr>
									<td>${paper.title}</td>
									<c:choose>
										<c:when test="${paper.type eq 'journal'}">
											<td>${paper.journal.name}</td>
											<td>${paper.issue}</td>
										</c:when>
										<c:otherwise>
											<td>${paper.conference}</td>
											<td>${paper.date}</td>
										</c:otherwise>
									</c:choose>
									<td>
									<!--  <span title="被中信所《中国科技期刊引证报告》收录">ISTIC</span>-->
									<span title="被EI收录">EI</span>
									<span title="被SCI收录">SCI</span>
									<span title="被北京大学《中文核心期刊要目总览》收录">PKU</span>
									</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="/robot/resources/plugin/echarts/dist/echarts.js"></script>
	<script src="/robot/resources/js/topic/network.js"></script>
</body>
</html>