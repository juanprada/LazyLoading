package co.com.lazyloading.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

	private ConvertUtil(){
		
	}
	
	public static List<Integer> convertBytesToList(byte[] archivo){
		String s = new String(archivo);
		return Arrays.stream(s.split("\n")).map(Integer::parseInt).collect(Collectors.toList());
	}
	
	public static byte[] convertListToBytes(List<Integer> list) {	 
		
		StringBuilder textoArchivo = new StringBuilder();
		
		for (int i = 0; i < list.size(); i++) {
			textoArchivo.append(String.format("CASE # %d: %d \n", i+1, list.get(i)));
		} 
	    
	    return textoArchivo.toString().getBytes();
	}
}
