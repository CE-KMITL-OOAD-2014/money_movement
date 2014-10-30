var checkuser = angular.module('checkuser', ['ngRoute','tc.chartjs']);
	checkuser.config(['$routeProvider',function($routeProvider) {
	    $routeProvider
	    .when('/index', {
	        templateUrl: 'index.html',
	        controller: 'Usercontroller'
	      })
	    .when('/graph', {
	        templateUrl: 'radrachart.html',
	        controller: 'chartgraph'
	      })
	    .when('/login', {
	        templateUrl: 'login.html',
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
 

    