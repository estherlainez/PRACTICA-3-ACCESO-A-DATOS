package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import modelo.HotelModel;
import modelo.VueloModel;

public class HotelController {

	
	public static void añadirNuevoHotel(Scanner teclado,ArrayList<HotelModel>hoteles) {
		String ruta="src/";
		String nombreF="hoteles.dat";
		File f= new File(ruta+nombreF);
		try {
			FileOutputStream fileout = new FileOutputStream(f,true);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			teclado.nextLine();
			System.out.println("Introduzca nombre:");
			String n=teclado.nextLine();
			System.out.println("Añada descripcion del hotel:");
			String d=teclado.nextLine();
			System.out.println("Añada ciudad donde se encuentra el Hotel:");
			String c=teclado.nextLine();
			System.out.println("Añada precio del hotel:");
			double p=teclado.nextDouble();
			
			HotelModel h=new HotelModel(n,d,c,p);
			//hoteles.add(h);
			
			objectout.writeObject(h);
			
			objectout.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void modificarHotel(Scanner teclado) {
		try {
			File f= new File("hoteles.dat");
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			System.out.println("¿Que hotel va a modificar? Introduzca su nombre");
			String nM=teclado.nextLine();
			HotelModel a=null;
			if(a.getNombre().equals("nM")) {
				System.out.println("Introduzca nuevo nombre:");
				String n=teclado.nextLine();
				a.setNombre(n);
				System.out.println("Añada nueva descripcion del hotel:");
				String d=teclado.nextLine();
				a.setDescripcion(d);
				System.out.println("Añada nueva ciudad donde se encuentra el Hotel:");
				String c=teclado.nextLine();
				a.setCiudad(c);
				System.out.println("Añada nuevo precio del hotel:");
				double p=teclado.nextDouble();
				a.setPrecio(p);
				System.out.println(a.toString());
				objectout.writeObject(a);
			}
			
			objectout.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void listarHoteles() {
		
	 	File f= new File("src/hoteles.dat");
		FileInputStream filein=null;
		ObjectInputStream objectin=null;
		HotelModel dh=null;
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
			
			while(true) {
				HotelModel hotel=(HotelModel) ois.readObject();
				System.out.println(dh.getNombre()+" "+dh.getDescripcion()+" "+dh.getCiudad()+" "+dh.getPrecio());
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();		
		}catch(EOFException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public static ArrayList<HotelModel> listaHoteles(ArrayList<HotelModel> hoteles) {

		try {
			File f= new File("src/hoteles.dat");
			FileInputStream filein=null;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	        HotelModel hotel = (HotelModel)ois.readObject();
	            
	        Iterator<HotelModel> i = hoteles.listIterator();
	        while(i.hasNext()){
	             System.out.println("Hotel: "+i.next().getNombre());
	        }

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return hoteles;




	}

}