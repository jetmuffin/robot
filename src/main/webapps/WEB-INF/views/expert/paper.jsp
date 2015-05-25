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
<link rel="stylesheet" href="/robot/resources/css/expert/expert.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>

	<section id="main">

	<div class="breadcrumb">
		<div class="container">
			<div class="content">
				<a href="/robot/index">首页</a><span> &gt; </span><a href="#">${module}</a><span>
					&gt; </span>${expert.name}
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
				<li><a href="/robot/expert/basic/${expert.expertId}">基本信息</a></li>
				<li class="selected"><a
					href="/robot/expert/paper/${expert.expertId}">论文信息</a></li>
				<li><a href="/robot/expert/patent/${expert.expertId}">专利信息</a></li>
				<li><a href="/robot/expert/relation/${expert.expertId}">关联专家</a></li>
				<li><a href="/robot/expert/topics/${expert.expertId}">研究方向</a></li>
			</ul>

			<div class="profile-bd">
				<div class="profile-block">
					<div class="block-title">论文发表</div>
					<div class="block-content">
						<div class="paper-static">
							<div class="row">
								<div class="col-md-6 static-item">
									<div class="static-title">论文引用情况</div>
									<div id="paper-refer" style="height: 200px"></div>
									<div class="static-conclude">多数论文被引用</div>
									<div class="static-desc">76%的论文被引用</div>
								</div>
								<div class="col-md-6 static-item">
									<div class="static-title">论文引用次数</div>
									<div id="paper-referdist" style="height: 200px"></div>
									<div class="static-conclude">高引用频度</div>
									<div class="static-desc">平均每篇文章被引用105.8次</div>
								</div>
							</div>
						</div>
						<div class="table-title static-title">最近发表论文</div>
						<table class="table table-hover paper-table">
							<thead>
								<tr>
									<th>标题</th>
									<th>发表于</th>
									<th>发表时间</th>
									<th>收录于</th>
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
				<div class="profile-block">
					<div class="block-title">
						近10年发表论文情况
					</div>
					<div class="block-content">
							<div class="row">
								<div id="lastTenyearPaper" class="col-md-12"
									style="height: 300px"></div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="/robot/resources/plugin/echarts/dist/echarts.js"></script>
	<script src="/robot/resources/js/expert/paper.js"></script>
</body>
</html>