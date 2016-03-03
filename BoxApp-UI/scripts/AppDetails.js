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




        detailsvm.tabs = [{
            title: 'User-Manual',
            url: 'one.tpl.html'
        }, {
            title: 'Architecture',
            url: 'two.tpl.html'
        }];

        detailsvm.currentTab = 'one.tpl.html';

        detailsvm.onClickTab = function (tab) {
            detailsvm.currentTab = tab.url;
        }

        detailsvm.isActiveTab = function(tabUrl) {
            return tabUrl == detailsvm.currentTab;
        }



        // used to cereater users here

       function CreateUser(form){

          // if(detailsvm.userinfo.gender == "Female"){
            //   detailsvm.userinfo.imgurl="http://d1ty0e8cxefhfl.cloudfront.net/images/profiles/profile-unknown-female-2.jpeg";
           //}
         //  else
               detailsvm.userinfo.imgurl="https://savoirs.rfi.fr/sites/all/themes/rfi/images/public/default-profile.png";


           detailsvm.userinfo.email=detailsvm.user.userEmail;
           console.dir(detailsvm.user,detailsvm.userinfo);

           Service.CreateUser(detailsvm.user,detailsvm.userinfo);


           detailsvm.user=null;

       }



    }


})();
