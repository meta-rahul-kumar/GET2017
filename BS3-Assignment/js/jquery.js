$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip(); 
	
	$('.collapse').on('show.bs.collapse', function(){
	$(this).parent().find(".glyphicon-plus").removeClass("glyphicon-plus").addClass("glyphicon-minus");
	}).on('hide.bs.collapse', function(){
	$(this).parent().find(".glyphicon-minus").removeClass("glyphicon-minus").addClass("glyphicon-plus");
	});
});

$(document).ready(function(){
	$('.btn-small').hover(function(){
		$('.btn-small').tooltip('destroy');
		if ($(window).width() > 787) {
			$('[data-toggle="tooltip"]').tooltip({title: "Tooltip on the top", placement: 'top' });
		} if($(window).width() > 560 && $(window).width() <600) {
			$('[data-toggle="tooltip"]').tooltip({title: "Tooltip on the top", placement: 'right' });
		} else {
			$('[data-toggle="tooltip"]').tooltip({title: "Tooltip on the right", placement: 'right' });
		}
	}); 
});


	
	