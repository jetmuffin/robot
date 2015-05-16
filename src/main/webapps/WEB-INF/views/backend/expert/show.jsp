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
<link href="/robot/resources/css/backend/lib/bootstrap.datepicker.css" type="text/css" rel="stylesheet">
<link href="/robot/resources/font/css/font-awesome.min.css" type="text/css" rel="stylesheet" />
<!-- global styles -->
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/layout.css" />
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/elements.css" />
<link rel="stylesheet" type="text/css" href="/robot/resources/css/backend/icons.css" />
<!-- this page specific styles -->
<link rel="stylesheet" href="/robot/resources/css/backend/expert-profile.css" type="text/css" media="screen" />
</head>
<body>
	<!-- navbar -->
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<!-- sidebar -->
	<jsp:include page="../common/sidebar.jsp"></jsp:include>
	<!-- main container -->
	<div class="content">

		<div class="container-fluid">
			<div id="pad-wrapper" class="user-profile">
				<!-- header -->
				<div class="row-fluid header">
					<div class="span8">
						<img src="/robot/resources/img/backend/user-thumb.png" class="avatar img-circle" />
						<h3 class="name">周志华</h3>
						<span class="area">南京大学</span>
					</div>
					<a class="btn-flat icon pull-right delete-user"
						data-toggle="tooltip" title="Delete user" data-placement="top">
						<i class="fa fa-trash"></i>
					</a> 
					<a href="/robot/backend/expert/1/edit" class="btn-flat icon large pull-right edit"> 编辑信息 </a>
				</div>

				<div class="row-fluid profile">
					<!-- bio, new note & orders column -->
					<div class="span9 bio">
						<div class="profile-box">
							<!-- biography -->
							<div class="span12 section">
								<h6>个人简介</h6>
								<p>周志华，南京大学教授，计算机科学与技术系副主任，软件新技术国家重点实验室常务副主任，机器学习与数据挖掘研究所（LAMDA）所长，校、系学术委员会委员；ACM杰出科学家，IEEE Fellow，IAPR Fellow，中国计算机学会会士；长江学者特聘教授，国家杰出青年基金获得者。</p>
							</div>

							<h6>个人履历</h6>
								<p>分别于1996年6月、1998年6月和2000年12月于南京大学计算机科学与技术系获学士、硕士和博士学位。2001年1月起留校任教，2002年3月被破格聘任为副教授，2003年29岁获国家杰出青年科学基金，随后被聘为教授，2004年4月获博士生导师资格，2006年入选教育部长江学者特聘教授，2012年当选IEEE Fellow，2013年当选ACM Distinguished Scientist[1] 。2007年创建南京大学机器学习与数据挖掘研究所（LAMDA），2010年11月任软件新技术国家重点实验室常务副主任，2013年5月任计算机系副主任。</p>
							<br />
							
							<h6>研究方向</h6>
							<ul class="area-labels">
								<li><label class="btn-flat white">机器学习</label></li>
								<li><label class="btn-flat white">数据挖掘</label></li>
							</ul>
							<br/>
							
							<h6>科研成果</h6>
								<p>主持973课题、国家自然科学基金重点项目等多项科研课题；出版著作《Ensemble Methods: Foundations and Algorithms》[3] 一部，主编文集多部，在计算机领域一流国际期刊和顶级国际会议发表论文100余篇；获发明专利12项。</p>
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
								<label for="datepicker">活动日期</label>
								<input type="text" id="datepicker"></input> 
								<label for="activity">活动内容</label>
								<textarea name="activity" id="activity"></textarea>
								
								<div class="span12 submit-box pull-right">
									<input type="submit" class="btn-glow primary" value="添加动态" />
									<span>OR</span> <input type="reset" value="取消"
										class="reset" />
								</div>
							</div>
						</div>
					</div>

					<!-- side address column -->
					<div class="span3 address pull-right">
						<h6>地址</h6>
						<ul>
							<li>2301 East Lamar Blvd. Suite 140.</li>
							<li>City, Arlington. United States,</li>
							<li>Zip Code, TX 76006.</li>
							<li class="ico-li"><i class="ico-phone"></i> 1817 274 2933</li>
							<li class="ico-li"><i class="ico-mail"></i> <a href="#">alejandra@detailcanvas.com</a>
							</li>
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
	<script src="/robot/resources/js/jquery/jquery-ui-1.10.2.custom.min.js"></script>
	<script src="/robot/resources/plugin/date-picker/js/bootstrap.datepicker.js"></script>
	<script src="/robot/resources/js/backend/common.js"></script>
	<!-- this page specific scripts -->
	<script src="/robot/resources/js/backend/expert-profile.js"></script>
</body>
</html>