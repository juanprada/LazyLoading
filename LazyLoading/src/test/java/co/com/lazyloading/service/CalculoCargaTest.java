package co.com.lazyloading.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculoCargaTest {

	@InjectMocks
	private CalculosCargas calculosCarga;
	
	private final List<Integer> listaCarga = Arrays.asList(5,4,30,30,1,1,3,20,20,20,11,1,2,3,4,5,6,7,8,9,10,11,6,9,19,29,39,49,59,10,32,56,76,8,44,60,47,85,71,91);
	
	private List<List<Integer>> listaCargaPorDiaEsperada = new ArrayList<List<Integer>>();
	
	@Before
	public void prepararDatos(){
		List<Integer> listaDia = Arrays.asList(30,30,1,1);
		listaCargaPorDiaEsperada.add(listaDia);
		
		listaDia = Arrays.asList(20,20,20);
		listaCargaPorDiaEsperada.add(listaDia);
		
		listaDia = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
		listaCargaPorDiaEsperada.add(listaDia);
		
		listaDia = Arrays.asList(9,19,29,39,49,59);
		listaCargaPorDiaEsperada.add(listaDia);
		
		listaDia = Arrays.asList(32,56,76,8,44,60,47,85,71,91);
		listaCargaPorDiaEsperada.add(listaDia);
	}
	
	@Test
	public void debeObtenerPesosElemetosPorDia(){
		List<List<Integer>> listaCargasDiaResultado = calculosCarga.obtenerElementosACargarPorDia(listaCarga);
		Assert.assertEquals(listaCargaPorDiaEsperada, listaCargasDiaResultado);
	}
	
	@Test
	public void debeObtenerNumeroMaximoCargasPorDia(){
		List<Integer> listaNroCargasDiaEsperada = Arrays.asList(2,1,2,3,8);
		List<Integer> listaCargasDiaResultado = calculosCarga.obtenerNumeroViajesPorDia(listaCargaPorDiaEsperada);
		Assert.assertEquals(listaNroCargasDiaEsperada, listaCargasDiaResultado);
	}
}
