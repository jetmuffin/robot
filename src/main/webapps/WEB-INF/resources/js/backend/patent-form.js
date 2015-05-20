/**
 * @author Jeff
 */

$(function(){
	var flag1 = flag2 = flag3 = false;
	var notice_icon = '<i class="fa fa-warning"></i>'
	$('input[name="title"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#title-notice').html("");
		} else {
			$('#title-notice').html(notice_icon+" 标题不能为空!");
		}
	});
	
	$('#datepicker').datepicker({
		format: "yyyy月mm日dd",
	});
	
	$('input[name="applicant"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#applicant-notice').html("");
		} else {
			$('#applicant-notice').html(notice_icon+" 申请人不能为空!");
		}
	});
	
	$('input[name="organization"]').blur(function() {
		if ($(this).val().length > 0) {
			$('#organization-notice').html("");
		} else {
			$('#organization-notice').html(notice_icon+" 单位不能为空!");
		}
	});
	
	//add author
	var author_num = 1;
	$('#add-author').click(function(){
		author_num ++ ;
		console.log(author_num);
		var input_dom = '<div class="input-group"><label>发明人'+author_num+':</label> <input id="tags-author" name="inventors"  value=""  data-toggle="popover" title=" " data-content=" " type="text" class="author-input tags span8"></div>';
		$('#authors').append(input_dom);
	});
	
	//submit the form
	$('#patent-submit').click(function(){
		if($('input[name="title"]').val().length == 0){
			$('#title-notice').html(notice_icon+" 标题不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		if($('input[name="applicant"]').val().length == 0){
			$('#applicant-notice').html(notice_icon+" 申请人不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		if($('input[name="organization"]').val().length == 0){
			$('#organization-notice').html(notice_icon+" 单位不能为空!");
			$("html,body").animate({scrollTop:0},100);
			return;
		}
		$('#patent-form').submit();
	});
});