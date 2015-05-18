<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家系统 - 后台管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- bootstrap -->
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap.css" />
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap-responsive.css" />
<link rel="stylesheet"
	href="/robot/resources/css/bootstrap/bootstrap-overrides.css" />
<!-- libraries -->
<link href="/robot/resources/css/backend/lib/bootstrap.datepicker.css"
	type="text/css" rel="stylesheet">
<link href="/robot/resources/font/css/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/layout.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/elements.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/icons.css" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="/robot/resources/css/backend/expert-profile.css" type="text/css"
	media="screen" />
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
	<div class="content">
		<c:if test="${not empty message}">
			<div class="alert alert-info">
				<i class="fa fa-exclamation-circle"></i> ${message}
			</div>
		</c:if>
		<div class="container-fluid">
			<div id="pad-wrapper" class="user-profile">
				<!-- header -->
				<div class="row-fluid header">
					<div class="span8">
						<h3 class="name">${paper.title}</h3>
					</div>
					<a class="btn-flat icon pull-right delete-user"
						href="/robot/backend/paper/delete/${paper.paperId}"
						data-toggle="tooltip" title="Delete user" data-placement="top">
						<i class="fa fa-trash"></i>
					</a> <a href="/robot/backend/paper/edit/${paper.paperId}"
						class="btn-flat icon large pull-right edit"> 编辑论文信息 </a>
				</div>
				<div class="row-fluid profile">
					<!-- bio, new note & orders column -->
					<div class="span12 bio">
						<div class="profile-box">
							<!-- biography -->
							<div class="span12 section">
								<h6>作者:</h6>
								<p>
								</p>
							</div>		
							<div class="span12 section">
								<h6>机构:</h6>
								<p>
								</p>
							</div>							
							<div class="span12 section">
								<h6>摘要:</h6>
								<a href="" class="edit" type="button" data-toggle="modal"
									data-target="#abs-modal"><i class="fa fa-edit"></i>编辑</a>
								<p>
									<c:if test="${empty paper.abs or paper.abs eq ''}">暂未收录</c:if>
									${paper.abs}
								</p>
							</div>
							<div class="span12 section">
								<h6>关键词:</h6>
								<p>
								</p>
							</div>								
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/expert-profile.js"></script>
</body>
</html>