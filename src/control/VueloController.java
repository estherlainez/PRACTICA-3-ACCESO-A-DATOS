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
import modelo.VueloModel;

public class VueloController {
	
public static void añadirNuevoVuelo(Scanner teclado) {
		
		String ruta="src/vuelos.dat";	
	
		File f= new File(ruta);		
		try {
			FileOutputStream fileout = new FileOutputStream(f,true);
		
			ObjectOutputStream os=null;
			if(f.exists()) {
				
				os=new MyObjectOutputStream(new FileOutputStream(f));
					
				ObjectOutputStream objectout = new ObjectOutputStream(fileout);
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
				objectout.writeObject(v);
				
				objectout.close();
	
			}else
				os=new ObjectOutputStream(new FileOutputStream(f));
				os.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static  ArrayList<VueloModel>listarVuelos() {
		ArrayList<VueloModel>vuelos=new ArrayList<VueloModel>();
	 	File f= new File("src/vuelos.dat");
		FileInputStream filein=null;
		ObjectInputStream objectin=null;
		HotelModel dh=null;
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			
			while(true) {
				vuelos.add(((VueloModel)ois.readObject()));
				
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();		
		}catch(EOFException e) {
			//e.printStackTrace();
			for (VueloModel v:vuelos) {
				System.out.println(v.toString());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return vuelos;
	
	}
	

}
