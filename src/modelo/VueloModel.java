package modelo;

import java.io.Serializable;

public class VueloModel implements Serializable{
	private String compa�ia;
	private String origen;
	private String destino;
	private double precio;
	public VueloModel(String c, String o, String d, double pv) {
		this.compa�ia=c;
		this.origen=o;
		this.destino=d;
		this.precio=pv;
	}
	public String getCompa�ia() {
		return compa�ia;
	}
	public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
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
		return "Vuelo [compa�ia=" + compa�ia + ", origen=" + origen + ", destino=" + destino + ", precio=" + precio
				+ "]";
	}
	

}