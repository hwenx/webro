<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include.jsp"%>
<%@ page session="true" %>
<html>
<head>


<title>welcome</title>
</head>
<body>
<script type="text/javascript">
alert('jenkins 자동 배포 테스트');
//css 로드가 되기전에 dom이 먼저 구성이 되어서 깨지는 화면이 먼저 나옴을 막기 위해 최초에 body를 hide 시키고 css가 로드 된 뒤에 다시 show 함
$('body').hide();
</script>
	<!-- chatting 부분 -->
	<div class="col-md-1" style="position:absolute;z-index: 999;margin-left:50%" id="chatlayout">
            <div class="panel panel-primary" id="dragDiv">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment" id="chatheader"></span> Chat
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown" style="display:none">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </button>
                        <ul class="dropdown-menu slidedown">
                            <li><a href="javascript:changeId();"><span class="glyphicon glyphicon-refresh">
                            </span>대화명 변경</a></li>
                            <!-- <li><a href=""><span class="glyphicon glyphicon-ok-sign">
                            </span>귓속말</a></li> -->
<!--                             <li><a href="http://www.jquery2dotnet.com"><span class="glyphicon glyphicon-remove">
                            </span>Busy</a></li>
                            <li><a href="http://www.jquery2dotnet.com"><span class="glyphicon glyphicon-time"></span>
                                Away</a></li>
                            <li class="divider"></li>
                            <li><a href="http://www.jquery2dotnet.com"><span class="glyphicon glyphicon-off"></span>
                                Sign Out</a></li> -->
                            
                        </ul>
                    </div>
                </div>
                <div class="panel-body" style="display:none;">
                    <ul class="chat">
                       <!--  <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="http://placehold.it/50/55C1E7/fff&amp;text=U" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">Jack Sparrow</strong> <small class="pull-right text-muted">
                                    <span class="glyphicon glyphicon-time"></span>12 mins ago</small>
                                </div>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                    dolor, quis ullamcorper ligula sodales.
                                </p>
                            </div>
                        </li>
                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="http://placehold.it/50/FA6F57/fff&amp;text=ME" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>13 mins ago</small>
                                    <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                </div>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                    dolor, quis ullamcorper ligula sodales.
                                </p>
                            </div>
                        </li>
                        <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="http://placehold.it/50/55C1E7/fff&amp;text=U" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">Jack Sparrow</strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span>14 mins ago</small>
                                </div>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                    dolor, quis ullamcorper ligula sodales.
                                </p>
                            </div>
                        </li>
                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="http://placehold.it/50/FA6F57/fff&amp;text=ME" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>15 mins ago</small>
                                    <strong class="pull-right primary-font">Bhaumik Patel</strong>
                                </div>
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare
                                    dolor, quis ullamcorper ligula sodales.
                                </p>
                            </div>
                        </li> -->
                    </ul>
                </div>
                <div class="panel-footer" style="display:none;">
                    <div class="input-group">
                        <input id="btn-input" type="text" class="form-control input-sm" placeholder="메시지를 입력하세요...">
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat">
                                	보내기</button>
                            <button class="btn btn-warning btn-sm" id="btn-picture">
                                	사진보첨부</button>
                            <input type="file" style="display:none" id="fileInput">
                        </span>
                    </div>
                </div>
            </div>
        </div>
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="jb-cell" style="text-align: center">
            <jsp:include page="./layout/header.jsp" flush="false" />
          </div>
        </div>
      </div>
     
     <div class="row">
     	<div class="col-md-12">
	     	<div class="jb-cell">
	     		<jsp:include page="./layout/body/${bodyContents}" flush="false" />
	     	</div>
     	</div>
     </div>
     
      <div class="row">
        <div class="col-md-12">
          <div class="jb-cell">
            <jsp:include page="./layout/footer.jsp" flush="false" />
          </div>
        </div>
      </div>
    </div>
	

	
</body>
<style>
.jb-cell {
  margin: 2px 0px;
  border: 1px solid #cccccc;
}
.row{
 	margin-left:-2px;
	margin-right:-2px;
	/* border: 1px solid #FF0000; */
	padding-top:10px;
}

