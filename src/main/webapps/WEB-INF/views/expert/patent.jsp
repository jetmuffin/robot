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
					<li><h2><span>目录</span></h2></li>
				<li><a href="/robot/expert/basic/${expert.expertId}">基本信息</a></li>
				<li><a href="/robot/expert/paper/${expert.expertId}">论文信息</a></li>
				<li class="selected"><a href="/robot/expert/patent/${expert.expertId}">专利信息</a></li>
				<li><a href="/robot/expert/relation/${expert.expertId}">关联专家</a></li>
				<li><a href="/robot/expert/topics/${expert.expertId}">研究方向</a></li>
			</ul>

			<div class="profile-bd">
				<div class="profile-block">
					<div class="block-title">专利成果</div>
					<div class="block-content">
						<div class="table-title static-title">最近申请专利</div>
						<table class="table table-hover paper-table">
							<thead>
								<tr>
									<th>标题</th>
									<th>申请时间</th>
									<th>申请人</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${expert.patents}" var="patent">
									<td>${patent.title}</td>
									<td>${patent.date}</td>
									<td>${patent.applicant}</td>
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
	<script src="/robot/resources/js/expert/patent.js"></script>
</body>
</html>