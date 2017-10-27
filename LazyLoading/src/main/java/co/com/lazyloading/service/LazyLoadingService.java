package co.com.lazyloading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LazyLoadingService {
	
	@Autowired
	private LogCargasService logCargasService;
	
	@Autowired
	private CalculosCargas calculosCargas;
	
	@Autowired
	private ValidacionesServices validacionesServices;
	
	public List<Integer> obtenerInformacion(List<Integer> listaCargas, String cedula) {
		logCargasService.guardarLog(cedula);
		validacionesServices.validarContenidoArchivo(listaCargas);
		final List<List<Integer>> elementosCargasDia = calculosCargas.obtenerElementosACargarPorDia(listaCargas);
		return calculosCargas.obtenerNumeroViajesPorDia(elementosCargasDia);
	}
}
