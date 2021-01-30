// Autor: A01636172, Michel Lujano
// Fecha: 26/03/20
// Clase: EvaluarExpresion.java
// Comentarios: Use la libreria stack de java, para no agregar otra clase más. 


import java.util.IllegalFormatConversionException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class EvaluarExpresion {

	public static void main(String[] args) {
		//System.out.println(evaluaParentesis("( 5 + ( 6 + 2 * 3 ) ) / 4"));
		
		/*System.out.println(evaluaExpresion("10 + 20 * ( 50 / 2 ) - 5.8"));
		System.out.println(evaluaExpresion("3 * 5 * 7 * 5 - 9"));
		System.out.println(evaluaExpresion("( 1 + { 2 - 4 } )"));
		System.out.println(evaluaExpresion("1 - 1"));
		System.out.println(evaluaExpresion("5 - ( ( 1 + 2 ) - 4 ) + 3"));
		System.out.println(evaluaExpresion("( ( 4 + 2 * 3 ) + ( 3 * ( 5 - 1 ) ) )"));
		System.out.println(evaluaExpresion("10 - 5  /  5 - 4  +  5 - 4  +  5 - 4"));
		
		System.out.println(evaluaExpresion("5 * 2 * 3 - 1 / 2 + 4 / 3 - 1 + 2 + 2 ^ 5 + ( 3 * 3 ^ 5 ) - 5 / 2 + 1 ^ 10  + ( 3 * 3 ^ 5 )"));*/
		System.out.println(evaluaExpresion("10 - 3 - 5"));
	}
	
	
	private String expresionInfija;
	
	public EvaluarExpresion(String expresionInfija) {
		this.expresionInfija= expresionInfija;
	}
	
	public void setExpresionInfija(String expresionInfija) {
		this.expresionInfija = expresionInfija;
	}

	public static double evaluaExpresion(String expresion) {

		String posFija = expresionPostfijo(expresion);
		String[] tokens = posFija.split(" ");
		//System.out.println(posFija);
		
		Stack<Double> pila = new Stack<Double>();
		
		
		if(tokens.length == 1 && tokens[0].matches("[0-9]+") || tokens[0].matches("[0-9]+.[0-9]")) {
			return Double.parseDouble(tokens[0]);
		}
			
			for (int i = 0; i < tokens.length; i++) {
				
				if(tokens[i].matches("[0-9]+") || tokens[i].matches("[0-9]+.[0-9]")) {
					pila.push(Double.parseDouble(tokens[i]));
				}else if(tokens[i].equals("-") || tokens[i].matches("[+,/,^,*]")) {
					
					double num2 = pila.pop();
					double num1 = pila.pop();
					
					 switch(tokens[i]) 
		                { 
			                case "^": 
		                    	pila.push(Math.pow(num1, num2)); 
		                    break; 
					 
		                    case "+": 
		                    	pila.push(num1+num2); 
		                    break; 
		                      
		                    case "-": 
		                    	pila.push(num1- num2); 
		                    break; 
		                      
		                    case "/": 
		                    	pila.push(num1/num2); 
		                    break; 
		                      
		                    case "*": 
		                    	pila.push(num1*num2); 
		                    break; 
		              } 
				}
				
			}
		
			
			double res = pila.pop();
			
		
		return res;
		
		
		
		
	}
	
	public static String expresionPostfijo(String expresionInfija) {
		String expresionPostFija = "";
		
		if(evaluaParentesis(expresionInfija)) {
			Stack<String> pila = new Stack<String>();
			String[] tokens = expresionInfija.split(" ");
			String[] tokensPos = new String[tokens.length];
				int k=0;
							
				for (int i = 0; i < tokens.length; i++) {
					if(tokens[i].matches("[0-9]+") || tokens[i].matches("[0-9]+.[0-9]")) {
						tokensPos[k++] = tokens[i];
					}else {
						
						
						if(!pila.isEmpty() && pila.peek().equals("^") && tokens[i].matches("[+,-,/,*]")) {
							while(!pila.isEmpty() && !pila.peek().matches("[,(,{]") && !pila.peek().equals("["))  {
								tokensPos[k++] = pila.pop();
							}	
						}
						
										
						if(!pila.isEmpty() && pila.peek().equals("*") && tokens[i].matches("[+,-]")) {
							while(!pila.isEmpty() && !pila.peek().matches("[,(,{]") && !pila.peek().equals("["))  {
								tokensPos[k++] = pila.pop();
							}	
						}
						
						
						if(!pila.isEmpty() && pila.peek().equals("/") && tokens[i].matches("[+,-]")) {
							while(!pila.isEmpty() && !pila.peek().matches("[,(,{]") && !pila.peek().equals("[")) {
								tokensPos[k++] = pila.pop();
							}	
						}
						
						
						while(!pila.isEmpty() && pila.peek().equals("*") && tokens[i].matches("[+,-]")   ) {
							tokensPos[k++] = pila.pop();
						}
						
						while(!pila.isEmpty() && pila.peek().equals("/") && tokens[i].matches("[+,-]")) {
							tokensPos[k++] = pila.pop();
						}
						
					
						
						while(!pila.isEmpty() && tokens[i].equals("/") && pila.peek().equals("*")) {
							tokensPos[k++] = pila.pop();
						}
						
						while(!pila.isEmpty() && tokens[i].equals("*") && pila.peek().equals("/")) {
							tokensPos[k++] = pila.pop();
						}
						

						while(!pila.isEmpty() && tokens[i].equals("-") && pila.peek().equals("+")) {
							tokensPos[k++] = pila.pop();
						}
						
						while(!pila.isEmpty() && tokens[i].equals("+") && pila.peek().equals("-")) {
							tokensPos[k++] = pila.pop();
						}
						
						
						if(tokens[i].equals("+") || tokens[i].equals("-")) {
							pila.push(tokens[i]);
						}else if(tokens[i].equals("*") || tokens[i].equals("/")) {
							pila.push(tokens[i]);
						}else if(tokens[i].equals("^")) {
							pila.push(tokens[i]);
						}else if(tokens[i].equals("(") || tokens[i].equals("{") || tokens[i].equals("[") ) {
							pila.push(tokens[i]);
						}
					}
					
					if(tokens[i].equals(")") ) {
						String s = pila.pop();
						while(!s.equals("(")) {
							tokensPos[k++] = s;
							s = pila.pop();
						}
						
					}else if(tokens[i].equals("}") ) {
						String s = pila.pop();
						while(!s.equals("{")) {
							tokensPos[k++] = s;
							s = pila.pop();
						}
						
					}else if( tokens[i].equals("]") ) {
						String s = pila.pop();
						while(!s.equals("[")) {
							tokensPos[k++] = s;
							s = pila.pop();
						}	
					}
				}
					
				
				while(!pila.isEmpty()) {
					tokensPos[k++] = pila.pop();
				}
				
				for (int i = 0; i < tokensPos.length; i++) {
					if(tokensPos[i] != null)
					expresionPostFija+=tokensPos[i]+" ";
				}
				

		}else {
			throw new IllegalArgumentException("La expresión no es correcta");
		}		
		
		
		
		return expresionPostFija;
	}
	
	public static boolean evaluaParentesis(String expresion) {
		try {
			Stack<String> pila = new Stack<String>();
			//MyStack<String> pila = new MyStack<>();
			//String expresion = "( 5 + ( 6 + 2 * 3 ) ) / 4";
			String[] tokens = expresion.split(" ");
			
			//Regla 1: Si cuentro un parentesis abierto, se manda a la pila
			//Regla 2: Si encuentro un parentesis de cierre, se hace un pop y debe ser del mismo tipo, sino error.
			// - Si al hacer el pop la pila estaba vacía, y se lanza excepción
			//  no estaba correcta
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
					pop = pila.pop();
					if (!"(".equals(pop)) {
						System.out.println("No fueron del mismo tipo");
						return false;
					}
					break;
				case "]":
					pop = pila.pop();
					if (!"[".equals(pop)) {
						System.out.println("No fueron del mismo tipo");
						return false;
					}
					break;
				case "}":
					pop = pila.pop();
					if (!"{".equals(pop)) {
						System.out.println("No fueron del mismo tipo");
						return false;
					}
					break;
				}

			}

			return pila.isEmpty();

		} catch (NoSuchElementException ex) {
			System.out.println("No había con quien cerrar");
			return false;
		}

	}
	
}
