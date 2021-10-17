/**
 * 
 */


window.onload=function(){ 
	getSession({role:"admin"});
}



/*--------------------个人--------------------*/
function my(){
	console.log(this.session_vue.login.adminId)
	var that=this;
	axios.post('../../getMyMsgById',this.session_vue.login).then(function (res) {
    	that.user_vue.user=res.data;
    	
    }).catch(function (error) {
    alert(error);
    });
}

function editMyMsg(){
	var admin=this.user_vue.user;
	that=this;
	axios.post('../../updateMyMsgById',admin).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload()
    	}
    }).catch(function (error) {
    alert(error);
    });
}

function checkedPassword(){
	my();
	var password= this.user_vue.user.password;
	var oldPwd=$("#oldPwd").val().trim();
	if(password != null && password == oldPwd){
		
	}
	else{
		alert("原密码不正确")
		console.log(password)
		console.log(oldPwd)
		$("#oldPwd").val('')
		
	}
	
}

function editPassword(){
	var newPwd=$("#newPwd").val().trim();
	this.user_vue.user.password=newPwd;
	var admin =this.user_vue.user;
	console.log(admin)
	axios.post('../../updatePsd',admin).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload();
    	}
    }).catch(function (error) {
    alert(error);
    });
}

/*--------------------个人--------------------*/

var user_vue=new Vue({
	  el:'#user_app',
	  data:{
		  user:{
			  
		  }
	  }
	  
	});


