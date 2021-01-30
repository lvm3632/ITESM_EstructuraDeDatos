import javax.swing.JOptionPane;

public class BinarySearch {
	
	public static int binarySearch(String valor, String[] valores) {
		int min=0,
			max=valores.length-1,
			avg;
		
		while(min<=max) {
			
			avg = (min+max)/2;
			//Si el valor buscado esta en avg regresar la posición
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max=avg-1;
			}else{
				min=avg+1;
			}
			//Sino revisar si es mayor o menor el valor buscado y
			//actualizar los índices. 
		}
		
		
		return -1;
	}
	
	

	public static <E extends Comparable<E>> int binarySearch(E valor, E[] valores) {
		int min=0,
			max=valores.length-1,
			avg;
		
		while(min<=max) {
			
			avg = (min+max)/2;
			//Si el valor buscado esta en avg regresar la posición
			if(valor.equals(valores[avg])) {
				return avg;
			}else if(valor.compareTo(valores[avg])<0) {
				max=avg-1;
			}else{
				min=avg+1;
			}
			//Sino revisar si es mayor o menor el valor buscado y
			//actualizar los índices. 
		}
		
		
		return -1;
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		//int[] numeros = {7,10,12,22,40,50,65,90};
		
		//System.out.println(binarySearch(50, numeros));
		
		
		String[] nombres = {"Juan", "Pedro", "Miguel", "Daniela"};
		
	System.out.println(binarySearch("Pedro", nombres));	
	String[] apellidos = {"Juan", "Pedro", "Miguel", "Daniela"};
	String nombre =JOptionPane.showInputDialog("Dame el apellido a buscar");
	int pos = binarySearch(nombre, apellidos);
	
	if(pos==-1) {
		System.out.println(nombre + "no se localiza");
	}else {
		System.out.println("Esta en la posición" + pos);
	}
			
		
	}

}
