function Hello($scope, $http) {
    $http.get('http://localhost:18080/api/customers').
        success(function(data) {
            $scope.customers = data;
        });
}