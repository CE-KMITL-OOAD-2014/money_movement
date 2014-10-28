var checkuser = angular.module('checkuser', ['ngRoute']);
	checkuser.config(['$routeProvider',function($routeProvider) {
	    $routeProvider
	    .when('/user', {
	        templateUrl: '../user.html',
	        controller: 'Usercontroller'
	      })
	    .when('/singup', {
	        templateUrl: 'result.html',
	        controller: 'Usercontroller'
	      })
//	      .when('/signup1', {
//	        templateUrl: 'signup1.html',
//	        controller: 'Usercontroller'
//	      })
//	      .when('/user', {
//	        templateUrl: 'collention/signup1.html',
//	        //controller: 'Usercontroller'
//	      })
	    .otherwise({
	        redirectTo: '/user'
	      });
	  }]);
 

    