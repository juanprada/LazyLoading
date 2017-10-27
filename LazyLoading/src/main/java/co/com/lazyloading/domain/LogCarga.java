package co.com.lazyloading.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="lazyloading", type="logCarga" )
public class LogCarga {

	@Id
	private Long logCargaID;
	private String cedula;
	private Date fecha;
	
	public Long getLogCargaID() {
		return logCargaID;
	}
	public void setLogCargaID(Long logCargaID) {
		this.logCargaID = logCargaID;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
