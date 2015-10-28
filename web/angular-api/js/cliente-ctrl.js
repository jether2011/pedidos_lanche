var app = angular.module('lanches', []);
var urlPath = "http://localhost:8080/lanches/api/cliente/";

app.controller('clienteCtrl', function ($scope, $http, $timeout) {
    $scope.clientes = [];
    $scope.cliente = {};

    $scope.loadClientes = function () {
        $http.get(urlPath, {cache: false})
                .success(function (response) {
                    //console.log(response);
                    $scope.clientes = response;
                });
        $scope.config = {
            itemsPerPage: 5,
            fillLastPage: true
        }
    };

    $scope.delete = function (id) {
        $http({
            url: urlPath + id,
            method: 'DELETE'
        }).success(function (status) {
            console.log("Success: ");
            console.log(status);
        });
    };
    
    $scope.update = function(id) {
        $http({
            url: urlPath + id,
            method: 'GET'
        }).success(function (response) {
            $scope.cliente = response;
            jQuery('[href="#formCliente"]')[0].click();
        });
    };

    $scope.save = function (cliente) {
        var values = JSON.stringify(cliente);
        console.log(values);
        
        var method;
        var url;
        if (cliente.id != null) {
            method = 'PUT';
            url = urlPath + cliente.id;
        } else {
            method = 'POST';
            url = urlPath;
        }
        
        $http({
            url: url,
            method: method,
            data: values,
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (status) {
            console.log("Success: ");
            console.log(status);
            jQuery('[href="#tabela"]')[0].click();
        }).error(function (status) {
            console.log("Error: ");
            console.log(status);
        });
    };

    var interval = setInterval(function () {
        $scope.loadClientes();
    }, 2000);
});