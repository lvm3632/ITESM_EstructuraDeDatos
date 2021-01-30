//Autor: A01636172 Michel Lujano
//Nombre de la clase: BubbleSortGenerico.java
//Fecha: 29/08/19
//Comentarios: Es interesante implementar génericos, y más en un arreglo de ordenamiento
// porque es de mucha utilidad, manejar todo tipo de variables sin utilizar muchas funciones
// o ser redudantes. por lo que me parece muy bueno que existan los génericos.
import java.util.Iterator;
public class BubbleSortGenerico {

	public static void main(String[] args) {
		
		String[] lista = {"Liebre", "Burbuja", "Zapato", "Robot","Armario", "Zanahoria", "Libro", "Pera"};
		Integer[] lista2 = {51,239,12,40,20,3,4};
		imprimeArreglo(lista);
		imprimeArreglo(lista2);
		
	}
	
	public static <E extends Comparable <E>> void imprimeArreglo(E[] lista) {
		
		BubbleSort(lista);
		
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i] + ",");
		}
		System.out.println();
	}
	
	
	private static <E extends Comparable <E>> void BubbleSort(E[] lista){
		
		//boolean desordenados=true;
		E key;
		
		for(int i=0;i<lista.length-1; i++) {
			//desordenados=false;
			for(int j=0;j<lista.length-1-i;j++) {
				if(lista[j].compareTo(lista[j+1]) > 0) {
					/*key = lista[j];
					lista[j] = lista[j+1];
					lista[j+1] = key;*/
					//desordenados=false;
					swap(lista, j);
					
				}
			}
		}
	
		
	}
	
		
	
	public static <E extends Comparable <E>> void swap(E[] lista, int j) {
	
		E key;
		
		key = lista[j];
		lista[j] = lista[j+1];
		lista[j+1] = key;
		
	}
	
	

	
	
	
}
