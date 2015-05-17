<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="/robot/resources/font/css/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="/robot/resources/plugin/tagsinput/bootstrap-tagsinput.css" />
	<link href="/robot/resources/plugin/uniform/css/uniform.default.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="/robot/resources/plugin/wysihtml5/bootstrap-wysihtml5.css" />
<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/layout.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/elements.css" />
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/backend/icons.css" />
<!-- this page specific styles -->
<link rel="stylesheet"
	href="/robot/resources/css/backend/expert-form.css" type="text/css"
	media="screen" />
	<link rel="stylesheet" href="/robot/resources/css/backend/compiled/ui-elements.css" type="text/css" media="screen">
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
	<div class="content">
		<div class="container-fluid">
			<div id="pad-wrapper" class="new-user">
				<div class="row-fluid header">
					<h3>修改专家信息</h3>
				</div>

				<div class="row-fluid form-wrapper">
					<!-- left column -->
					<div class="span9 with-sidebar">
						<div class="container">
							<jsp:include page="form.jsp"></jsp:include>
						</div>
					</div>

					<!-- side right column -->
					<div class="span3 form-sidebar pull-right">
						<div class="btn-group toggle-inputs hidden-tablet">
							<button class="glow left active" data-input="inline">INLINE
								INPUTS</button>
							<button class="glow right" data-input="normal">NORMAL
								INPUTS</button>
						</div>
						<h6>Sidebar text for instructions</h6>
						<p>Add multiple users at once</p>
						<p>Choose one of the following file types:</p>
						<ul>
							<li><a href="#">Upload a vCard file</a></li>
							<li><a href="#">Import from a CSV file</a></li>
							<li><a href="#">Import from an Excel file</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end main container -->
	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<script src="/robot/resources/plugin/uniform/js/jquery.uniform.min.js"></script>
		<script src="/robot/resources/plugin/tagsinput/bootstrap-tagsinput.min.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/expert-form.js"></script>
</body>
</html>