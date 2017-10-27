package co.com.lazyloading.exceptions;

public class ExcepcionNegocio extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6190533120232359451L;

	public ExcepcionNegocio(String mensaje) {
		this(mensaje, null);
	}
	
	public ExcepcionNegocio(String mensaje, Throwable exception){
		super(mensaje, exception);
	}
}
