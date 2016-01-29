(function () {
    'use strict';

    angular
        .module('BoxApp')
        .controller('AgentController', AgentController);

    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 

    AgentController.$inject = ['$location', 'Service'];

    function AgentController($location, Service) {

        var agentvm = this;
        agentvm.user;
        agentvm.claimsPending;
        agentvm.claimsApproved;
        agentvm.status = "Set Status";
        agentvm.updateClaim = updateClaim;
        agentvm.claimupdate;
        agentvm.adjustor;


        function loadAdjustor(){

            Service.getAjustor().then(function (adjustors) {

                console.log("i got adjustors");

                agentvm.adjustor= adjustors;

                console.dir(agentvm.adjustor);

            },  function (error) {
                console.log(error);
            });


        }


        function updateClaim() {

            window.alert('Updated');
            console.dir(agentvm.claimupdate);
            Service.updateClaim(agentvm.claimupdate).then(function (claim) {

                console.log("i was updated");
                claimload();


            }, function (error) {
                console.log(error);
            });




        }

        function setstatus(status) {

            agentvm.status = status;
            console.log("status function was called ");

        }


        console.log('I am here at the Agentcontroller controller ');

        loadAdjustor();
        logged();

        function logged() {

            agentvm.user = Service.getLogged();
            claimload();

        }

        function claimload(){

            Service.getClaimsAgent("pending").then(function (claim) {

                agentvm.claimsPending = claim;
                console.log("got all clamins for pending");
                console.dir(agentvm.claimsPending);

            }, function (error) {
                console.log(error);
            });

            Service.getClaimsAgent("approved").then(function (claim) {

                agentvm.claimsApproved = claim;
                console.log("got all clamins for approved");
                console.dir(agentvm.claimsApproved);

            }, function (error) {
                console.log(error);
            });
        }


    }

})();