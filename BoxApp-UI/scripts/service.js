(function() {
  'use strict';

  angular
    .module('BoxApp')
    .service('Service', Service);

     Service.$inject = ['$q', '$http',];

  function Service($q, $http) {
    var self = this;
    
    self.logd ;    // current users email is logged once the login takes place 
    self.getUsers = getUsers;
    self.Auth = Auth;
    self.logged =logged; 
     self.getLogged=getLogged;
      self.getClaims=getClaims;
   
    function logged(loggedUser){

      self.logd= loggedUser;
      console.dir(self.logd);
      
    	return self.logd;

    }

    // returns the current logged user to the respective controller
    function getLogged(){
      console.dir(self.logd);

      return self.logd;

    }
    
    
    function Auth(email,key){
    //	self.logd=email;  // records the email of the person logged
    	var defer =$q.defer();
    	var url = 'http://localhost:8080/BoxApp-Api/api/claim/Auth1?';
    	var url2 = 'email='+email;
    	var comUrl = url.concat(url2);
    	
    	console.log(comUrl);
    	
    	$http
    	 .get(comUrl)
    	 .then(successfn,errorfn);
    	
    	console.log("made the auth1 call");
    	
    	
    	function successfn(response) {
    	        defer.resolve(response.data);
    	      }

    	      function errorfn(error) {
    	        defer.reject(error.statusText);
    	      }
    	      return defer.promise;
    }
   
    
    //private members
    // get  all users
    function getUsers() {

      var defer = $q.defer();

      $http
        .get('http://localhost:8080/BoxApp-Api/api/claim/Auth')
        .then(successFn, errorFn);

      function successFn(response) {
        defer.resolve(response.data);
      }

      function errorFn(error) {
        defer.reject(error.statusText);
      }

      return defer.promise;
    }


      function createClaim(claim){

          var defer = $q.defer();
          var url = "http://localhost:8080/BoxApp-Api/api/claim/claim/create?email=" + self.logd.userEmail ;

          $http
              .post(url, claim)
              .then(successFn, errorFn);

          function successFn(response) {
              defer.resolve(response.data);
          }

          function errorFn(error) {
              defer.reject(error.statusText);
          }

          return defer.promise;


      }


      function createVehicle(vehicle){

          var defer = $q.defer();
          var url = "http://localhost:8080/BoxApp-Api/api/claim/vehicle/create?email=" + self.logd.userEmail;

          $http
              .post(url,vehicle)
              .then(successFn, errorFn);

          function successFn(response) {
              defer.resolve(response.data);
          }

          function errorFn(error) {
              defer.reject(error.statusText);
          }

          return defer.promise;


      }


      function getClaims(email){

          var defer = $q.defer();
          var url = "http://localhost:8080/BoxApp-Api/api/claim/claims?email=" + email;

          $http
              .get(url)
              .then(successFn, errorFn);

          function successFn(response) {
              defer.resolve(response.data);
          }

          function errorFn(error) {
              defer.reject(error.statusText);
          }

          return defer.promise;


      }

  }
})();