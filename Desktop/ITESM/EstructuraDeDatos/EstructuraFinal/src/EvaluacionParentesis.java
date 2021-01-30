import java.util.NoSuchElementException;

public class EvaluacionParentesis {
	
	public static void main(String[] args) {
		
		System.out.println(evaluaParentesis("[ 5 + ( 6 + 2 * 3 ) ) / 4"));
		
	}
	
	
	public static boolean evaluaParentesis(String expresion) {
		
		try {
			MyStack<String> pila = new MyStack<>();
			
			//String expresion = "( 5 + ( 6 + 2 * 3 ) ) / 4";
			String[] tokens=expresion.split(" ");
			
			//Regla 1: Si cuentro un parentesis abierto, se manda a la pila
			//Regla 2: Si encuentro un parentesis de cierre, se hace un pop y debe ser del mismo tipo, sino error.
			//		 - Si al hacer el pop la pila estaba vacía, y se lanza excepción
			//		  no estaba correcta
			//Regla 3: Al final si la pila está vacía la expresión es correcta sino faltaron
			// parentesis de cierre
			String pop;
			for (int i = 0; i < tokens.length; i++) {
				
				switch (tokens[i]) {
				
					case "(":
					
					case "[":
						
					case "{":
						pila.push(tokens[i]);
						break;
						
					case ")":
						pop=pila.pop();
						if(!"(".equals(pop)) {
							System.out.println("No fueron del mismo tipo");
							return false;
						}
						break;
					case "]":
						pop=pila.pop();
						if(!"[".equals(pop)) {
							System.out.println("No fueron del mismo tipo");
							return false;
						}
						break;
					case "}":
						pop=pila.pop();
						if(!"{".equals(pop)) {
							System.out.println("No fueron del mismo tipo");
							return false;
						}
						break;
				}
				
			}
			
			return pila.isEmpty();
			
		}catch(NoSuchElementException ex){
			System.out.println("No había con quien cerrar");
			return false;
		}
		
		
	}

}
