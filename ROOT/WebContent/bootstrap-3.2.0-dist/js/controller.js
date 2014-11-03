//var chartjs = angular.module('chartjs',['tc.chartjs'])
checkuser.controller('Usercontroller', ['$scope','$http','$location','statedata', function ($scope,$http,$location,statedata) { 
	datas={};
	$scope.datauser = statedata.getData();
	$scope.typedata = [{'typelist':'food','type':'H'},
						{'typelist':'live','type':'H'},
						{'typelist':'travel','type':'M'},
						{'typelist':'ent','type':'L'}]
						;
	
	
	
	$scope.selectItem = function(val){
		alert(datas.addtype);
		datas.addgroup = 'M';
	};
}]);



checkuser.controller('profile', ['$scope','$http','statedata', function($scope,$http,statedata){
	$scope.datau = statedata.getData();
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
	
}]);



