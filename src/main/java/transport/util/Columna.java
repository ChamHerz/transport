package transport.util;

public class Columna {
	private String nombre;
	private int size;
	
	public Columna(String _nombre,int _size){
		nombre = _nombre;
		size = _size;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getSize(){
		return size;
	}
}