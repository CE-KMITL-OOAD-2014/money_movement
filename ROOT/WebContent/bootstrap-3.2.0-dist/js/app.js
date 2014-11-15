var moneyMovement = angular.module('moneyMovement', ['ngRoute','tc.chartjs','checklist-model']);
	moneyMovement.config(['$routeProvider',function($routeProvider) {
		$routeProvider
	    .when('/index', {
	        template: "<div ng-include src=template ng-init=template='collettion/intro.html'></div>",
	        controller: 'Logincontroller'
	      })
	    .when('/graph', {
	        templateUrl: 'radrachart.html',
	        controller: 'chartgraph'
	      })
	    .when('/login', {
	        templateUrl: 'login.html',
	        controller: 'Logincontroller'
	      })
	    .when('/user', {
	        templateUrl: 'user.html',
	        controller: 'Usercontroller'
	      })
	    .when('/profile', {
	        templateUrl: 'collettion/profile.html',
	        controller: 'profile'
	      })
	   .otherwise({
	        redirectTo: '/index'
	      });
	  }]);
 

    