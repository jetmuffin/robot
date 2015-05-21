/**
 *  @author JetMuffin
 */

$(function(){
	
	//select search type
	$('#search-menu li').click(function(){
		var type = $(this).attr('data-key');
		$('#search-menu li.current').removeClass("current");
		$(this).addClass("current");
		$('#typeInput').val(type);
		if(type == "expert"){
			$('#keyInput').attr('placeholder',"输入专家名，如：周志华");
			$('.selectui-result').html("专家");
		}else if(type == "field"){
			$('#keyInput').attr('placeholder',"输入研究领域名称，如：计算机");
			$('.selectui-result').html("领域");
		}else if(type == "topic"){
			$('#keyInput').attr('placeholder',"输入研究方向名称，如：机器学习");
			$('.selectui-result').html("方向");
		}
	});
});