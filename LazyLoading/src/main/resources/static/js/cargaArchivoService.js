angular.module("cargaArchivoModule")
.service("cargaArchivoService" , ["$http", function($http){
	var service = {};
	
	service.cargarArchivo = function (file, cedula){
		var formData = new FormData();
		formData.append("archivo", file[0]);
		formData.append("cedula", cedula);
		return $http.post("lazyLoading/calcular", formData, 
				{headers: {	"Content-type": undefined},transformRequest: angular.indentity});
	}
	
	return service;
}]);