//Autor: A01636172 Michel Lujano
//Nombre de la clase: BusquedaBinaria.java
//Fecha: 26/08/19
//Comentarios: Forma interesante de utilizar código con buena eficacia y en menor número de líneas de código. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BusquedaBinaria {

	
	public static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor) {

		int min = 0,
			max = valores.length-1;
		
		return binarySearchRec(valores, valor, min, max);
	}
	
	
	private static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor,int min,int max) {

		if(min>max) {
			return -1;
		}
		else {
			int avg = (max+min)/2;
			if(valores[avg].compareTo(valor)< 0) {
				return binarySearchRec(valores, valor, avg+1, max);
			} else if (valores[avg].compareTo(valor) > 0) {
				return binarySearchRec(valores, valor, min, avg-1);
			}else {
				return avg;
			}
		}
				
	}
	
	
	
	public static void main(String[] args) {
		
		Integer lista[] = {10,20,30,40,55,60,70,90,100};
		
		System.out.println(binarySearchRec(lista, 60));
		
	}
}
								

