/**
 * 
 */

var dormBuildId;

window.onload=function(){
	var login=getSession({role:"dormManager"});
	dormBuildId=sessionStorage.getItem("dormBuildId");
	getRecordMsg();
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

function addRecordJILU(){
	that=this;
	axios.get('../../getStudentMsgByBuildId?pageNum='+1+'&pageSize='+100+'&filter='+''+"&key="+''+"&dormBuildId="+dormBuildId).then(function (res) {
		that.addRecordMsg_vue.studentManageList=res.data.rows;
		console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

function addRecordMsg(){
	var that=this;
	var stuIndex=this.addRecordMsg_vue.stuIndex;
	this.addRecordMsg_vue.recordMsg.studentNumber=this.addRecordMsg_vue.studentManageList[stuIndex].stuNum;
	this.addRecordMsg_vue.recordMsg.studentName=this.addRecordMsg_vue.studentManageList[stuIndex].name;
	this.addRecordMsg_vue.recordMsg.dormName=this.addRecordMsg_vue.studentManageList[stuIndex].dormName;
	this.addRecordMsg_vue.recordMsg.dormBuildId=dormBuildId;
	this.addRecordMsg_vue.recordMsg.date=new Date(this.addRecordMsg_vue.recordMsg.date)
	console.log(this.addRecordMsg_vue.recordMsg)
	axios.post('../../addRecordMsg', this.addRecordMsg_vue.recordMsg, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		that.addRecordMsg_vue.recordMsg={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//获取studentManage
function getRecordMsg(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getRecordMsg?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key+"&dormBuildId="+dormBuildId).then(function (res) {
		that.vue.recordMsgList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="studentName";
		that.vue.search.key=""
	    }).catch(function (error) {
	    alert(error);
	    });
	
}

//根据获取dormManId DormManage
function getRecordById(recordId){
	var that=this;
    axios.get('../../getRecordById',{
    	params:{
    		recordId:recordId
    	}
    }).then(function (res) {
    	
	that.getRecordMsgById_vue.recordMsg=res.data;
    }).catch(function (error) {
    alert(error);
    });
}



//根据Id更新
function updataRecordMsg(){
	var that=this;
	var recordMsg=this.getRecordMsgById_vue.recordMsg;
	axios.post('../../updataRecordMsg', recordMsg, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		that.getRecordMsgById_vue.recordMsg={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  recordManagerDeleteById(recordId){
	var that=this;
    axios.get('../../recordManagerDeleteById1?recordId='+recordId).then(function (res) {
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
	getRecordMsg();
}
//用户点击退出
function exit(){
  this.addRecordMsg_vue.studentManageList={};
  this.addRecordMsg_vue.stuId=-1;
}

//分页
function pageUp(){
	if(this.vue.pagination.pageNum>1){
		this.vue.pagination.pageNum--;
		getRecordMsg();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getRecordMsg();
		
	}
	else{
		alert("已经是最后一页")
	}
}

var addRecordMsg_vue=new Vue({
	  el:'#addRecordMsg_app',
	  data:{
		  recordMsg:{
			  
		},
		studentManageList:{},
		stuIndex:-1
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		  recordMsgList:[],
		search:{
			filter:"studentName",
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
		  getRecordById:function(recordId){
			  getRecordById(recordId)
		  },
		  recordManagerDeleteById:function(recordId){
			  recordManagerDeleteById(recordId);
		  }
	  }
	});

var getRecordMsgById_vue=new Vue({
	  el:'#getRecordMsgById_app',
	  data:{
		  recordMsg:{}
	  }
	  
	});