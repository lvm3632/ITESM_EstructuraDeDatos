//Autor: A01636172, Michel Lujano
//Nombre de la clase: MyListaEnlazada.java
//Fecha:15/01/2020
//Comentarios:  Me parecieron muy oportunas las respuestas del maestro a mis preguntas,
// ya que pude entender el tema y resolví los métodos, con el análisis, y las explicaciones que pude relacionar de la clase.
// Además, considero que este tema, se trabaja con los génericos y los objetos, de una forma constante,
// Por lo que pude reforzar más ese aspecto. 



import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListaEnlazada <E> {

	
	public static void main(String[] args) {
		Integer[] valores = {10,9,8,7,6,5,4,3,2,1};
		
		
		MyListaEnlazada<Integer> test = new MyListaEnlazada(valores);
		
	
	
		Iterator<Integer> iterator = test.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println(test.size);
	}
	
	private MyNodo<E> first,
					  last;
	
	private int size;
	
	public Iterator<E> iterator(){
		return new Iterator<E>() {
			
			//variables
		
			int pos=0;
			boolean found=false;
			MyNodo<E> current = first;
			
		

			@Override
			public E next() {
				while(pos<11) {
					found=true;
					E valor = current.getValor();
					current = current.getNext();
					pos++;
					return valor;
				}return null;
			}	
			
			@Override
			public boolean hasNext() {
				return current.getNext()!=null;
			}
			
			public void remove() {
				if(this.found) {
					removeAt(pos);
					this.found=false;
					pos--;
				}else {
					throw new NoSuchElementException("Itera primero toda la lista");
				}
			}
			
		};
		
	}
	
	public MyListaEnlazada(E[] datos) {
		
		// Insertar valores en la lista
		// e inicializar valores en la lista
		for (E e : datos) {
			insertLast(e);			
		}
	
	}
	
	//Arroja una excepcion cuando la posición es inválida
	public void insertAt(int pos, E valor) {
		
		MyNodo<E> current = first;
		MyNodo<E> nvo = new MyNodo<E>(valor);
	if(pos>=0 && pos<=size-1 && !isEmpty()) {
		if(pos==0) {
			insertFirst(valor);
		}
		else {
			for (int i = 0; i < pos; i++) {
						
					if(i==pos-1) {
						nvo.setNext(current.next);
						current.next = nvo;
						size++;
					}		
						current = current.next;								
				}
			}
			
	}else {
		throw new NoSuchElementException("El índice no se encuentra dentro de la lista (insertAt)");
	}	
}
	
	//Arroja una excepcion cuando la posición es inválida
	public E removeAt(int pos) {
		//Regresa elemento que borra
		
		MyNodo<E> current = first;
		MyNodo<E> tmp;
		E removed=null;
		
		if(pos>=0 && pos<=size-1 && !isEmpty()) {
			
			if(pos==0) {
				removed = removeFirst();
			}if(pos==size-1) {
				removed = removeLast();
			}
			else {

				for (int i = 0; i < pos; i++) {
					
					if(i==pos-1) {
						tmp=current.next.next;
						current.next=tmp;
						removed=current.getValor();
						size--;
					}
					
					current=current.next;
				}
					
			}
			
		return removed;
			
		}else {
			throw new NoSuchElementException("El índice no se encuentra dentro de la lista (removeAt)");
		}
	}
	
	//Regresa el elemento que se localiza en la posición pos
	public E getAt(int pos) {
		E valor=null;
		MyNodo<E> current = first;
		
		if(pos>=0 && pos<=size-1 && !isEmpty()) {
			if(pos==0) {
				valor=first.valor;
			}else {
				for (int i = 0; i < pos; i++) {
					if(i==pos-1) {
						valor=current.next.valor;
					}
					
					current=current.next;
					}	
			}
				
			return valor;
			
		}else {
			throw new NoSuchElementException("El índice no se encuentra dentro de la lista (getAt)");
		}

	}
	
	//Agrega valor
	public void setAt(int pos, E valor) {
		
		MyNodo<E> current = first;
		
		if(pos>=0 && pos<=size-1 && !isEmpty()) {
			if(pos==0) {
				first.valor=valor;
			}else {
				for (int i = 0; i < pos; i++) {
					if(i==pos-1) {
						current.next.setValor(valor);
					}
					
					current=current.next;
					}	
			}
				
	
		}else {
			throw new NoSuchElementException("El índice no se encuentra dentro de la lista (setAt)");
		}
			
	}
	
	public void flush() { //Borra los elementos de la lista;
		this.first=this.last=null;
		this.size=0;
		System.gc();
	}
	
	
	//No recibe nada, solo inicializa atributos
	public MyListaEnlazada() {
		this.first=this.last= null; //Apunta a null porque es un objeto y no un primitivo
		this.size=0;
	}
	
	public int size() {
		return this.size;
	}
	
	
	public boolean isEmpty() {
		return this.first==null; //or if this.size==0
	}
	
	
	public void insertFirst(E valor) {
	
		//Esta es la creación de la cajita del nodo.
		MyNodo<E> nvo = new MyNodo<>(valor, this.first);   // Es para crear un nuevo nodo, y recordar que es parametrizado 	
		if(isEmpty()) {
			this.last=nvo;
		}
		//nvo.setNext(this.first);
		this.first=nvo;
		this.size++;
		
	}
	
	public void insertLast(E valor) {
		if(isEmpty()) {
			this.insertFirst(valor);
		}else {
			MyNodo<E> nvo = new MyNodo<>(valor);
			this.last.setNext(nvo);  //this.last.next=nvo;
			this.last=nvo;
			this.size++;
		}
			
	}
	
	public E first() {
		return this.first.valor;
	}
	
	public E last() {
		return this.last.valor;
	}
	
	public void desplazarLista(int pos) {
		
		MyNodo<E> current1 = first;
		MyNodo<E> current2 = last; 
		//{1,2,3,4,5}
		//desplazarLista(3);
		
		for (int i = 0; i < pos-1; i++) {
				
				current1=current1.next;
				
		}
		
		current2=current1.next;
		System.out.println(current1.valor);
		System.out.println(current2.valor);
		current1.setNext(null);
		this.last.setNext(this.first);
		this.first=current2;
		this.last=current1;
		
		
	}
	
	public String toString() {
		
		String res="";
		MyNodo<E> current=this.first;
		
		while(current!=null) {
		res+=current.getValor()+",";
		current=current.getNext();
	}
		return res;
}
	
	
	public E removeFirst() {
		
		try {
			E tmp=this.first.valor;
			this.first=this.first.next;
			this.size--;
			return tmp;
		}catch(NullPointerException  | ArithmeticException e) {
			throw new NoSuchElementException("No se puede hacer un remove de una lista vacia (removeFirst)");
		}
	}
	
	
	public E removeLast() {
		
		
		try {
			
			MyNodo<E> current = this.first;
			E tmp = this.last.valor;
			
			for(int i=0;i<this.size-2;i++) { // while(current.next!=this.last)
				current=current.next;
			}
			
			current.next=null;
			this.last=current;
			this.size--;
			return tmp;
			
			
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede hacer un remove a una lista vacia (removeLast)");
		}
		
		
		
	
	}

class  MyNodo<E>{
	
	 //private E valor; // Primera sintaxis
	 //private MyNodo<E> next // Primera sintaxis
	
	 E valor;
	 MyNodo<E> next; 
	
	
	public MyNodo(E valor, MyNodo<E> next) {

		this.valor = valor;
		this.next = next;
	}
	
	public MyNodo(E valor) {
		this(valor,null);
		
	}

	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public MyNodo<E> getNext() {
		return next;
	}
	public void setNext(MyNodo<E> next) {
		this.next = next;
	}
	
	public String toString() { //Para debuggeo, regresa el value
		return this.valor.toString();
	}


	
}

}

