(function() {
  'use strict';

  angular
    .module('BoxApp')
    .service('Service', Service);

     Service.$inject = ['$q', '$http'];

  function Service($q, $http) {
    var self = this;

    self.getUsers = getUsers;
    self.getUserId = getUserId;
    self.Auth = Auth;
    
    
    function Auth(){
    	var defer =$q.defer();
    	
    	$http
    	 .get('')
    	 .then(successfn,errorfn);
    	
    	
    }
   
    
    //private members
    // get  all users
    function getUsers() {

      var defer = $q.defer();

      $http
        .get('http://localhost:8080/BoxApp/Auth')
        .then(successFn, errorFn);

      function successFn(response) {
        defer.resolve(response.data);
      }

      function errorFn(error) {
        defer.reject(error.statusText);
      }

      return defer.promise;
    }

    
    
    
   // get by id
    function getUserId(id) {
      var defer = $q.defer();

      $http
        .get('http://jsonplaceholder.typicode.com/users/' + id)
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