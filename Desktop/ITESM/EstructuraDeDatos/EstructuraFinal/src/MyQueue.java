
public class MyQueue<E> {
	
	private ListaEnlazada<E> cola;
	
	
	
	public MyQueue() {
		this.cola = new ListaEnlazada<>();
	}
	
	public void enqueue(E valor) {
		this.cola.insertarFin(valor);
	}
	
	public int size() {
		return this.cola.size();
	}
	
	
	public E next() {
		return this.cola.inicio();
	}
	
	
	public void flush() {
		this.cola=new ListaEnlazada<>();
		System.gc();
	}
	
	public E dequeue() {
		return this.cola.borrarInicio();
	}
	
	public boolean isEmpty() {
		return this.cola.isEmpty();
	}
	
	
	
	public MyQueue(E[] datos) {
		this.cola = new ListaEnlazada<>(datos);
	}

	public static void main(String[] args) {
		
		MyQueue<String> numeros = new MyQueue<>();
		numeros.enqueue("hola");
		numeros.enqueue("adios");
		numeros.enqueue("como");
		numeros.enqueue("estas");
		numeros.enqueue("fin");
		
		System.out.println(numeros.toString());
		
	
		//Vaciar
		while(!numeros.isEmpty()) {
			System.out.println(numeros);
		}
		
		//for
		while(!numeros.isEmpty()) {
			System.out.println(numeros.dequeue());
		}
		

	}

}
