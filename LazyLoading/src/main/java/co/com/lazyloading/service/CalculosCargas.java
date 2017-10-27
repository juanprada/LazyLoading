package co.com.lazyloading.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class CalculosCargas {

	public List<List<Integer>> obtenerElementosACargarPorDia(List<Integer> listaCargas){
		List<List<Integer>> cargas = new ArrayList<List<Integer>>();
		
		AtomicInteger inicio 	= new AtomicInteger(2);
		AtomicInteger fin 		= new AtomicInteger(listaCargas.get(1) + 2);
		
		cargas.add(listaCargas.subList(inicio.get(), fin.get()));
		
			IntStream.range(1, listaCargas.get(0)).forEach(j->{
				inicio.set(fin.get() + 1);
				fin.set(listaCargas.get(fin.get()) +fin.get() + 1);
				cargas.add(listaCargas.subList(inicio.get(), fin.get()));	
			});
		
		return cargas;
	}
	
	public List<Integer> obtenerNumeroViajesPorDia(List<List<Integer>> elementosCargasDia){
		List<Integer> resultado = new ArrayList<Integer>();
		
		elementosCargasDia.stream().forEach(i->{ 
			resultado.add(obtenerNroViajes(i));
		});
		
		return resultado;
	}
	
	private Integer obtenerNroViajes(List<Integer> pesosDia){
		List<Integer> pesosDiaOrdenado = pesosDia.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		int cargasDia = 0;
		int recorrido = pesosDiaOrdenado.size();
		for (int i = 0; i < recorrido; i++) {
			int items = (int) Math.ceil((double)50 / (double)pesosDiaOrdenado.get(i));
			if (items != 1){
				recorrido = recorrido - items;
			}
			cargasDia++;
		}
		return cargasDia;	
	}
}
