app.controller('headerCtrl',function($scope,$rootScope,$location){
    $scope.mapSearch = function(){    	
        $rootScope.$broadcast("mapSearch",$scope.map_address);  
        $location.path("/");      
    }

});
