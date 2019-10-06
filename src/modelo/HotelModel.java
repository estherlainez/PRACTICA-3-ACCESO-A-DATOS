package modelo;
import java.io.Serializable;
import java.util.*;

public class HotelModel implements Serializable{
	private String nombre;
	private String descripcion;
	private String ciudad;
	private double precio;
	
	public HotelModel(String n, String d, String c, double p) {
		this.nombre=n;
		this.descripcion=d;
		this.ciudad=c;
		this.precio=p;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public static double calcularPrecioEstancia(double precio, int dias) {
		double resultado=precio*dias;
		return resultado;
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Hotel [nombre=" + nombre + ", descripcion=" + descripcion + ", ciudad=" + ciudad + ", precio=" + precio
				+ " euros/Noche"+"]";
	}

}
