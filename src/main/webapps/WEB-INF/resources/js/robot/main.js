/**
 * 
 */

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

	$("#fOnOff").click(toggleSidebar(document_w,document_h,isOff));
	
	$('#searchInput').bind('keypress',function(event){
   if(event.keyCode == "13")  {
	   getExpertList($(this).val());
        }
    });
	var experts = new Array();
	var expert = {};
	expert["name"] = "周志华";
	expert["avatar"] = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3087230349,1824937363&fm=58";
	experts.push(expert);
	console.log(experts);
	
	loadExpert(experts);
});

var textarea = $("#msg_textarea");
var msg_console = $("#index_msg");
var expert_list = $("#friendBox");

function getExpertList(topic){
	var url = 'http://localhost:8080/robot/expert/getTopTen/3.json';
	$.getJSON(url,function(data){
		console.log(data);
	});
}

function send(){
	var message = $.trim(textarea.val());
	
	msg_console.append('<div class="msg_right"><div class="avatar"></div><div class="cont"><div class="name">游客</div><div>'+message+'</div></div><div class="clear"></div></div>')
	receive(message,"周志华","https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3087230349,1824937363&fm=58");
	systemMsg(message);
	scrollToBottom();
}

function receive(message,name,avatar){
	msg_console.append('<div class="msg_left"><div class="avatar" style="background:url('+avatar+');background-size: cover;"></div><div class="cont"><div class="name">'+name+'</div><div>'+message+'</div></div><div class="clear"></div></div>');
}

function loadExpert(experts){
	$.each(experts,function(i,expert){
		console.log(expert);
		expert_list.append('<div class="friend"><div class="friend_pic" style="background:url(' + expert.avatar +');background-size:cover;"></div><div class="friend_name">'+expert.name+'</div><div class="clear"></div></div>');
	});
}

function systemMsg(message){
	msg_console.append('<div class="msg_left msg_sys"><div class="avatar"></div><div class="cont"><div class="name">系统消息：</div><div>'+message+'</div></div><div class="clear"></div>');
}

function scrollToBottom(){
	$('#index_msg').scrollTop( $('#index_msg')[0].scrollHeight);
}

function toggleSidebar(document_w,document_h,isOff) {
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