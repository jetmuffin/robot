<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家机器人 - 搜索</title>
	<!-- animate css -->
		<link rel="stylesheet" href="/robot/resources/css/common/animate.min.css">
		<!-- bootstrap css -->
		<link rel="stylesheet" href="/robot/resources/css/bootstrapv3/bootstrap.min.css">
		<!-- font-awesome -->
		<link rel="stylesheet" href="/robot/resources/font/css/font-awesome.min.css">
	  <link rel="stylesheet" href="/robot/resources/css/common/common.css" />		
		<!-- custom css -->
		<link rel="stylesheet" href="/robot/resources/css/search/search.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<section id="main">
		<div class="container search-main">
			<div class="filter">
        <div class="filter-all">
            <div class="des">选择搜索类型</div>
            <ul>
                <li class="hover"><a>全站</a></li>
                <li><a href="">专家</a></li>
                <li><a href="">研究方向</a></li>
                <li><a href="">研究领域</a></li>
            </ul>
        </div>
    </div>
		</div>
	</section>
</body>
</html>