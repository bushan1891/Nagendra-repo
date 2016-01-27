(function() {
	'use strict';

	angular.module('BoxApp').controller('LoginController', LoginController);

	// EmployeesController.$inject = ['employeeService'];
	// inject it later employeeService down parameter
	LoginController.$inject = [ '$location', 'Service' ];

	function LoginController($location, Service) {

		var loginvm = this;
		console.log('I am here at the login controller ');

		loginvm.login = login;
		loginvm.collection = [];

		function init() {
			Service.getUsers().then(function(users) {
				loginvm.users = users;
				loginvm.collection = users;
				// console.dir(loginvm.users);
			}, function(error) {
				console.log(error);
			});
		}
		init();

		function login() {

			console.dir(loginvm.collection);
			console.log(loginvm.collection[0].userEmail);
			console.log(loginvm.collection[0].userKey);
			console.log(loginvm.email);
			console.log(loginvm.password);
			console.log(loginvm.collection.length);

			for (var i = 0; i < loginvm.collection.length; i++) {

				// check for the type of user and switch the content accordingly

				if (loginvm.collection[i].userEmail == loginvm.email
						&& loginvm.collection[i].userKey == loginvm.password) {

					// check for the type of user
					if (loginvm.collection[i].userType == "User") {
						$location.path("/user");
					}

					if (loginvm.collection[i].userType == "Agent") {
						$location.path("/agent");
					}
					if (loginvm.collection[i].userType == "Adjustor") {
						$location.path("/adjustor");
					}

				}

				
			}
			
		}

	}

})();