package co.com.lazyloading.service;

import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.lazyloading.domain.LogCarga;
import co.com.lazyloading.repository.LogCargaRepository;

@RunWith(MockitoJUnitRunner.class)
public class LogCargaServiceTest {

	@InjectMocks
	private LogCargasService logCargasService;
	
	@Mock
	private LogCargaRepository logCargaRepository;
	
	ArgumentCaptor<LogCarga> logCargaCaptor = ArgumentCaptor.forClass(LogCarga.class);
	
	private static final String CEDULA = "1234567";
	
	@Test
	public void debeGuardarTrazaCarga(){
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		logCargasService.guardarLog(CEDULA);
		verify(logCargaRepository).save(logCargaCaptor.capture());
		Assert.assertEquals(CEDULA, logCargaCaptor.getValue().getCedula());
		Assert.assertEquals(formato.format(new Date()), formato.format(logCargaCaptor.getValue().getFecha()));
	}
}
