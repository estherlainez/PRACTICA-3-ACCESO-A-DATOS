package modelo;

import java.io.Serializable;

public class PaqueteModel implements Serializable{
	private String fechaInicio;
	private String fechaFin;
	private HotelModel estancia;
	private VueloModel vueloIda;
	private VueloModel vueloVuelta;
	
	public PaqueteModel(String fIni, String fFin, HotelModel e,VueloModel ida, VueloModel vuelta) {
		this.fechaInicio=fIni;
		this.fechaFin=fFin;
		this.estancia=e;
		this.vueloIda=ida;
		this.vueloVuelta=vuelta;
		
	}
	
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public HotelModel getEstancia() {
		return estancia;
	}

	public void setEstancia(HotelModel estancia) {
		this.estancia = estancia;
	}

	public VueloModel getVueloIda() {
		return vueloIda;
	}

	public void setVueloIda(VueloModel vueloIda) {
		this.vueloIda = vueloIda;
	}

	public VueloModel getVueloVuelta() {
		return vueloVuelta;
	}

	public void setVueloVuelta(VueloModel vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}


	@Override
	public String toString() {
		return "PaqueteModel [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estancia=" + estancia
				+ ", vueloIda=" + vueloIda + ", vueloVuelta=" + vueloVuelta + "]";
	}

	
	
	
	
}
