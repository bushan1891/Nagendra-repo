(function(){
'use strict';


    angular
        .module('BoxApp')
        .controller('myCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){

            $scope.uploadFile = function(id){

                var file = $scope.myFile;
                //$scope.myFile.name="zz";

                console.log('file is ' );
                console.dir(file);
                var uploadUrl = "http://localhost:8080/BoxApp-Api/api/claim/uploadcalim?claimid="+id;
                fileUpload.uploadFileToUrl(file, uploadUrl);
            };

        }]);

})();


