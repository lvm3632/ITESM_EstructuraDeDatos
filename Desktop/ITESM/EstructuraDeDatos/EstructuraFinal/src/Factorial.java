
public class Factorial {

	public long factorial(long n) {
		
		if(n<=1) {
			return 1;
		}else {
			
			return n * factorial(n-1);
		}	
	}
	
	public static void main(String[] args) {

		Factorial test = new Factorial();
		System.out.println(test.factorial(5));
		
	}
	
	

}
