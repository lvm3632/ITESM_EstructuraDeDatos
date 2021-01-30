
public class Fibonacci {

	
	public static void main(String[] args) {
		long ini=System.nanoTime(),
				fin;
		/*System.out.println(Fibonacci.fibonacci(46));
		
		System.out.println("Se tardo: " + ((fin-ini)/1000000000.0));*/
		
		System.out.println(Fibonacci.fibonacciOpt(100));
		fin=System.nanoTime();
		System.out.println("Se tardo: " + ((fin-ini)/1000000000.0));
	}
	
	public static long fibonacci(int n) {
		if(n==1 || n==0) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}	
	}
	
	public static long fibonacciOpt(int n) {
		long[] serie=new long[n+1];
		serie[0]=serie[1]=1;
		return fibonacciOpt(n, serie);
	}
	
	public static long fibonacciOpt(int n, long[] serie) {
		
		if(serie[n]!=0) {
			return serie[n];
		}
		else {
			serie[n] = fibonacciOpt(n-2, serie)+fibonacciOpt(n-1, serie);
			return serie[n];
		}
	}
	
	
}
