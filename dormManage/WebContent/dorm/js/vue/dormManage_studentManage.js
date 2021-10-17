/**
 * 
 */

var dormBuildId;
window.onload=function(){
	getSession({role:"dormManager"});
	dormBuildId=sessionStorage.getItem("dormBuildId");
	var that=this;
	getStudentManage()
	//获取公告
	getNoticeAll(); 
}

function getNoticeAll(){
	var that=this;
	axios.post('../../getNoticeAll').then(function (res) {
    	that.vue.noticeList=res.data;
    	console.log(that.vue.noticeList)
    }).catch(function (error) {
    alert(error);
    });
}

//获取studentManage
function getStudentManage(){
	var that=this;
	axios.get('../../getStudentMsgByBuildId?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key+"&dormBuildId="+dormBuildId).then(function (res) {
		that.vue.studentManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="name";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}




//根据Id删除
function  studentMsgDeleteById(studentId){
	var that=this;
    axios.get('../../studentMsgDeleteById?studentId='+studentId).then(function (res) {
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
	getStudentManage();
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
		getStudentManage();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getStudentManage();
		
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
		studentManageList:[],
		search:{
			filter:"name",
			key:""
		},
		pagination:{
			pageNum:1,
			pageSize:17,
			pageTotal:0
		},
		noticeList:[]
	  },
	  methods:{
		  
		  studentMsgDeleteById:function(studentId){
			  studentMsgDeleteById(studentId);
		  }
	  }
	});
