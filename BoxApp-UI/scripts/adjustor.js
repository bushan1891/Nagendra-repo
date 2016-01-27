(function() {
  'use strict';

  angular
    .module('BoxApp')
    .controller('AdjustorController', AdjustorController);
    
    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
  AdjustorController.$inject = [ '$location', 'Service' ];
  
    function AdjustorController($location,Service) {
      
    	var adjustorvm = this;
        adjustorvm.user;


      console.log(adjustorvm.curUserEmail);

      logged();

      function logged(){

        adjustorvm.user = Service.getLogged()

      }
    	
    	
        console.log('I am here at the Adjustorcontroller controller ');
    }
    
})();