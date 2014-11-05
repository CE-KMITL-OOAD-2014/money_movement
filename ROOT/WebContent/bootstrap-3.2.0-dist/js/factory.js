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

checkuser.factory('datatest', function () {
	var transaction = {};
    var service = {};
     return{
    	 getData : function(){
    		 var objservice = JSON.parse(localStorage.service);
    		 return objservice;
    	 },
    	 setData : function(input){
    		 localStorage.service = angular.toJson(input);
    	 },
    	 clearData : function(){
    		 localStorage.clear();
    	 },
    	 
    	 
    	 gettransaction : function(){
    		//var objservice = JSON.parse(localStorage.transaction);
    		 return transaction;//objservice;
    	 },
    	 settransaction : function(input){
    		 alert(input);
    		 console.log(input);
    		//transaction = input; 
    		 localStorage.transaction = angular.toJson(input);
    	 },
    	 cleartransaction : function(){
    		 localStorage.clear();
    	 }
    	 
     }
});
