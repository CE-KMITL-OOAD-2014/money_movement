
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
	$http.post('bootstrap-3.2.0-dist/json/user.json').success(function(data, status, headers, config){
		$scope.datas = data;
	});
	$scope.submitform = function (){
		$scope.users.username = "asdf";
		$scope.users.email = "asdfsa";
		$scope.users.sex = "male";
		$scope.users.password = "12345678";
		$scope.users.confirmPassword = "12345678";
		$http.post('http://localhost:8080/register?username='+$scope.users.username+'&email='+$scope.users.email+'&password='+$scope.users.password+'&confirmPassword='+$scope.users.confirmPassword)
		.success(function(data, status, headers, config){
			//$scope.datas = data;
			alert("121549516556456");
		})
		.error(function(data,status){
			alert(status);
		})
		;
	};
	$scope.users = {
			username:null,
			email:null,
			sex:null,
			password:null,
			confirmPassword:null
			};
	
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

