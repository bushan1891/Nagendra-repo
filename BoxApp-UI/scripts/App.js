 (function(){
	 'use strict'
	 
	 angular
	    .module('BoxApp', ['ngRoute'])
	    .config(moduleConfig);
	 
	 moduleConfig.$inject = ['$routeProvider'];
	 
	 
	 function moduleConfig ($routeProvider) {
	      
	       $routeProvider
			   .when('/register', {
				   templateUrl: 'registration.html',
				   controller: 'register',
				   controllerAs: 'registervm'
			   })

	        .when('/login', {
	          templateUrl: 'user.login.tmpl.html',
	          controller: 'LoginController',
	          controllerAs: 'loginvm'
	        })
	        .when('/user', {
	          templateUrl: 'user.tmpl.html',
	          controller: 'UserController',
	          controllerAs: 'uservm'
	        })
	        .when('/agent', {
	          templateUrl: 'agent.tmpl.html',
	          controller: 'AgentController',
	          controllerAs: 'agentvm'
	        })
	        .when('/adjustor', {
	          templateUrl: 'adjustor.tmpl.html',
	          controller: 'AdjustorController',
	          controllerAs: 'adjustorvm'
	        })
			   .when('/AppDetails', {
				   templateUrl: 'AppDetails.html',
				   controller: 'DetailsCntl',
				   controllerAs: 'detailsvm'
			   })
	        .otherwise({
	          redirectTo: '/register'
	        });
	    }
	 
 })();