package co.com.lazyloading.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.lazyloading.exceptions.ExcepcionNegocio;

@RunWith(MockitoJUnitRunner.class)
public class ValidacionesServiceTest {

	@InjectMocks
	private ValidacionesServices validacionesServices;
	
	private List<Integer> listaCargas;
	
	@Test(expected=ExcepcionNegocio.class)
	public void debeRetornarExcepcionSiPrimerRegistroMayorA500(){
		listaCargas = Arrays.asList(501);
		validacionesServices.validarContenidoArchivo(listaCargas);
	}
	
	@Test(expected=ExcepcionNegocio.class)
	public void debeRetornarExcepcionSiPrimerRegistroMenorA1(){
		listaCargas = Arrays.asList(0);
		validacionesServices.validarContenidoArchivo(listaCargas);
	}
	
	@Test(expected=ExcepcionNegocio.class)
	public void debeRetornarExcepcionSiPesoMayorA100(){
		listaCargas = Arrays.asList(101, 110);
		validacionesServices.validarContenidoArchivo(listaCargas);
	}
	
	@Test(expected=ExcepcionNegocio.class)
	public void debeRetornarExcepcionSiPesoMenorA1(){
		listaCargas = Arrays.asList(101, 0);
		validacionesServices.validarContenidoArchivo(listaCargas);
	}
}
