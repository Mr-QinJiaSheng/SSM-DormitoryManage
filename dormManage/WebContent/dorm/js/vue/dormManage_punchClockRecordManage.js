/**
 * 
 */

var dormBuildId;
window.onload=function(){
	getSession({role:"dormManager"});
	//获取公告
	getNoticeAll();
	dormBuildId=sessionStorage.getItem("dormBuildId");
	var that=this;
	getPunchClockRecordMsgByDormBuildId()
     
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
function getPunchClockRecordMsgByDormBuildId(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getPunchClockRecordMsgByDormBuildId?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key+'&dormBuildId='+dormBuildId).then(function (res) {
		that.vue.punchClockRecordManageList=res.data.rows;
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
	getPunchClockRecordMsgByDormBuildId();
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
		getPunchClockRecordMsgByDormBuildId();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getPunchClockRecordMsgByDormBuildId();
		
	}
	else{
		alert("已经是最后一页")
	}
}



var vue=new Vue({
	  el:'#app',
	  data:{
		  punchClockRecordManageList:[],
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
		  recordManagerDeleteById:function(recordId){
			  recordManagerDeleteById(recordId);
		  }
	  }
	});

