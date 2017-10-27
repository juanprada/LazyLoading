angular.module("cargaArchivoModule")
.controller("cargaArchivoController", ['$scope', 'cargaArchivoService', function($scope, cargaArchivoService){
	
	$scope.respuestaExitosa = false;
	$scope.respuestaErronea = false;
	
	$scope.cargarArchivo = function(){
		cargaArchivoService.cargarArchivo($scope.archivo,$scope.cedula).then(function(response){
			$scope.descargarArchivo(response);
		    $scope.respuestaExitosa = true;
		    $scope.respuestaErronea = false;
			$scope.mensaje = "Archivo procesado correctamente";
		}, function(error){
			$scope.respuestaErronea = true;
			$scope.respuestaExitosa = false;
			$scope.mensaje = error.data;
		});
	}
	
	$scope.descargarArchivo = function(response){
		var contentType = response.headers["Content-Type"] || "application/octet-stream";
	    var urlCreator = window.URL || window.webkitURL || window.mozURL || window.msURL;
	    if (urlCreator) {
	        var blob = new Blob([response.data], { type: contentType });
	        var url = urlCreator.createObjectURL(blob);
	        var a = document.createElement("a");
	        document.body.appendChild(a);
	        a.style = "display: none";
	        a.href = url;
	        a.download = "respuesta.txt";
	        a.click();
	        window.URL.revokeObjectURL(url);
	    }
	}
	
	$scope.uploadedFile = function (element){
		$scope.$apply(function($scope) {
			   $scope.archivo = element.files;         
		});
	}
}]);