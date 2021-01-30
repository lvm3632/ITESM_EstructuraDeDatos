//Autor: A01636172 Michel Lujano
//Nombre de la clase: Recursion.java
//Fecha: 17/02/20
//Comentarios: Recursión

public class Recursion {

	public static void main(String[] args) {
		//Integer[] arr={5,4,3,2,1,1,2,3,4,5,6,1,3,5,7,2,4};
		//System.out.println(buscaUltimo(arr, 4));
		System.out.println(Recursion.tribonacci(10));
 	}
	
	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor) {
		return buscaUltimo(valores, valor, 0);
	}
	
	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor, int pos) {
		int num=-1;
		if(pos<valores.length) {			
			if(valor.equals(valores[pos])) {
				int max = pos;
				return max = Math.max(max, buscaUltimo(valores,valor,pos+1));
			}	
		num=buscaUltimo(valores,valor,pos+1);
		}
		if(num!=-1) {
			return num;
		}else {
			return num;
		}
	}
	
	 public static int tribonacci(int n) {
	        return addTrib(n, 0, 1, 1);
	    }
	    
	    public static int addTrib(int n, int b1, int b2, int b3) {
	        if (n == 0) return 0;
	        if (n == 1 || n == 2) return 1;
	        int sum = b1+b2+b3;
	        if (n == 3) return sum;
	        return addTrib(n-1, b2, b3, sum);
	    }
	
}
