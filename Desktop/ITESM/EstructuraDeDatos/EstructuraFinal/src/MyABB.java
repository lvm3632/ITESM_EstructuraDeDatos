
public class MyABB<E extends Comparable<E>> {
	
	private MyNodoABB<E> raiz;
	private int size; // saber cuantos elementos existen en el arbol
	
	public MyABB() {
		super();
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size==0;
	}
	
	public E buscar(E valor) {
		MyNodoABB<E> current = this.raiz;
		while(current!=null) {
			if(current.dato.compareTo(valor)==0) {
				return current.getDato();
			}else if(valor.compareTo(current.dato)<0) {
				current=current.izq;
			}else if(valor.compareTo(current.dato)>0) {
				current=current.der;
			}
		}
		return null;
	}
	
	
	public void insertar(E valor) {
		MyNodoABB<E> nvo = new MyNodoABB<E>(valor);
		
		
		if(this.raiz == null) {
			this.raiz=new MyNodoABB(valor);
		}else {
			
			MyNodoABB<E> current = this.raiz;
		
			E res = buscar(valor);
			
				if(nvo.dato.compareTo(this.raiz.dato)<0) {
					
					while(current.izq != null) {
						current = current.izq;
					}
					if(res==null) {
						current.izq = nvo;
						size++;
					}
				} 
				
				if(nvo.dato.compareTo(this.raiz.dato)>0){
					while(current.der != null) {
						current = current.der;
					}
					if(res==null) {
						current.der = nvo;
					}
				
				}
				this.size++;
		}
	}
	
	public void insertar_profe(E valor) {
		
		if(this.raiz==null) {
			this.raiz = new MyNodoABB<>(valor);			
		}else {
			MyNodoABB<E> prev=null,
					 current=this.raiz;
		
		while(current != null) {
			prev = current;
			if(valor.compareTo(current.dato)<0) {
				current=current.izq;
			}else {
				current=current.der;
			}
		}
		
		
		if(valor.compareTo(prev.dato)<0) {
			prev.izq = new MyNodoABB<>(valor);
		}else {
			prev.der = new MyNodoABB<>(valor);
		}
		
	
		
		
		}
		this.size++;
		
		
	}
	
	public void preorden() {
		this.preorden(this.raiz);
	}
	
	private void preorden(MyNodoABB<E> current){
		
		if(current!=null) {
			System.out.print(current.dato+",");
			preorden(current.izq);
			preorden(current.der);
		}
		
	}
	
	public void inorden() {
		this.inorden(this.raiz);
	}
	private void inorden(MyNodoABB<E> current){
		
		if(current!=null) {
			
			inorden(current.izq);
			System.out.print(current.dato+",");
			inorden(current.der);
		}
		
	}
	
	public void posorden() {
		this.posorden(this.raiz);
	}
	private void posorden(MyNodoABB<E> current){
		
		if(current!=null) {
			
			posorden(current.izq);
			
			posorden(current.der);
			System.out.print(current.dato+",");
		}
		
	}
	
	
	
	public E borrar() {
		
	}
	
	public static void main(String[] args) {
		MyABB<Integer> arbol = new MyABB<>();
		
		arbol.insertar_profe(100);
		arbol.insertar_profe(50);
		arbol.insertar_profe(200);
		arbol.insertar_profe(25);
		arbol.insertar_profe(75);
		arbol.insertar_profe(125);
		arbol.insertar_profe(275);
		arbol.preorden();
		System.out.println();
		arbol.inorden();
		System.out.println();
		arbol.posorden();
		
		System.out.println("hola");
		
	}

}






class MyNodoABB<E extends Comparable<E>> /*implements Comparable<MyNodoABB<E>>*/{
	E dato;
	MyNodoABB<E> izq,
				 der;
	
	public MyNodoABB(E dato, MyNodoABB<E> izq, MyNodoABB<E> der) {
		this.dato=dato;
		this.izq=izq;
		this.der=der;
	}
	
	public MyNodoABB(E dato) {
		this(dato, null, null);
	}

	public String toString() {
		return this.dato.toString();
	}
	
	public E getDato() {
		return dato;
	}

	public void setDato(E dato) {
		this.dato = dato;
	}

	public MyNodoABB<E> getIzq() {
		return izq;
	}

	public void setIzq(MyNodoABB<E> izq) {
		this.izq = izq;
	}

	public MyNodoABB<E> getDer() {
		return der;
	}

	public void setDer(MyNodoABB<E> der) {
		this.der = der;
	}

	/*@Override
	public int compareTo(MyNodoABB<E> nodo) {
		return this.dato.compareTo(nodo.dato);	
	}*/
	
	
	
	
}