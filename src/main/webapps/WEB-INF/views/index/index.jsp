<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家机器人 - 首页</title>
	<!-- animate css -->
		<link rel="stylesheet" href="/robot/resources/css/common/animate.min.css">
		<!-- bootstrap css -->
		<link rel="stylesheet" href="/robot/resources/css/bootstrapv3/bootstrap.min.css">
		<!-- font-awesome -->
		<link rel="stylesheet" href="/robot/resources/font/css/font-awesome.min.css">
		<!-- custom css -->
		<link rel="stylesheet" href="/robot/resources/css/index/index.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>
			<!-- start home -->
		<section id="home">
			<div class="overlay">
				<div class="container">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10 wow fadeIn" data-wow-delay="0.3s">
							<h1 class="text-upper">比特能·专家机器人</h1>
							<p class="tm-white">This is a fully Responsive, Clean Design, Modern, and Flexible Software Landing Page for startups, businesses and agencies. It is built with HTML5 &amp; CSS3, Bootstrap 3.3.4, Font Awesome 4.3.0, and much more. Designed by <a href="http://www.templatemo.com">templatemo</a>. Images by <a href="http://pixabay.com">Pixabay</a></p>
							<img src="/robot/resources/img/index/software-img.png" class="img-responsive" alt="home img">
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</div>
		</section>

	<section id="search">
	<div class="grid wow fadeInUp" data-wow-delay="0.3s">
		<div class="filling-box">
			<div class="title">
				<h3>各领域专家数据图谱</h3>
			</div>
			<div class="tab-search-box">
				<div class="tab-hd">
					<ul class="search-menu">
						<li><a  v="expert" class="cur">专家</a></li>
						<li><a v="topic"  class="">研究方向</a></li>
						<li><a v="field"  class="">研究领域</a></li>
					</ul>
					<div class="clear"></div>
				</div>
				<div class="tab-bd">
					<div class="input">
						<input id="searchInput" type="text" placeholder="请输入您想了解的专家名称">
						<a class="btn-search">深入分析</a>
						<ul class="dropdown-box"></ul>
					<div class="clear"></div>
					</div>
					<p class="tips">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore</p>
				</div>
			</div>
		</div>
	</div>
	</section>
	
		<!-- start divider -->
		<section id="divider">
			<div class="container">
				<div class="row">
					<div class="col-md-4 wow fadeInUp templatemo-box" data-wow-delay="0.3s">
						<i class="fa fa-laptop"></i>
						<h3 class="text-uppercase">RESPONSIVE LAYOUT</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
					</div>
					<div class="col-md-4 wow fadeInUp templatemo-box" data-wow-delay="0.3s">
						<i class="fa fa-twitter"></i>
						<h3 class="text-uppercase">BOOTSTRAP 3.3.4</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
					</div>
					<div class="col-md-4 wow fadeInUp templatemo-box" data-wow-delay="0.3s">
						<i class="fa fa-font"></i>
						<h3 class="text-uppercase">GOOGLE FONT</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation. </p>
					</div>
				</div>
			</div>
		</section>
		
	<!-- start feature -->
		<section id="feature1">
			<div class="container">
				<div class="row">
					<div class="col-md-6 wow fadeInLeft" data-wow-delay="0.6s">
						<h2 class="text-uppercase">Our Software Features</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						<p><span><i class="fa fa-mobile"></i></span>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						<p><i class="fa fa-code"></i>Quis autem velis reprehenderit et quis voluptate velit esse quam.</p>
					</div>
					<div class="col-md-6 wow fadeInRight" data-wow-delay="0.6s">
						<img src="/robot/resources/img/index/software-img.png" class="img-responsive" alt="feature img">
					</div>
				</div>
			</div>
		</section>
		<!-- end feature -->
	
	<!-- start footer -->
		<footer>
			<div class="container">
				<div class="row">
					<p>Copyright © 2015 - 4ever DAG | Expert Robot </p>
				</div>
			</div>
		</footer>
		<!-- end footer -->
		<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
		<script src="/robot/resources/js/bootstrapv3/bootstrap.min.js"></script>
		<script src="/robot/resources/js/common/wow.min.js"></script>
		<script src="/robot/resources/plugin/echarts/dist/echarts.js"></script>
		<script src="/robot/resources/js/index/index.js"></script>
		
	</body>
</body>
</html>