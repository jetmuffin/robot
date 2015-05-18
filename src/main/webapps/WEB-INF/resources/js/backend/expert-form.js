/**
 *  @author JetMuffin
 */

$(function() {

	// add uniform plugin styles to html elements
	$("input:checkbox, input:radio").uniform();

	//form validate
	var ok1 = false;
	var ok2 = false;
	var notice_icon = '<i class="fa fa-warning"></i>'
		$('input[name="name"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#name-notice').html("");
			var name = $(this).val();
			duplicateName();
			nameValidate(name);
			ok1 = true;
		} else {
			$('#name-notice').html(notice_icon+" 姓名不能为空!");
		}
	});

	
	$('input[name="email"]').blur(function() {
		var email = $(this).val();
		if (email=="" || ( email!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(email) )) {
			$('#email-notice').html(notice_icon+" 请填写正确的Email格式!");
		} else {
			$('#email-notice').html("");
		}
	});
	
	$('input[name="homepage"]').blur(function() {
		var homepage = $(this).val();
		if (homepage=="" || ( homepage!="" && !/^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/.test(homepage) )) {
			$('#homepage-notice').html(notice_icon+" 请填写正确的网址格式!");
		} else {
			$('#homepage-notice').html("");
		}
	});
	
	//sumit the form
	$('#expert-submit').click(function(){
		var org = $('#tags-org').val();
		var topic = $('#tags-topic').val();
		if(org != '')
			ok2 = true;
		$('input[name="orgnization"]').val(org);
		$('input[name="topic"').val(topic);
		console.log(org);
		if(!ok1){
			$("html,body").animate({scrollTop:0},100);
			$('#name-notice').html(notice_icon+" 姓名不能为空!");
			return;
		}
		if(!ok2){
			$("html,body").animate({scrollTop:0},100);
			$('#org-notice').html(notice_icon+" 单位不能为空!");
			return;
		}
		var address = $('input[name="city"]').val() +'#'+ $('input[name="street"]').val()
		+'#'+ $('input[name="province"]').val();
		$('input[name="address"]').val(address);

		$('#expert-form').submit();
	});
	
	function duplicateName(){
		$('#input-name').popover({
			  template:'<div id="duplicate-name" class="popover pop-dialog full" role="tooltip"><div class="arrow" style="top: 50%;"></div><div class="body" style="border:none"><div class="settings"><a href="#" class="close-icon" id="close-popover"><i class="fa fa-remove"></i></a><div class="items" id="duplicate-item"><div class="item"><img src="/robot/resources/img/backend/loading.gif" width=30/> 查询重名专家中...</div></div></div></div></div>',
		  }).popover('show');		
	}
	
	//check whether the name is duplicate or not
	function nameValidate(name){
		$.ajax({
			type : "GET",
			url : "/robot/backend/expert/check/" + name + ".json",
			success : function(data) {
				
				if(data.length == 0){
					$('#input-name').popover('hide');
				}
				$('#duplicate-item').html('');
				var appendHtml = '';
				$(data).each(function(i, item) {
					console.log(typeof(item.org));

					item.org = typeof(item.org) == "undefined" ?'未知单位':item.org;
					appendHtml += '<a href="/robot/backend/expert/edit/'+item.expertId+
					'"><div class="item"><i class="fa fa-reorder"></i>'
						+ item.name + '<code>'+item.org+'</code>'+'</div></a>';
				});
				$('#duplicate-item').html(appendHtml);
			}
		});
	}
	
	
	//tagsinput
	$('#tags-org').tagsinput({
		  tagClass: 'big label label-info',
		});
	
	$('#tags-topic').tagsinput({
		tagClass: 'big label label-info'
	});
	
	//address to street-city-province
	var address = $('input[name="address"]').val();
	var addr = address.split('#');
	if(addr.length == 3){
		$('input[name="street"]').val(addr[0]);
		$('input[name="city"]').val(addr[1]);
		$('input[name="province"]').val(addr[2]);
	}
	
});
