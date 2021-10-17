/**
 * 
 */

var studentNumber;
window.onload=function(){
	getSession({role:"student"});
	studentNumber=sessionStorage.getItem("studentNumber");
	getNoticeAll()
	var that=this;
	getPunchClockRecordMsgByStuNum()
     
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

//根据学号获取
function getPunchClockRecordMsgByStuNum(){
	var that=this;
	axios.get('../../getPunchClockRecordMsgByStuNum?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key+'&studentNumber='+studentNumber).then(function (res) {
		that.vue.punchClockRecordManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="date";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}


function getPunckColcokRecordById(id){
	var that=this;
    axios.get('../../getPunckColcokRecordById?id='+id).then(function (res) {
    	that.punckClockRecordById_vue.punckClockRecordMasg=res.data;
    }).catch(function (error) {
        console.log(error);
    }); 
}


function updataPunchClockRecordMsg(){
	var punckClockRecordMasg=this.punckClockRecordById_vue.punckClockRecordMasg;
	axios.post('../../updataPunchClockRecordMsg', punckClockRecordMasg, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		console.log($("#"+punckClockRecordMasg.id))
    		$("#"+punckClockRecordMasg.id).attr("disabled","disabled");
    		this.punckClockRecordById_vue.punckClockRecordMasg={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}


//查询
function searchRecordMsg(){
	getPunchClockRecordMsgByStuNum();
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
		getPunchClockRecordMsgByStuNum();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getPunchClockRecordMsgByStuNum();
		
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
		  getPunckColcokRecordById:function(id){
			  getPunckColcokRecordById(id);
		  }
	  }
	});

var punckClockRecordById_vue=new Vue({
	  el:'#punckClockRecordById_app',
	  data:{
		  punckClockRecordMasg:{}
	  }
	  
	});

