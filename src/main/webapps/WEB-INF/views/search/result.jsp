<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/robot/resources/css/search/search.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<section id="main">
	<div class="left-side">
		<div class="total">共找到<strong>2</strong>个结果</div>
		<div class="filter">
			<div class="filter-all">
				<div class="des">选择搜索类型</div>
				<ul>
					<li class="hover"><a href="#">专家</a></li>
					<li><a href="#">研究领域</a></li>
					<li><a href="#">研究方向</a></li>
				</ul>
			</div>
			<div class="filter-item">
				<div class="item-hd">
					地区选择<i class="icon up" jd="e:drop,ua"></i>
				</div>
				<ul>
					<li class="item"><i class="icon checked"></i> <span
						class="name">所有</span></li>
					<li class="item"><i class="icon"></i> <span class="name"
						title="江苏">江苏</span> <span class="rs" title="1">1</span></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="right-side">
		<div class="search-input">
			<form method="get" action="/robot/search">
				<fieldset>
					<div class="selectui search-field" data-maxheight="200"
						data-dock="false">
						<div class="selectui-head">
							<div class="selectui-result">专家</div>
							<div class="selectui-drop"  data-name="searchField" data-toggle="dropdown"></div>
							<ul class="dropdown-menu" role="menu" id="search-menu">
						    <li class="current" data-key="expert"><a href="#">专家</a></li>
						    <li data-key="field"><a href="#">研究领域</a></li>
						    <li data-key="topic"><a href="#">研究方向</a></li>
						  </ul>
						</div>

					</div>
					<div class="float-left relative">
						<button type="submit">
							<i class="icon-32-nd icon-32-find"></i>搜索
						</button>
						<input maxlength="100" type="text" data-selector="keyword"
							data-synonym-key="4" class="keyword input-large " name="searchKey"
							size="20" placeholder="输入专家名，如：周志华"  id="keyInput">
						<input type="text" style="display:none" name="searchType" id="typeInput"/>
						<div class="sojob-suggest" data-selector="sojob-suggest"></div>
					</div>
				</fieldset>
			</form>
		</div>

		<div class="result">
			<ul>
				<li>
					<div class="expert-avatar">
						<a href="#"><img
							src="/robot/resources/img/common/user-thumb.png" alt="" /></a>
					</div>
					<div class="expert-info info-item">
						<a class="expert-name info-item" href="/robot/expert/30">周志华</a>
						<div class="expert-org info-item">南京大学</div>
						<div class="expert-field info-item">
							研究领域 :<span>计算机</span>
						</div>
						<div class="expert-topic info-item">
							研究方向 :<span>机器学习</span><span>人工智能</span>
						</div>
						<div class="expert-paper info-item">
							发表文章: <span>30</span> 被引用: <span>18</span> 专利数: <span>9</span>
						</div>
					</div>
					<div class="clear"></div>
				</li>
				<li>
					<div class="expert-avatar">
						<a href="#"><img
							src="/robot/resources/img/common/user-thumb.png" alt="" /></a>
					</div>
					<div class="expert-info">
						<a class="expert-name info-item" href="#">姚期智</a>
						<div class="expert-org info-item">清华大学</div>
						<div class="expert-field info-item">
							研究领域 :<span>计算机</span>
						</div>
						<div class="expert-topic info-item">
							研究方向 :<span>计算机理论</span>
						</div>
						<div class="expert-paper info-item">
							发表文章: <span>30</span> 被引用: <span>18</span> 专利数: <span>9</span>
						</div>
					</div>
					<div class="clear"></div>
				</li>
			</ul>
		</div>

	</div>
	<div class="clear"></div>
	</section>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
<script src="/robot/resources/js/bootstrapv3/bootstrap.min.js"></script>
<!-- custom javascript -->
<script src="/robot/resources/js/search/result.js"></script>
</html>