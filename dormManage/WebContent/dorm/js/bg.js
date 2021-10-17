//判断是否是PC端

window.onload=function(){
	isPc();
}


function isPc(){
	
    var sUserAgent = navigator.userAgent.toLowerCase();
    if (/iphone|midp|rv:1.2.3.4|ucweb|android|windows ce|windows mobile/.test(sUserAgent)) {
	  
	  
    }
	//PC端
	else{
	
	  var bg_pc =["0.jpg", "1.jpg", "2.jpg","3.jpg","4.jpg","5.jpg"];    //（设定想要显示的图片）
	  var length=bg_pc.length;
	  var imgPath="dorm/img/bg_pc/";
	  var pc=$("#bg");
	  $("#body").css({
	    backgroundImage:"linear-gradient(to left, rgba(255, 0, 149, 0.2), rgba(0, 247, 255, 0.2)),url("+imgPath+bg_pc[getIndex(length)]+")"
	    
	  });
	  
        setInterval(function (){time(pc,bg_pc,length,imgPath)},5000);//循环调用time1()函数，时间间隔为2000ms
	}
	
 }
 
function time(object,arr,length,imgPath){
	 
	 object.fadeOut(1000,function(){
	 object.css({
	    backgroundImage:"linear-gradient(to left, rgba(255, 0, 149, 0.2), rgba(0, 247, 255, 0.2)),url("+imgPath+arr[getIndex(length)]+")"
	 }); 
	  
	}) 
	object.fadeIn(1500);
}
 
function getIndex(length){
	return Math.floor(Math.random()*length);
}

function move(titel,role){
	if(role=='admin'){
		$("#role").val("admin")
	}
	if(role=="dormManager"){
		$("#role").val("dormManager")
	}
	if(role=='student'){
		$("#role").val("student")
	}
	$(".role_titel").text(titel)
	$(".box1").slideToggle('slow',function(){
		$(".box2").slideToggle()
	})
}

