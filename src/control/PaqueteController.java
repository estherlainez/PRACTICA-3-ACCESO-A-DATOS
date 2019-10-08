package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.HotelModel;
import modelo.PaqueteModel;
import modelo.VueloModel;

public class PaqueteController {

	private static String ruta="src/paquetes.dat";

	public static void añadirNuevoPaquete(Scanner teclado) {
		File f= new File(ruta);
		
		try {
			ObjectOutputStream os=null;
			if(f.exists()) {
				
				os=new MyObjectOutputStream(new FileOutputStream(f,true));

				teclado.nextLine();
				System.out.println("Introduzca nombre del paquete:");
				String nom=teclado.nextLine();
				String fIni,fFin;
				boolean esCorrecto=true;
				
				do{
					System.out.println("Comprobando las fechas, la fecha de inicio sera anterior a la de fin.....");
					System.out.println("Añada fecha de inicio:");
					fIni=teclado.nextLine();
					System.out.println("Añada fecha de fin:");
					fFin=teclado.nextLine();
					esCorrecto=PaqueteModel.compararFechas(fIni, fFin);
					
				}while(esCorrecto==false);
				
				int diasViaje=PaqueteModel.calcularDias(fIni, fFin);
				System.out.println("Duracion de dias del viaje--->"+diasViaje+" dias");
				System.out.println("Datos del hotel:");
				System.out.println("Nombre del Hotel");
				String nH=teclado.nextLine();
				System.out.println("Descripcion del hotel:");
				String dH= teclado.nextLine();
				System.out.println("Ciudad del Hotel:");
				String cH=teclado.nextLine();
				System.out.println("Precio Hotel:");
				double pH=teclado.nextDouble();
				double precioEstancia=HotelModel.calcularPrecioEstancia(pH, diasViaje);
				System.out.println("El precio de la estancia sera de--->"+precioEstancia+" euros");
				HotelModel ho=new HotelModel(nH,dH,cH,pH);
				System.out.println("Datos del vuelo de ida:");
				System.out.println("Nombre de la compañia:");
				teclado.nextLine();
				String nV=teclado.nextLine();
				System.out.println("Origen del vuelo de ida");
				String oV=teclado.nextLine();
				System.out.println("Destino del vuelo de ida");
				String dV=teclado.nextLine();
				System.out.println("Precio del vuelo de ida");
				double pI=teclado.nextDouble();
				VueloModel vueloIda=new VueloModel(nV,oV,dV,pI);
				System.out.println("Datos del vuelo de vuelta:");
				System.out.println("Nombre de la compañia:");
				teclado.nextLine();
				String nV1=teclado.nextLine();
				System.out.println("Origen del vuelo de ida");
				String oV1=teclado.nextLine();
				System.out.println("Destino del vuelo de ida");
				String dV1=teclado.nextLine();
				System.out.println("Precio del vuelo de ida");
				double p1=teclado.nextDouble();
				VueloModel vueloVuelta=new VueloModel(nV1,oV1,dV1,p1);
				double precioTotal=precioEstancia+pI+p1;
				System.out.println(".....Su precio total asciende a..."+precioTotal+" Euros");
				PaqueteModel p=new PaqueteModel(nom, fIni,fFin, ho,vueloIda, vueloVuelta);

				os.writeObject(p);
				
				os.close();
			}else {
				os=new ObjectOutputStream(new FileOutputStream(f));
			
				teclado.nextLine();
				System.out.println("Introduzca nombre del paquete:");
				String nom=teclado.nextLine();
				String fIni,fFin;
				boolean esCorrecto=true;
				
				do{
					System.out.println("Comprobando las fechas, la fecha de inicio sera anterior a la de fin.....");
					System.out.println("Añada fecha de inicio:");
					fIni=teclado.nextLine();
					System.out.println("Añada fecha de fin:");
					fFin=teclado.nextLine();
					esCorrecto=PaqueteModel.compararFechas(fIni, fFin);
					
				}while(esCorrecto==false);
				
				int diasViaje=PaqueteModel.calcularDias(fIni, fFin);
				System.out.println("Duracion de dias del viaje--->"+diasViaje+" dias");
				System.out.println("Datos del hotel:");
				System.out.println("Nombre del Hotel");
				String nH=teclado.nextLine();
				System.out.println("Descripcion del hotel:");
				String dH= teclado.nextLine();
				System.out.println("Ciudad del Hotel:");
				String cH=teclado.nextLine();
				System.out.println("Precio Hotel:");
				double pH=teclado.nextDouble();
				double precioEstancia=HotelModel.calcularPrecioEstancia(pH, diasViaje);
				System.out.println("El precio de la estancia sera de--->"+precioEstancia+" euros");
				HotelModel ho=new HotelModel(nH,dH,cH,pH);
				System.out.println("Datos del vuelo de ida:");
				System.out.println("Nombre de la compañia:");
				teclado.nextLine();
				String nV=teclado.nextLine();
				System.out.println("Origen del vuelo de ida");
				String oV=teclado.nextLine();
				System.out.println("Destino del vuelo de ida");
				String dV=teclado.nextLine();
				System.out.println("Precio del vuelo de ida");
				double pI=teclado.nextDouble();
				VueloModel vueloIda=new VueloModel(nV,oV,dV,pI);
				System.out.println("Datos del vuelo de vuelta:");
				System.out.println("Nombre de la compañia:");
				teclado.nextLine();
				String nV1=teclado.nextLine();
				System.out.println("Origen del vuelo de ida");
				String oV1=teclado.nextLine();
				System.out.println("Destino del vuelo de ida");
				String dV1=teclado.nextLine();
				System.out.println("Precio del vuelo de ida");
				double p1=teclado.nextDouble();
				VueloModel vueloVuelta=new VueloModel(nV1,oV1,dV1,p1);
				double precioTotal=precioEstancia+pI+p1;
				System.out.println(".....Su precio total asciende a..."+precioTotal+" Euros");
				PaqueteModel p=new PaqueteModel(nom, fIni,fFin, ho,vueloIda, vueloVuelta);
	
				os.writeObject(p);
				os.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void modificarPaquete(Scanner teclado) {
		ArrayList<PaqueteModel>paquetes=null;

		try {
			paquetes=listarPaquetes();

			System.out.println("Introduce nombre del paquete a modificar");
			teclado.nextLine();
			String nombreP=teclado.nextLine();
			for(PaqueteModel p:paquetes) {
				if(p.getNombre().equals(nombreP)) {
					System.out.println("Introduzca nuevo nombre:");
					String n=teclado.nextLine();
					p.setNombre(n);
					
					String fIni,fFin;
					
					boolean esCorrecto=true;
					do{
						System.out.println("Comprobando las fechas, la fecha de inicio sera anterior a la de fin.....");
						System.out.println("Cambie la fecha de inicio:");
						fIni=teclado.nextLine();
						p.setFechaInicio(fIni);
						System.out.println("Cambie la fecha de fin:");
						fFin=teclado.nextLine();
						p.setFechaFin(fFin);
						esCorrecto=PaqueteModel.compararFechas(fIni, fFin);
						
					}while(esCorrecto==false);

					int diasViaje=PaqueteModel.calcularDias(fIni, fFin);
					System.out.println("Duracion de dias del viaje--->"+diasViaje+" dias");
					
					System.out.println("Datos del hotel:");
					System.out.println("Nombre del Hotel");
					teclado.hasNextLine();
					String nH=teclado.nextLine();
					System.out.println("Descripcion del hotel:");
					String dH= teclado.nextLine();
					System.out.println("Ciudad del Hotel:");
					String cH=teclado.nextLine();
					System.out.println("Precio Hotel:");
					double pH=teclado.nextDouble();
					HotelModel estanciaNueva=new HotelModel(nH,dH,cH,pH);
					p.setEstancia(estanciaNueva);
					double precioEstancia=HotelModel.calcularPrecioEstancia(pH, diasViaje);
					System.out.println("El precio de la estancia sera de--->"+precioEstancia+" euros");
					
					System.out.println("Datos del vuelo de ida:");
					System.out.println("Nombre de la compañia:");
					teclado.nextLine();
					String nV=teclado.nextLine();
					System.out.println("Origen del vuelo de ida");
					String oV=teclado.nextLine();
					System.out.println("Destino del vuelo de ida");
					String dV=teclado.nextLine();
					System.out.println("Precio del vuelo de ida");
					double pI=teclado.nextDouble();
					VueloModel NuevoVueloIda=new VueloModel(nV,oV,dV,pI);
					p.setVueloIda(NuevoVueloIda);
					
					System.out.println("Datos del vuelo de vuelta:");
					System.out.println("Nombre de la compañia:");
					teclado.nextLine();
					String nV1=teclado.nextLine();
					System.out.println("Origen del vuelo de ida");
					String oV1=teclado.nextLine();
					System.out.println("Destino del vuelo de ida");
					String dV1=teclado.nextLine();
					System.out.println("Precio del vuelo de ida");
					double p1=teclado.nextDouble();
					VueloModel NuevoVueloVuelta=new VueloModel(nV1,oV1,dV1,p1);
					p.setVueloVuelta(NuevoVueloVuelta);
					
				}

			}

		}catch(Exception e) {

			for (PaqueteModel pa:paquetes) {
				System.out.println(pa.toString());
			}
		}

		try {
			File f= new File(ruta);
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			for(PaqueteModel p: paquetes)
				objectout.writeObject(p);

			objectout.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public static  ArrayList<PaqueteModel>listarPaquetes() {
		ArrayList<PaqueteModel>paquetes=new ArrayList<PaqueteModel>();
		File f= new File(ruta);	
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));

			while(true) {
				paquetes.add(((PaqueteModel)ois.readObject()));

			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();		
		}catch(EOFException e) {

			for (PaqueteModel pa: paquetes) {
				System.out.println(pa.toString());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return paquetes;

	}
	
	public static void BorrarPaquete(Scanner teclado) {
		ArrayList<PaqueteModel>paquetes=null;
		
		try {
			paquetes=listarPaquetes();

			System.out.println("Introduce la posicion del paquete a borrar");
			int pos=teclado.nextInt();
			
			File f= new File(ruta);
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fout);
			
			for(int i=0;i<paquetes.size();i++) {
				if((i+1!=pos)) {
					out.writeObject(paquetes.get(i));
				}
			}
			out.close();

		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}
