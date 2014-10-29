var checkuser = angular.module('checkuser', ['ngRoute']);
	checkuser.config(['$routeProvider',function($routeProvider) {
	    $routeProvider
	    .when('/index', {
	        templateUrl: 'collettion/intro.html',
	        controller: 'Usercontroller'
	      })
	    .when('/signup', {
	        templateUrl: 'collettion/signup1.html',
	        controller: 'Usercontroller'
	      })
	    .when('/user', {
	        templateUrl: 'user.html',
	        controller: 'Usercontroller'
	      })
	    .when('/profile', {
	        templateUrl: 'collettion/profile.html',
	        controller: 'Usercontroller'
	      })
	   .otherwise({
	        redirectTo: '/index'
	      });
	  }]);
 

    