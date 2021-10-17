/**
 * 
 */


window.onload=function(){
	getSession({role:"admin"});
	var that=this;
	getDormManage()
     
}

//获取dormMange
function getDormManage(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getDormManage?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key).then(function (res) {
		that.vue.dormManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="name";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

//根据获取dormManId DormManage
function getDormMangerById(dormManId){
	var that=this;
    axios.get('../../getDormMangerById',{
    	params:{
    		dormManId:dormManId
    	}
    }).then(function (res) {
    	
	that.getDormMangerById_vue.dormManage=res.data;
	that.getDormMangerById_vue.dormManage.sex=="男"? that.getDormMangerById_vue.dormManage.sex="0":that.getDormMangerById_vue.dormManage.sex="1"
	$("#editPassword").val(that.getDormMangerById_vue.dormManage.password);
    }).catch(function (error) {
    alert(error);
    });
}

//校验密码
function checkPassword(status){
	if(status=="add"){
		if(this.addDormManage.dormManage.password!=null && this.addDormManage.dormManage.password.trim()!="" && (this.addDormManage.dormManage.password.trim()==$("#addPassword").val().trim())){
			$(".hidden_btn").css({
				display:"inline-block"
			})
		}
		else{
			$(".hidden_btn").css({
				display:"none"
			})
			this.addDormManage.dormManage.password="";
			$("#addPassword").val("");
			alert("两次密码输入不一致");
		}
	}
	if(status=="edit"){
		if(this.getDormMangerById_vue.dormManage.password!=null && this.getDormMangerById_vue.dormManage.password.trim()!="" && (this.getDormMangerById_vue.dormManage.password.trim()==$("#editPassword").val().trim())){
			$(".hidden_btn").css({
				display:"inline-block"
			})
		}
		else{
			$(".hidden_btn").css({
				display:"none"
			})
			this.getDormMangerById_vue.dormManage.password="";
			$("#editPassword").val("");
			alert("两次密码输入不一致");
		}
	}
	
}

function addDormManageMsg(){
	var dormManage=this.addDormManage.dormManage;
	dormManage.sex==0?dormManage.sex="男":dormManage.sex="女";
	axios.post('../../addDormManage', dormManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.addDormManage.dormManage={};
    		this.addDormManage.dormManage.sex="0";
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id更新
function updataDormManageMsg(){
	var dormManage=this.getDormMangerById_vue.dormManage;
	dormManage.sex==0?dormManage.sex="男":dormManage.sex="女";
	axios.post('../../updataDormManageById', dormManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.getDormMangerById_vue.dormManage={};
    		this.getDormMangerById_vue.dormManage.sex="0";
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  dormManagerDeleteById(dormManId){
	var that=this;
    axios.get('../../dormManagerDeleteById?dormManId='+dormManId).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload();
    	}
    }).catch(function (error) {
    alert(error);
    });
}

//查询
function searchDormManage(){
	console.log(this.vue.search);
	getDormManage();
}
//用户点击退出
function exit(){
  this.addDormManage.dormManage={};
  this.addDormManage.dormManage.sex="0";
  $("#addPassword").val('')
}

//分页
function pageUp(){
	if(this.vue.pagination.pageNum>1){
		this.vue.pagination.pageNum--;
		getDormManage();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getDormManage();
		
	}
	else{
		alert("已经是最后一页")
	}
}


var addDormManage=new Vue({
	  el:'#addDormManage_app',
	  data:{
		dormManage:{
			userName:"",
			password:"",
			name:"",
			sex:"0",
			tel:""	
		}
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		dormManageList:[],
		search:{
			filter:"name",
			key:""
		},
		pagination:{
			pageNum:1,
			pageSize:17,
			pageTotal:0
		}
	   
		
		
	  },
	  methods:{
		  getDormMangerById:function(dormManId){
			  getDormMangerById(dormManId)
		  },
		  dormManagerDeleteById:function(dormManId){
			  dormManagerDeleteById(dormManId);
		  }
	  }
	});

var getDormMangerById_vue=new Vue({
	  el:'#getDormMangerById_app',
	  data:{
		  dormManage:{}
	  }
	  
	});


