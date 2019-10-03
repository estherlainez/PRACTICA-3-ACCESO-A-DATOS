package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import modelo.VueloModel;

public class VueloController {
	
	public static void añadirNuevoVuelo(Scanner teclado) {
		String ruta="src/";	
		String nombreF= "vuelos.dat";
		File f= new File(ruta+nombreF);
		try {
			f.createNewFile();
			FileOutputStream fileout = new FileOutputStream(f,true);
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
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void MostrarVuelos() {
		
		File f=new File("src/vuelos.dat");
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			
			while(true) {
				VueloModel vu=(VueloModel)ois.readObject();
				System.out.println(vu.getCompañia()+" "+vu.getOrigen()+" "+vu.getDestino()+" "+vu.getPrecio());
			}
				
					
		}catch(ClassNotFoundException e) {
					
		}catch(EOFException e) {} catch (IOException e) {
			
		}	
	}

}
