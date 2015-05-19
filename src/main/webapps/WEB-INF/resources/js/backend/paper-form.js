/**
 *  @author Jeff
 */

$(function(){
	
	//tagsinput
	$('#tags-keywords').tagsinput({
		  tagClass: 'big label label-info',
		});
	
	//datepicker
	$("#datepicker").datepicker();
	
	//add author
	var author_num = 1;
	$('#add-author').click(function(){
		author_num ++ ;
		var input_dom = '<div class="input-group"><label>作者'+author_num+':</label> <input id="tags-author" name="authors" onblur="duplicateName(this)" value=""  data-toggle="popover" title=" " data-content=" " type="text" class="author-input tags span8"></div>';
		$('#authors').append(input_dom);
	});
	
	//form validate
	var flag1 = flag2 = flag3 = false;
	var notice_icon = '<i class="fa fa-warning"></i>'
	$('input[name="title"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#title-notice').html("");
			flag1 = true;
		} else {
			$('#title-notice').html(notice_icon+" 标题不能为空!");
		}
	});
	
	$('input[name="journal"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#journal-notice').html("");
			flag2 = true;
		} else {
			$('#journal-notice').html(notice_icon+" 期刊不能为空!");
		}
	});
	
	$('input[name="issue"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#issue-notice').html("");
			flag3 = true;
		} else {
			$('#issue-notice').html(notice_icon+" 刊号不能为空!");
		}
	});
	
	
	//submit the form
	$('#paper-submit').click(function(){
		if($('input[name="title"]').val().length == 0){
			$('#title-notice').html(notice_icon+" 标题不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		var author = $('#author-input').val();
		console.log(author);
		if(author.length == 0){
			$('#author-notice').html(notice_icon+" 作者不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		if($('input[name="journal"]').val().length == 0){
			$('#journal-notice').html(notice_icon+" 期刊不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		if($('input[name="issue"]').val().length == 0){
			$('#issue-notice').html(notice_icon+" 刊号不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		var keywords = $('#tags-keywords').val();
		$('input[name="author"]').val(author);
		$('input[name="keywords"]').val(keywords);
		$('.author-input').each(function(){
			console.log($(this).attr('data-id'));
		});
		$('#paper-form').submit();
	});
	
	//change type
	 $("input[name=type]").change(function(){
		  changeType(this);
		 });
});

//check whether the name is duplicate or not
function nameValidate(name,inputSelector){
	$.ajax({
		type : "GET",
		url : "/robot/backend/expert/check/" + name + ".json",
		success : function(data) {
			if(data.length == 0){
				$('#author-input').popover('hide');
			}
			$('#duplicate-item').html('');
			var appendHtml = '';
			$(data).each(function(i, item) {
				item.org = typeof(item.org) == "undefined" ?'未知单位':item.org;
				appendHtml += '<a href="#" onclick="selectExpert(this)" data-id="'+item.expertId+'"><div class="item"><i class="fa fa-reorder"></i>'
					+ item.name + '<code>'+item.org+'</code>'+'</div></a>';
			});
			$('#duplicate-item').html(appendHtml);
		}
	});
}

function selectExpert(selector){
	var id = $(selector).attr('data-id');
	$(selector).parents(".input-group").children("input").attr("data-id",id);
}
function duplicateName(selector){
	$(selector).popover({
		  template:'<div id="duplicate-name" class="popover pop-dialog full" role="tooltip"><div class="arrow" style="top: 50%;"></div><div class="body" style="border:none"><div class="settings"><a href="#" class="close-icon" id="close-popover"><i class="fa fa-remove"></i></a><div class="items" id="duplicate-item"><div class="item"><img src="/robot/resources/img/backend/loading.gif" width=30/> 查询重名专家中...</div></div></div></div></div>',
	  }).popover('show');	
	nameValidate($(selector).val());
}

function changeType(selector){
	var type = $(selector).val();
	if(type == "journal"){
		$('#journal-info').show();
		$('#conference-info').hide();
	} else {
		$('#journal-info').hide();
		$('#conference-info').show();
	}
}