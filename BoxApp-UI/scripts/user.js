(function() {
  'use strict';

  angular
    .module('BoxApp')
    .controller('UserController', UserController);
    
    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
  UserController.$inject = [ '$location', 'Service' ];
  
    function UserController($location,Service) {
      
    	var uservm = this;
            uservm.user;           // current user claim
            uservm.newClaim;      // for the post new calim
            uservm.claims;       // to display all the claims of the user
            uservm.newVehicle;   // for the new vehicle claim

        uservm.addClaim = addClaim;

        function addClaim(form){
            form.$setPristine();

            console.log("claim form called ");

            var currentDate = new Date().getDate();


            uservm.newClaim.claimID = uservm.user.userinfo.UserID;    // assigning the current user id as the claim id // can be modified later
            uservm.newClaim.status="pending";
            uservm.newClaim.reportedDate = currentDate; // get the current date
            uservm.newClaim.assignedAdjustor = 2;    // will handle this in the back end
            uservm.Vehicle = uservm.newVehicle.vin;    // assign the current vehicle vin


            uservm.newVehicle.id = uservm.user.userinfo.UserID;
            uservm.newVehicle.claimNumber = uservm.newClaim.claimID;


            console.dir(uservm.newClaim);
            console.dir(uservm.newVehicle);

            Service.createClaim(uservm.newClaim);



            // once pushed to the backend clean the claim and vehicle
           // uservm.newClaim= null;
           // uservm.newVehicle= null;


        }


      console.log('I am here at the User controller ');
          logged();

      function logged(){
        uservm.user = Service.getLogged()

      }

        function getClaim(){
            uservm.claims = Service.getclaim(uservm.user)

        }









    }
    
})();