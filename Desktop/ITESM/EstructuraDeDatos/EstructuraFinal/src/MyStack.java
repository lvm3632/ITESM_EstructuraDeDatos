
public class MyStack<E> {

	private ListaEnlazada<E> stack;
	
	
	public MyStack() {
		this.stack=new ListaEnlazada<>();
	}
	
	public int size() {
		return this.stack.size();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public void flush() {
		this.stack= new ListaEnlazada<>();
		System.gc();
	}
	
	public void push(E valor) {
		this.stack.insertarInicio(valor);
	}
	
	public E pop() {
		return this.stack.borrarInicio();
	}
	
	public E top() {
		return this.stack.inicio();
	}
	
		
	public static void main(String[] args) {
		
		MyStack<String> numeros = new MyStack<>();
		numeros.push("hola");
		numeros.push("como");
		numeros.push("estas");
		numeros.push("bien");
		
		
		
		System.out.println(numeros.toString());
		
		
		while(!numeros.isEmpty()) {
			System.out.println(numeros.pop());
		}
				
	}
	
}
