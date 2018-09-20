// JavaScript Document 错误提示框插件
	var timeout = null;
	var $prompt =$("<div></div>");

	$(function(){
		$("body").append($prompt);
		$prompt.css({
			"width":"0","height":"0", "background-color":"rgba(0,0,0,0.7)",
			"font-size":"20px", "position":"fixed", "top":"-50px", "left":"0", "right":"0", "bottom":"0",
			"margin":"auto","z-index":"2000", "text-align":"center","color":"#fff", "line-height":"60px",
			"-moz-user-select":"none", "-webkit-user-select":"none", "opacity":"0"	
		});
	});

	function prompts(str){
		clearTimeout(timeout);	
		$prompt.html(str);
		$prompt.animate({width:"300px",height:"60px",opacity:"1"},500,function(){
			timeout = setTimeout(function(){	
				$prompt.animate({width:"0",height:"0",opacity:"0"},300,function(){				
					$prompt.html("");	
					clearTimeout(timeout);	
				});
			},1800);
		});		
	}