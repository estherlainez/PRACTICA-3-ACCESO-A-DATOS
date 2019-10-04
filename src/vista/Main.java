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
		
		//ArrayList<HotelModel>hoteles=new ArrayList<HotelModel>();
		//ArrayList<VueloModel>vuelos=new ArrayList<VueloModel>();
		//ArrayList<PaqueteModel>paquetes=new ArrayList<PaqueteModel>();
	
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
			System.out.println("Introduzca opcion a elegir");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			
			case 1:
				VueloController.añadirNuevoVuelo(teclado);
				
				break;
			case 2:
				VueloController.listarVuelos();
				
				break;
			case 3:
				VueloController.modificarVuelo(teclado);
				
				break;
				
			case 4:
				VueloController.BorrarVuelo(teclado);
				
				break;
			case 5:
				HotelController.añadirNuevoHotel(teclado);
				
				break;
			case 6:
				HotelController.listarHoteles();
				
				break;
			case 7:
				HotelController.modificarHotel(teclado);
				
				break;
			case 8:
				HotelController.BorrarHotel(teclado);
				
				break;
			case 9:
				PaqueteController.añadirNuevoPaquete(teclado);
				break;
			case 10:
				PaqueteController.listarPaquetes();
				break;
			case 11:
				break;
			case 12:
				break;
				
			}
			
			
		}while(opcion!=12);
		
	}

}
