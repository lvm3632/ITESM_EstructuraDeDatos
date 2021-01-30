import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<E>{
	//crear nodo en cualquier posicion, p, ya tiene la posicion
	// el nodo se genera a la derecha de p. 
	// crear nodo, con el valor
	//nvo.next = p.next; 
	//p.next = nvo;
	
	//borrar
	//p.next=p.next.next
	
	//Iterator

		public Iterator<E> iterator(){
			return new Iterator<E>() {
				
				//variables
			
				int pos=0;
				boolean found=false;
				NodoLE<E> current = inicio;
				
				@Override
				public boolean hasNext() {
					return current.getNext()!=null;
				}

				@Override
				public E next() {
					if(this.hasNext()) {
						found=true;
						E valor = current.getValor();
						
						current = current.getNext();
						pos++;
						return valor;
					}else {
						throw new NoSuchElementException("Ya se iteró toda la lista");
					}
				}
				
				public void remove() {
					if(this.found) {
						borrarEn(pos);
						this.found=false;
						pos--;
					}else {
						throw new NoSuchElementException("Itera primero toda la lista");
					}
				}
				
			};
			
		}
	
	
	
	
	//Fin iterator
	public static void main(String[] args) {
		//String[] lista = {"a","b","c","d","e"};
		//String[] lista2 = {};
		//ListaEnlazada test = new ListaEnlazada<>(lista2);
		
	Integer[] valores = {10,9,8,7,6,5,4,3,2,1};
		
		
		ListaEnlazada<Integer> test = new ListaEnlazada(valores);
		
	
	
		Iterator<Integer> iterator = test.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
	
	public ListaEnlazada(E[] arr) {
		//Inicializa la lista con los valores del arreglo (1,8,10,2) >1->8->10->2 size=4
		if(arr.length==0) {
			throw new NoSuchElementException("No hay elementos en la lista");
		}
		
		/*this.inicio = new NodoLE<>((E)arr[0]);
		NodoLE<E> current = this.inicio;
		this.size++;
		for (int i = 1; i < arr.length; i++) {
			current.next = new NodoLE<>((E)arr[i]);
			System.out.println(current.next.valor);
			current=current.next;
			this.size++;
		}
		System.out.println(current.valor);
		this.fin=current;*/
		for (E e : arr) {
			this.insertarFin(e);
		}
	}
	
	
	
	public String toString() {
		String res="";
		NodoLE<E> current = this.inicio;
		while(current != null) {
			res+=current.getValor()+",";
			current=current.next;
		}
		return res;
	}
	
	public void insertarEn(int pos, E valor) {
			
		try {
		
			NodoLE<E> nvo = new NodoLE<>(valor);
			NodoLE<E> current=this.inicio;
			NodoLE<E> tmp;
			if(pos==0) {
				tmp=this.inicio;
				tmp.next=current.next;
				nvo.next=tmp;
				this.inicio=nvo;
				size++;
				return;
			}else {
				for (int i = 0; i < pos-1; i++) {
					current=current.next;
				}
				nvo.next = current.next;
				current.next = nvo;
				
				if(pos==this.size-1) 
					this.fin=nvo;
				
				this.size++;
			}
			
		}catch(NullPointerException e) {
			throw new NoSuchElementException("Posición Incorrecta");
		}
		
	}
	
	public E borrarEn(int pos) {
		
		try {
			if(pos==0) {
				return borrarInicio();
			}else if(pos==this.size-1) {
				return borrarFin();
			}
			E borrado=null;
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos-1; i++) {
				current=current.next;
			}
			borrado=current.next.getValor();
			current.next = current.next.next;
			this.size--;
			return borrado;
			
		}catch(NullPointerException e) {
			throw new NoSuchElementException("La lista está vacía");
		}
		
	}
	
	public void setAt(int pos, E valor) {
		
		if(pos>=0 && pos < this.size) {
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < pos; i++) {
				current=current.next;
			}			
				current.setValor(valor);		
		}else {
			throw new IndexOutOfBoundsException("No se puede modificar la posición"+pos+"de una lista de tamaño" +this.size);
		}	
	}
		
	
	
	public E borrarFin() {
		try {	
			E borrado;
			if(this.size==1) {
				//return borrarInicio();
				borrado=inicio();
				this.inicio=this.fin=null;
				this.size=0;
			}
			NodoLE<E> current = this.inicio;
			for (int i = 0; i < this.size-2; i++) {
				current=current.next;
			}
			
			
			borrado=current.next.getValor();
			current.next=null;
			this.fin=current;
			this.size--;
			return borrado;
						
		}catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede borrar el inicio de una lista vacía");
		}		
	}
	
	public E borrarInicio() {
		
		//Borra el primer elemento de la lista y regresa el valor que se elimino
		//En caso de que la lista esté vacía debe arrojar un NoSuchElementException
		try {
		 E borrado=null;
		if(this.inicio.getNext()==null) {
			borrado=this.inicio.getValor();
			this.inicio=this.fin=null;		
			this.size--;
		}else {	
			borrado=this.inicio.getValor();
			this.inicio=this.inicio.getNext();
			this.size--;
		}
		 return borrado;
		 
		}catch(NullPointerException e) {
			throw new NoSuchElementException("La lista está vacía");
		}
	}
	
	
	private NodoLE<E> inicio;
	private NodoLE<E> fin;
	private int size;
	
	public ListaEnlazada() {
		super();
		this.inicio=this.fin=null;
		this.size=0;
	}
	
	public E inicio() {
		try {
			return this.inicio.valor;
		}catch(NullPointerException e){
			throw new NoSuchElementException("No se puede regresar el inicio de una lista vacía");
		}		
	}
	
	public E fin() {
		try {
			return this.fin.valor;
		}catch(NullPointerException e){
			throw new NoSuchElementException("No se puede regresar el fin de una lista vacía");
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public void insertarInicio(E valor) {
		//NodoLE<E> nvo = new NodoLE<>(valor, this.inicio);	
		//this.inicio=nvo;
		this.inicio=new NodoLE<E>(valor,this.inicio);
		if(this.fin==null) {
			this.fin=inicio;
		}
		this.size++;
	}
	
	public void insertarFin(E valor) {
		if(this.size!=0) {
			NodoLE<E> nvo = new NodoLE<>(valor);
			this.fin.setNext(nvo);
			this.fin=nvo;
			this.size++;
		}else {
			this.insertarInicio(valor);
		}
		
	}

	
	

}

class NodoLE<E>{
	NodoLE<E> next;
	E valor;
	
	
	public NodoLE(E valor) {
		this(valor,null);
	}
	
	public NodoLE(E valor, NodoLE<E> next) {
		super();
		this.valor=valor;
		this.next=next;
	}
	
	public NodoLE<E> getNext() {
		return next;
	}
	public void setNext(NodoLE<E> next) {
		this.next = next;
	}
	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return this.valor.toString();
	}
	
}

