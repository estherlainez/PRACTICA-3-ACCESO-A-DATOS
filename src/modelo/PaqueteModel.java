package modelo;

import java.io.Serializable;

public class PaqueteModel implements Serializable{
	String nombre;
	String fechaInicio;
	String fechaFin;
	HotelModel estancia;
	VueloModel vueloIda;
	VueloModel vueloVuelta;
	
	public PaqueteModel(String nom,String fIni, String fFin, HotelModel e,VueloModel ida, VueloModel vuelta) {
		this.nombre=nom;
		this.fechaInicio=fIni;
		this.fechaFin=fFin;
		this.estancia=e;
		this.vueloIda=ida;
		this.vueloVuelta=vuelta;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		String paq="DATOS DEL PAQUETE"
				+"\nNombre del Paquete\n"
				+this.nombre
				+"\nFecha inicio\n"+
				this.fechaInicio+
				"\nFecha fin\n"+
				this.fechaFin+
				"\nDatos del hotel de estancia\n"+
				estancia.toString()+
				"\nDatos del vuelo de ida\n"+
				vueloIda.toString()+
				"\nDatos del vuelo de vuelta\n"+
				vueloVuelta.toString();
		return paq;
	}
	
	
}
