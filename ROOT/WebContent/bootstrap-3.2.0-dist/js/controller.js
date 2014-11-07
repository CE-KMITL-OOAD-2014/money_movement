//var chartjs = angular.module('chartjs',['tc.chartjs'])
checkuser.controller('Usercontroller', ['$scope','$http','$location','statedata','datatest', function ($scope,$http,$location,statedata,datatest) { 
	$scope.datas={};
	$scope.datadis= datatest.gettransaction();
	$scope.datauser = datatest.getData();//datatest.getData();//
	$scope.typedata = {};
	//$scope.transactionlist = datatest.gettransaction();

	$scope.selectItem = function(){
		$scope.datas.addgroup = $scope.datas.addtype.type;
		$scope.datas.addpriority = $scope.datas.addtype.priority;
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

	$scope.addtransaction = function(){
		if($scope.datas.addlist!=null&&$scope.datas.addamount!=null&&$scope.datas.adddate!=null&&$scope.datas.addgroup!=null){
			$http.post('service/addincomeoutlay?username='+$scope.datauser.data.username
					+'&sessionId='+$scope.datauser.data.sessionId
					+'&owner='+$scope.datauser.data.username
					+'&nameincomeoutlay='+$scope.datas.addlist
					+'&amount='+$scope.datas.addamount
					+'&savedate='+$scope.datas.adddate
					+'&comment=null'
					+'&nametype='+$scope.datas.addtype.name
					+'&type='+$scope.datas.addgroup
					+'&priority='+$scope.datas.addpriority)
					.success(function(data,status){
						if(data.status=='complete'){
							alert("add transaction successed!!!!");
							$http.post('service/getincomeoutlay?username='+$scope.datauser.data.username
									+'&sessionId='+$scope.datauser.data.sessionId
									+'&startsavedate=null'
									+'&stopsavedate=null')
									.success(function(data,status){
										alert("pass");
										datatest.settransaction(data);
									})
									.error(function(data,status){
										alert(status);
									})
						}
						else{
							alert("error");
						}
					}).error(function(data,status){
						alert("not succesed");
					})
		}
		else
		{
			alert("value is null");
		}
	};
	$scope.deletelist = {
			list:[]
	};
	$scope.deletetransaction = function(){
//		$http.post('service/deleteincomeoutlay?username='+$scope.datauser.data.username
//				+'&sessionId='+$scope.datauser.data.sessionId
//				+'&owner='+$scope.datauser.data.username
//				+'&nameincomeoutlay='+$scope.datas.addlist
//				+'&savedate='+$scope.datas.adddate)
//				.success(function(data,status){
//					datatest.set
//				}).error(function(data,status){
//					alert("not succesed");
//				});
//	
		alert($scope.deletelist.list.length);
		for(var i =0 ;i<$scope.deletelist.list.length;i++){
			console.log($scope.deletelist.list[i]);
		};
	};
	$scope.logout = function(){
		datatest.cleartransaction();
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



