(function() {
  'use strict';

  angular
    .module('BoxApp')
    .controller('AgentController', AgentController);
    
    //EmployeesController.$inject = ['employeeService'];
    // inject it later employeeService down parameter 
  
  AgentController.$inject = [ '$location', 'Service' ];
  
    function AgentController($location,Service ) {
      
    	var agentvm = this;
      agentvm.user;

    	

      console.log('I am here at the Agentcontroller controller ');



      logged();

      function logged(){

        agentvm.user = Service.getLogged()

      }



    }
    
})();