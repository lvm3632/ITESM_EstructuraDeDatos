//Autor: A01636172 Michel Lujano
//Nombre de la clase: Ordenamientos.java
//Fecha: 27/02/20
//Comentarios: QuickSort


public class Ordenamientos{
		
	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		boolean orden=true;
		for(int i=0;i<datos.length-1 && orden;i++) { //Cuantas iteraciones voy a realizar
				orden=false;
			for(int j=0;j<datos.length-1-i;j++) {
				if(datos[j].compareTo(datos[j+1])>0) {
					swap(datos,j,j+1);
					orden=true;
				}
			}
			imprimeArreglo(datos);
		}
	}
	
	public static <E extends Comparable<E>> void mergesort(E[] datos) {
		mergesort(datos, 0, datos.length-1);
	}
	
	//primero:0 y ultimo: ultimo elemento
	private static <E extends Comparable<E>> void mergesort(E[] datos, int primero, int ultimo) {
		
		if(primero<ultimo) {
			int central=(primero+ultimo)/2; //1ra 0+5/2= 2.5 = [2];
			mergesort(datos,primero,central); //1ra (datos,0,2) // primero, ultimo 2 y luego 1
			mergesort(datos,central+1,ultimo); //1ra de 3 a 5
			mezcla(datos,primero,ultimo);
		}
	}
	
	private static <E extends Comparable<E>> void mezcla(E[] datos, int primero, int ultimo) {
		//ya estan ordenados de primero a central y de central+1 a ultimo
		//Tengo que dejar los datos ordenados desde primero hasta ultimo
		//Necesitas apoyarte de un arreglo temporal y no olvides regresar los datos al arreglo original
		
		E[] tmp = (E[]) new Comparable[ultimo+1];

		for (int i = primero;i<=ultimo;i++) {
			tmp[i]=datos[i];
		}

		int mid = (ultimo+primero)/2;
		int i=primero;
		int j=mid+1;
		for(int k=primero;k<=ultimo;k++) {
			if(i>mid) {
				datos[k]=tmp[j++];
			}else if(j>ultimo) {
				datos[k]=tmp[i++];
			}else if(tmp[i].compareTo(tmp[j])<0) {
				datos[k]=tmp[i++];
			}else {
				datos[k]=tmp[j++];
			}
		}
				
		System.out.print(primero + " primero " + ",");  //primero
		System.out.print(mid + " mid " + ",");
		System.out.print(ultimo + " ultimo " + ",");
		System.out.print(datos.length + " len" + ",");
		for (E e : tmp) {
			System.out.print(" "+e+",");
		}
		System.out.print("|||DATOS||||");
		for (E e : datos) {
			System.out.print(" "+e+"");
		}
	
		System.out.println();
		
	}

	
	private static <E> void swap(E[] datos,int i, int j) {
		E aux = datos[i];
		datos[i]=datos[j];
		datos[j]=aux;
	}
	
	public static <E> void imprimeArreglo(E[] datos) {
		
		for (int i = 0; i < datos.length; i++) {
			System.out.print(datos[i]+",");
		}
		System.out.println();
	}
	
	
	
	//QuickSort inplace
	//Usar primero quickSort arreglos grandes y luego mergesort
	//quicksort worst case n al 2	
	public static <E extends Comparable<E>> void quicksort(E[] datos) {
		quicksort(datos,0,datos.length-1);
	}
	
	public static <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {
		if(left<right) {
			int posPivote=particion(datos,left,right);
			quicksort(datos,left, posPivote-1);
			quicksort(datos,posPivote+1, right);
		}	
	}
	
	private static <E extends Comparable<E>> int particion(E[] datos, int left, int right) {
	
		E valorPivote = datos[left];
		System.out.println(left+1 + "cuando entra");
		int i = left+1; //1 después del pivote
		
		
		for (int j = left+1; j <= right; j++) {
			if(datos[j].compareTo(valorPivote)<0) {
				swap(datos,i,j);
				i++;
			}
		}	
		
		swap(datos, left, i-1);	
		System.out.println("Iteracion: ");
		imprimeArreglo(datos);
		System.out.println(i-1);
		
		return i-1;
	}
	
	
	//top-bottom mergesort
	public static void main(String[] args) {
		Integer[] valores = {3,8,2,5,1,4,7,6};
		Integer[] valores2 = {65,70,75,80,60,55,50,45};
		Integer[] valores3 = {32,28,45,21,16,52,47,18};
		String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E","X","A","M","P","L","E"};
		/*imprimeArreglo(valores);
		bubbleSort(valores);
		imprimeArreglo(valores);*/
		quicksort(valores);
		//mergesort(str);
		
	}

}
