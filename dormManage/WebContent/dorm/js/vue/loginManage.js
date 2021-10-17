/**
 * 公众号【C you again】
 * 个人博客:cyouagain.cn
 * 登录管理
 * 
 */


//登录
function login(){
	var login=this.login_vue.login;
	login.role=$("#role").val();
	if(login.userName !=null && login.userName.trim()!=''){
		if(login.password != null && login.password.trim()!=''){
			login_fun()
		}
		else{
			alert("密码不能为空")
		}
	}
	else{
		alert("用户名不能为空")
	}
	
}

function login_fun(){
	var login=this.login_vue.login;
	axios.post('login',login).then(function (res) {
		
		if(res.data.length===1){
    		//用户存在
			var url="";
    		this.login_vue.login={};
    		
    		if(login.role=="admin"){
    			url="dorm/admin/admin_index.html";
    		}
    		if(login.role=="dormManager"){
    			url="dorm/dormManager/dormManage_index.html"
    		}
    		if(login.role=="student"){
    			url="dorm/student/student_index.html"
    		}
    		window.location.replace(url);
    	}
    	else{
    		this.login_vue.login={}
    		alert("用户不存在或密码错误，请认真检查")
    	}
    	
    	
    	
    }).catch(function (error) {
    alert(error);
    });
}


var login_vue=new Vue({
	el:'#login_app',
	  data:{
		  login:{
			  userName:"",
			  password:"",
			  role:""
		  }
	  }
})