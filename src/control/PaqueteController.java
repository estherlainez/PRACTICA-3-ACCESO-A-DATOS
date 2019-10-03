package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import modelo.PaqueteModel;
import modelo.VueloModel;

public class PaqueteController {
	public class VueloController {
		
		public void añadirPaquete(Scanner teclado) {
			String ruta="src/";	
			String nombreF= "paquetes.dat";
			File f= new File(ruta+nombreF);
			try {
				f.createNewFile();
				FileOutputStream fileout = new FileOutputStream(f,true);
				ObjectOutputStream objectout = new ObjectOutputStream(fileout);
				teclado.nextLine();
				System.out.println("Introduzca fecha de inicio");
				String fIni=teclado.nextLine();
				System.out.println("Introduzca fecha de fin:");
				String fFin=teclado.nextLine();
				//System.out.println("Vuelo de ida");
				//String vI=teclado.nextLine();
				//System.out.println("Vuelo de vuelta:");
				//String vV=teclado.nextLine();
				//System.out.println("Estancia en el hotel:");
				//String nH=teclado.nextLine();
				//PaqueteModel p=new PaqueteModel(fIni,fFin,vI,vV,nH);
				//objectout.writeObject(p);
				
				objectout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void MostrarPaquete() {
			
			File f=new File("src/paquetes.dat");
			try {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				
				while(true) {
					PaqueteModel p=(PaqueteModel)ois.readObject();
					System.out.println(p.toString());
				}
					
						
			}catch(ClassNotFoundException e) {
						
			}catch(EOFException e) {} catch (IOException e) {
				
			}	
		}
	}

}
