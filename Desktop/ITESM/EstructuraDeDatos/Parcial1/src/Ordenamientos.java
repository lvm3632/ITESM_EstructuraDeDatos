//Autor: A01636172 Michel Lujano
//Nombre de la clase: Ordenamientos.java [quickSort a evaluar]
//Fecha: 02/09/19
//Comentarios: Es interesante la forma de particionar a partir de tener un pivote, dónde 
// las particiones trabajan a partir de éste y ordena en lado izq y der los menores y mayores. 
public class Ordenamientos {

	public static void BubbleSort(int[] datos) {
	
		
		int key;
		
		
		for(int i = datos.length-1; i > 0; i--) {
			for(int j=0;j<i;j++) {
				if(datos[j] > datos[j+1]) {
					key = datos[j];
					datos[j] = datos[j+1];
					datos[j+1] = key;
				}	
			}	
		}
	}
	
	
	//Mejor de los casos orden n
	//Peor de los casos n^2
public static void BubbleSort2(int[] datos) {
	
	
	boolean desordenados=true;
	
		for(int i=0;i<datos.length-1 && desordenados;i++) {
			desordenados=false;
			for(int j=0;j<datos.length-1-i;j++) {
				if(datos[j]>datos[j+1]) {
					swap(datos,j, j+1);
					desordenados=true;
				}
			}
			
		}
		
		
	}


	public static void swap(int[] datos, int i, int j) {
		
		int tmp;
		
		tmp = datos[j];
		datos[i] = datos[j];
		datos[j] = tmp;
		
		
	}
	
	// Función de imprime arreglo para datos primitivos
	public static void imprimeArreglo(int[] datos) {
		
		mergesort(datos);
		for (int valor:datos) {
			System.out.print(valor +",");
		}
		
	}
	
