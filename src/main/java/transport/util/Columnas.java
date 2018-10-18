package transport.util;

import java.util.ArrayList;
import java.util.List;

public class Columnas {
	private List<Columna> listaColumnas = new ArrayList<Columna>();
	
	public void agregar(Columna columna){
		listaColumnas.add(columna);
	}
	
	public String[] getNombresColumnas(){
		String[] arrayString = new String[listaColumnas.size()];
		int index = 0;
		for(Columna columna:listaColumnas){
			arrayString[index] = columna.getNombre();
			index++;
		}
		return arrayString;
	}
	
	public int[] getAnchos(){
		int[] arrayInt = new int[listaColumnas.size()];
		int index = 0;
		for(Columna columna:listaColumnas){
			arrayInt[index] = columna.getSize();
			index++;
		}
		return arrayInt;
	}
}