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
        self.updateClaim = updateClaim;
        self.getAjustor = getAjustor;
        self.getClaimsAdjustor = getClaimsAdjustor;
        self.getAdjustorClaimApproved=getAdjustorClaimApproved;
        self.renameClaimFile=renameClaimFile;
        self.sendfile=sendfile;
        self.getVehicle=getVehicle;
        self.Mailregister=Mailregister;
        self.CreateUser=CreateUser;

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
            var url = 'http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/Auth1?';
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
                .get('http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/Auth')
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;
        }


        function createClaim(claim, vehicle ) {

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/claim/create?email=" + self.logd.userEmail;



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
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/claim/vehicle?email=" + self.logd.userEmail;

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
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/claims?email=" + email;

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
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/claims/agent?status=" + status;

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


        function updateClaim(calim) {


            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/claims/update";

            $http
                .put(url, calim)
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;

        }


        function getAjustor() {

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/Adjustor";

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

        function getClaimsAdjustor(user) {

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/AdjustorClaim?user=" + user;

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

        function getAdjustorClaimApproved(status) {

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/AdjustorClaimApproved?status=" + status;

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

        // renaming the claimfile
        function renameClaimFile(name){

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/renamecalim?claim="+name;

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

        var sendfile = function(file){


            console.dir(file);
            console.log(" at my service ")


        }



        function getVehicle(userid) {

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/getVehicle?userid="+userid;

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


        function Mailregister(reg){

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/mail";

            $http
                .post(url, reg)
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);
            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;


        }


        function CreateUser(user,userinfo){

            var defer = $q.defer();
            var url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/Createuserinfo";

            $http
                .post(url, userinfo)
                .then(successFn, errorFn);

            function successFn(response) {
                defer.resolve(response.data);


                console.log(response.status);
                url = "http://box-envi.fz2ptpitzf.us-west-2.elasticbeanstalk.com/api/claim/Createuser";


                $http
                    .post(url, user)
                    .then(successFn1, errorFn1);
                function successFn1(response) {


                    defer.resolve(response.data);
                    console.log(response.status);


                }
                function errorFn1(error) {
                    console.log(error.status);
                    if(error.status==404) {
                        alert("User not created ! Email ID USED ")

                    }
                    defer.reject(error.statusText);
                }

            }

            function errorFn(error) {
                defer.reject(error.statusText);
            }

            return defer.promise;


        }





    }
})();