
public class BusquedaBinaria {

	public static <E extends Comparable<E>> int BinarySearch(E[] datos, E valor) {
		int min=0,
			max=datos.length-1,
			avg;
		
		while(min<=max) {
			avg = min + (max-min)/2;
			if(valor.equals(datos[avg])) {
				return avg;
			}else if(valor.compareTo(datos[avg])<0) {
				max=avg-1;
			}else if(valor.compareTo(datos[avg])>0) {
				min=avg+1;
			}		
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearchRec(E[] datos, E valor) {
		return binarySearchRec(datos, valor, 0, datos.length-1);
	}
	
	public static <E extends Comparable<E>> int binarySearchRec(E[] datos, E valor, int min, int max) {
		
		int avg = min+(max-min)/2;
		
		if(min<=max) {
		
			if(valor.equals(datos[avg])) {
				return avg;
			}else if(valor.compareTo(datos[avg])<0) {
				return binarySearchRec(datos,valor,min,avg-1);
			}else if(valor.compareTo(datos[avg])>0) {
				return binarySearchRec(datos,valor,avg+1,max);
			}
			
		}
		
		return -1;
		
	}
	
	
	
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5};
		String[] str = {"Alan", "Eleonore", "Enrique", "Ingrid","Mathew", "Maxime"};
		
		System.out.println(binarySearchRec(str,"Maxime"));
		System.out.println(BinarySearch(str, "Enrique"));
	}
	
	
}
