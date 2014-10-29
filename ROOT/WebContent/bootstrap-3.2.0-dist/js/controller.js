
checkuser.controller('Usercontroller', ['$scope','$http','$location',function ($scope,$http,$location) {                
	$scope.types = [
	               {type:'Hight'},
	               {type:'Middle'},
	               {type:'Little'}
	               ];
	//$scope.templates = "collettion/intro.html";
	
	$scope.datas = [];
	$scope.addcontent = function(){

		$http.post('bootstrap-3.2.0-dist/json/user.json?date='+$scope.datas.adddate+'&list='+$scope.datas.addlist+'&type='+$scope.datas.addgroup.type+'&amount='+$scope.datas.addamount)
		.success(function(data, status, headers, config){
			alert("52919501099");
			$scope.datas = data;
		})
		.error(function(data,status){
			alert(status);
		});	
	};
	
	$scope.submitform = function (){
		$scope.users.username = "asdf";
		$scope.users.email = "asdfsa@asdf.com";
		$scope.users.sex = "male";
		$scope.users.password = "12345678";
		$scope.users.confirmPassword = "12345678";
		//$location.path('/signup');
		$http.post('http://localhost:8080/register?username='+$scope.users.username+'&email='+$scope.users.email+'&password='+$scope.users.password+'&confirmPassword='+$scope.users.confirmPassword)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			//$scope.template="collettion/signup1.html"; 
			$location.path('/signup');
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
	//	$scope.users.birthday ='';
		$scope.users.job = "engineer";
		$scope.users.province = "sk";
		//$location.path('/login');
		$http.post('http://localhost:8080/register?name='+$scope.users.name+'&age='+$scope.users.age+'&birthday='+$scope.users.birthday+'&job='+$scope.users.job+'&province='+$scope.users.province)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			$location.path('/user'); 
			alert("121549516556456");
		})
		.error(function(data,status){
			alert(status);
		})
		;
	};
	
	$scope.formlogin = function (){
		$http.post('http://localhost:8080/register?username='+$scope.ulogin.username+'&age='+$scope.ulogin.password)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			$location.path('/user'); 
			alert("45679");
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

checkuser.controller('profile', ['$scope','$http', function($scope,$http){
	$scope.datauser = {
		"name":"pasaskorn jonlapon",
		"gender":"male",
		"email":"tiew1992@gmail.com",
		"age":22,
		"birthday":02/09/1992,
		"job":"engineering",
		"province":"sk"
	};
//	$http.post('bootstrap-3.2.0-dist/json/datauser.json')
//	.success(function(data,status){
//		$scope.datauser = data
//	}).error(function(data,status){
//		alert(status);
//	})

}]);

