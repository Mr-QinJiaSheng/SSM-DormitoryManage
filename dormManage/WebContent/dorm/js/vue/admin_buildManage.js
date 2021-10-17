/**
 * 
 */

var DORMBuildId;

window.onload=function(){
	getSession({role:"admin"});
	var that=this;
	getBuildManage()
     
}

//获取BuildMange
function getBuildManage(){
	console.log("num",this.vue.pagination.pageNum)
	var that=this;
	axios.get('../../getBuildManage?pageNum='+that.vue.pagination.pageNum+'&pageSize='+that.vue.pagination.pageSize+'&filter='+this.vue.search.filter+"&key="+this.vue.search.key).then(function (res) {
		that.vue.buildManageList=res.data.rows;
		that.vue.pagination.pageTotal=Math.ceil(res.data.total/that.vue.pagination.pageSize);
		that.vue.search.filter="dormBuildName";
		that.vue.search.key=""
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

//根据获取BuildManId BuildManage
function getBuildMangerById(dormBuildId){
	var that=this;
    axios.get('../../getBuildMangerById',{
    	params:{
    		dormBuildId:dormBuildId
    	}
    }).then(function (res) {
	that.getBuildMangerById_vue.buildManage=res.data;
    }).catch(function (error) {
    alert(error);
    });
}


function addBuildManageMsg(){
	var buildManage=this.addBuildManage_vue.buildManage;
	axios.post('../../addBuildManage', buildManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.addBuildManage_vue.buildManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id更新
function updataBuildManageMsg(){
	var buildManage=this.getBuildMangerById_vue.buildManage;
	axios.post('../../updataBuildManageById', buildManage, {headers: {'Content-Type': 'application/json;charset=UTF-8'}})
    .then(function (response) {
    	if(response.data.result==true){
    		this.getBuildMangerById_vue.buildManage={};
    		window.location.reload();
    	}
    }).catch(function (error) {
        console.log(error);
    }); 
}

//根据Id删除
function  buildManagerDeleteById(dormBuildId){
	var that=this;
    axios.get('../../buildManagerDeleteById?dormBuildId='+dormBuildId).then(function (res) {
    	console.log(res)
    	if(res.data.result==true){
    		window.location.reload();
    	}
    }).catch(function (error) {
    alert(error);
    });
}

//根据宿舍楼id获取宿管信息
function getDormMangerByBuildId(dormBuildId){
	var that=this;
	DORMBuildId=dormBuildId;
    axios.get('../../getDormMangerByBuildId?dormBuildId='+dormBuildId).then(function (res) {
    	console.log(res)
    	that.getDormManageByBuildId_vue.dormManage=res.data;
    }).catch(function (error) {
    alert(error);
    });  
    
	var that=this;
	axios.get('../../getDormManage2').then(function (res) {
		that.getDormManageByBuildId_vue.optionsDormManage=res.data;
	    console.log(res)
	    }).catch(function (error) {
	    alert(error);
	    });
}

function addDormManageToBuild(){
	var dormManId=this.getDormManageByBuildId_vue.optionKey;
	if(dormManId !=-1){
		axios.get('../../addDormManageToBuild?dormBuildId='+DORMBuildId+'&dormManId='+dormManId).then(function (res) {
	    	if(res.data.result==true){
	    		getDormMangerByBuildId(DORMBuildId)
	    	}
	    }).catch(function (error) {
	    alert(error);
	    }); 
	}
	else{
		alert("你选择了无效值")
	}
}

function removeaDormManageToBuild(dormManId){
	axios.get('../../removeaDormManageToBuild?dormManId='+dormManId).then(function (res) {
    	if(res.data.result==true){
    		getDormMangerByBuildId(DORMBuildId)
    	}
    }).catch(function (error) {
    alert(error);
    }); 
}

//查询
function searchBuildManage(){
	console.log(this.vue.search);
	getBuildManage();
}
//用户点击退出
function exit(){
  this.addBuildManage_vue.buildManage={};
}

//分页
function pageUp(){
	if(this.vue.pagination.pageNum>1){
		this.vue.pagination.pageNum--;
		getBuildManage();
	}
	else{
		alert("就是第一页")
	}
}
function pageDown(){
	if(this.vue.pagination.pageNum<this.vue.pagination.pageTotal){
		this.vue.pagination.pageNum++;
		getBuildManage();
		
	}
	else{
		alert("已经是最后一页")
	}
}

var addBuildManage_vue=new Vue({
	  el:'#addBuildManage_app',
	  data:{
		buildManage:{
				
		}
	  }	
	});

var vue=new Vue({
	  el:'#app',
	  data:{
		buildManageList:[],
		search:{
			filter:"dormBuildName",
			key:""
		},
		pagination:{
			pageNum:1,
			pageSize:17,
			pageTotal:0
		}
		
	  },
	  methods:{
		  getBuildMangerById:function(dormBuildId){
			  getBuildMangerById(dormBuildId)
		  },
		  buildManagerDeleteById:function(dormBuildId){
			  buildManagerDeleteById(dormBuildId);
		  },
		  getDormMangerByBuildId:function(dormBuildId){
			  getDormMangerByBuildId(dormBuildId)
		  }
	  }
	});

var getBuildMangerById_vue=new Vue({
	  el:'#getBuildMangerById_app',
	  data:{
		  buildManage:{}
	  }
	  
	});


var getDormManageByBuildId_vue=new Vue({
	  el:'#getDormManageByBuildId_app',
	  data:{
		  dormManage:{},
		  optionsDormManage:[],
		  optionKey:-1
	  },
	  methods:{
		  removeaDormManageToBuild:function(dormManId){
			  removeaDormManageToBuild(dormManId)
		  }
	  }
	  
	});



