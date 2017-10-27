package co.com.lazyloading.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LazyLoadingServiceTest {

	@InjectMocks
	private LazyLoadingService lazyLoadingService;
	
	@Mock
	private CalculosCargas calculosCargas;
	
	@Mock
	private LogCargasService logCargasService;
	
	@Mock
	private ValidacionesServices validacionesServices;
	
	private List<Integer> listaCargas = Arrays.asList(1,2,3,4,5);
	
	private List<List<Integer>> listaCargasPorDia = new ArrayList<>();
	
	private List<Integer> numeroViajesPorDiaEsperado = new ArrayList<Integer>();
	
	private static final String CEDULA = "1234567";
	
	@Test
	public void debeRetornarResultadoNumeroMaximoViajesPorDia() {
		when(calculosCargas.obtenerElementosACargarPorDia(listaCargas)).thenReturn(listaCargasPorDia);
		when(calculosCargas.obtenerNumeroViajesPorDia(listaCargasPorDia)).thenReturn(numeroViajesPorDiaEsperado);
		List<Integer> numeroViajesPorDiaResultado = lazyLoadingService.obtenerInformacion(listaCargas, CEDULA);
		Assert.assertEquals(numeroViajesPorDiaEsperado, numeroViajesPorDiaResultado);
	}
	
	@Test
	public void debeGuardarValidarArchivo(){
		when(calculosCargas.obtenerElementosACargarPorDia(listaCargas)).thenReturn(listaCargasPorDia);
		when(calculosCargas.obtenerNumeroViajesPorDia(listaCargasPorDia)).thenReturn(numeroViajesPorDiaEsperado);
		lazyLoadingService.obtenerInformacion(listaCargas, CEDULA);
		verify(validacionesServices).validarContenidoArchivo(listaCargas);
	}
	
	@Test
	public void debeGuardarTrazaEjecucion(){
		when(calculosCargas.obtenerElementosACargarPorDia(listaCargas)).thenReturn(listaCargasPorDia);
		when(calculosCargas.obtenerNumeroViajesPorDia(listaCargasPorDia)).thenReturn(numeroViajesPorDiaEsperado);
		lazyLoadingService.obtenerInformacion(listaCargas, CEDULA);
		verify(logCargasService).guardarLog(CEDULA);
	}
}
