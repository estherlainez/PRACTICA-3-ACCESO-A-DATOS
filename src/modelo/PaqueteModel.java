package modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	
	public static int calcularDias(String fIni, String fFin) {	
		String[] arrayFechaInicio = fIni.split("/");
		int dia = Integer.valueOf(arrayFechaInicio[0]);
		int mes = Integer.valueOf(arrayFechaInicio[1]) -1;
		int año = Integer.valueOf(arrayFechaInicio[2]);		
		
		String[] arrayFechaFin = fFin.split("/");
		int dia1 = Integer.valueOf(arrayFechaFin[0]);
		int mes1 = Integer.valueOf(arrayFechaFin[1]) -1;
		int año1 = Integer.valueOf(arrayFechaFin[2]);
		 
		Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
       
        cal1.set(año, mes, dia);
        cal2.set(año1, mes1, dia1);
        int dias = (int)( (cal2.getTime().getTime() - cal1.getTime().getTime()) / (1000 * 60 * 60 * 24)) ;
       
		return dias;
	}
	
	
	public static  boolean compararFechas(String fIni,String fFin) {
		boolean esAnterior=false;
		try {
			 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			 Date fecha1 = formato.parse(fIni);
			 Date fecha2 = formato.parse(fFin);
			   
			  if ( fecha1.before(fecha2) ){
			      esAnterior=true;
			  }
	    } catch (ParseException e) {
			 System.out.println("Error!!!  "+e.getMessage());
	    }  
		return esAnterior;
		
	}

	@Override
	public String toString() {
		int diasViaje=PaqueteModel.calcularDias(this.fechaInicio, this.fechaFin);
		double sumaTotal=estancia.getPrecio()*diasViaje+ vueloIda.getPrecio()+vueloVuelta.getPrecio();
		String paq="DATOS DEL PAQUETE"
				+"\nNombre del Paquete\n"+
				this.nombre
				+"\nFecha inicio\n"+
				this.fechaInicio+
				"\nFecha fin\n"+
				this.fechaFin+
				"\nDuracion del viaje "+diasViaje+" dias"+
				"\nDatos del hotel de estancia\n"+
				estancia.toString()+
				"\nPrecio de la estancia "+estancia.getPrecio()*diasViaje+	
				"\nDatos del vuelo de ida\n"+
				vueloIda.toString()+
				"\nPrecio de la ida "+vueloIda.getPrecio()+	
				"\nDatos del vuelo de vuelta\n"+
				vueloVuelta.toString()+
				"\nPrecio de la ida "+vueloVuelta.getPrecio()+		
				"\nPrecio Total del viaje :"+sumaTotal+" euros";
				
		
		return paq;
	}
	
	
}
