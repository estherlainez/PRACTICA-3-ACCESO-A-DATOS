package modelo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{

	protected MyObjectOutputStream() throws IOException, SecurityException {
		super();
	}
	
	public  MyObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}
	
	@Override
	protected void writeStreamHeader()throws IOException{
		//Este es el metodo encargado de crear la cabecera
		//Lo dejamos vacio para que no haga nada
	}

}
