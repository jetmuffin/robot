<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>比特能专家机器人 - 机器人</title>
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
<link rel="stylesheet" href="/robot/resources/css/robot/robot.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>

	<section id="main">
	<div id="friendList">
		<div id="fList">
			<div id="friendBox">
				<div class="friend">
					<div class="friend_pic"></div>
					<div class="friend_name">ADMIN</div>
					<div class="clear"></div>
				</div>
			</div>
			<button class="btn btn-primary" data-toggle="modal"
				data-target="#loadExpert" id="add-expert">选择研究领域</button>
		</div>
		<div id="fOnOff"></div>

	</div>
	<div id="index_main" style="float: right">

		<div id="index_msg" class="msg">
			<div class="msg_left msg_sys">
				<div class="avatar"></div>
				<div class="cont">
					<div class="name">系统消息：</div>
					<div>admin 上线了</div>
				</div>
				<div class="clear"></div>
			</div>

			<div class="msg_left">
				<div class="avatar"></div>
				<div class="cont">
					<div class="name">name</div>
					<div>Hello World !</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="msg_right">
				<div class="avatar"></div>
				<div class="cont">
					<div class="name">name</div>
					<div>Hello World !</div>
				</div>
				<div class="clear"></div>
			</div>

		</div>
		<div class="clear"></div>

		<div id="index_send" class="msg">
			<div id="to">
				<span><b>提问: </b></span>
			</div>
			<div style="height: 8px"></div>
			<div class="row">
				<textarea class="col-md-10" id="msg_textarea">
          
        </textarea>
				<button class="col-md-2 btn btn-primary" id="send" onclick="send()">发送</button>
			</div>

			<div id="send_notice">按Ctrl+Enter发送</div>
		</div>
	</div>
	<div class="clear"></div>
	</section>

	<!-- Modal -->
	<div class="modal fade" id="loadExpert" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div id="pipe_2" class="choosing expert-choosing">
					<h1 class="choosing-h1">选择参与决策的专家</h1>
					<div class="base-form">
						<div class="base-line">
							<label>热门领域</label>
							<div class="bd" id="choosing-h1Type" type="radio">
								<label class="tag tag-hover"> <a href="#">数据挖掘</a>
								</label> <label class="tag"> <a href="#">机器学习</a>
								</label> <label class="tag"> <a href="#">自然语言处理</a>
								</label> <label class="tag"> <a href="#">人工智能</a>
								</label>
							</div>
						</div>
						<div class="base-line">
							<label>搜索领域:</label>
							<div class="">
								<input type="text" value="" placeholder="输入具体领域名称" id="searchInput">
							</div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="tabDiv">
						<table>
							<thead>
								<tr>
									<th class="col1">专家名</th>
									<th class="col2">单位</th>
									<th class="col3">专家评分</th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="/robot/resources/js/jquery/jquery-2.0.0.min.js"></script>
	<script src="/robot/resources/js/bootstrapv3/bootstrap.min.js"></script>
	<script src="/robot/resources/js/robot/main.js"></script>
</body>
</html>