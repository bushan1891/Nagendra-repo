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

            var currentDate = new Date().getMilliseconds();


            uservm.newClaim.claimID = currentDate;    // can be modified later
            uservm.newClaim.status="pending";
            uservm.newClaim.reportedDate = currentDate; // get the current date
            uservm.newClaim.assignedAdjuster = 2;    // will handle this in the back end
            uservm.newClaim.vehicle = uservm.newVehicle.vin;    // assign the current vehicle vin


            uservm.newVehicle.id = currentDate;
            uservm.newVehicle.claimNumber = uservm.newClaim.claimID;


            console.dir(uservm.newClaim);
            console.dir(uservm.newVehicle);


            Service.createClaim(uservm.newClaim, uservm.newVehicle);



           // Service.createVehicle(uservm.newVehicle);


             //once pushed to the backend clean the claim and vehicle
            uservm.newClaim= null;
            uservm.newVehicle= null;


        }


      console.log('I am here at the User controller ');

        // on load
          logged();
          getClaims();

       function  getClaims(){

           console.log("i am in get claims");

           Service.getClaims(uservm.user.userEmail).then(function(claim){

               uservm.claims=claim;
               console.log("got all clamins for "+ uservm.user.userEmail );
               console.dir(uservm.claims);

           },function(error){
               console.log(error);
           });
       }


      function logged(){
        uservm.user = Service.getLogged()

      }


    }
    
})();