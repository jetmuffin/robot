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
		<!--  	<li class="selected"><a
					href="/robot/topic/basic/${topic.topicId}">基本概况</a></li>
				<li><a href="/robot/topic/network/${topic.topicId}">专家网络</a></li>
				<li><a href="/robot/topic/knowledge/${topic.topicId}">知识图谱</a></li>-->	
					<li class="selected"><a
					href="/robot/topic/basic/3">基本概况</a></li>
				<li><a href="/robot/topic/network/3">专家网络</a></li>
				<li><a href="/robot/topic/knowledge/3">知识图谱</a></li>
			</ul>

			<div class="profile-bd">
				<div class="profile-block">
					<div class="block-title">基本信息</div>
					<div class="block-content">
						<div class="basic-info row">
							<div class="basic-info-left col-md-6">
								<span>中文名</span> 机器学习
							</div>
							<div class="basic-info-right col-md-6">
								<span>领域</span> 计算机
							</div>
						</div>
					</div>
				</div>
				<div class="profile-block">
					<div class="block-title">相关专家统计</div>
					<div class="block-content">
						<div class="expert-static">
							<div class="row">
								<div class="static-item col-md-6">
									<div class="static-title">专家学历</div>
									<div class="static-graph expert-edu">
										<div id="expertEdu" style="height:200px"></div>
									</div>
									<div class="static-desc">大多数专家为博士及以上学历</div>
								</div>
								<div class="static-item gender col-md-6">
									<div class="static-title">专家性别</div>
									<div class="static-graph">
										<div id="expertGender" style="height: 200px;"></div>
									</div>
									<div class="static-desc">多数研究该方向的是男专家</div>
								</div>
								<div class="static-item col-md-12">
									<div class="static-title">专家组织</div>
									<div class="static-graph">
										<div id="expertLocation" style="height: 400px;"></div>
									</div>
								</div>
								<div class="static-item col-md-12">
									<div class="static-title">专家地区分布</div>
									<div class="static-graph">
										<div id="expertProv" style="height:600px"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="/robot/resources/plugin/echarts/dist/echarts.js"></script>
	<script src="/robot/resources/js/topic/basic.js"></script>
</body>
</html>