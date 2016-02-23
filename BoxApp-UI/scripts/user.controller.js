(function() {
	'use strict';

	angular.module('BoxApp').controller('LoginController', LoginController);

	// EmployeesController.$inject = ['employeeService'];
	// inject it later employeeService down parameter
	LoginController.$inject = [ '$location', 'Service',];

	function LoginController($location, Service) {

		var loginvm = this;
		console.log('I am here at the login controller ');

		loginvm.login = login;
		loginvm.route=route;
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
		//init();

		function login() {

			console.log(loginvm.collection.length);

			// Auth method called

			Service.Auth(loginvm.email, loginvm.password).then(
					function(user) {

						if (user == null) {
							alert("Authentication failed");
						}

						if (user.userEmail == loginvm.email
								&& user.userKey == loginvm.password) {

							// check for the type of user
							if (user.userType == "User") {
								$location.path("/user");
							}

							if (user.userType == "Agent") {
								$location.path("/agent");
							}
							if (user.userType == "Adjustor") {
								$location.path("/adjustor");
							}

						}
						else{
							alert("user not found");
						}


						Service.logged(user);

						loginvm.user = user;
						console.dir(user);

					}, function(error) {

					alert("user not found");
						console.log(error);
					});

		}

		function route(){
			console.log("here");
			$location.path("/AppDetails");
		}

	}

})();