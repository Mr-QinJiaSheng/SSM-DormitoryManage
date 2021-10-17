/**
 *  公众号【C you again】
 */


window.onload=function(){
	getSession({role:"admin"});
	var that=this;
	getNoticeManage()
     
}

//获取studentManage
function getNoticeManage(){
	
	var that=this;
	axios.get('../../getNoticeManage?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key).then(function (res) {
		that.vue.noticeManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="date";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

//根据获取dormManId DormManage
function getNoticeMangerById(noticeId){
	var that=this;
    axios.get('../../getNoticeMangerById',{
    	params:{
    		noticeId:noticeId
    	}
    }).then(function (res) {
	that.getNoticeMangerById_vue.noticeManage=res.data;
    }).catch(function (error) {
    alert(error);
    });
}

function addNoticeManageMsg(){
	var noticeManage=this.addNoticeManage_vue.noticeManage;
	axios.post('../../addNoticeManage', noticeManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.addNoticeManage_vue.noticeManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id更新
function updataNoticeManageMsg(){
	var noticeManage=this.getNoticeMangerById_vue.noticeManage;
	axios.post('../../updataNoticeManageById', noticeManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.getNoticeMangerById_vue.noticeManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  noticeManagerDeleteById(noticeId){
	var that=this;
    axios.get('../../noticeManagerDeleteById?noticeId='+noticeId).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload();
    	}
    }).catch(function (error) {
    alert(error);
    });
}

//查询
function searchNoticeManage(){
	console.log(this.vue.search);
	getNoticeManage();
}
//用户点击退出
function exit(){
  this.addNoticeManage_vue.noticeManage={};
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

var addNoticeManage_vue=new Vue({
	  el:'#addNoticeManage_app',
	  data:{
		  noticeManage:{
			
		}
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		  noticeManageList:[],
		search:{
			filter:"date",
			key:""
		},
		pagination:{
			pageNum:1,
			pageSize:17,
			pageTotal:0
		}
	   
		
		
	  },
	  methods:{
		  getNoticeMangerById:function(noticeId){
			  getNoticeMangerById(noticeId)
		  },
		  noticeManagerDeleteById:function(noticeId){
			  noticeManagerDeleteById(noticeId);
		  }
	  }
	});

var getNoticeMangerById_vue=new Vue({
	  el:'#getNoticeMangerById_app',
	  data:{
		  noticeManage:{}
	  }
	  
	});