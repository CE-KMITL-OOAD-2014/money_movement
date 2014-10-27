
checkuser.controller('Usercontroller', ['$scope','$http', function ($scope,$http) {                
	$scope.types = [
	               {type:'Hight'},
	               {type:'Middle'},
	               {type:'Little'}
	               ];
	$scope.datas = [];
	$scope.addcontent = function(data){
			
			$http.post('http://localhost:8080/register?&date='+$scope.datas.adddate+'&list='+$scope.datas.addlist+'&type='+$scope.datas.addgroup.type+'&amount='+$scope.datas.addamount)
			.success(function(data, status, headers, config){
				$scope.datas = data;
			})
			.error(function(data,status){
				atert(status);
			});	
	};
	$scope.submitform = function (){
		$scope.users.username = "asdf";
		$scope.users.email = "asdfsa@asdf.com";
		$scope.users.sex = "male";
		$scope.users.password = "12345678";
		$scope.users.confirmPassword = "12345678";
		$http.post('http://localhost:8080/register?username='+$scope.users.username+'&email='+$scope.users.email+'&password='+$scope.users.password+'&confirmPassword='+$scope.users.confirmPassword)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			$scope.template="collettion/signup1.html"; 
			alert("121549516556456");
		})
		.error(function(data,status){
			alert(status);
		})
		;
	};
	$scope.submitdetail = function (){
		$scope.users.name = "passakorn";
		$scope.users.age = 22;
		$scope.users.birthday = 09021992;
		$scope.users.job = "engineer";
		$scope.users.province = "sk";
		$http.post('http://localhost:8080/register?name='+$scope.users.name+'&age='+$scope.users.age+'&birthday='+$scope.users.birthday+'&job='+$scope.users.job+'&province='+$scope.users.province)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			$scope.template="test2.html"; 
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


