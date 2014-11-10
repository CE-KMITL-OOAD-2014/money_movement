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

checkuser.factory('datatest',['$http',function ($http) {
	var graph = {};
	var transaction = {};
    var service = {};
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
    	 
    	 getGraph : function(){
    		 graph = JSON.parse(localStorage.getItem("graph"));
    		 return graph;
    	 },
    	 setGraph : function(input){
    		 localStorage.setItem("graph",JSON.stringify(input));
    	 },
    	 requiredata : function(url){
    		 $http.post(url).success(function(data,status){
    			 if(data){
    				 localStorage.setItem("graph",JSON.stringify(data));
    			 }
    		 	}).error(function(data,status){
    			 
    		 })
    	 }
     }
}]);
