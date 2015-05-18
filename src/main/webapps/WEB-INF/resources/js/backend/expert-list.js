/**
 *  @author Jeff
 */

$(function(){
	$('.list-org').each(function(){
		var org_str = $(this).html();
		$(this).html('');
		if(org_str != ''){
			org = org_str.split(',');
			for(var i = 0; i < org.length;i++)
				$(this).append(org[i]+" ");
		}
	});
});