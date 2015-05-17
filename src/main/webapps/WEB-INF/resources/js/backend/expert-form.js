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
			duplicateName();
			ok1 = true;
		} else {
			$('#name-notice').html(notice_icon+" 姓名不能为空!");
		}
	});

	$('input[name="organization"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#org-notice').html("");
			ok2 = true;
		} else {
			$('#org-notice').html(notice_icon+" 单位不能为空!");
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
	
	$('#expert-submit').click(function(){
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
		var address = $('input[name="city"]').val() + $('input[name="street"]').val()
		+ $('input[name="province"]').val();
		$('input[name="address"]').val(address);
		$('#expert-form').submit();
	});
	
	//popover
	$(function () {

		});
		
	function duplicateName(){
		$('#input-name').popover({
			  template:'<div id="duplicate-name" class="popover pop-dialog full" role="tooltip"><div class="arrow" style="top: 50%;"></div><div class="body" style="border:none"><div class="settings"><a href="#" class="close-icon" id="close-popover"><i class="fa fa-remove"></i></a><div class="items"><div class="item"><img src="/robot/resources/img/backend/loading.gif" width=30/> 查询重名专家中...</div></div></div></div></div>',
		  }).popover('show');		
	}
	
	//TODO
	function nameValidate(name){
		$.ajax({
			type : "POST",
			url : "#",
			data : "name=23",
			success : function(msg) {
				alert("Data Saved: " + msg);
			}
		});
	}
});
