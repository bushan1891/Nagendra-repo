(function(){

    'use strict';

    angular
        .module('BoxApp')
        .service('fileUpload', ['$http', function ($http) {


            this.uploadFileToUrl = function(file, uploadUrl){
                var fd = new FormData();
                console.log("multipart");
                console.dir(file);

                fd.append('file', file);
                $http.post(uploadUrl, fd, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}
                    })
                    .success(function(){
                    })
                    .error(function(){
                    });
            }
        }]);


})();



