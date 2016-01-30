(function () {
    'use strict';

    angular
        .module('BoxApp')
        .service('Service', Service);

    Service.$inject = ['$q', '$http',];

    function Service($q, $http) {
        var self = this;

        self.logd;    // current users email is logged once the login takes place
        self.getUsers = getUsers;
        self.Auth = Auth;
        self.logged = logged;
        self.getLogged = getLogged;
        self.getClaims = getClaims;
        self.createClaim = createClaim;
        self.createVehicle = createVehicle;
        self.getClaimsAgent = getClaimsAgent;
        self.updateClaim=updateClaim;
        self.getAjustor=getAjustor;
        self.getClaimsAdjustor=getClaimsAdjustor;

        function logged(loggedUser) {

            self.logd = loggedUser;
            console.dir(self.logd);

            return self.logd;

        }

        // returns the current logged user to the respective controller
        function getLogged() {
            console.dir(self.logd);

            return self.logd;

        }


        function Auth(email, key) {
            //	self.logd=email;  // records the email of the person logged
            var defer = $q.defer();
            var url = 'http://localhost:8080/BoxApp-Api/api/claim/Auth1?';
            var url2 = 'email=' + email;
            var comUrl = url.concat(url2);

            console.log(comUrl);

            $http
                .get(comUrl)
                .then(successfn, errorfn);

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


        function createClaim(claim, vehicle) {

            var defer = $q.defer();
            var url = "http://localhost:8080/BoxApp-Api/api/claim/claim/create?email=" + self.logd.userEmail;

            $http
                .post(url, claim)
                .then(successFn, errorFn);

            function successFn(response) {
                // nested calls
                createVehicle(vehicle);

                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;


        }


        function createVehicle(vehicle) {
            console.log("inside create vehicle now")
            var defer = $q.defer();
            var url = "http://localhost:8080/BoxApp-Api/api/claim/claim/vehicle?email=" + self.logd.userEmail;

            $http
                .post(url, vehicle)
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;


        }


        function getClaims(email) {

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


        // functions for the agent

        function getClaimsAgent(status) {

            var defer = $q.defer();
            var url = "http://localhost:8080/BoxApp-Api/api/claim/claims/agent?status=" + status ;

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


        function updateClaim(calim){


            var defer = $q.defer();
            var url = "http://localhost:8080/BoxApp-Api/api/claim/claims/update";

            $http
                .put(url,calim)
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;

        }



        function getAjustor(){

            var defer = $q.defer();
            var url = "http://localhost:8080/BoxApp-Api/api/claim/Adjustor";

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

      // get claims for the adjustor

       function  getClaimsAdjustor(user){

           var defer = $q.defer();
           var url = "http://localhost:8080/BoxApp-Api/api/claim/AdjustorClaim?user="+user;

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