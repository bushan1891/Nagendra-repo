(function() {
  'use strict';

  angular
    .module('BoxApp')
    .controller('AdjustorController', AdjustorControllerfn);
    
    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
  
    function AdjustorControllerfn() {
      
    	var adjustorvm = this; 		    	
    	
        console.log('I am here at the Adjustorcontroller controller ');
    }
    
})();