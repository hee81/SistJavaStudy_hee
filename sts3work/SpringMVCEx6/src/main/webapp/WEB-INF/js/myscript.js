 $(function(){
 	$("#myimg").attr("src","../image/Food/1.jpg");
 	
 	$("#myimg").hover(function(){
 		$(this).attr("src","../image/Food/2.jpg");
 	},function(){
 		$("#myimg").attr("src","../image/Food/1.jpg");
 	});
 });