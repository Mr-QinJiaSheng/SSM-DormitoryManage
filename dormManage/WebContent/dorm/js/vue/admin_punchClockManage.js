/**
 *  公众号【C you again】
 */


window.onload=function(){
	getSession({role:"admin"});
	var that=this;
	getPunchClockManage()
     
}

//获取studentManage
function getPunchClockManage(){
	
	var that=this;
	axios.get('../../getPunchClockManage?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key).then(function (res) {
		that.vue.punchClockManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="date";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

//获取
function getPunchClockMangerById(id){
	var that=this;
    axios.get('../../getPunchClockMangerById',{
    	params:{
    		id:id
    	}
    }).then(function (res) {
	that.getPunchClockMangerById_vue.punchClockManage=res.data;
    }).catch(function (error) {
    alert(error);
    });
}

function addPunchClockManageMsg(){
	this.addPunchClockManage_vue.punchClockManage.person=sessionStorage.getItem("userName");
	var punchClockManage=this.addPunchClockManage_vue.punchClockManage;
	
	axios.post('../../addPunchClockManageMsg', punchClockManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.addPunchClockManage_vue.punchClockManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id更新
function updataPunchClockManageMsg(){
	var punchClockManage=this.getPunchClockMangerById_vue.punchClockManage;
	axios.post('../../updataPunchClockManageMsgById', punchClockManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.getPunchClockMangerById_vue.punchClockManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  punchClockManagerDeleteById(id){
	var that=this;
    axios.get('../../punchClockManagerDeleteById?id='+id).then(function (res) {
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
	getPunchClockManage();
}
//用户点击退出
function exit(){
  this.addPunchClockManage_vue.punchClockManage={};
}

//分页
function pageUp(){
	if(this.vue.pagination.pageNum>1){
		this.vue.pagination.pageNum--;
		getPunchClockManage();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getPunchClockManage();
		
	}
	else{
		alert("已经是最后一页")
	}
}

var addPunchClockManage_vue=new Vue({
	  el:'#addPunchClockManage_app',
	  data:{
		  punchClockManage:{
			
		}
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		  punchClockManageList:[],
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
		  getPunchClockMangerById:function(id){
			  getPunchClockMangerById(id)
		  },
		  punchClockManagerDeleteById:function(id){
			  punchClockManagerDeleteById(id);
		  }
	  }
	});

var getPunchClockMangerById_vue=new Vue({
	  el:'#getPunchClockMangerById_app',
	  data:{
		  punchClockManage:{}
	  }
	  
	});