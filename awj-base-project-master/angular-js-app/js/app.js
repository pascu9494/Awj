var app = angular.module('blog', []);

app.controller('MarcaController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/persoana';

    $scope.Marca = [];
    $scope.fields = [];
    $scope.Marca = {};


    $scope.Marca = {};
    $scope.editMarca = {};



    $http.get(url).then(function successCallback(response) {

        $scope.Marca = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.Marca);
        //console.log($scope.fields);

    });


    $scope.addMarca = function(Marca) {
        Marca.id = parseInt(Marca.id);
        console.log(Marca.id);
        $http({
            method: 'POST',
            url: url,
            data: Marca
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(Marca);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteMarca = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.Marca = $scope.Marca.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateMarca = function(Marca) {
        $scope.editMarca = Marca;
    };


    $scope.updateMarca = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editMarca
        }).then(function successCallback(response) {
            $scope.editMarca = {};
            console.log(response);
            // $scope.Marca.push($scope.editMarca);
            // done.
        }, function errorCallback(response) {
            $scope.editMarca = {};
            console.log(response);
        });
    };

}]);