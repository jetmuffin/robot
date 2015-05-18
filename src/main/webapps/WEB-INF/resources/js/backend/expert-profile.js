/**
 *  @author JetMuffin
 */

$(function () {
	$("#datepicker").datepicker();

	var addr_str = $('#expert-address').html();
	var addr = addr_str.split('#');
	var addr_html = '';
	for(var i = 0; i < addr.length; i++){
		addr_html += addr[i];
	}
	$('#expert-address').html(addr_html);
});

