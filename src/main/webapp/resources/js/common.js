Common = {
	makePageOnLoadPageNum: function(totalCount, searchParams) {
		var offset = 10;
		var count =  Math.ceil(totalCount / offset); 
		$("#paginate").paginate({
			count: count,
			start: 1,
			display: 20, //페이지 생성 번호 갯수
			border: false,
			text_color: '#79B5E3',
			background_color: 'none',	
			text_hover_color: '#2573AF',
			background_hover_color: 'none', 
			images: false,
			mouse: 'press',
			onChange: function(page){
				pagemove(SearchParams, page);
			}
		});
	},
	makePageNum: function(totalCount, searchParams) {
		var offset = 10;
		var count =  Math.ceil(totalCount / offset); 
		$("#paginate").paginate({
			count: count,
			start: 1,
			display: 20, //페이지 생성 번호 갯수
			border: false,
			text_color: '#79B5E3',
			background_color: 'none',	
			text_hover_color: '#2573AF',
			background_hover_color: 'none', 
			images: false,
			mouse: 'press',
			onChange: function(page){
				pagemove(SearchParams, page);
			}
		});
	},
	ajaxFactory : function(method, url, data, callback){
		$.ajax({
	        type : method,
	        url : url,
	        data : data,
	        dataType : "json",
	        success : function (result) {
	        	callback(result);
	        	
	        },
	        error : function(text){
	        	alert('처리 중 오류 발생 \n'+url)
	        }
	 
	 
	    });
	}
}