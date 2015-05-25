// preloader
$(window).load(function(){
    $('.preloader').fadeOut(1000); // set duration in brackets    
});

$(function() {
    new WOW().init();
    		
    	var curNav = $('.search-menu li a');
    	var searchInput = $('#searchInput');
    	var searchType = 'expert';
    	$('.search-menu li a').each(function(){
    		$(this).click(function(){
    				searchType = $(this).attr('v');
    				curNav.removeClass('cur');
    				$(this).addClass('cur');
    				if(searchType == "expert")
    						searchInput.attr('placeholder','请输入您想了解的专家姓名');
    				else if(searchType == "topic")
    					searchInput.attr('placeholder',"请输入您想了解的研究方向");
    				else if(searchType == "field")
    					searchInput.attr('placeholder','请输入您想了解的研究领域');
    			});
    		});
    	
    searchInput.keydown(function(event){
    		if(event.keyCode == 13){
    			var searchKey = searchInput.val();
    			window.open('/robot/search?searchKey='+searchKey+'&searchType='+searchType );
    		}
    	}	);
    $('.btn-search').click(function(){
    			var searchKey = searchInput.val();
    			if(searchKey.length != 0)
    				window.open('/robot/search?searchKey='+searchKey+'&searchType='+searchType );
    		});
    
    /* Hide mobile menu after clicking on a link
    -----------------------------------------------*/
    $('.navbar-collapse a').click(function(){
        $(".navbar-collapse").collapse('hide');
    });
});

