package modelo;

import java.io.Serializable;

public class VueloModel implements Serializable{
	private String compañia;
	private String origen;
	private String destino;
	private double precio;
	public VueloModel(String c, String o, String d, double pv) {
		this.compañia=c;
		this.origen=o;
		this.destino=d;
		this.precio=pv;
	}
	public String getCompañia() {
		return compañia;
	}
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Vuelo [compañia=" + compañia + ", origen=" + origen + ", destino=" + destino + ", precio=" + precio
				+ "]";
	}
	

}