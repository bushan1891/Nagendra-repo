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
        adjustorvm.claimupdate;
        adjustorvm.updateClaim = updateClaim;

        adjustorvm.adjustorclaimApproved;
        adjustorvm.modalclaim; // for view table




        logged();
        loadClaim();

        function logged() {

            adjustorvm.user = Service.getLogged()

        }

        function loadClaim() {

            console.log(adjustorvm.user.userName);

            Service.getClaimsAdjustor(adjustorvm.user.userName ).then(function (claim) {

                adjustorvm.claimsApproved = claim;

                console.log("adjustors claims loaded here");
                console.dir(adjustorvm.claimsApproved);


            }, function (error) {
                console.log(error);
            });


            Service.getAdjustorClaimApproved('Approved').then(function(claim){
                adjustorvm.adjustorclaimApproved= claim;

            }, function (error) {
                console.log(error);

            });




        }


        function updateClaim() {



            window.alert('Updated');
            console.dir(adjustorvm.claimupdate);
            Service.updateClaim(adjustorvm.claimupdate).then(function (claim) {

                console.log("i was updated");
                loadClaim();


            }, function (error) {
                console.log(error);
            });


        }


    }

})();