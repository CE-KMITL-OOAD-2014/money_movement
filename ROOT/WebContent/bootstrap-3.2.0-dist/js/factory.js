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


