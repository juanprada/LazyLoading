package co.com.lazyloading.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.com.lazyloading.exceptions.ExcepcionNegocio;

@Component
public class ValidacionesServices {
	
	public void validarContenidoArchivo(List<Integer> listaCargas){
		
		if (!listaCargas.subList(1, listaCargas.size()).stream().filter(n->n<1 || n>100).collect(Collectors.toList()).isEmpty()){
			throw new ExcepcionNegocio("El peso debe ser entre 1 y 100");
		}
		
		if (listaCargas.get(0) < 1 || listaCargas.get(0) > 500){
			throw new ExcepcionNegocio("El numero de dias a cargar debe ser entre 1 y 500");
		}
	}
	
	
}
