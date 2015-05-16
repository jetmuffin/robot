/**
 *  @author JetMuffin
 */

$(function() {

	// add uniform plugin styles to html elements
	$("input:checkbox, input:radio").uniform();

	$(".wysihtml5").wysihtml5({
		"font-styles" : false
	});
	
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
