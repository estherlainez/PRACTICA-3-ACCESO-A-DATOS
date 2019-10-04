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
			FileOutputStream out = new FileOutputStream(f,true);

			ObjectOutputStream os=null;
			if(f.exists()) {

				os=new MyObjectOutputStream(new FileOutputStream(f));

				ObjectOutputStream objectout = new ObjectOutputStream(out);
				teclado.nextLine();
				System.out.println("Introduzca nombre del paquete:");
				String nom=teclado.nextLine();
				System.out.println("Añada fecha de inicio:");
				String fIni=teclado.nextLine();
				System.out.println("Añada fecha de fin:");
				String fFin=teclado.nextLine();
				System.out.println("Datos del hotel:");
				System.out.println("Nombre del Hotel");
				String nH=teclado.nextLine();
				System.out.println("Descripcion del hotel:");
				String dH= teclado.nextLine();
				System.out.println("Ciudad del Hotel:");
				String cH=teclado.nextLine();
				System.out.println("Precio Hotel:");
				double pH=teclado.nextDouble();
				HotelModel ho=new HotelModel(nH,dH,cH,pH);
				System.out.println("Datos del vuelo de ida:");
				System.out.println("Nombre de la compañia:");
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
				String nV1=teclado.nextLine();
				System.out.println("Origen del vuelo de ida");
				String oV1=teclado.nextLine();
				System.out.println("Destino del vuelo de ida");
				String dV1=teclado.nextLine();
				System.out.println("Precio del vuelo de ida");
				double p1=teclado.nextDouble();
				VueloModel vueloVuelta=new VueloModel(nV1,oV1,dV1,p1);

				PaqueteModel p=new PaqueteModel(nom, fIni,fFin, ho,vueloIda, vueloVuelta);

				objectout.writeObject(p);
				
				objectout.close();
			}else
				os=new ObjectOutputStream(new FileOutputStream(f));
			os.close();

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
	
}
