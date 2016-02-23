/**
 * Created by bushan on 2/17/16.
 */

(function() {
    'use strict';

    angular.module('BoxApp').controller('DetailsCntl', DetailsCntl);

    DetailsCntl.$inject = ['$location', 'Service', '$timeout'];

    function DetailsCntl($location, Service, timeout, dialog) {

       var detailsvm=this;
        detailsvm.CreateUser=CreateUser;
        detailsvm.login=login;

        detailsvm.Types = {
            "Types": ["User","Agent","Adjustor"]
        }
        detailsvm.gender={
            "Types":["Male" , "Female"]
        }

        detailsvm.userinfo;
        detailsvm.user;


        function login(){

            $location.path("/login");

        }



        // used to cereater users here

       function CreateUser(form){

           if(detailsvm.userinfo.gender == "Female"){
               detailsvm.userinfo.imgurl="http://d1ty0e8cxefhfl.cloudfront.net/images/profiles/profile-unknown-female-2.jpeg";
           }
           else
               detailsvm.userinfo.imgurl="http://www.polymtl.ca/lmp/img/noprofile_000.png";


           detailsvm.userinfo.email=detailsvm.user.userEmail;
           console.dir(detailsvm.user,detailsvm.userinfo);

           Service.CreateUser(detailsvm.user,detailsvm.userinfo);


       }



    }


})();
