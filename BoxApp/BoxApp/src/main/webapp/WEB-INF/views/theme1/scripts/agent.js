(function() {
  'use strict';

  angular
    .module('BoxApp')
    .controller('AgentController', AgentControllerfn);
    
    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
  
    function AgentControllerfn() {
      
    	var agentvm = this; 		    	
    	
      console.log('I am here at the Agentcontroller controller ');
    }
    
})();