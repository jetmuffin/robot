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
						<i class="fa fa-exclamation-circle"></i>
						${message}
					</div>
		</c:if>
		<div class="container-fluid">
			<div id="pad-wrapper" class="user-profile">
				<!-- header -->
				<div class="row-fluid header">
					<div class="span8">
						<img src="/robot/resources/img/backend/user-thumb.png"
							class="avatar img-circle" />
						<h3 class="name">${expert.name}</h3>
						<c:forEach items="${expert.orgnizations}" var="organization">
							<span class="area">${organization.name}</span>
						</c:forEach>
					</div>
					<a class="btn-flat icon pull-right delete-user"
						href="/robot/backend/expert/delete/${expert.expertId}"
						data-toggle="tooltip" title="Delete user" data-placement="top">
						<i class="fa fa-trash"></i>
					</a> <a href="/robot/backend/expert/edit/${expert.expertId}"
						class="btn-flat icon large pull-right edit"> 编辑信息 </a>
				</div>

				<div class="row-fluid profile">
					<!-- bio, new note & orders column -->
					<div class="span9 bio">
						<div class="profile-box">
							<!-- biography -->
							<div class="span12 section">
								<h6>个人简介</h6>
								<a href="" class="edit" type="button" data-toggle="modal"
									data-target="#info-modal"><i class="fa fa-edit"></i>编辑</a>
								<p>
									<c:if test="${empty expert.info or expert.info eq ''}">暂未收录</c:if>
									${expert.info}
								</p>
							</div>

							<h6>个人履历</h6>
							<a href="" class="edit" type="button" data-toggle="modal"
								data-target="#experience-modal"><i class="fa fa-edit"></i>编辑</a>
							<p>
								<c:if
									test="${empty expert.experience or expert.experience eq ''}">暂未收录</c:if>
								${expert.experience}
							</p>
							<br />

							<h6>研究方向</h6>
							<ul class="area-labels">
								<c:forEach items="${expert.topics}" var="topic">
									<li><label class="btn-flat white">${topic.name}</label></li>
								</c:forEach>
							</ul>
							<br />

							<h6>科研成果</h6>
							<a href="" class="edit" type="button" data-toggle="modal"
								data-target="#achievement-modal"><i class="fa fa-edit"></i>编辑</a>
							<p>
								<c:if
									test="${empty expert.achievement or expert.achievement eq ''}">暂未收录</c:if>
								${expert.achievement}
							</p>
							<br />


							<!-- recent orders table -->
							<h6>近期活动</h6>
							<br />
							<table class="table table-hover">
								<thead>
									<tr>
										<th class="span3"><span class="line"></span> 时间</th>
										<th class="span9"><span class="line"></span> 活动</th>
										</th>
									</tr>
								</thead>
								<tbody>
									<!-- row -->
									<tr class="first">
										<td>Jan 03, 2014</td>
										<td>出席IEEE会议</td>
									</tr>
								</tbody>
							</table>

							<!-- new activity form -->
							<div class="span12  comment">
								<h6>添加活动</h6>
								<label for="datepicker">活动日期</label> <input type="text"
									id="datepicker"></input> <label for="activity">活动内容</label>
								<textarea name="activity" id="activity"></textarea>

								<div class="span12 submit-box pull-right">
									<input type="submit" class="btn-glow primary" value="添加动态" />
									<span>OR</span> <input type="reset" value="取消" class="reset" />
								</div>
							</div>
						</div>
					</div>

					<!-- side address column -->
					<div class="span3 address pull-right">
						<h6>地址</h6>
						<ul>
							<li id="expert-address"><c:if
									test="${empty expert.address or expert.address eq ''}">暂未收录</c:if>${expert.address}</li>
							<li class="ico-li"><i class="ico-mail"></i> <a href="#">
									<c:if test="${empty expert.email or expert.email eq ''}">暂未收录</c:if>${expert.email}
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- modal -->
	<div class="modal fade" id="info-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/robot/backend/expert/editInfo/${expertId}"
					method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="info-label">编辑信息</h4>
					</div>
					<div class="modal-body">

						<label for="info-input">个人简介</label>
						<textarea name="info" id="info-input" style="width: 95%;" rows="6"></textarea>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal -->
	<div class="modal fade" id="experience-modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/robot/backend/expert/editExperience/${expertId}"
					method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="experience-modal">编辑信息</h4>
					</div>

					<div class="modal-body">

						<label for="experience-input">个人履历</label>
						<textarea name="experience" id="info-input" style="width: 95%;"
							rows="6"></textarea>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- modal -->
	<div class="modal fade" id="achievement-modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="/robot/backend/expert/editAchievement/${expertId}"
					method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="achievement-modal">编辑信息</h4>
					</div>
					<div class="modal-body">

						<label for="achievement-input">研究成果</label>
						<textarea name="achievement" id="info-input" style="width: 95%;"
							rows="6"></textarea>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script
		src="/robot/resources/plugin/date-picker/js/bootstrap.datepicker.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/expert-profile.js"></script>
</body>
</html>