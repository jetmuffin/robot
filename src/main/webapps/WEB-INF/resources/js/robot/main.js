/**
 * 
 */

var textarea = $("#msg_textarea");
var msg_console = $("#index_msg");
var expert_list = $("#friendBox");
var experts = new Array();
var tbody = $('.tabDiv tbody');

$(document).ready(function() {
	var height = document.body.clientHeight;
	$("body").scrollTop(height + 1000);

	var document_h = document.documentElement.clientHeight - 124;
	var document_w = document.documentElement.clientWidth - 90;
	$("#friendList").css('height', document_h + 'px');
	$("#fList").css('height', (document_h - 24) + 'px');
	$("#fOnOff").css('height', (document_h - 24) + 'px');
	$("#index_main").css('width', document_w + 'px');

	var isOff = true;

	$("#fOnOff").click(toggleSidebar(document_w, document_h, isOff));

	$('#searchInput').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			getExpertList($(this).val());
		}
	});

	$('.hot-keyword').click(function() {
		getExpertList($(this).html());
	});

	textarea.keydown(function(e) {
		if (e.ctrlKey && e.keyCode == 13) {
			send();
			
		}
	})
});

function getExpertList(topic) {
	var url = '/robot/expert/getTopTen/' + topic + '.json';
	tbody.html("");
	$('#searchLoading')
			.html(
					'<img src="/robot/resources/img/backend/loading.gif"/><p>正在查找中..</p>.');
	$
			.getJSON(
					url,
					function(data) {
						$('#searchLoading').html("");
						$
								.each(
										data,
										function(i, item) {
											console.log(item);
											tbody
													.append('<tr><td><a href="#" onclick="chooseExpert(this)" class="expertButton" data-id="'
															+ item.expertId
															+ '">'
															+ item.name
															+ '</a></td><td>'
															+ item.org
															+ '</td><td>'
															+	 item.rate
															+'</td></tr>')
										});

						var expertsStr = "";
						// 确认专家选择
						$('#confirmButton')
								.click(
										function() {
											experts = new Array();
											expertsStr = "";
											var expertsButton = $('.expertButton.chosen');
											// 找到选中的专家
											expertsButton
													.each(function() {
														var id = $(this).attr(
																"data-id");
														// 获取数据
														$
																.each(
																		data,
																		function(
																				i,
																				item) {
																			if (item["expertId"] == id) {
																				if (item["url"] == null)
																					item["url"] = "/robot/resources/img/common/user-thumb.png";
																				experts
																						.push(item);
																				expertsStr += item["name"]
																						+ " ";
																			}
																		});
													});
											// 关闭对话框
											$('#loadExpert').modal('hide');
											// 加载专家
											loadExpert(experts);
											// 显示系统信息
											systemMsg(expertsStr + "加入讨论组");
										});
					});
}

function chooseExpert(selector) {
	$(selector).toggleClass("chosen");
}

function send() {
	var message = $.trim(textarea.val());

	msg_console
			.append('<div class="msg_right"><div class="avatar"></div><div class="cont"><div class="name">游客</div><div>'
					+ message + '</div></div><div class="clear"></div></div>')
	receive(message, "周志华",
			"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3087230349,1824937363&fm=58");
	scrollToBottom();
	textarea.val("");
}

function receive(message, name, avatar) {
	msg_console
			.append('<div class="msg_left"><div class="avatar" style="background:url('
					+ avatar
					+ ');background-size: cover;"></div><div class="cont"><div class="name">'
					+ name
					+ '</div><div>'
					+ message
					+ '</div></div><div class="clear"></div></div>');
}

function loadExpert(experts) {
	expert_list.html("");
	$
			.each(
					experts,
					function(i, expert) {
						console.log(expert);
						expert_list
								.append('<div class="friend"><div class="friend_pic" style="background:url('
										+ expert.url
										+ ');background-size:cover;"></div><div class="friend_name">'
										+ expert.name
										+ '</div><div class="clear"></div></div>');
					});
}

function systemMsg(message) {
	msg_console
			.append('<div class="msg_left msg_sys"><div class="avatar"></div><div class="cont"><div class="name">系统消息：</div><div>'
					+ message + '</div></div><div class="clear"></div>');
	scrollToBottom();
}

function scrollToBottom() {
	$('#index_msg').scrollTop($('#index_msg')[0].scrollHeight);
}

function toggleSidebar(document_w, document_h, isOff) {
	if (isOff) {
		$("#fList").show(500);
		$("#friendList").animate({
			width : "260px"
		}, 500);
		$("#index_main").animate({
			width : document_w - 210
		}, 400);
		isOff = false;
	} else {
		$("#fList").hide(500);
		$("#friendList").animate({
			width : "48px"
		}, 500);
		$("#index_main").animate({
			width : document_w
		}, 600);
		isOff = true;
	}
}