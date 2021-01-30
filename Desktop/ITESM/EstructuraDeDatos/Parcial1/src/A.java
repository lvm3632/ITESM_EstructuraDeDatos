import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;

public class A<E extends Comparable<E>> {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int ruta=0;
        
		int n = sc.nextInt();
		int t = sc.nextInt();
		int s[] = new int[n];
		int d[] = new int[n];

		
		for (int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			d[i] = sc.nextInt();
		} 
		
		int suma=0;
		for (int i = 0; i < n; i++) {
			if(t-s[i] <= 0) {
				ruta = s[i];
				break;
			}else if(t == s[i]) {
				ruta = s[i];
				break;
			}else if (t-s[i] >= 1) {
				
				int x = 10000/d[i];
				
				while(suma != 100000) {
					suma = suma + (s[i]+d[i])+d[i];
				}
			}
			
			
			
		}
		
		System.out.println(ruta);
		
	}
}