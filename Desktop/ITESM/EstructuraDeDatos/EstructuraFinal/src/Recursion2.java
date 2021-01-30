

public class Recursion2 {

	public static void main(String[] args) {
		//Integer[] arr = {-2,-1,1,1,-2,-3,-4,-512,2,41,-4555};
		Integer[] arr = {-1,-2,4,3,-555,23,999999999,1,4,-222111,1,-211};
		String[] str = {"Pedro", "Michel", "Angel"};
		System.out.println(min(arr));
		for (Integer x : arr) {
			System.out.print(x +",");
		}
		//System.out.println(min(str));
		//printRec(15);
	}
	
	
	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor) {
		return buscaUltimo(valores,valor,0);
	}
	
	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor, int pos) {
	
		if(pos<valores.length) {
			if(valor.equals(valores[pos])) {
				
			}
		}
	}
	
	
	
	public static <E extends Comparable<E>> E min(E[] arr) {
		return min(arr,arr.length-1);
	}
	
	public static <E extends Comparable<E>> E min(E[] arr, int i) {
		if(i==0) {
			return arr[0];
		}
		//System.out.println(i);
		E min=min(arr, i-1);
		if(min.compareTo(arr[i])>0) {
			min=arr[i];
		}
		return min;
	}
	
	public static void printRec(int a) {
		
		if(a<=1) {
			System.out.print(a + ",");
			System.out.print(a + ",");
		}else {
			System.out.print(a+ ",");
			printRec(a-1);
			System.out.print(a + ",");
		}
	}
	
	
	
}
