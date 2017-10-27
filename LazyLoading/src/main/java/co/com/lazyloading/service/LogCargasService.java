package co.com.lazyloading.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.com.lazyloading.domain.LogCarga;
import co.com.lazyloading.repository.LogCargaRepository;

@Service
public class LogCargasService {

	@Autowired
	private LogCargaRepository cargaRepository;
	
	@Async
	public void guardarLog(String cedula){
		LogCarga carga = new LogCarga();
		carga.setCedula(cedula);
		carga.setFecha(new Date());
		cargaRepository.save(carga);
	}
}
