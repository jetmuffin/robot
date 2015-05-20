// preloader
$(window).load(function(){
    $('.preloader').fadeOut(1000); // set duration in brackets    
});

$(function() {
    new WOW().init();
    
    	$('.search-menu li a').each(function(){
    			var val = $(this).attr('v');
    			$(this).click(function(){
    			
    				console.log(val)
    			});
    			
    		});

    /* Hide mobile menu after clicking on a link
    -----------------------------------------------*/
    $('.navbar-collapse a').click(function(){
        $(".navbar-collapse").collapse('hide');
    });
});

