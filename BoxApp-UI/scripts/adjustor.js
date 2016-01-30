(function () {
    'use strict';

    angular
        .module('BoxApp')
        .controller('AdjustorController', AdjustorController);

    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
    AdjustorController.$inject = ['$location', 'Service'];

    function AdjustorController($location, Service) {

        console.log('I am here at the Adjustorcontroller controller ');

        var adjustorvm = this;
        adjustorvm.user;
        adjustorvm.claimsApproved; // claims assigned to adjustor and approved by the agent

        console.log(adjustorvm.curUserEmail);

        logged();
        loadClaim();

        function logged() {

            adjustorvm.user = Service.getLogged()

        }

        function loadClaim() {

            console.log(adjustorvm.user.userName);

            Service.getClaimsAdjustor(adjustorvm.user.userName).then(function (claim) {

                adjustorvm.claimsApproved = claim;

                console.log("adjustors claims loaded here");
                console.dir(adjustorvm.claimsApproved);

            }, function (error) {
                console.log(error);
            });


        }


    }

})();