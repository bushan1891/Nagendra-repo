(function(){
    'use strict';

    angular.module('BoxApp').controller("Ctrl1",function($scope){

            // initial values
            $scope.val1 = 34;
            $scope.val2 = 54;
            $scope.val3 = $scope.val1 + $scope.val2;

            $scope.$watch('[val1,val2]', function (newValue, oldValue) {

                $scope.val3 = parseInt($scope.val1) + parseInt($scope.val2);

            });


        })
        .directive('toggle', function(){
            return {
                restrict: 'A',
                link: function(scope, element, attrs){
                    if (attrs.toggle=="tooltip"){
                        $(element).tooltip();
                    }
                    if (attrs.toggle=="popover"){
                        $(element).popover();
                    }
                }
            };
        })
        .directive("progressBar", ["$timeout", function ($timeout) {
            return {
                restrict: "EA",
                scope: {
                    total: '=total',
                    complete: '=complete',
                    barClass: '@barClass',
                    completedClass: '=?'
                },
                transclude: true,
                link: function (scope, elem, attrs) {

                    scope.label = attrs.label;
                    scope.completeLabel = attrs.completeLabel;
                    scope.showPercent = (attrs.showPercent) || false;
                    scope.completedClass = (scope.completedClass) || 'progress-bar-danger';

                    scope.$watch('complete', function () {

                        //change style at 100%
                        var progress = scope.complete/scope.total;
                        if (progress >= 1) {
                            $(elem).find('.progress-bar').addClass(scope.completedClass);
                        }
                        else if (progress < 1) {
                            $(elem).find('.progress-bar').removeClass(scope.completedClass);
                        }

                    });

                },
                template:
                "<span class='small'> {{label}}</span>" +
                "<div class='progress'>"+
                "   <div class='progress-bar {{barClass}}' title='{{complete/total * 100 | number:0 }}%' style='width:{{complete/total * 100}}%;'>{{showPercent ? (complete/total*100) : complete | number:0}} {{completeLabel}}</div>" +
                "</div>"
            };
        }])

//$(document).ready(function(){});





})();