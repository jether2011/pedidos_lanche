/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('lanches', []);
var urlPath = "http://localhost:8080/lanches/api/pedido/";
var urlProdutoPath = "http://localhost:8080/lanches/api/produto/";
var urlClientePath = "http://localhost:8080/lanches/api/cliente/";

app.controller('pedidoCtrl', function ($scope, $http, $timeout) {
    $scope.pedidos = [];
    $scope.pedido = {};
    $scope.clienteOpcoes = [];
    $scope.produtoOpcoes = [];

    $scope.loadPedidos = function () {
        $http.get(urlPath, {cache: false})
                .success(function (response) {
                    //console.log(response);
                    $scope.pedidos = response;
                });
    };

    $scope.delete = function(pedido) {
        var now = new Date();
        pedido.dataCancelamento = now;
        delete pedido.$$hashKey;
        var values = JSON.stringify(pedido);
        $http({
            url: urlPath + pedido.id,
            method: 'PUT',
            data: values,
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (status) {
            console.log("Success: ");
            console.log(status);
        }).error(function (status) {
            console.log("Error: ");
            console.log(status);
        });
    };
    
    $scope.update = function(id) {
        $http({
            url: urlPath + id,
            method: 'GET'
        }).success(function (response) {
            $scope.pedido = response;
            jQuery('[href="#formPedido"]')[0].click();
        });
    };

    $scope.addItem = function() {
        if ($scope.pedido.itensPedido == null) {
            $scope.pedido.itensPedido = [];
        }
        $scope.pedido.itensPedido.push({});
    };

    $scope.limparPedido = function() {
        $scope.pedido = {};
        $scope.flagVisualizar = false;
    };

    $scope.finalizar = function(pedido) {
        var now = new Date();
        pedido.dataEntrega = now;
        delete pedido.$$hashKey;
        var values = JSON.stringify(pedido);
        $http({
            url: urlPath + pedido.id,
            method: 'PUT',
            data: values,
            headers: {'Content-Type': 'application/json; charset=utf-8'}
        }).success(function (status) {
            console.log("Success: ");
            console.log(status);
        }).error(function (status) {
            console.log("Error: ");
            console.log(status);
        });
    };

    $scope.esconderComandos = function(pedido) {
        if (pedido.dataCancelamento != null || pedido.dataEntrega != null) {
            return false;
        }  else {
            return true;
        }
    };

    $scope.visualizar = function(pedido) {
        $scope.pedido = pedido;
        $scope.flagVisualizar = true;
        
        jQuery('[href="#formPedido"]')[0].click();
        
    };

    $scope.save = function (pedido) {
        var total = 0;
        for (var i = 0; i < pedido.itensPedido.length; i++ ) {
            delete pedido.itensPedido[i].$$hashKey;
            pedido.itensPedido[i].valorUnitario = pedido.itensPedido[i].produto.valor;
            pedido.itensPedido[i].valorTotal = pedido.itensPedido[i].quantidade * pedido.itensPedido[i].produto.valor;
            total = total + pedido.itensPedido[i].valorTotal;
        }
        pedido.valorTotal = total;
        var now = new Date();
        pedido.dataPedido = now;
        
        var values = JSON.stringify(pedido);
        console.log(values);
        
        var method;
        var url;
        if (pedido.id != null) {
            method = 'PUT';
            url = urlPath + pedido.id;
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
        $scope.loadPedidos();
    }, 2000);
    $http.get(urlClientePath, {cache: false})
    .success(function (response) {
        $scope.clienteOpcoes = response;
    });

    $http.get(urlProdutoPath, {cache: false})
    .success(function (response) {
        $scope.produtoOpcoes = response;
    });
});

