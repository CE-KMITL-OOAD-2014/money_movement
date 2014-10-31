//var chartjs = angular.module('chartjs',['tc.chartjs'])
checkuser.controller('Usercontroller', ['$scope','$http','$location',function ($scope,$http,$location) { 
	////--------------------------------------------------/////
	
	
	///----------------------------------------------------////
	$scope.types = [
	               {type:'Hight'},
	               {type:'Middle'},
	               {type:'Little'}
	               ];
	$scope.typelist = [
		               {typelist:'live',type:'Hight'},
		               {typelist:'travel',type:'Hight'},
		               {typelist:'work' ,type:'Hight'},
		               {typelist:'relex' ,type:'Middle'}
		               ];
	$scope.provinces = [];
	$http.get('service/province').success(function(data,status){
		$scope.provinces = data;
	}).error(function(data,status){
		alert(status);
	});
	
	$scope.jobs=[];
	$http.get('service/job').success(function(data,status){
		$scope.jobs = data;
	}).error(function(data,status){
		alert(status);
	});
	//$scope.templates = "collettion/intro.html";
	$scope.ulogin = {
			username:null,
			password:null
			};
	$scope.users = {
			username: null ,
			email:null,
			sex:null,
			password:null,
			confirmPassword:null,
			name : null,
			age: null,
			birthday :null,
			job:null,
			province:null
			};
	$scope.datas = [];
	$scope.datauser = [];
	$scope.profile = [];
	$scope.addcontent = function(){

		$http.post('service/addincomeoutlay?date='+$scope.datas.adddate+'&list='+$scope.datas.addlist+'&type='+$scope.datas.addgroup.type+'&amount='+$scope.datas.addamount)
		.success(function(data, status, headers, config){
			alert("52919501099");
			$scope.datas = data;
		})
		.error(function(data,status){
			alert(status);
		});	
	};
	
	$scope.submitform = function (){
			$scope.template="collettion/signup1.html";
	};
	$scope.submitdetail = function (){
	//	$location.path('/login');
		$http.post('service/register?username='+$scope.users.username
				+'&email='+$scope.users.email
				+'&password='+$scope.users.password
				+'&confirmPassword='+$scope.users.confirmPassword
				+'&name='+$scope.users.name
				+'&age='+$scope.users.age
				+'&birthday='+$scope.users.birthday
				+'&job='+$scope.users.job
				+'&province='+$scope.users.province)
		.success(function(data, status, headers, config){
			$scope.datas = data;
			$location.path('/login'); 
			alert("121549516556456");
		})
		.error(function(data,status){
			alert(status);
		})
		;
	};
	
	$scope.formlogin = function (){
		$http.get('service/login?username='+$scope.ulogin.username+'&password='+$scope.ulogin.password)
		.success(function(data, status, headers, config){
			if(data.data != null){
				
				$location.path('/user'); 
				alert("5465");
				$scope.datauser = data.data;
				$scope.profile = data.data.profile;
				alert($scope.profile.name);
			}else{
				alert("plase your username or your password");
			}
		})
		.error(function(data,status){
			alert(status);
		})
		;
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
		"username":"passakornOD",
		"name":"pasaskorn jonlapon",
		"gender":"male",
		"email":"tiew1992@gmail.com",
		"age":22,
		"birthday": "02/09/1992",
		"job":"engineering",
		"province":"sk"
	};
	$scope.editprofile = function(){
		alert("success");
		$scope.template = "collettion/profile/editprofile.html";
		
	};
	
	$scope.editfile = function(){
		$http.post('bootstrap-3.2.0-dist/json/user.json').success(function(data,status){
			$scope.datauser = data;
			$scope.template = "collettion/profile/showprofile.html";
			alert(status);
		})
		.error(function(data,status){
			alert(status);
		});
	};

}]);

checkuser.controller('chartgraph',function($scope){
	$scope.data = {
		      labels: ['Eating', 'Drinking', 'Sleeping', 'Designing', 'Coding', 'Cycling', 'Running'],
		      datasets: [
		        {
		          label: 'My First dataset',
		          fillColor: 'rgba(220,220,220,0.2)',
		          strokeColor: 'rgba(220,220,220,1)',
		          pointColor: 'rgba(220,220,220,1)',
		          pointStrokeColor: '#fff',
		          pointHighlightFill: '#fff',
		          pointHighlightStroke: 'rgba(220,220,220,1)',
		          data: [65, 59, 90, 81, 56, 55, 40]
		        },
		        {
		          label: 'My Second dataset',
		          fillColor: 'rgba(151,187,205,0.2)',
		          strokeColor: 'rgba(151,187,205,1)',
		          pointColor: 'rgba(151,187,205,1)',
		          pointStrokeColor: '#fff',
		          pointHighlightFill: '#fff',
		          pointHighlightStroke: 'rgba(151,187,205,1)',
		          data: [28, 48, 40, 19, 96, 27, 12]
		        }
		      ]
		    };

	$scope.options =  {

		      // Sets the chart to be responsive
		      responsive: true,

		      //Boolean - Whether to show lines for each scale point
		      scaleShowLine : true,

		      //Boolean - Whether we show the angle lines out of the radar
		      angleShowLineOut : true,

		      //Boolean - Whether to show labels on the scale
		      scaleShowLabels : false,

		      // Boolean - Whether the scale should begin at zero
		      scaleBeginAtZero : true,

		      //String - Colour of the angle line
		      angleLineColor : 'rgba(0,0,0,.1)',

		      //Number - Pixel width of the angle line
		      angleLineWidth : 1,

		      //String - Point label font declaration
		      pointLabelFontFamily : '"Arial"',

		      //String - Point label font weight
		      pointLabelFontStyle : 'normal',

		      //Number - Point label font size in pixels
		      pointLabelFontSize : 10,

		      //String - Point label font colour
		      pointLabelFontColor : '#666',

		      //Boolean - Whether to show a dot for each point
		      pointDot : true,

		      //Number - Radius of each point dot in pixels
		      pointDotRadius : 3,

		      //Number - Pixel width of point dot stroke
		      pointDotStrokeWidth : 1,

		      //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
		      pointHitDetectionRadius : 20,

		      //Boolean - Whether to show a stroke for datasets
		      datasetStroke : true,

		      //Number - Pixel width of dataset stroke
		      datasetStrokeWidth : 2,

		      //Boolean - Whether to fill the dataset with a colour
		      datasetFill : true,

		      //String - A legend template
		      legendTemplate : '<ul class="tc-chart-js-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].strokeColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>'
		    };

});
