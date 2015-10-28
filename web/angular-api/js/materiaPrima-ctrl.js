var app = angular.module('lanches', []);
var urlPath = "http://localhost:8080/lanches/api/materiaPrima/";

app.controller('materiaPrimaCtrl', function ($scope, $http, $timeout) {
    $scope.materiasPrima = [];
    $scope.materiaprima = {};

    $scope.loadMateriaPrima = function () {
        $http.get(urlPath, {cache: false})
                .success(function (response) {
                    //console.log(response);
                    $scope.materiasPrima = response;
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
            $scope.materiaprima = response;
            jQuery('[href="#formMateriaPrima"]')[0].click();
        });
    };

    $scope.save = function (materiaprima) {
        var values = JSON.stringify(materiaprima);
        console.log(values);
        
        var method;
        var url;
        if (materiaprima.id != null) {
            method = 'PUT';
            url = urlPath + materiaprima.id;
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
        $scope.loadMateriaPrima();
    }, 2000);
});/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


