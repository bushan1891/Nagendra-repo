/**
 * Created by bushan on 2/16/16.
 */


(function() {
    'use strict';

    angular.module('BoxApp').controller('register', register);


    register.$inject = ['$location', 'Service','$timeout'];

    function register($location, Service,timeout,dialog) {

        var registervm = this;
        registervm.reg;

        registervm.login=login;


        function login(form){

           // form.$setPristine();
            console.dir(registervm.reg);

            //Service.Mailregister(registervm.reg);

      alert("Email sent to " +  registervm.reg.email  + " regarding how to use the App");


            $location.path("/login");

        }

        console.log('I am here at register controller ');
    }
})();