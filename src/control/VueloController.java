package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;


public class VueloController {
	private static String ruta="src/vuelos.dat";
	
	public static void añadirNuevoVuelo(Scanner teclado) {
		File f= new File(ruta);		
		try {
			ObjectOutputStream os=null;	
			
			if(f.exists()) {
				os=new MyObjectOutputStream(new FileOutputStream(f,true));
	
				teclado.nextLine();
				System.out.println("Introduzca nombre de la compañia:");
				String n=teclado.nextLine();
				System.out.println("Añada ciudad de oriden:");
				String co=teclado.nextLine();
				System.out.println("Añada ciudad de destino:");
				String cd=teclado.nextLine();
				System.out.println("Añada precio:");
				double pv=teclado.nextDouble();
					
				VueloModel v=new VueloModel(n,co,cd,pv);
				os.writeObject(v);
				os.close();
			}else {
				os=new ObjectOutputStream(new FileOutputStream(f));
				
				teclado.nextLine();
				System.out.println("Introduzca nombre de la compañia:");
				String n=teclado.nextLine();
				System.out.println("Añada ciudad de oriden:");
				String co=teclado.nextLine();
				System.out.println("Añada ciudad de destino:");
				String cd=teclado.nextLine();
				System.out.println("Añada precio:");
				double pv=teclado.nextDouble();
					
				VueloModel v=new VueloModel(n,co,cd,pv);
				os.writeObject(v);
				os.close();
			}
	
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public static  ArrayList<VueloModel> listarVuelos() {
		ArrayList<VueloModel>vuelos=new ArrayList<VueloModel>();
	
		File f= new File(ruta);
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			
			while(true) {
				vuelos.add((VueloModel)ois.readObject());
				
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();		
		}catch(EOFException e) {
			for (VueloModel v:vuelos) {
				System.out.println(v.toString());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return vuelos;
	
	}
	
	

	public static void modificarVuelo(Scanner teclado) {
		ArrayList<VueloModel>vuelos=null;

		try {
			vuelos=listarVuelos();

			System.out.println("Introduce el origen del vuelo a modificar");
			teclado.nextLine();
			String origen=teclado.nextLine();
			for(VueloModel v:vuelos) {
				if(v.getOrigen().equals(origen)) {
					System.out.println("Introduzca la compañia aerea:");
					String c=teclado.nextLine();
					v.setCompañia(c);
					System.out.println("Introduzca nuevo origen:");
					String o=teclado.nextLine();
					v.setOrigen(o);
					System.out.println("Introduzca nueva ciudad de destino:");
					String ciu=teclado.nextLine();
					v.setDestino(ciu);
					System.out.println("Añada nuevo precio:");
					double p=teclado.nextDouble();
					v.setPrecio(p);
				}
			}
		}catch(Exception e) {
			for (VueloModel vuelo:vuelos) {
				System.out.println(vuelo.toString());
			}
		}

		//Escribo de nuevo
		try {
			File f= new File(ruta);
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			for(VueloModel vu: vuelos)
				objectout.writeObject(vu);
			
            objectout.close();
            
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void BorrarVuelo(Scanner teclado) {
		ArrayList<VueloModel>vuelos=null;
		
		try {
			vuelos=listarVuelos();

			System.out.println("Introduce la posicion del vuelo a borrar");
			int pos=teclado.nextInt();
			String origen=teclado.nextLine();
			for(int i=1;i<=vuelos.size();i++) {
				if(!(i==pos)) {
					
					File f= new File(ruta);
					FileOutputStream fileout = new FileOutputStream(f);
					ObjectOutputStream objectout = new ObjectOutputStream(fileout);
					for(VueloModel vu: vuelos)
						objectout.writeObject(vu);

					objectout.close();
				}
			}

		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	

}
