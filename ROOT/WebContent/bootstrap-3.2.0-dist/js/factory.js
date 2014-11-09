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

checkuser.factory('datatest',function () {
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
    	 } 
     }
});
