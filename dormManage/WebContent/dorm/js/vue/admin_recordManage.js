/**
 * 
 */


window.onload=function(){
	getSession({role:"admin"});
	var that=this;
	getRecordManage()
     
}

//获取studentManage
function getRecordManage(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getRecordManage?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key).then(function (res) {
		that.vue.recordManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="studentName";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

//根据获取dormManId DormManage
function getStudentMangerById(studentId){
	var that=this;
    axios.get('../../getStudentMangerById',{
    	params:{
    		studentId:studentId
    	}
    }).then(function (res) {
    	
	that.getStudentMangerById_vue.studentManage=res.data;
	that.getStudentMangerById_vue.studentManage.sex=="男"? that.getStudentMangerById_vue.studentManage.sex="0":that.getStudentMangerById_vue.studentManage.sex="1"
	$("#editPassword").val(that.getStudentMangerById_vue.studentManage.password);
    }).catch(function (error) {
    alert(error);
    });
}

//校验密码
function checkPassword(status){
	if(status=="add"){
		if(this.addStudentManage_vue.studentManage.password!=null && this.addStudentManage_vue.studentManage.password.trim()!="" && (this.addStudentManage_vue.studentManage.password.trim()==$("#addPassword").val().trim())){
			$(".hidden_btn").css({
				display:"inline-block"
			})
		}
		else{
			$(".hidden_btn").css({
				display:"none"
			})
			this.addStudentManage_vue.studentManage.password="";
			$("#addPassword").val("");
			alert("两次密码输入不一致");
		}
	}
	if(status=="edit"){
		if(this.getStudentMangerById_vue.studentManage.password!=null && this.getStudentMangerById_vue.studentManage.password.trim()!="" && (this.getStudentMangerById_vue.studentManage.password.trim()==$("#editPassword").val().trim())){
			$(".hidden_btn").css({
				display:"inline-block"
			})
		}
		else{
			$(".hidden_btn").css({
				display:"none"
			})
			this.getStudentMangerById_vue.studentManage.password="";
			$("#editPassword").val("");
			alert("两次密码输入不一致");
		}
	}
	
}

function addStudentManageMsg(){
	var studentManage=this.addStudentManage_vue.studentManage;
	studentManage.sex==0?studentManage.sex="男":studentManage.sex="女";
	axios.post('../../addStudentManage', studentManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.addStudentManage_vue.studentManage={};
    		this.addStudentManage_vue.studentManage.sex="0";
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id更新
function updataStudentManageMsg(){
	var studentManage=this.getStudentMangerById_vue.studentManage;
	studentManage.sex==0?studentManage.sex="男":studentManage.sex="女";
	axios.post('../../updataStudentManageById', studentManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.getStudentMangerById_vue.studentManage={};
    		this.getStudentMangerById_vue.studentManage.sex="0";
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  recordManagerDeleteById(recordId){
	var that=this;
    axios.get('../../recordManagerDeleteById?recordId='+recordId).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload();
    	}
    }).catch(function (error) {
    alert(error);
    });
}

//查询
function searchRecordManage(){
	console.log(this.vue.search);
	getRecordManage();
}
//用户点击退出
function exit(){
  this.addStudentManage_vue.studentManage={};
  this.addStudentManage_vue.studentManage.sex="0";
  $("#addPassword").val('')
}

//分页
function pageUp(){
	if(this.vue.pagination.pageNum>1){
		this.vue.pagination.pageNum--;
		getRecordManage();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getRecordManage();
		
	}
	else{
		alert("已经是最后一页")
	}
}

var addStudentManage_vue=new Vue({
	  el:'#addStudentManage_app',
	  data:{
		  studentManage:{
			stuNum:"",
			password:"",
			name:"",
			sex:"0",
			dormBuildId:null,
			dormName:"",
			tel:""	
		}
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		  recordManageList:[],
		search:{
			filter:"studentName",
			key:""
		},
		pagination:{
			pageNum:1,
			pageSize:17,
			pageTotal:0
		}
	   
		
		
	  },
	  methods:{
		  
		  recordManagerDeleteById:function(recordId){
			  recordManagerDeleteById(recordId);
		  }
	  }
	});

var getStudentMangerById_vue=new Vue({
	  el:'#getStudentMangerById_app',
	  data:{
		  studentManage:{}
	  }
	  
	});