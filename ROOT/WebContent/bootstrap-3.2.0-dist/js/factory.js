checkuser.factory('statedata', function(){
	
	var profile={};
	
	return {
		getData : function()
		{
			return profile;
		},
		setData : function(inputData)
		{
			profile = inputData;
		}
	}
});

checkuser.factory('datatest',['$http','$filter',function ($http,$filter) {
	/*variable of function return*/
	var tempvalue = {
			value : []
	};
	var tempdata = {
			data : []
	};
	var temptotal = {
			total : []
	}
	var total = {} ;
	var label = {};
	var dailygraph = {};
	var doghnutgraph = {};
	var piegraph = {};
	var compareLinegraph = {};
	var transaction = {};
    var service = {};
    /*return value follow function this below*/
     return{
    	 getData : function(){
    		 service =  JSON.parse(localStorage.getItem("service"));
    		 return service;
    	 },
    	 setData : function(input){
    		 localStorage.setItem("service",JSON.stringify(input));
    	 },
    	 clearData : function(){
    		 localStorage.clear();
    	 },
    	 
    	 gettransaction : function(){
    		 transaction =  JSON.parse(localStorage.getItem("transaction"));
    		 console.log(transaction);
    		 return transaction;
    	 },
    	 settransaction : function(input){
    		 localStorage.setItem("transaction",JSON.stringify(input));
    		 
    	 },
    	 cleartransaction : function(){
    		 localStorage.clear();
    	 },
    	/*collection of graph*/ 
    	 getDoghnutGraph : function(){
    		 doghnutgraph = JSON.parse(localStorage.getItem("doghnutgraph"));
    		 return doghnutgraph;
    	 },
//    	 getPieGraph : function(){
//    		 piegraph = JSON.parse(localStorage.getItem("piegraph"));
//    		 return piegraph;
//    	 },
    	 getCompareLineGraph : function(){
    		 compareLinegraph = JSON.parse(localStorage.getItem("compareLinegraph"));
    		 return compareLinegraph;
    	 },
    	 getLinearGraph : function(){
    		 linegraph = JSON.parse(localStorage.getItem("linegraph"));
    		 return linegraph;
    	 },
    	 requireDoghnutData : function(url){
    		 $http.post(url).success(function(data,status){
    			 if(data){
    				 localStorage.setItem("doghnutgraph",JSON.stringify(data));
    			 }
    		 	}).error(function(data,status){
    			 
    		 })
    	 },
//    	 requirePieData : function(url){
//    		 $http.post(url).success(function(data,status){
//    			 if(data){
//    				 localStorage.setItem("piegraph",JSON.stringify(data));
//    			 }
//    		 	}).error(function(data,status){
//    			 
//    		 })
//    	 },
    	 requireCompareData : function(url){
    		 $http.post(url).success(function(data,status){
    			 if(data){
    				 localStorage.setItem("compareLinegraph",JSON.stringify(data));
    			 }
    		 	}).error(function(data,status){
    			 
    		 })
    	 },
    	 requireLinaerData : function(url){
    		 $http.post(url).success(function(data,status){
    			 if(data){
    				 localStorage.setItem("Lineargraph",JSON.stringify(data));
    			 }
    		 	}).error(function(data,status){
    			 
    		 })
    	 },
    	 setarraylabel : function(){
    		 tempvalue.value = [];
    		 var temp = $filter('orderBy')(transaction.data.incomeoutlay,'savedate');
    		 for(var i in temp){
    			 var item = temp[i].savedate;
    			 var date = new Date(item);
    			 var day = date.getDate();
    			 tempvalue.value.push(day)
    			 
    		 }
    		 localStorage.setItem("label",JSON.stringify(tempvalue.value));
    		 label = JSON.parse(localStorage.getItem("label"));
    		 console.log(label);
    		 return label;
    		 
    	 },
    		  
    	 setarraydata : function(){
    		 tempdata.data = [];
    		 temptotal.total = [];
    		 var totalincomeoutcome = 0;
    		 var income = 0;
    		 var outcome = 0;
    		 var temp = $filter('orderBy')(transaction.data.incomeoutlay,'savedate');
    		 for(var i in temp){
    			 var item = temp[i].amount;
    			 if(temp[i].typeofuse.type=="outcome"){
    				 outcome += item;
    				 item *= (-1);
    				 tempdata.data.push(item);
    			 }else{
    				 income += item;
    				 tempdata.data.push(item);
    			 } 
    			 totalincomeoutcome += item;
    			 console.log(item +' '+total);
    		 }
    		 temptotal.total.push({
    			 'income': income,
    			 'outcome': outcome,
    			 'total': totalincomeoutcome
    		 });
    		 localStorage.setItem("total",JSON.stringify(temptotal.total));
    		 localStorage.setItem("data",JSON.stringify(tempdata.data));
    		 data = JSON.parse(localStorage.getItem("data"));
    		 console.log(item);
    		 return data;
    	 },
    	 
    	 getsumvalue : function(){
    		 total = JSON.parse(localStorage.getItem("total"));
    		 console.log(total);
    		 return total;
    	 }
    	 
     }
}]);
