package co.com.lazyloading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.lazyloading.service.LazyLoadingService;
import co.com.lazyloading.util.ConvertUtil;

@RestController
@RequestMapping("lazyLoading")
public class LazyLoadingController {

	@Autowired
	private LazyLoadingService lazyLoadingService;
	
	@RequestMapping(method=RequestMethod.POST, value="calcular", produces = "application/octet-stream")
	public byte[] calcular(@RequestParam("archivo") MultipartFile archivo,
			@RequestParam("cedula") String cedula) throws Exception {
		List<Integer> listaPesosACargar = ConvertUtil.convertBytesToList(archivo.getBytes());
		List<Integer> resultadoCargasPorDia = lazyLoadingService.obtenerInformacion(listaPesosACargar, cedula);
		return ConvertUtil.convertListToBytes(resultadoCargasPorDia);
	}
}
