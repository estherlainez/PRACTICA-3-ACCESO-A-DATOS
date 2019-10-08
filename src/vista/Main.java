package vista;
import java.util.*;

import control.HotelController;
import control.PaqueteController;
import control.VueloController;
import modelo.HotelModel;
import modelo.PaqueteModel;
import modelo.VueloModel;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado=new Scanner(System.in);
		int opcion;
	
		do {
			System.out.println("MENU");
			System.out.println("1.Introducir vuelo");
			System.out.println("2.Leer vuelos");
			System.out.println("3.Modificar Vuelos");
			System.out.println("4.Borrar un vuelo");
			System.out.println("5.Introducir un hotel");
			System.out.println("6.Leer Hoteles");
			System.out.println("7.Modificar Hotel");
			System.out.println("8.Borrar un hotel");
			System.out.println("9.Introducir un paquete de Viajes");
			System.out.println("10.Leer Paquetes");
			System.out.println("11.Modificar Paquete");
			System.out.println("12.Borrar un paquete");
			System.out.println("13.Salir");
			System.out.println("Introduzca opcion a elegir");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			
			case 1:
				System.out.println("Introducir nuevo vuelo");
				VueloController.añadirNuevoVuelo(teclado);
				break;
			case 2:
				System.out.println("Leer los vuelos");
				VueloController.listarVuelos();			
				break;
			case 3:
				System.out.println("Modificar un vuelo");
				VueloController.modificarVuelo(teclado);			
				break;			
			case 4:
				System.out.println("Borrar un vuelo");
				VueloController.BorrarVuelo(teclado);				
				break;
			case 5:
				System.out.println("Introducir nuevo hotel");
				HotelController.añadirNuevoHotel(teclado);				
				break;
			case 6:
				System.out.println("Leer los Hoteles");
				HotelController.listarHoteles();				
				break;
			case 7:
				System.out.println("Modificar un Hotel");
				HotelController.modificarHotel(teclado);				
				break;
			case 8:
				System.out.println("Borrar un hotel");
				HotelController.BorrarHotel(teclado);				
				break;
			case 9:
				System.out.println("Introducir un paquete de Viaje");
				PaqueteController.añadirNuevoPaquete(teclado);
				break;
			case 10:
				System.out.println("Leer Paquetes de Viaje");
				PaqueteController.listarPaquetes();
				break;
			case 11:
				System.out.println("Modificar un Paquete de Viaje");
				PaqueteController.modificarPaquete(teclado);
				break;
			case 12:
				System.out.println("Borrar un paquete de Viaje");
				PaqueteController.BorrarPaquete(teclado);
				break;
			case 13:
				System.out.println("Que tengas un buen viaje");
				break;
				
				default:
					System.out.println("Ha elegido una opcion errronea");
					break;
				
			}
			
			
		}while(opcion!=13);
		
	}

}
