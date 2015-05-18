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
<link rel="stylesheet" type="text/css"
	href="/robot/resources/css/code-editor.css" />
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
	<div class="content">

		<!-- settings changer -->
		<div class="skins-nav">
			<a href="#" class="skin first_nav selected"> <span class="icon"></span><span
				class="text">Default</span>
			</a> <a href="#" class="skin second_nav" data-file="css/skins/dark.css">
				<span class="icon"></span><span class="text">Dark skin</span>
			</a>
		</div>

		<div class="container-fluid">
			<div id="pad-wrapper">
				<div class="row-fluid editor-header">
					<div class="span12">
						<h4>Ace Code Editor</h4>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div id="editor">/** * In fact, you're looking at ACE right
							now. Go ahead and play with it! * * We are currently showing off
							the JavaScript mode. ACE has support for 45 * language modes and
							24 color themes! */ function add(x, y) { var resultString =
							"Hello, ACE! The result of your math is: "; var result = x + y;
							return resultString + result; } var addResult = add(3, 2);
							console.log(addResult); // build all tooltips from
							data-attributes $("[data-toggle='tooltip']").each(function
							(index, el) { $(el).tooltip({ placement:
							$(this).data("placement") || 'top' }); });</div>
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
	<script src="/robot/resources/plugin/ace/ace.js"></script>
	    <script type="text/javascript">
        var editor = ace.edit("editor");
        // editor.setTheme("ace/theme/github");
        editor.getSession().setMode("ace/mode/javascript");
    </script>
</body>
</html>