	public static <E extends Comparable <E>> void imprimeArreglo(E[] datos) {
		mergesort(datos);
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i] + ",");
		}
	}
	
	// Función de mergesort para datos primitivos
	
	private static void mergesort(int[] datos, int ini, int fin) {
		//ini<fin or lista.length>1
		if(ini<fin) {
			//int mid=(ini+fin)/2;
			//mergesort(datos, ini, mid);
			//mergesort(datos, mid+1, fin);
			//merge(datos,ini,fin);
			
			// Primera mitad 
			int[] firstHalf = new int [datos.length/2];
			System.arraycopy(datos, 0, firstHalf, 0, datos.length/2);
			mergesort(firstHalf);
			// Segunda mitad
			int secondHalfLength = datos.length - datos.length/2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(datos, datos.length/2, secondHalf, 0, secondHalfLength);
			mergesort(secondHalf);
			
			//	Mezcla de la primera mitad con la segunda mtiad
			merge(firstHalf, secondHalf, datos);
		}
	}
	
	// Función de mergesort para génericos
	private static <E extends Comparable <E>> void mergesort(E[] datos, int ini, int fin) {
		if(ini<fin) {
			// Primera mitad
			E[] firstHalf =   (E[])(new Comparable[datos.length/2]);
			System.arraycopy(datos, 0, firstHalf, 0, datos.length/2);
			mergesort(firstHalf);
			// Segunda mitad
			int secondHalfLength = datos.length - datos.length/2;
			E[] secondHalf =   (E[])(new Comparable[secondHalfLength]);
			System.arraycopy(datos, datos.length/2, secondHalf, 0, secondHalfLength);
			mergesort(secondHalf);
			
			// Mezcla de la primera mtiad con la segunda mitad
			merge(firstHalf, secondHalf, datos);
		}
	}
	
		
	// Función de preparación para datos primitivos
	public static void mergesort(int[] datos) {
		mergesort(datos,0, datos.length-1);
	}
	
	// Función de preparación para génericos
	public static <E extends Comparable <E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length-1);
	}
	
	
	// Función de preparación para datos primitivos -QuickSort-
	
	public static void quickSort(int[] datos) {
		quickSort(datos, 0, datos.length-1);
	}
	
	// Función de preparación para datos genéricos -QuickSort-
	public static <E extends Comparable <E>> void quickSort(E[] datos){
		quickSort(datos,0 ,datos.length-1);
	}
	// Función de merge para datos primitivos
	private static void merge(int[] lista1, int[] lista2, int[]temp) {
			int index1 = 0, //Index en lista 1
				index2 = 0, //Index en lista 2
				index3 = 0; //Index en temporal
			
			while(index1 < lista1.length && index2 < lista2.length) {
				if(lista1[index1] < lista2[index2]) {
					temp[index3++] = lista1[index1++];
				}else {
					temp[index3++] = lista2[index2++];
				}
			}
			
			while(index1 < lista1.length) {
				temp[index3++] = lista1[index1++];
			}
			
			while(index2 < lista2.length) {
				temp[index3++] = lista2[index2++];
			}
	}
	// Función de merge para génericos
	private static <E extends Comparable <E>> void merge(E[] lista1, E[] lista2, E[] temp) {
			int index1 = 0, // Index en lista 1,
				index2 = 0, // Index en lista2,
				index3 = 0; // Index en temporal.
			
			while(index1 < lista1.length && index2 < lista2.length) {
				if(lista1[index1].compareTo(lista2[index2]) < 0) {
					temp[index3++] = lista1[index1++];
				}else {
					temp[index3++] = lista2[index2++];
				}
			}
			
			while(index1 < lista1.length) {
				temp[index3++] = lista1[index1++];
			}
			
			while(index2 < lista2.length) {
				temp[index3++] = lista2[index2++];
			}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		int[] lista = {9,8,7,6,5,4,3,2,1};
		String[] lista_letras = {"Z", "B", "C", "D", "A", "R", "X", "E", "Y", "F", "O", "MO"};
		Integer[] lista_numeros = {1,3,591,2,9};
		imprimeArreglo(lista_letras);
		
	}
	
	
	// Función quickSort para primitivos
	private static void quickSort(int[] datos, int first, int last) {
		if(last>first) {
			int pivotIndex = partition(datos, first, last);
			quickSort(datos, first, pivotIndex-1);
			quickSort(datos, pivotIndex+1, last);
			
		}
	}
	
	// Función quickSort para génericos
	private static <E extends Comparable <E>> void quickSort(E[] datos, int first, int last) {
		if(last>first) {
			int pivotIndex = partition(datos, first, last);
		 	quickSort(datos,first, pivotIndex-1);
			quickSort(datos,pivotIndex+1, last);
		}
	}
	
	// Función quickSort partition para primitivos
	public static int partition(int[] datos, int first, int last) {
		int pivot = datos[first];
		int low = first + 1;
		int high = last;
		
		while(high > low) {
			
			while(low <= high && datos[low] <= pivot)
				low++;
			
			while(low <= high && datos[high] > pivot)
				high--;
			
			if(high>low) {
				int temp = datos[high];
				datos[high] = datos[low];
				datos[low] = temp;
			}
		}
		
		while(high>first && datos[high] >= pivot)
			high--;
		
		if(pivot>datos[high]) {
			datos[first] = datos[high];
			datos[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
	
	public static <E extends Comparable <E>> int partition(E[] datos, int first, int last) {
		E pivot = datos[first];
		int low = first + 1;
		int high = last;
		
		while(high > low) {
			
			while(low <= high && datos[low].compareTo(pivot) <= 0)
				low++;
			
			while(low <= high && datos[high].compareTo(pivot) > 0)
				high--;
			
			if(high>low) {
				E temp = datos[high];
				datos[high] = datos[low];
				datos[low] = temp;
			}
		}
		
		while(high>first && datos[high].compareTo(pivot) >= 0)
			high--;
		
		if(pivot.compareTo(datos[high])>0) {
			datos[first] = datos[high];
			datos[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
	
}
