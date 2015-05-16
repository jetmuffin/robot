/**
 *  @author JetMuffin
 */

$(function() {

	// add uniform plugin styles to html elements
	$("input:checkbox, input:radio").uniform();

	var ok1 = false;
	var ok2 = false;
		$('input[name="name"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#name-notice').text("");
			ok1 = true;
		} else {
			$('#name-notice').text("姓名不能为空!");
		}
	});

	$('input[name="organization"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#org-notice').text("");
			ok2 = true;
		} else {
			$('#org-notice').text("单位不能为空!");
		}
	});
	
	$('input[name="email"]').blur(function() {
		var email = $(this).val();
		if (email=="" || ( email!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(email) )) {
			$('#email-notice').text("请填写正确的Email格式!");
		} else {
			$('#email-notice').text("");
		}
	});
	
	$('input[name="homepage"]').blur(function() {
		var homepage = $(this).val();
		if (homepage=="" || ( homepage!="" && !/^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/.test(homepage) )) {
			$('#homepage-notice').text("请填写正确的网址格式!");
		} else {
			$('#homepage-notice').text("");
		}
	});
	
	$('#expert-submit').click(function(){
		if(!ok1){
			$("html,body").animate({scrollTop:0},100);
			$('#name-notice').text("姓名不能为空!");
			return;
		}
		if(!ok2){
			$("html,body").animate({scrollTop:0},100);
			$('#org-notice').text("单位不能为空!");
			return;
		}
		var address = $('input[name="city"]').val() + $('input[name="street"]').val()
		+ $('input[name="province"]').val();
		$('input[name="address"]').val(address);
		$('#expert-form').submit();
	});
});
