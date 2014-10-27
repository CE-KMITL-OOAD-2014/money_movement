var checkuser = angular.module('checkuser', ['ngRoute']);
	checkuser.config(['$routeProvider',function($routeProvider) {
	    $routeProvider
	    .when('/', {
	        templateUrl: 'intro.html',
	        controller: 'Usercontroller'
	      })
	    .when('/singup', {
	        templateUrl: 'signup.html',
	        controller: 'Usercontroller'
	      })
	      .when('/signup1', {
	        templateUrl: 'signup1.html',
	        controller: 'Usercontroller'
	      })
	      .when('/user', {
	        templateUrl: 'user.html',
	        controller: 'Usercontroller'
	      })
	    .otherwise({
	        redirectTo: '/'
	      });
	  }]);
 

    