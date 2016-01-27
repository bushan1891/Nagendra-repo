 (function(){
	 'use strict'
	 
	 angular
	    .module('BoxApp', ['ngRoute'])
	    .config(moduleConfig);
	 
	 moduleConfig.$inject = ['$routeProvider'];
	 
	 
	 function moduleConfig ($routeProvider) {
	      
	       $routeProvider
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
	        .otherwise({
	          redirectTo: '/login'
	        });
	    }
	 
 })();