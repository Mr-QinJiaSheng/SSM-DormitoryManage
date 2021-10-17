/**
 * 
 */

var studentNumber;
window.onload=function(){
	getSession({role:"student"});
	studentNumber=sessionStorage.getItem("studentNumber");
	getNoticeAll();
	var that=this;
	getRecordMsgByStuNum()
     
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

//根据学号获取考勤记录
function getRecordMsgByStuNum(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getRecordMMsgByStuNum?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key+'&studentNumber='+studentNumber).then(function (res) {
		that.vue.recordManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="date";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}


//查询
function searchRecordMsg(){
	getRecordMsgByStuNum();
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
		getRecordMsgByStuNum();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getRecordMsgByStuNum();
		
	}
	else{
		alert("已经是最后一页")
	}
}



var vue=new Vue({
	  el:'#app',
	  data:{
		  recordManageList:[],
		search:{
			filter:"date",
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
		  
	  }
	});

