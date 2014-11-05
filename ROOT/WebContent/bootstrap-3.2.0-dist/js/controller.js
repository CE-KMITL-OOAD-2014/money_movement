//var chartjs = angular.module('chartjs',['tc.chartjs'])
checkuser.controller('Usercontroller', ['$scope','$http','$location','statedata','datatest', function ($scope,$http,$location,statedata,datatest) { 
	$scope.datas={};
	$scope.datadis={};
	$scope.datauser = statedata.getData();//datatest.getData();//
	$scope.typedata = {};
	
	$scope.selectItem = function(){
		$scope.datas.addgroup = $scope.datas.addtype.type;
	};
	
	$http.post('service/typeincomeoutlay?username='+$scope.datauser.data.username+'&sessionId='+$scope.datauser.data.sessionId)
	.success(function(data,status){
		$scope.typedata = data;
	})
	.error(function(data,status){
		alert("your not active");
	})
	
	$scope.addcontent = function(){
		 $scope.show = true;
	}
	
}]);



checkuser.controller('profile', ['$scope','$http','statedata','datatest', function($scope,$http,statedata,datatest){
	$scope.datau = datatest.getData();
	$scope.editprofile = function(){
		$scope.template = "collettion/profile/editprofile.html";
		
	};
	
	$scope.editfile = function(){
		$http.post('bootstrap-3.2.0-dist/json/user.json').success(function(data,status){
			//$scope.datauser = statedata.setData(data);
			$scope.template = "collettion/profile/showprofile.html";
			alert(status);
		})
		.error(function(data,status){
			alert(status);
		});
	};
	
	$scope.cleardata = function(){
		datatest.clearData();
	};
}]);



