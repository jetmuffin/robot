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
<link rel="stylesheet" href="/robot/resources/css/backend/expert-import.css" />
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
				<h3>导入专家文件</h3>
			</div>

			<div class="container-fluid"></div>
			<div class="row-fluid form-wrapper">
				<div class="container">
					<form class="import-expert-form inline-input">
						<div class="span12 field-box ">
							<label>要导入的文件:</label> <input type="file" name="file"
								class="span9" />
						</div>
					<div class="span12 field-box ">
						<label>导入格式:</label> 
						<select name="type" id="file-type">
							<option value="CSV">CSV</option>
							<option value="Json">Json</option>
							<option value="xls">XLS</option>
						</select>
						<span class="charactersleft">文件必须以相应的格式结尾,如<strong>.csv</strong>,<strong>.json</strong></span>
					</div>						
					<div class="clear"></div>
					</form>
				<h5>导入状态:</h5>
				<div class="profile-box">
					<div id="import-console">
					<button id="conn-btn">建立链接</button>
						<div id="connect"></div>
						<div id="disconnect"></div>
						<div id="conversationDiv"></div>
						<div id="response"></div>
					</div>
				</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/expert-import.js"></script>
</body>
</html>