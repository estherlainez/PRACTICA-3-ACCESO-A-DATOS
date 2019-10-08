package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.SequenceInputStream;
import java.util.*;
import modelo.MyObjectOutputStream;
import modelo.HotelModel;
import modelo.VueloModel;

public class HotelController {
	private static String ruta="src/hoteles.dat";

	public static void a�adirNuevoHotel(Scanner teclado) {
		File f= new File(ruta);
		ObjectOutputStream os=null;
		
		try {
			if(!f.exists()){
				os=new ObjectOutputStream(new FileOutputStream(f));
				
				teclado.nextLine();
				System.out.println("Introduzca nombre:");
				String n=teclado.nextLine();
				System.out.println("A�ada descripcion del hotel:");
				String d=teclado.nextLine();
				System.out.println("A�ada ciudad donde se encuentra el Hotel:");
				String c=teclado.nextLine();
				System.out.println("A�ada precio del hotel:");
				
				double p=teclado.nextDouble();
	
				HotelModel h=new HotelModel(n,d,c,p);
	
				os.writeObject(h);
		
				os.close();
				
			}else {
			
				os=new MyObjectOutputStream(new FileOutputStream(f,true));
					
				teclado.nextLine();
				System.out.println("Introduzca nombre:");
				String n=teclado.nextLine();
				System.out.println("A�ada descripcion del hotel:");
				String d=teclado.nextLine();
				System.out.println("A�ada ciudad donde se encuentra el Hotel:");
				String c=teclado.nextLine();
				System.out.println("A�ada precio del hotel:");
				
				double p=teclado.nextDouble();
	
				HotelModel h=new HotelModel(n,d,c,p);
	
				os.writeObject(h);
		
				os.close();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static  ArrayList<HotelModel>listarHoteles() {
		ArrayList<HotelModel>hoteles=new ArrayList<HotelModel>();
		File f= new File(ruta);
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(f));
			
			while(true) {
				hoteles.add(((HotelModel)ois.readObject()));
				
			}

		}catch(ClassNotFoundException e) {
			e.printStackTrace();		
		}catch(EOFException e) {

			for (HotelModel h:hoteles) {
				System.out.println(h.toString());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return hoteles;

	}

	
	public static void modificarHotel(Scanner teclado) {
		ArrayList<HotelModel>hoteles=null;

		try {
			hoteles=listarHoteles();

			System.out.println("Introduce nombre que vas a modificar");
			teclado.nextLine();
			String nM=teclado.nextLine();
			for(HotelModel h:hoteles) {
				if(h.getNombre().equals(nM)) {
					System.out.println("Introduzca nuevo nombre:");
					String n=teclado.nextLine();
					h.setNombre(n);
					System.out.println("A�ada nueva descripcion del hotel:");
					String d=teclado.nextLine();
					h.setDescripcion(d);
					System.out.println("A�ada nueva ciudad donde se encuentra el Hotel:");
					String c=teclado.nextLine();
					h.setCiudad(c);
					System.out.println("A�ada nuevo precio del hotel:");
					double p=teclado.nextDouble();
					h.setPrecio(p);
				}

			}

		}catch(Exception e) {

			for (HotelModel h:hoteles) {
				System.out.println(h.toString());
			}
		}

		//escribo de nuevo
		try {
			File f= new File(ruta);
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			for(HotelModel h: hoteles)
				objectout.writeObject(h);

			objectout.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void BorrarHotel(Scanner teclado) {
		ArrayList<HotelModel>hoteles=null;
		
		try {
			hoteles=listarHoteles();

			System.out.println("Introduce la posicion del hotel a borrar");
			int pos=teclado.nextInt();
			
			File f= new File(ruta);
			FileOutputStream fileout = new FileOutputStream(f);
			ObjectOutputStream objectout = new ObjectOutputStream(fileout);
			
			for(int i=0;i<hoteles.size();i++) {
				if((i+1!=pos)) {
					
					objectout.writeObject(hoteles.get(i));

					
				}
			}
			objectout.close();

		}catch(IOException e) {
			e.printStackTrace();
		}

	}


}