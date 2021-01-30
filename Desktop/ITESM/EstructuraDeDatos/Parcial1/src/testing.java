import java.util.*;
import java.io.*;


public class testing {
    
    /*
    BufferedReader and String.spit
    */
    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //numero de rutas
        int T = Integer.parseInt(br.readLine()); //tiempos en llegar a la estacion
        //String tokens[] = br.readLine().split(" ");
        
        //System.out.println("Hay estas rutas" + N );
        //System.out.println("Estes el tiempo en llegar a la estacion " + T);
        
        
        int[] primer_tiempo = new int[N];
        int[] intervalo = new int[T];
        
        for(int i=0; i<N; i++){
           int s = sc.nextInt();   // primer camion en llegar
           primer_tiempo[i] = s;
           int d = sc.nextInt();   // tiempo entre un camion y otro
           intervalo[i] = d;
        }
        
        
        for (int i = 0; i < N; i++) {
        	int suma = 0;
			if(T == primer_tiempo[i]) {
				System.out.println(i+1);
				break;
			}
			else if(primer_tiempo[i] % T == 0) {
				System.out.println(i+1);
				break;
			}else if(T % primer_tiempo[i]== 1) {
				
					
				suma = (primer_tiempo[i] + intervalo[i]) + intervalo[i];
				
				if(suma == T-1 || suma == T+1) {
					System.out.println(i+1);
					break;
				}
			}
			
		}
        	
        
      
        br.close();
        
    }
    
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
   
        public MyScanner() {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
   
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
   
        int nextInt() {
            return Integer.parseInt(next());
        }
   
        long nextLong() {
            return Long.parseLong(next());
        }
   
        double nextDouble() {
            return Double.parseDouble(next());
        }
   
        String nextLine(){
            String str = "";
  	  try {
  	     str = br.readLine();
  	  } catch (IOException e) {
  	     e.printStackTrace();
  	  }
  	  return str;
        }

     }
}	