/* chat body toggle을 쓰면 자동으로 overflow가 hidden을 먹음 히든을 풀기 위한 방법 */
.panel-body{overflow:auto!important}  
</style>

<script type="text/javascript">				

//socket 서버가 죽어 있으면 화면이 뜨지 않을 수 있으므로 채팅 스크립트와 분리
require(['jquery'], function($) {
	  //css 로드 된 후 body show
	  $('body').show();  	
});

											/* 모바일 draggable 플러그인 하지만 chat body 안에 스크롤 동작안함  */
require(['jquery', 'socket.io', 'jquery.ui'/* , 'jquery.touch' */], function($, io) {
	  //접속된 유저 리스트 저장
	  var connectUser = [];
	  
 	  $('#chatheader').on('click', function(e){
 		  if($('.panel-body').is(':visible')){
 		  	$('#chatlayout').attr('class', 'col-md-1');
 		  }else{
 		  	$('#chatlayout').attr('class', 'col-md-4');
 		  }
 		  
		  	$('.panel-body').slideToggle();
			$('.panel-footer').slideToggle();
			$('.dropdown-toggle').slideToggle();
	  });
	  
	  var loginYn = "${isLoginYn}";
	  var userId = '';
	  if('Y' === loginYn){
		  userId = '${sessionScope.email}'
	  }else{
		  userId = noMemberId();
	  }
	  var sendData = {};
	  
	  //서버에 보낼 데이터 오브젝트
	  sendData = {
		userId 		    : userId,   //아이디
		beforeId	    : '',		//변경전 아이디
		msg 		    : '',       //메시지
		msgType 	    : '',		//메시지 타입
		whisperTarget   : '',		//귓속말 대상
		whisperReceive  : '',		//귓속말 보낸 유저 
		fromId 		    : '',		//귓속말 상대
		userType 	    : 'GUEST',  //사용자타입
		userState       : 'F',		//전송 타입 F=최초접속, CID=아이디변경
		picData 	    : ''	    //사진
	  }
	  
	  var socket = io.connect(window.socketioAddr);
	  userInit();
	  
	  $('#btn-chat').on('click', function(e){
		  e.preventDefault();
		  sendData.msg = $('#btn-input').val();
          socket.emit('fromclient', sendData);
          $('#btn-input').val('');
          msgDisplay(sendData, 'me');
	  })
	  
	  $('#btn-picture').on('click', function(e){
		  e.preventDefault();
		  $('#fileInput').click();
	  })
	  
	   $("#fileInput").change(function(){
        //alert(this.value); //선택한 이미지 경로 표시
        readURL(this);
    	});
	  
	  window.readURL = function(input) {
			console.log(input.files[0].name);
			var fileSuffix = input.files[0].name.substring(input.files[0].name.lastIndexOf(".") + 1);
			console.log(fileSuffix);
		    fileSuffix = fileSuffix.toLowerCase();
		    if ( "jpg" == fileSuffix || "jpeg" == fileSuffix  || "gif" == fileSuffix || "bmp" == fileSuffix ){
		    }else{
		    	alert('이미지 파일이 압니다.');
		    	return;
		    } 
		        
		    
		    
	        if (input.files && input.files[0]) {
	            var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
	            reader.onload = function (e) {
	            //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
	                
	                sendData.picData = e.target.result;
	                sendData.msgType = 'PIC';
	                socket.emit('fromclient', sendData); 
	                $('#btn-input').val('');
	                msgDisplay(sendData, 'me');
	                sendData.msgType= '';
	                //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
	                //(아래 코드에서 읽어들인 dataURL형식)
	            }                   
	            reader.readAsDataURL(input.files[0]);
	            //File내용을 읽어 dataURL형식의 문자열로 저장
	        }
	    }//readURL()--
	  
	  //서버로 보냄
	  $("#btn-input").keyup(function(event) {
		  event.preventDefault();
		  var msg = $('#btn-input').val();
		  
		  //귓속말 관련 로직  32 space bar
		  if(event.which == 32){
			  if(msg.indexOf('/x') !== -1 && msg.length === 3){
				  sendData.whisperTarget = '';
				  $('#btn-input').val('');
				  $('#btn-input').attr('placeholder', '메시지를 입력하세요...');
			  }
			  
			  // [/w]
			  if(msg.indexOf('/w') !== -1){
				  var position = [];
				  var pos = msg.indexOf(' ');
				  
				  //찾을 위치를 증가 시키면서 공백의 index 위치를 찾음
				  while(pos > -1){
					  position.push(pos);
					  pos = msg.indexOf(' ', pos+1);
				  }
				  //공백이 3개 이상이면 귓속말 기능 동작안함 형식에 맞지 않는 명령어를 썻을 경우 방어 로직
				  if(position.length >= 3){
					  return;
				  }
				  
				  //공객이 2개가 있을 경우 /w_아이디_ 아이디만 뽑기 위함  
				  if(position.length === 2){
				  	var whisperTarget = msg.substring(position[0], position[1]).trim();
				  	if(userCheck(whisperTarget)){
					  	sendData.whisperTarget = whisperTarget;
					  	$('#btn-input').val('');
					  	$('#btn-input').attr('placeholder', whisperTarget+'님 에게 보낼 메시지를 입력하세요');	
				  	}else{
				  		$('#btn-input').val('');
				  		$('#btn-input').attr('placeholder', '존재 하지 않거나 자신에게 귓속말할 수 없습니다.');
				  	}
				  	
				  }
			  }
			  
			  //[/r]
			  if(msg.indexOf('/r') !== -1){
				  if(msg.length === 3){
					  var whisperReceive = sendData.whisperReceive.trim();
					  if(whisperReceive !== '' && whisperReceive !== undefined){
						if(userCheck(whisperReceive)){
						    sendData.whisperTarget = whisperReceive;
					  	    $('#btn-input').val('');
					  	    $('#btn-input').attr('placeholder', whisperReceive+'님 에게 보낼 메시지를 입력하세요');	
					  	}else{
					  		$('#btn-input').val('');
					  		$('#btn-input').attr('placeholder', whisperReceive+' 존재 하지 않습니다.');
					  	}
						  
					  }
				  }
			  }
			  
		  }		
		  
          if (event.which == 13) {
        	  sendData.msg = msg;
              socket.emit('fromclient', sendData);
              $('#btn-input').val('');
              msgDisplay(sendData, 'me');
              $('#btn-input').attr('placeholder', '메시지를 입력하세요...');
              
          }
      });
	  
	  //서버로 부터 받음
      socket.on('toclient',function(data){
    	  //io connection 동시에 서버로 부터 받는 부분
          if(data.userId === undefined){
        	  data.userId = 'Admin';
        	  sendData.userState = '';
          }
          
    	  //최초 userInit() 실행시에 서버로 부터 받는 부분
          if(data.userState === 'F'){
        	  data.msg = data.userId + '님 접속 하였습니다';
          }
          
          //아이디 변경시 알릴 메시지
          if(data.userState === 'CID'){
        	  data.msg = data.beforeId +' --> '+data.userId + '로 아이디를 변경 하였습니다.';
        	  data.userId = 'ADMIN';
        	  sendData.userState = '';
          }
          
          msgDisplay(data, 'you');
      });
      
	  //사용자가 추가되거나 삭제 될때 마다 사용자 리스트를 받음
      socket.on('userlist', function(data){
    	  connectUser = data.users;
    	  console.log('userList : ' + data.users);
      })
      
      function userCheck(user){
		  for(var i in connectUser){
			  if(connectUser[i] === user){
				  if(sendData.userId !== connectUser[i]){
					  return true;
				  }
			  }
		  }
		  return false;
	  }
      
      
      //비회원아이디 생성
      function noMemberId(){
    	  var d = new Date();
    	  var id = 'GUEST'+d.getHours()+''+d.getMinutes()+''+d.getSeconds()+''+Math.floor(Math.random() * 20) + 1;
    	  return id;
      }
      
	  //사용자 초기화
      function userInit(){
    	  socket.emit('init', sendData)
      }
      
      function msgDisplay(data, type){
    	  var html = '';
    	  if('me' === type){
	    	  var bodyDiv = '';
    		  if(data.whisperTarget !== ''){
    			  bodyDiv = '<div class="chat-body clearfix" style="background-color:yellow">'
    			  //귓속말 초기화
    			  sendData.whisperTarget = '';
    			  $('#btn-input').attr('placeholder', '메시지를 입력하세요...')
    		  }else{
	    	  	  bodyDiv = '<div class="chat-body clearfix">';
    		  }
    		  
    		  html = '<li class="right clearfix"><span class="chat-img pull-right">'+
 	  		 '<img src="http://placehold.it/50/FA6F57/fff&amp;text=ME" alt="User Avatar" class="img-circle"></span>'+
 	  		  bodyDiv+
 	  		 '<div class="header">'+
 	  		 '<small class=" text-muted"><span class="glyphicon glyphicon-time"></span>'+getTime()+'</small>'+
 	  		 '<strong class="pull-right primary-font">'+data.userId+'</strong>'+
 	  		 '</div>'+
 	  		 '<p>'+(data.msgType !== 'PIC'?data.msg:'<img src="'+data.picData+'" width="50%" height="50%">')+'</p>'+
 	  		 '</div></li>';
    	  }else{
    		  var bodyDiv = '';
    		  if(data.whisperTarget !== '' && data.whisperTarget !== undefined){
    			  bodyDiv = '<div class="chat-body clearfix" style="background-color:yellow">'
    			  //귓속말 보낸 유저 저장 하기 /r 사용을 위해 저장함 
    			  sendData.whisperReceive = data.userId;
    		  }else{
	    	  	  bodyDiv = '<div class="chat-body clearfix">';
    		  }
    		  
    		  
    		  html = '<li class="left clearfix"><span class="chat-img pull-left">'+
  	  		 '<img src="http://placehold.it/50/55C1E7/fff&amp;text=U" alt="User Avatar" class="img-circle"></span>'+
  	  		   bodyDiv+
  	  		 '<div class="header">'+
  	  		 '<strong class="primary-font">'+data.userId+'</strong> <small class="pull-right text-muted">'+
  	  		 '<span class="glyphicon glyphicon-time"></span>'+getTime()+'</small>'+
  	  		 '</div>'+
  	  		 '<p>'+(data.msgType !== 'PIC'?data.msg:'<img src="'+data.picData+'" width="50%" height="50%">')+'</p>'+
  	  		 '</div></li>';
    		  
    		  
    	  }
    	  
    	  $('.chat').append(html);
    	  //자동 스크롤 기능
    	  $('.panel-body').animate({
              scrollTop: $('.panel-body')[0].scrollHeight}, 1000);
    	  		 
      }
      
      function getTime(){
    	  var d = new Date();
    	  return d.getHours()+'시 '+d.getMinutes()+'분 '+d.getSeconds()+'초';
      }
      
      //chat div draggable
      $('#dragDiv').draggable();
      
      //모바일에서 draggable 이 작동을 하지 않아 jquery.touch을 추가 하여 가능 하게 하였지만 
      //jquery.touch를 추가 하자 모바일에서 input=text에 터치를 해도 포커스가 가지 않아 아래 구문을 추가함 
	  $('#btn-input').on('click', function(e){
    	e.preventDefault();
	  	$(this).focus();
      });
      
      
      //아이디변경
      window.changeId = function(){
    	  var inputString = prompt('변경할 아이디를 입력 하여 주시기 바랍니다.', '영어 숫자만 사용 하실 수 있습니다.');
    	  var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
  		  var check = special_pattern.test(inputString);
  		  if(check){
  		    alert('특수문자는 사용할 수 없습니다.');
  		    return false;
  		  }
  		  sendData.beforeId =  sendData.userId;			//아이디 변경시			
  		  sendData.userState = 'CID';			//아이디 변경시			
  		  sendData.userId = inputString;
  		  userInit();
  		  
      }
      
});
</script>
</html>