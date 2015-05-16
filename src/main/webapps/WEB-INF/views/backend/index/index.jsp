<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
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
<link href="/robot/resources/css//backend/lib/jquery-ui-1.10.2.custom.css" rel="stylesheet"
	type="text/css" />
<link href="/robot/resources/font/css/font-awesome.min.css" type="text/css" rel="stylesheet" />
<!-- global styles -->
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/layout.css" />
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/elements.css" />
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/icons.css" />
<!-- this page specific styles -->
<link rel="stylesheet" href="/robot/resources/css/backend/compiled/index.css" type="text/css" media="screen" />
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
    <div class="content">
        <div class="container-fluid">
            <!-- upper main stats -->
            <div id="main-stats">
                <div class="row-fluid stats-row">
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">2457</span>
                            Experts
                        </div>
                        <span class="date">收录专家</span>
                    </div>
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">3240</span>
                            Topics
                        </div>
                        <span class="date">研究方向</span>
                    </div>
                    <div class="span3 stat">
                        <div class="data">
                            <span class="number">322</span>
                            Fields
                        </div>
                        <span class="date">学术领域</span>
                    </div>
                    <div class="span3 stat last">
                        <div class="data">
                            <span class="number">6532</span>
                            	Papers
                        </div>
                        <span class="date">收录论文</span>
                    </div>
                </div>
            </div>
            <!-- end upper main stats -->
            <div id="pad-wrapper">
									<h3>你好,世界!</h3>
            </div>
        </div>
    </div>
	<!-- scripts -->
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrap/bootstrap.min.js"></script>
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/index.js"></script>
</body>
</html>