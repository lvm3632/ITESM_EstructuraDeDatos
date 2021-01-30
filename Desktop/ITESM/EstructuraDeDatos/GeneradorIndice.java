// Autor: Michel Lujano
// Matrícula: A01636172
// Fecha: 04/06/2020
// Clase: GeneradorIndice.java

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;




public class GeneradorIndice {
	
	  
	  

	public static void main(String[] args) {
		
		imprimeIndice("Pepe pecas pica papas con un pico pica papas pepe pecas con un pico pica papas pepe pecas");
	}
	
	
	
	public static void imprimeIndice(String texto) {
		Hashtable<String, String> palabras = new Hashtable<String, String>();
		int pos=0;
		String res ="";
	//put, get, equals
		String found="";
		String str = texto.toUpperCase();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			found = st.nextToken(" ");
			String pos_actual = String.valueOf(pos);
		
			pos++;
			if(palabras.containsKey(found)) {
				String pos_anterior = palabras.get(found);
				palabras.put(found, pos_anterior + ","+pos_actual);
			}else {
				palabras.put(found, pos_actual);
			}
			
		
		}
		
			Set<String> keys = palabras.keySet();
	
			Iterator<String> itr = keys.iterator();
			
			while(itr.hasNext()) {
				
				 str = itr.next();
				
				 System.out.println(str +": "+palabras.get(str));
			}
	
		
		
	}
	
	
	
	
}
