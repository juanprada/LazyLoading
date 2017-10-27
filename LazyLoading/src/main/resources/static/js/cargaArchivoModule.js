angular.module("cargaArchivoModule", ['ngRoute','ui.bootstrap'])
.config(['$routeProvider',
	   function($routeProvider) {
	      $routeProvider.
	         when('/cargaArchivo', {
	            templateUrl: 'pages/cargaArchivo.html',
	            controller: 'cargaArchivoController'
	         });

	   }]);