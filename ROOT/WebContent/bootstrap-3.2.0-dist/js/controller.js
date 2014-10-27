
checkuser.controller('Usercontroller', ['$scope','$http', function ($scope,$http) {                
	$scope.types = [
	               {type:'Hight'},
	               {type:'Middle'},
	               {type:'Little'}
	               ];
	$scope.addcontent = function(){
		if($scope.adddate != '' && $scope.addlist!= ''&&$scope.addtype!=''&& $scope.addgroup.type!=''&&$scope.addamount!=''){		
			$scope.datas.push(
				{
					check:false,
					date:$scope.adddate,
					list:$scope.addlist,
					type:$scope.addtype,
					group:$scope.addgroup.type,
					amount:$scope.addamount
				});
		};
		$scope.adddate = '';
		$scope.addlist = '';
		$scope.addtype = '';
		$scope.addgroup ='';
		$scope.addamount = '';
	};
	$http.post('bootstrap-3.2.0-dist/json/user.json').success(function(data){
		$scope.datas = data;
	});
	
	$scope.editcontent = function(){
		angular.forEach(data, function(data) {
			if(!data.check){
				
			};
		});
	};
	$scope.removecontent = function(){
		angular.forEach(content, function(data,c) {
			if(!data.check) $scope.datas.push(data);
		});
	};
	
}]);

