package co.com.lazyloading.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = { IndexOutOfBoundsException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String IndexOfBoundException(Exception ex, WebRequest req) {
        return "Archivo no tiene la estructura correcta";
    }
	
	@ExceptionHandler(value = { NumberFormatException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String numericException(Exception ex, WebRequest req) {
        return "Archivo contiene caracteres diferentes a numeros";
    }
	
	@ExceptionHandler(value = { ExcepcionNegocio.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String negocioException(Exception ex, WebRequest req) {
        return ex.getMessage();
    }
}
